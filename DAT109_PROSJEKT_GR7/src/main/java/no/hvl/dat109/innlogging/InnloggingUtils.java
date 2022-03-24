package no.hvl.dat109.innlogging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class InnloggingUtils {
	
	public static int timeoutISekunder = 100000000;
	
	public static boolean isInnlogget(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute("innlogget") != null;
	}

	public static void loggInnMedTimeout(HttpServletRequest request, String epost) {

		loggUt(request);
		HttpSession sesjon = request.getSession(true);
		sesjon.setMaxInactiveInterval(timeoutISekunder);
		sesjon.setAttribute("innlogget", epost);
	}

	public static void loggUt(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

}
