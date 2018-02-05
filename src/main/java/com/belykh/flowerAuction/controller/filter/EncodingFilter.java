package com.belykh.flowerAuction.controller.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * The Class EncodingFilter.
 */
public class EncodingFilter implements Filter {

    private String code;

    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig)  {
        code = filterConfig.getInitParameter("encoding");
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String encoding = request.getCharacterEncoding();
        if (encoding == null || !encoding.equals(code)) {
            request.setCharacterEncoding(code);
        }
        chain.doFilter(request, response);
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {

    }
}
