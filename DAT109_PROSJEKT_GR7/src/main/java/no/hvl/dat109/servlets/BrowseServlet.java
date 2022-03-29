package no.hvl.dat109.servlets;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.app.Spill;
import no.hvl.dat109.utils.InnloggingUtils;

/**
 * 
 * @author arnemunthe-kaas
 *
 */
@WebServlet(name = "BrowseServlet", urlPatterns = "/browse")
public class BrowseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!InnloggingUtils.isInnlogget(request)) {
			request.setAttribute("FEILMELDING", "Du har blitt logget ut!");
			request.getRequestDispatcher("WEB-INF/login.jsp")
			.forward(request, response);
			return;
		}
		
		List<Spill> allespill = Spill.getSpill();
		List<Spill> ikkeStartet = allespill.stream().filter(s -> !s.startet()).collect(Collectors.toList());
		List<Spill> startet = allespill.stream().filter(s -> s.startet()).collect(Collectors.toList());
		
		request.setAttribute("ikkeStartet", ikkeStartet);
		request.setAttribute("startet", startet);
		
		
		
		request.getRequestDispatcher("WEB-INF/browse.jsp")
		.forward(request, response);
	}



}
