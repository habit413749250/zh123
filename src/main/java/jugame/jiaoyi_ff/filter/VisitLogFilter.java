package jugame.jiaoyi_ff.filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jugame.assist.util.CookieUtil;
import cn.jugame.util.RequestUtils;

/**
 * 用户访问日志记录
 * 
 * @author cai9911
 * 
 */
public class VisitLogFilter implements Filter {
	Logger visitLog = LoggerFactory.getLogger("visit_log");
	Logger logger = LoggerFactory.getLogger(VisitLogFilter.class);

	private final String UID = "uid";
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		//String url = httpServletRequest.getRequestURI();
		String url = httpServletRequest.getRequestURL().toString();
		//p3p
		httpServletResponse.setHeader("P3P","CP=\"NON DSP COR CURa ADMa DEVa TAIa PSAa PSDa IVAa IVDa CONa HISa TELa OTPa OUR UNRa IND UNI COM NAV INT DEM CNT PRE LOC\"");
		
		String queryString = httpServletRequest.getQueryString();
		if (StringUtils.isNotBlank(queryString)) {
			url += "?" + queryString;
		}
		if (!url.contains("Login")){
			//request.setAttribute("currUrl", url); //用户当前访问的url
			request.setAttribute("currUrlEncode", URLEncoder.encode(url,"utf-8")); //用户当前访问的url
		}
		
		String userip = RequestUtils.getUserIp(httpServletRequest);
		String referer = httpServletRequest.getHeader("referer");//来路

		// logger.info(uaStr);
		String uid = "0"; // 登录用户id
		HttpSession session = httpServletRequest.getSession(true);
		if (session.getAttribute(UID) != null) {
			uid = session.getAttribute(UID).toString();
		}
		// 给每一个用户记一个cookie号
		String cookieUid = CookieUtil.getCookie(httpServletRequest, "jugame_cookie_uid");
		if (StringUtils.isBlank(cookieUid)) {
			UUID uuid = UUID.randomUUID();
			// cookie_uid = MD5.encode(uuid.toString());
			cookieUid = uuid.toString(); 
			CookieUtil.setCookie(httpServletRequest, httpServletResponse,  "jugame_cookie_uid", cookieUid , 3600 * 24 * 365);
		}
		//处理fr参数
		String fr = httpServletRequest.getParameter("fr"); 
		if (StringUtils.isNotBlank(fr)){
			CookieUtil.setCookie(httpServletRequest, httpServletResponse, "jugame_fr", fr , -1);
		}else{
			fr = CookieUtil.getCookie(httpServletRequest, "jugame_fr");
		}
		String userAgent = httpServletRequest.getHeader("user-agent");
		String orderEn = httpServletRequest.getParameter("order_en");
		if(orderEn == null){
			orderEn = CookieUtil.getCookie(httpServletRequest, "order_en");
		}
		String method = httpServletRequest.getMethod();
		visitLog.info(cookieUid + "`" + uid + "`" + url + "`" + userAgent
				+ "`" + userip + "`null`null`" + referer + "`" + fr + "`" + orderEn + "`" + method);
		chain.doFilter(request, response);
	} 

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

}
