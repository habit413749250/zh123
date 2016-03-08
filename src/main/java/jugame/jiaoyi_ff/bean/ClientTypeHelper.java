package jugame.jiaoyi_ff.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

/**
 * 客户端类型
 * @author Samsung
 *
 */
public class ClientTypeHelper {
	
	/**
	 * 平台类型：手机版
	 */
	public static final String JUGAME_PF_MOBILE = "0";
	
	/**
	 * 平台类型：PC版
	 */
	public static final String JUGAME_PF_PC = "1";

	/**
	 * 用户是否手机访问
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isMobile(HttpServletRequest request) {
		// request.getServerName();
		HttpSession session = request.getSession();

		// queryStrign 带有__v参数，优先判断
		String v = request.getParameter("__v");
		if (v != null) {
			if ("mobile".equalsIgnoreCase(v)) {
				session.setAttribute("jugame_pf", JUGAME_PF_MOBILE);
				return true;
			} else {
				session.setAttribute("jugame_pf", JUGAME_PF_PC);
				return false;
			}
		}

		boolean isMobile = false;
		String sessionPf = (String) session.getAttribute("jugame_pf");
		if (!StringUtils.isBlank(sessionPf)) {
			if (sessionPf.equals(JUGAME_PF_MOBILE)) {
				return true;
			} else {
				return false;
			}
		} else {
			// 判断 UA
			String userAgent = request.getHeader("User-Agent");
			if (userAgent != null) {
				userAgent = userAgent.toLowerCase();

				// 现有 Android UA 都包含有 Mobile Safari 字符串
				boolean isAndroid = userAgent.indexOf("mobile safari") > 0;
				// 现有 IOS 都包含 iPhone/iPad/iPod
				boolean isIOS = false;
				if (!isAndroid) {
					isIOS = userAgent.indexOf("iphone") > 0 || userAgent.indexOf("ipod") > 0 || userAgent.indexOf("ipad") > 0;
				}
				// Windows Phone UA 中包含 IEMobile
				boolean isIEMobile = userAgent.indexOf("iemobile") > 0;

				if (isAndroid || isIOS || isIEMobile) {
					session.setAttribute("jugame_pf", JUGAME_PF_MOBILE);
					isMobile = true;
				}
			}
		}

		return isMobile;
	}
}
