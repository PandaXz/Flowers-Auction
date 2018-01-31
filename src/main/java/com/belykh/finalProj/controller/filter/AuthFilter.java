package com.belykh.finalProj.controller.filter;

import com.belykh.finalProj.manager.ConfigurationManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 16.11.17.
 */
public class AuthFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(AuthFilter.class);

    List<String> adminCommands;
    List<String> guestCommands;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        adminCommands = new ArrayList<>();
        adminCommands.add("APPROVE_LOT");
        adminCommands.add("DENY_LOT");
        adminCommands.add("ADDED_LOTS");

        guestCommands = new ArrayList<>();
        guestCommands.add("SIGNUP");
        guestCommands.add("LOGIN");
        guestCommands.add("ACCEPTED_LOT_LIST");
        guestCommands.add("ACCEPTED_LOT_LIST");
        guestCommands.add("ENGLISH_LANGUAGE");
        guestCommands.add("RUSSIAN_LANGUAGE");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession(false);

        boolean pass = true;
        int role = 0;
        if (session!=null&& session.getAttribute("role") != null) {
            role = (Integer) session.getAttribute("role");
        }

        pass = checkPass(httpServletRequest, role);

        //logger.log(Level.DEBUG,role+","+pass);
        if (pass) {
            chain.doFilter(request, response);
        } else {
            httpServletResponse.sendRedirect("/auction"+ConfigurationManager.getProperty("path.page.index"));
        }

    }

    @Override
    public void destroy() {

    }

    private boolean checkPass(HttpServletRequest request, int role) {
        boolean result = true;
        String command = request.getParameter("command");
        //logger.log(Level.DEBUG,command);
        if (command != null && !guestCommands.contains(command.toUpperCase()) && role == 0) {
            result = false;
        }
        if (command != null && adminCommands.contains(command.toUpperCase()) && role != 2) {
            result = false;
        }

        return result;
    }
}
