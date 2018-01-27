package com.belykh.finalProj.controller;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.command.CommandProvider;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.manager.ConfigurationManager;
import com.belykh.finalProj.manager.MessageManager;
import com.belykh.finalProj.manager.ResourceManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by panda on 15.11.17.
 */
@WebServlet(name = "AuctionServlet")
public class AuctionServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(AuctionServlet.class);
    public static MessageManager messageManager = MessageManager.INSTANCE;
    public static ResourceManager resourceManager = ResourceManager.INSTANCE;

    private static final String LOCALE_RU_VALUE = "ru";
    private final static String LOCALE_RU = "ru_RU";

    @Override
    public void init() throws ServletException {
        logger.log(Level.DEBUG, "initialize servlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("locale".equals(cookie.getName())) {
                request.setAttribute("lang", cookie.getValue());
                if (LOCALE_RU.equals(cookie.getValue())) {
                    AuctionServlet.messageManager.changeLocale(new Locale(LOCALE_RU_VALUE, LOCALE_RU_VALUE.toUpperCase()));
                    AuctionServlet.resourceManager.changeLocale(new Locale(LOCALE_RU_VALUE, LOCALE_RU_VALUE.toUpperCase()));
                } else {
                    AuctionServlet.messageManager.changeLocale(Locale.US);
                    AuctionServlet.resourceManager.changeLocale(Locale.US);
                }
            }
        }

        String page = null;
        if(request.getSession(false)!=null){
            logger.log(Level.DEBUG, "session is available");
            CommandProvider provider = new CommandProvider();
            ActionCommand command = provider.getCommand(request);
            try {
                page = command.execute(request, response);
            } catch (CommandException e) {
                logger.log(Level.ERROR, e);
            }
        }

        if (page != null) {
            if(request.getAttribute("redirect")!=null) {
                logger.log(Level.DEBUG, "redirect = " + request.getAttribute("redirect"));
            }
            if (request.getAttribute("redirect") != null) {
                response.sendRedirect(request.getAttribute("redirect").toString());
            } else {
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
                requestDispatcher.forward(request, response);
            }
        } else {
            page = ConfigurationManager.getProperty("path.page.index");
            request.getSession().setAttribute("nullPage",
                    MessageManager.INSTANCE.getProperty("message.nullpage"));
            response.sendRedirect(request.getContextPath() + page);
        }
    }
}
