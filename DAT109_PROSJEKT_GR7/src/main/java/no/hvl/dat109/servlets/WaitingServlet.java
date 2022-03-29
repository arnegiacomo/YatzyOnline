package no.hvl.dat109.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat109.app.Admin;
import no.hvl.dat109.app.Spill;
import no.hvl.dat109.app.Spiller;
import no.hvl.dat109.app.Tilskuer;
import no.hvl.dat109.utils.InnloggingUtils;

/**
 * 
 * @author arnemunthe-kaas
 *
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
		
		if(spill.startet()) {
			response.sendRedirect("game");
			return;
		}
		
		
		request.setAttribute("bruker", InnloggingUtils.getInnlogget(request));
		
	
		request.getRequestDispatcher("WEB-INF/waiting.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Meh dårlig kode fikse? TODO faen dette er den styggeste servleten gjennom tidene -arne
		String create = req.getParameter("create");
		
		if(create != null && create.equals("new")){
			Admin admin = new Admin(InnloggingUtils.getInnlogget(req));
			Spill spill = new Spill(admin);
			this.spill = spill;
			
			HttpSession session = req.getSession(false);
			session.setAttribute("spill", spill);
			
			doGet(req, resp);
			return;
		}
		
		String join = req.getParameter("join");
		
		if(join != null){
			Spill spill = Spill.getSpillFraID(Integer.parseInt(join));
		
			spill.join(new Spiller(InnloggingUtils.getInnlogget(req)));
			this.spill = spill;
			
			HttpSession session = req.getSession(false);
			session.setAttribute("spill", spill);
			
			doGet(req, resp);
			return;
		}
		
		String spectate = req.getParameter("spectate");
		
		if(spectate != null){
			Spill spill = Spill.getSpillFraID(Integer.parseInt(spectate));
			spill.spectate(new Tilskuer(InnloggingUtils.getInnlogget(req)));
			this.spill = spill;
			
			HttpSession session = req.getSession(false);
			session.setAttribute("spill", spill);
			
			doGet(req, resp);
			return;
		}
		
		String start = req.getParameter("start");
		
		if(start != null) {
			spill.start();
			resp.sendRedirect("game");
		}
		
		
		
		//  TODO feilhåndtering?
				
	}

}
