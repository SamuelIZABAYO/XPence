package XPence.XPence.Service;

import javax.servlet.http.HttpServletRequest;

public class Utitlity {
    public static String getSiteURL(HttpServletRequest request) {
	String siteURL = request.getRequestURI().toString();
	return siteURL.replaceAll(request.getServletPath(), "");
    }
}
