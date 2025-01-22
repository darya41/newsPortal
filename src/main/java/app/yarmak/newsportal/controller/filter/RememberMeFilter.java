package app.yarmak.newsportal.controller.filter;

import java.io.IOException;

import com.google.protobuf.ServiceException;

import app.yarmak.newsportal.bean.Auth;
import app.yarmak.newsportal.service.ServiceProvider;
import app.yarmak.newsportal.service.UserService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RememberMeFilter extends HttpFilter implements Filter {
    private static final long serialVersionUID = 1L;

    private final UserService userService = ServiceProvider.getInstance().getUserService();

    public RememberMeFilter() {
        super();
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpSession session = httpRequest.getSession(false);

            if (session == null || session.getAttribute("user") == null) {
                Cookie[] cookies = httpRequest.getCookies();

                if (cookies != null) {
                    for (Cookie c : cookies) {
                        if ("remember-me".equals(c.getName())) {
                            String token = c.getValue();
                            Auth user = userService.rememberMe(token);

                            if (session == null) {
                                session = httpRequest.getSession(true);
                            }
                            session.setAttribute("user", user);
                            break; 
                        }
                    }
                }
            }

            chain.doFilter(request, response);

        } catch (ServiceException e) {
            ((HttpServletResponse) response)
                    .sendRedirect("MyController?command=go_to_index_page&authError=Wrong login or password!");
        }
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }
}
