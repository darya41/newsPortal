package app.yarmak.newsportal.controller.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

	private static final String URL = "goController?command=go_to_index_main";
	
	public static final List<String> PUBLIC_COMMANDS = Arrays.asList( 
			"go_to_index_main","go_to_all_news_page", 
			"go_to_auth","do_auth",
			"go_to_registration","do_registration",
			"do_apply_authot","go_to_apply_author",
			"go_to_application_submit"
			
			);
	public static final List<String> AUTHOR_COMMANDS = Arrays.asList( 
			"add_news","delete_news", "go_to_page_news",
			"edit_news","go_to_edit_news",
			"go_to_add_news_page", "go_to_personal_account",
			"log_out"
			
			);
	public static final List<String> ADMIN_COMMANDS = Arrays.asList( 
			"delete_news","go_to_page_news",
			"edit_news","go_to_edit_news","go_to_personal_account",
			"log_out"
			);
	public static final List<String> USER_COMMANDS = Arrays.asList(
			"go_to_personal_account", "go_to_page_news",
			"log_out"
			);
	
//go_to_applicationSubmit
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      
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
            httpResponse.sendRedirect(URL);
        }
        
        if ("/Controller".equals(path) && AUTHOR_COMMANDS.contains(command)) {
        	if (httpRequest.getSession().getAttribute("user.role") =="author") {
        		 chain.doFilter(request, response);
                 return;
        	}            	
        }
       
        if ("/Controller".equals(path) && ADMIN_COMMANDS.contains(command)) {
        	if (httpRequest.getSession().getAttribute("user.role") !="admin") {
        		 chain.doFilter(request, response);
                 return;
        	}
           
        }
        
        httpResponse.sendRedirect(URL);    
    }

    @Override
    public void destroy() {
      
    }
}
