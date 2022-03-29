package no.hvl.dat109.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.database.Bruker;

public class InnloggingUtils {
	
	public static int timeoutISekunder = 100000000;
	
	public static boolean isInnlogget(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute("innlogget") != null;
	}
	
	public static Bruker getInnlogget(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		return (Bruker) session.getAttribute("innlogget");
	}

	public static void loggInnMedTimeout(HttpServletRequest request, Bruker bruker) {

		loggUt(request);
		HttpSession sesjon = request.getSession(true);
		sesjon.setMaxInactiveInterval(timeoutISekunder);
		sesjon.setAttribute("innlogget", bruker);
	}

	public static void loggUt(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

}
