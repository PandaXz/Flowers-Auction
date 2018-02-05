package com.belykh.finalProj.controller;

import com.belykh.finalProj.command.ActionCommand;
import com.belykh.finalProj.command.CommandProvider;
import com.belykh.finalProj.constant.PathPage;
import com.belykh.finalProj.exception.CommandException;
import com.belykh.finalProj.manager.MessageManager;
import com.belykh.finalProj.manager.ResourceManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50    // 50MB
)
public class AuctionServlet extends HttpServlet {

    private static final Logger LOGGER = LogManager.getLogger(AuctionServlet.class);
    public static MessageManager messageManager = MessageManager.INSTANCE;
    public static ResourceManager resourceManager = ResourceManager.INSTANCE;

    private static final String LOCALE_RU_VALUE = "ru";
    private final static String LOCALE_RU = "ru_RU";

    @Override
    public void init() throws ServletException {
        //LOGGER.log(Level.DEBUG, "initialize servlet");
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
        if((request.getSession(false))!=null){
            CommandProvider provider = new CommandProvider();
            ActionCommand command = provider.getCommand(request);
            try {
                page = command.execute(request, response);
            } catch (CommandException e) {
                LOGGER.log(Level.ERROR, e);
            }
        }

        if (page != null) {
            if (request.getAttribute("redirect") != null) {
                LOGGER.log(Level.DEBUG, "redirect = " + request.getAttribute("redirect"));
                response.sendRedirect(request.getAttribute("redirect").toString());
            } else {
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
                requestDispatcher.forward(request, response);
            }
        }else{
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(PathPage.INDEX.getPath());
            requestDispatcher.forward(request, response);
        }
    }
}
