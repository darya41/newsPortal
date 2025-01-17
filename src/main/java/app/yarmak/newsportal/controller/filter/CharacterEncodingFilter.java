package app.yarmak.newsportal.controller.filter;

import java.io.IOException;

import com.oracle.wls.shaded.org.apache.xalan.xsltc.dom.Filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class CharacterEncodingFilter extends HttpFilter  implements Filter{

	private static final long serialVersionUID = 1L;

	public CharacterEncodingFilter() {
        super();        
    }

	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {		
	}

	@Override
	public boolean test(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}


}
