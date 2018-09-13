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

		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post' action='home.jsp'>");
		out.println("ID da nota: <input type='number' name='nota_id'><br>");
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
			
			nota.setId(Integer.valueOf(request.getParameter("nota_id")));
			nota.setTitle(request.getParameter("title"));
			nota.setContent(request.getParameter("content"));
			
			dao.alteraNota(nota);
			
//			PrintWriter out = response.getWriter();
//			out.println("<html><body>");
//			out.println("Nota Atualizada");
//			out.println("</body></html>");
			
			dao.close();
			}
			
}
