package myPackage;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/crianota")

public class CriaNota extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post' action='home.jsp'>");
		out.println("Título: <input type='text' name='title'><br>");
		out.println("Conteúdo: <textarea name='content' cols='30' rows='7'> </textarea><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
		}
	
	@Override
	protected void doPost (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
			DAO dao = new DAO();
			
			Notas nota = new Notas();
//			Users user = new Users();
			
			nota.setTitle(request.getParameter("title"));
			nota.setContent(request.getParameter("content"));
			
			dao.adicionaNota(nota);

//			PrintWriter out = response.getWriter();
//			out.println("<html><body>");
//			out.println("Nota adicionada: " + nota.getTitle());
//			out.println("</body></html>");
			
			dao.close();
			}
			
}
