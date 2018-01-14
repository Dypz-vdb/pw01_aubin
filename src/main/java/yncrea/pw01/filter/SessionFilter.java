package yncrea.pw01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class SessionFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        if(req.getServletPath().equals("/login") || req.getServletPath().equals("/index.jsp") || session.getAttribute("loggedPharmacist") != null){
            filterChain.doFilter(req, res);
        } else if (session.getAttribute("loggedPharmacist") == null){
            res.sendRedirect(req.getServletContext().getContextPath() + "/");
        }
    }

    @Override
    public void destroy() {

    }
}
