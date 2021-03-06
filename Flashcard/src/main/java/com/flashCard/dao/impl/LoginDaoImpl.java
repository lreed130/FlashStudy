package com.flashCard.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.servlet.ModelAndView;

import com.flashCard.dao.LoginDao;
import com.flashCard.model.User;

import javax.servlet.http.HttpServletRequest;

public class LoginDaoImpl implements LoginDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;
 
	public void saveLogin(User user) {
		String dbName = "jdbc:mysql://ec2-13-58-137-45.us-east-2.compute.amazonaws.com:3306/myDB";
		String dbUserName = "newremoteuser";
		String dbPassword = "password";
		Connection conn = null;
		ModelAndView mav = null;
		if (validateEmail(user) != true){
			  mav = new ModelAndView("Register");
			  mav.addObject("message", "Email already in use");
			  validateEmail(user);
		  }
		  if (validateUsername(user) != true){
			  mav = new ModelAndView("Register");
			  mav.addObject("message", "Username already in use");
			  validateUsername(user);
		  }
		 try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(dbName, dbUserName, dbPassword);
            System.out.println("Database connection established");
    		String insertSQL = "INSERT INTO User (USER_NAME, PASSWORD, EMAIL,NICKNAME) VALUES ('" + user.getUsername() + "' , '" + user.getPassword() +"', '" + user.getEmail() +"', '" +  user.getNickname() +"')";
    		PreparedStatement preparedStatement = conn.prepareStatement(insertSQL);
    		boolean rs= preparedStatement.execute();
        
		 } 
		 catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 try {
		 conn.close();
		} 
	 catch (SQLException e) {	
			e.printStackTrace();
		}
	}
	public boolean validateEmail(User user){
		String dbName = "jdbc:mysql://ec2-13-58-137-45.us-east-2.compute.amazonaws.com:3306/myDB";
		String dbUserName = "newremoteuser";
		String dbPassword = "password";
		Connection conn = null;
		ModelAndView mav = null;

		Statement st;
		try {
			st = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = ("SELECT * FROM User WHERE EMAIL =" + user.getEmail() + ";");
		ResultSet rs=null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rs == null){
			return true;
		}
		else {
			mav = new ModelAndView("Register");
			mav.addObject("Message", "Invalid, user with that email already exists");
			return false;
			}
	}
	public boolean validateUsername(User user){
		String dbName = "jdbc:mysql://ec2-13-58-137-45.us-east-2.compute.amazonaws.com:3306/myDB";
		String dbUserName = "newremoteuser";
		String dbPassword = "password";
		Connection conn = null;
		ModelAndView mav = null;
		
		Statement st =null;
		try {
			st = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = ("SELECT * FROM User WHERE USER_NAME =" + user.getUsername() + ";");
		ResultSet rs=null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rs == null){
			return true;
		}
		else {
			mav = new ModelAndView("Register");
			mav.addObject("Message", "User with that email already exists");
			return false;
			}
	}
	public User validateLogin(User login) {
		User user = null;
		String sql = "select * from User where USER_NAME='" + login.getUsername() + "' and PASSWORD='"
				+ login.getPassword() + "'";
		String dbName = "jdbc:mysql://ec2-13-58-137-45.us-east-2.compute.amazonaws.com:3306/myDB";
		String dbUserName = "newremoteuser";
		String dbPassword = "password";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(dbName, dbUserName, dbPassword);
           System.out.println("Database connection established");
           PreparedStatement preparedStatement = conn.prepareStatement(sql);
   		
   		ResultSet rs= preparedStatement.executeQuery();
		while(rs.next()) {
			String username= rs.getString("USER_NAME");
			String nickname = rs.getString("NICKNAME");
			String email = rs.getString("EMAIL");
			String password = rs.getString("PASSWORD");
			user = new User(username, nickname, password, email);
			}
		} 
		 catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 

	 try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return user;
	}
	class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("USER_NAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setNickname(rs.getString("NICKNAME"));
		user.setEmail(rs.getString("EMAIL"));
		return user;
	}
}
}