package no.hvl.dat109.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
		
		//TODO midlertidig
		HashMap<Integer, Spill> spill = new HashMap<Integer, Spill>();
		spill.put(0, new Spill(0, null, 0, 0));
		spill.put(1, new Spill(1, null, 0, 0));
		spill.put(2, new Spill(2, null, 0, 0));
		spill.put(3, new Spill(3, null, 0, 0));
		
		Spill.setSpill(spill);
		request.setAttribute("spill", new ArrayList(Spill.getSpill().values()));
		
		if (!InnloggingUtils.isInnlogget(request)) {
			request.setAttribute("FEILMELDING", "Du har blitt logget ut!");
			request.getRequestDispatcher("WEB-INF/login.jsp")
			.forward(request, response);
			return;
		}
		
		request.getRequestDispatcher("WEB-INF/browse.jsp")
		.forward(request, response);
	}



}
