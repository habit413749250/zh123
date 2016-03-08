package jugame.jiaoyi_ff.bean;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.View;



/**
 * Created by Timothy on 14-5-20.
 */
public class ExDispatcherServlet extends DispatcherServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public View resolveViewName(String viewName, Map<String, Object> model, Locale locale,
								   HttpServletRequest request) throws Exception {

		if (viewName.indexOf(":") <0 ) {
			if (!ClientTypeHelper.isMobile(request)) {
				viewName = "pc/" + viewName;
			} else {
				viewName = "mobile/" + viewName;
			}
		} else {
			viewName = viewName.replaceFirst("^(mobile|pc):(.*)", "$1/$2");
		}

		//System.out.println("viewName: " + viewName);
		
		return super.resolveViewName(viewName, model, locale, request);
	}


}
