package jugame.jiaoyi_ff.bean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理
 * 
 * @author caixb
 *
 */
public class ExceptionHandler implements HandlerExceptionResolver {   
  
	Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
    @Override  
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    	logger.error("", ex);
    	String path = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/public/500.html";
    	return new ModelAndView("redirect:" + path);
    }   
}  