package app.yarmak.newsportal.controller.filter;

import java.io.IOException;
import java.net.URLEncoder;

import app.yarmak.newsportal.bean.Auth;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationFilter extends HttpFilter {
    
    private static final long serialVersionUID = 1L;
    
    @SuppressWarnings("deprecation")
    private static final String errorMessage = URLEncoder.encode("Ошибка авторизации. Войдите или зарегистрируйтесь в системе.");

    private static final String URL = "Controller?command=go_to_index_main&errorMessage=" + errorMessage;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Инициализация фильтра
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        String command = httpRequest.getParameter("command");

        if ("/Controller".equals(path) && Permissions.PUBLIC_COMMANDS.contains(command)) {
            chain.doFilter(request, response);
            return;
        }
        
        if (httpRequest.getSession().getAttribute("user") == null) {
            if (!httpResponse.isCommitted()) {
                httpResponse.sendRedirect(URL);
            }
            return;
        }
        
        Auth auth = (Auth) httpRequest.getSession().getAttribute("user");
        String userRole = auth.getRole();

        if ("/Controller".equals(path) && Permissions.isCommandAllowed(command, userRole)) {
            chain.doFilter(request, response);
            return;
        }
               
        if (!httpResponse.isCommitted()) {
            httpResponse.sendRedirect(URL);
        }
    }

    @Override
    public void destroy() {
        // Завершение работы фильтра
    }
}
