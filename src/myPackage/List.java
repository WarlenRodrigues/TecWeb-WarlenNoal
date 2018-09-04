package myPackage;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/list")

public class List extends HttpServlet {
	
	protected void service (HttpServletRequest request,
							HttpServletResponse response)

		throws ServletException, IOException {
		
		DAO dao = new DAO();
		
		List<Users> users = dao.getLista();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border='1'>");
		out.println("<tr><td>ID</td><td>Nome</td></tr>" +
				"<td>Nascimento</td><td>Altura</td></tr>");
		for (Users user : users) {
			out.println("<tr><td>"+user.getId() +	"</td>");
			out.println("<td>" + user.getNome() +	"</td>");
			out.println("<td>" + user.getNascimento().getTime() +	"</td>");
			out.println("<td>" + user.getAltura()	+ "</td></tr>");
		}
		out.println("</table><body><html>");
	}
	
}
