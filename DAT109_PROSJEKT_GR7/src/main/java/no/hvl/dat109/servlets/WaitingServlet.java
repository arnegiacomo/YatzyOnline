package no.hvl.dat109.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.app.Admin;
import no.hvl.dat109.app.Spill;
import no.hvl.dat109.utils.InnloggingUtils;

/**
 * Servlet implementation class WaitingServlet
 */
@WebServlet(name = "WaitingServlet", urlPatterns = "/waiting")
public class WaitingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Spill spill; 

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
		
		request.setAttribute("spill", this.spill);
		request.setAttribute("bruker", InnloggingUtils.getInnlogget(request));
		
	
		request.getRequestDispatcher("WEB-INF/waiting.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Meh dårlig kode fikse? TODO
		String create = req.getParameter("create");
		
		if(create != null){
			Spill spill = new Spill(new Admin(InnloggingUtils.getInnlogget(req)));
			this.spill = spill;
			doGet(req, resp);
		}
		
		String join = req.getParameter("join");
		
		if(join != null){
			
		}
		
		String spectate = req.getParameter("spectate");
		
		if(spectate != null){
			
		}
		
	}

}
