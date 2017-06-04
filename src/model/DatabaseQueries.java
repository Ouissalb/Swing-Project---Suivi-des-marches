package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueries 
{
	public static boolean employeLoggedIn = false;
	public static boolean directorLoggedIn = false;
	public static boolean chefProjetLoggedIn = false;
	
	ResultSet rs = null;
	Connection connection = null;
	Statement statement = null; 
	
	public Employee getEmployee(String employeUsername)  
	{				
		Employee employee = null;
		String query = "SELECT * FROM EMPLOYE WHERE USERNAME= 'eGregory'";
		try {			
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			
			if (rs.next()) {
				employee = new Employee();
				employee.setempNom(rs.getString("NOM"));
				employee.setempPrenom(rs.getString("PRENOM"));
				employee.setempUsername(rs.getString("USERNAME"));
				employee.setempPassword(rs.getString("PASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return employee;
	}
	
	public boolean matchingUsername(String username, String typeSalarie)
	{
		String query = "SELECT * FROM "+typeSalarie +" WHERE USERNAME= '"+username+"'";
		String tempUSERNAME1 = "";
		System.out.println("Test" + query);
		try {			
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			
			if (rs.next()) 
			{
				tempUSERNAME1 = rs.getString("USERNAME");
			}
			else
			{
				System.out.println("no row found");
				return false; 
			}	
			if (tempUSERNAME1.equals(username))
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean isThePasswordCorrect(String username, String password,String typeSalarie)
	{
		String query = "SELECT * FROM "+typeSalarie+" WHERE USERNAME = '"+username+"'";
		String tempUSERNAME = "";
		String tempPASSWORD = "";
		try {			
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) 
			{
				tempUSERNAME = rs.getString("USERNAME");
				tempPASSWORD = rs.getString("PASSWORD");
			}
			else
			{
				System.out.println("no row found");
				return false;
			}	
				if (tempPASSWORD.equals(password))
				{
					switch(typeSalarie)
					{
						case "DIRECTEUR":
							directorLoggedIn = true;
							break;
						case "EMPLOYE":
							employeLoggedIn = true;
							break;
						case "CHEF_DE_PROJET":
							chefProjetLoggedIn = true;
							break;
					}
					return true;
				}
				else
					return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
