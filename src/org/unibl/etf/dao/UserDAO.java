package org.unibl.etf.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.unibl.etf.dto.User;
import org.unibl.etf.helper.Utility;

public class UserDAO {
	
	private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	
	private static final String SQL_SELECT_BY_USERNAME = "SELECT * FROM user WHERE username=?";
	private static final String SQL_SELECT_BY_EMAIL = "SELECT * FROM user WHERE email=?";
	private static final String SQL_INSERT_USER = "INSERT INTO user (first_name, last_name, username, password, email, picture, programme, year, interests, faculty) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static UserDAO instance = null;
	
	private UserDAO() {}
	
	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		
		return instance;
	}
	
	public User readByUsername(String username) {
		User user = null;
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object values[] = { username };
		try {
			connection = connectionPool.checkOut();
			PreparedStatement preparedStatement = DAOUtil.prepareStatement(connection, SQL_SELECT_BY_USERNAME, false, values);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				user = new User(resultSet.getInt("id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getString("email"),
						resultSet.getString("picture"), resultSet.getString("programme"),
						resultSet.getInt("year"), resultSet.getString("interests"),
						FacultyDAO.getInstance().readById(resultSet.getInt("faculty")));
			}
			preparedStatement.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		
		return user;
	}
	
	public User readByEmail(String email) {
		User user = null;
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object values[] = { email };
		try {
			connection = connectionPool.checkOut();
			PreparedStatement preparedStatement = DAOUtil.prepareStatement(connection, SQL_SELECT_BY_EMAIL, false, values);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				user = new User(resultSet.getInt("id"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getString("email"),
						resultSet.getString("picture"), resultSet.getString("programme"),
						resultSet.getInt("year"), resultSet.getString("interests"),
						FacultyDAO.getInstance().readById(resultSet.getInt("faculty")));
			}
			preparedStatement.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		
		return user;
	}
	
	public boolean createUser(User user) {
		boolean created = false;
		
		Connection connection = null;		
		
		Integer faculty = (user.getFaculty() != null) ? user.getFaculty().getId() : null;
		
		Object values[] = { user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getEmail(), user.getImage(), user.getProgramme(), user.getYear(), user.getInterests(), faculty };
		
		try {
			connection = connectionPool.checkOut();
			PreparedStatement preparedStatement = DAOUtil.prepareStatement(connection, SQL_INSERT_USER, true, values);
			int affectedRows = preparedStatement.executeUpdate();
			
			if (affectedRows == 0)
				created = false;
			else
				created = true;
			
			preparedStatement.close();
		} catch (SQLException e) {
			created = false;
		} finally {
			connectionPool.checkIn(connection);
		}
		
		return created;
	}

}
