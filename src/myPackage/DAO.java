package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import myPackage.Users;

public class DAO {
	
	private Connection connection = null;
	public DAO() {	
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost/crudproject","root","Warlen1998");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public List<Users> getLista(){
		
		List<Users> users = new ArrayList<Users>();
		
		PreparedStatement stmt = null;
		try {
			stmt = connection.
					prepareStatement("SELECT * FROM PESSOAS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				Users user = new Users();
				user.setId(rs.getInt("id"));
				user.setNome(rs.getString("nome"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("nascimento"));
				user.setNascimento(data);
				user.setAltura(rs.getDouble("altura"));
				users.add(user);
				
			rs.close();
			stmt.close();
			} 
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return users;
	}


}
