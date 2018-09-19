package myPackage;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/atualizanota")

public class AtualizaNota extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

//		
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>");
//		out.println("<form method='post'>");
//		out.println("Título: <input type='text' name='title'><br>");
//		out.println("Conteúdo: <textarea name='content' cols='30' rows='7'> </textarea><br>");
//		out.println("<input type='submit' value='Submit'>");
//		out.println("</form>");
//		out.println("<body><html>");
	}


	@Override
	protected void doPost (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
			DAO dao = new DAO();
			
			Notas nota = new Notas();
			
			nota.setId(Integer.valueOf(request.getParameter("id")));
			nota.setTitle(request.getParameter("title"));
			nota.setContent(request.getParameter("content"));
			nota.setUserID(Integer.valueOf(request.getParameter("user_id")));
			nota.setUsername(request.getParameter("username"));
			
			dao.alteraNota(nota);
			dao.close();
			
			request.setAttribute("userId", nota.getUserID());
			request.setAttribute("Username", nota.getUsername());

			request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			
}
