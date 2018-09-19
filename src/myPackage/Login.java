package myPackage;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		}
	
	@Override
	protected void doPost (HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

			DAO dao = new DAO();
		
			Tentativas tentativa = new Tentativas();
			tentativa.setUsername(request.getParameter("username"));
			tentativa.setPassword(request.getParameter("password"));
		
			dao.autenticaUsuario(tentativa);
			Users autenticatedUser = dao.setUser(tentativa.getUsername());
			System.out.println(autenticatedUser);
			
			request.setAttribute("userId", dao.autenticaUsuario(tentativa).getId());
			request.setAttribute("Username", autenticatedUser.getName());
			request.getRequestDispatcher("home.jsp").forward(request, response);

			dao.close();
		}	
}	
