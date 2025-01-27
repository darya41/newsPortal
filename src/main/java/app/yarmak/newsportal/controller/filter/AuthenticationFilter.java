package app.yarmak.newsportal.controller.filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

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

    private static final List<String> PUBLIC_COMMANDS = Arrays.asList( 
            "go_to_index_main", "go_to_all_news_page", 
            "go_to_auth", "do_auth",
            "go_to_registration", "do_registration",
            "do_apply_authot", "go_to_apply_author",
            "go_to_application_submit", "search_news",
            "go_to_category_page"
    );

    private static final List<String> AUTHOR_COMMANDS = Arrays.asList( 
            "add_news", "delete_news", "go_to_page_news",
            "edit_news", "go_to_edit_news_page",
            "go_to_edit_news", "go_to_personal_account",
            "log_out"
    );

    private static final List<String> ADMIN_COMMANDS = Arrays.asList( 
            "delete_news", "go_to_page_news",
            "edit_news", "go_to_edit_news", "go_to_personal_account",
            "log_out"
    );

    private static final List<String> USER_COMMANDS = Arrays.asList(
            "go_to_personal_account", "go_to_page_news",
            "log_out"
    );
    
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

        if ("/Controller".equals(path) && PUBLIC_COMMANDS.contains(command)) {
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

        if ("/Controller".equals(path)) {
        	System.out.println("-------1");
            if (AUTHOR_COMMANDS.contains(command) && "author".equals(userRole)) {
                chain.doFilter(request, response);
                return;
            }
            
            if (ADMIN_COMMANDS.contains(command) && "admin".equals(userRole)) {
                chain.doFilter(request, response);
                return;
            }
            
            if (USER_COMMANDS.contains(command)) {
                chain.doFilter(request, response);
                return;
            }
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
