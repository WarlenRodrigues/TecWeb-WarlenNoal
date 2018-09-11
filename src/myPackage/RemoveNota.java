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
		PrintWriter out = response.getWriter();
	out.println("<html><body>");
	out.println("<form method='post'>");
	out.println("Remover ID: <input type='number' name='id'><br>");
	out.println("<input type='submit' value='Submit'>");
	out.println("</form>");
	out.println("<body><html>");
	}

	@Override
	 protected void doPost(HttpServletRequest request,
	 HttpServletResponse response)
	 throws ServletException, IOException {
	 DAO dao = new DAO();
	 dao.removeNota(Integer.valueOf(request.getParameter("id")));
	 PrintWriter out = response.getWriter();
	 out.println("<html><body>");
	 out.println("Nota Removida");
	 out.println("</body></html>");
	 dao.close();
	 }
}