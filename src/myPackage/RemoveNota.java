package myPackage;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/removenota")

public class RemoveNota extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {

	}

	@Override
	 protected void doPost(HttpServletRequest request,
	 HttpServletResponse response)
	 throws ServletException, IOException {
	 DAO dao = new DAO();
	 dao.removeNota(Integer.valueOf(request.getParameter("id")));
	 dao.close();
	 request.getRequestDispatcher("home.jsp").forward(request, response);

	 }
}