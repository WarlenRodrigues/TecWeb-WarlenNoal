package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			stmt = connection.prepareStatement("SELECT * FROM user");
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
//				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setUsername(rs.getString("username"));
				user.setAge(rs.getInt("age"));
				user.setEmail(rs.getString("email"));
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
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public void adiciona(Users user) {
		String sql = "INSERT INTO user" + "(name, surname, username, age, email) values(?,?,?,?,?)";
		try {
			PreparedStatement stmt = null;
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getSurname());
			stmt.setString(3, user.getUsername());
			stmt.setInt(4,user.getAge());
			stmt.setString(5, user.getEmail());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void altera(Users user) {
		String sql = "UPDATE user SET" + "name=?, surname=?, username=?, age=?, email=? WHERE user_id=?";	
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getSurname());
			stmt.setString(3, user.getUsername());
			stmt.setInt(4,user.getAge());
			stmt.setString(5, user.getEmail());
			stmt.setInt(6, user.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove(Integer id) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM users WHERE user_id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}


}
