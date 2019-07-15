package org.unibl.etf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.unibl.etf.dto.Faculty;
import org.unibl.etf.dto.User;

public class FacultyDAO {

private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
	
	private static final String SQL_SELECT_BY_ID = "SELECT * FROM user WHERE id=?";
	
	private static FacultyDAO instance = null;
	
	private FacultyDAO() {}
	
	public static FacultyDAO getInstance() {
		if (instance == null) {
			instance = new FacultyDAO();
		}
		
		return instance;
	}
	
	public Faculty readById(Integer id) {
		Faculty faculty = null;
		
		Connection connection = null;
		ResultSet resultSet = null;
		Object values[] = { id };
		try {
			connection = connectionPool.checkOut();
			PreparedStatement preparedStatement = DAOUtil.prepareStatement(connection, SQL_SELECT_BY_ID, false, values);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				faculty = new Faculty(resultSet.getInt("id"), resultSet.getString("name"));
			}
			
			preparedStatement.close();
		} catch (SQLException exp) {
			exp.printStackTrace();
		} finally {
			connectionPool.checkIn(connection);
		}
		
		return faculty;
	}

	
}
