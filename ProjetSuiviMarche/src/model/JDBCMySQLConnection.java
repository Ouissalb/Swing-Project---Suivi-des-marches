/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author boughriba
 */
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class JDBCMySQLConnection 
	{
		//static reference to itself
		private static JDBCMySQLConnection instance = new JDBCMySQLConnection();
		public static final String URL = "jdbc:mysql://localhost/projet";
		public static final String USER = "root";
		public static final String PASSWORD = "inStagram3";
		public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver"; 
		
		//private constructor
		private JDBCMySQLConnection() 
		{
			try {
				//Step 2: Load MySQL Java driver
				Class.forName(DRIVER_CLASS);
				}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		
		private Connection createConnection()
		{

			Connection connection = null;
			try {
				//Step 3: Establish Java MySQL connection
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
                            e.printStackTrace();
				System.out.println("ERROR: Unable to Connect to Database.");    
			}
			return connection;
		}	
		
		public static Connection getConnection() 
		{
			return instance.createConnection();
		}
	}


