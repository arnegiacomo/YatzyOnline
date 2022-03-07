package no.hvl.dat109.mypackage;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB DAO dao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao.getAll().forEach(o -> System.out.println(o.toString()));
		request.getRequestDispatcher("WEB-INF/hello.jsp")
		.forward(request, response);

	}

}
