package myPackage;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/lista")

public class Lista extends HttpServlet {
	
	protected void service (HttpServletRequest request,
							HttpServletResponse response)

		throws ServletException, IOException {
		
		DAO dao = new DAO();
		
		List<Users> users = dao.getLista();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border='1'>");
		out.println("<tr><td>Nome</td><td>Sobrenome</td></tr>" +
				"<td>Usuário</td><td>Idade</td><td>E-mail</td></tr>");
		for (Users user : users) {
			out.println("<tr><td>" + user.getName() +	"</td>");
			out.println("<td>" + user.getSurname() +	"</td>");
			out.println("<td>" + user.getUsername() +	"</td>");
			out.println("<td>" + user.getAge()	+ "</td></tr>");
			out.println("<td>" + user.getEmail() +	"</td>");

		}
		out.println("</table><body><html>");
		dao.close();
	}
	
	
}
