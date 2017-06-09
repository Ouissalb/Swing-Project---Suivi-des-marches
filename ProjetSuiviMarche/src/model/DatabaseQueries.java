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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import view.LoginWindow;

public class DatabaseQueries 
{
        public static int projet_courant ;
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
        
        public boolean setProjetInDB(Projet projet)
        {
            String query1 = "SELECT * FROM EMPLOYE WHERE USERNAME = '"+LoginWindow.user_logged_in+"' ;";
            String user_service = "";
            
            try {			
                connection = JDBCMySQLConnection.getConnection();
                statement = connection.createStatement();
		rs = statement.executeQuery(query1);
		if (rs.next()) 
                {
                    user_service = rs.getString("SERVICE");
                    System.out.println("waaaaawawaa\n\t"+user_service+"\t");
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
            
            System.out.println("Are you here?");
            System.out.println(user_service);
            
            System.out.println("hahouwaaaaa\n\t");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String reportDate = df.format(projet.getDateFinale());
            System.out.println(reportDate);
            
            String query = "INSERT INTO PROJET (OBJECTIF, DATE, BUDGET, SERVICE) VALUES " +
                    " (\"" +
                        //projet.getId() +", \""+ AUTOINCREMENT
                        projet.getObjectif() +"\", '" +
                        reportDate+"', " +
                        projet.getBudget()+", \""+
                        user_service +"\"" 
                    + ");";
                        
            System.out.println(query);
            
            try {
                connection = JDBCMySQLConnection.getConnection();
                statement = connection.createStatement();
		int a = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                System.out.println("Project ID aaaaaaaaaa\n\t" + a + "\t\n");
		if (a>0) 
                {
                    projet_courant = a;
                    return true;
		}
                else
                    return false;
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
            return false;
        }
        
        public boolean setTache(Tache tache)
        {
            System.out.println("hahouwaaaaa\n\t");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String reportDate = df.format(tache.getDate());
            System.out.println(reportDate);
            
            String query = "INSERT INTO TACHE (CONTENU, DATE_FINALE, DUREE, ID_PROJET) VALUES "
                    + "(\"" +
                        //+ tache.getNumero() +", \""+
                        tache.getContenu() +"\", '" +
                        reportDate+"', " +
                        tache.getDuree()+", "+
                        //tache.getEtat()+"\", "+
                        projet_courant +""
                    + ");";
            
            System.out.println(query);
            
            try {
                connection = JDBCMySQLConnection.getConnection();
                statement = connection.createStatement();
		int b = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                System.out.println("\n\t bbbbbb = " + b + "\t\n");
                return b>0 ? true : false;
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
            return false;
        }
        
        public String[] getProjects()
        {
            String query = "SELECT * FROM PROJET;";
            try{
                
            String[] a = new String[10];
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            int i = 0;
            while(rs.next() && i < 10)
            {
                a[i] = "id :" + Integer.toString(rs.getInt("ID")) +" Ojectif :"+ rs.getString("OBJECTIF");
                System.out.println(a.length);
                ++i;
            }            
            return a;
            }catch(Exception e)
            {
                e.printStackTrace();
            }finally
            {
                if (connection != null) 
                {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
}
        /*
        public int getProjectId()
        {
            try
            {
            String query = "select ID from PROJET;";
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            int id = 1;
            while(rs.next())
            {
                id = rs.getInt("ID");
            }            
            return id;
            
            }catch(Exception e)
            {
                e.printStackTrace();
            }finally
            {
                if (connection != null) 
                {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

            return 1;
        }
}*/