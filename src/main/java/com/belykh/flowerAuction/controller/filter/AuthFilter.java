package com.belykh.flowerAuction.controller.filter;

import com.belykh.flowerAuction.constant.PathPage;
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
 * The Class AuthFilter.
 */
public class AuthFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(AuthFilter.class);

    private List<String> adminCommands;
    
    private List<String> guestCommands;

    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) {
        adminCommands = new ArrayList<>();
        adminCommands.add("APPROVE_LOT");
        adminCommands.add("DENY_LOT");
        adminCommands.add("ADDED_LOTS");
        adminCommands.add("CHANGE_BALANCE");
        adminCommands.add("ADD_FLOWER");
        adminCommands.add("ADD_CITY");
        adminCommands.add("USER_LIST");

        guestCommands = new ArrayList<>();
        guestCommands.add("SIGNUP");
        guestCommands.add("LOGIN");
        guestCommands.add("FORWARD");
        guestCommands.add("ENGLISH_LANGUAGE");
        guestCommands.add("RUSSIAN_LANGUAGE");

    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession(false);


        int role = 0;
        if (session!=null&& session.getAttribute("role") != null) {
            role = (Integer) session.getAttribute("role");
        }
        boolean pass = checkPass(httpServletRequest, role);

        //logger.log(Level.DEBUG,role+","+pass);
        if (pass) {
            chain.doFilter(request, response);
        } else {
            httpServletResponse.sendRedirect("/auction"+ PathPage.INDEX.getPath());
        }

    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
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
