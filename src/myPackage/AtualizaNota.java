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
		out.println("<form method='post'>");
		out.println("ID: <input type='number' name='user_id'><br>");
		out.println("Nome: <input type='text' name='name'><br>");
		out.println("Sobrenome: <input type='text' name='surname'><br>");
		out.println("Usuário: <input type='text' name='username'><br>");
		out.println("Idade: <input type='number' name='age' step='1'><br>");
		out.println("E-mail: <input type='text' name='email'><br>");
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
			Users user = new Users();
			
			nota.setId(Integer.valueOf(request.getParameter("nota_id")));
			nota.setTitle(request.getParameter("title"));
			nota.setContent(request.getParameter("content"));
			
			dao.alteraNota(nota, user);
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("Nota Atualizada");
			out.println("</body></html>");
			
			dao.close();
			}
			
}
