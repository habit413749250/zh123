package jugame.jiaoyi_ff.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import jugame.jiaoyi_ff.bean.XssHttpServletRequestWrapper;


/**
 * xss攻击filter
 * 
 * @author caixb
 *
 */
public class XssFilter implements Filter {
	FilterConfig filterConfig = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(new XssHttpServletRequestWrapper(request), response);
	}
}