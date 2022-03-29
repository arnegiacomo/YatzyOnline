package no.hvl.dat109.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.utils.InnloggingUtils;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet(name = "GameServlet", urlPatterns = "/game")
public class GameServlet extends HttpServlet {
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
		
		request.getRequestDispatcher("WEB-INF/game.jsp")
		.forward(request, response);
	}



}
