package connect4.controllers;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;

import com.mysql.jdbc.Connection;

import connect4.views.HistoryDate;
import connect4.views.HistoryLabel;

public class ConnectionSQL {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", "root");
	    connectionProps.put("password", "");

	    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/connect_four",connectionProps);
	    
	    return conn;
	}
	
	
	
}
