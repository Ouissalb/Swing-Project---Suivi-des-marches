package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import view.LoginWindow;

public class DatabaseQueries 
{
	public static int projet_courant ;
	public static boolean employeLoggedIn = false;
	public static boolean directorLoggedIn = false;
	public static boolean chefProjetLoggedIn = false;

	static ResultSet rs = null;
	static ResultSet rs2 = null;
	static Connection connection = null;
	static Statement statement = null; 

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
			statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			int key;
			ResultSet keys = statement.getGeneratedKeys();    
			keys.next();  
			key = keys.getInt(1);

			System.out.println("Project ID aaaaaaaaaa\n\t" + key + "\t\n");
			if (key>0) 
			{
				projet_courant = key;
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

		String query = "INSERT INTO TACHE (CONTENU, DATE_FINALE, ETAT, DUREE, ID_PROJET) VALUES "
				+ "(\"" +
				//+ tache.getNumero() +", \""+
				tache.getContenu() +"\", '" +
				reportDate+"', " +
				"0, " +   //etat = 0 en cours ou 1 fini(ou validée)
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

	public boolean setLicence(Licence licence)
	{
		String query = "INSERT INTO LICENCE (description, id_projet) VALUES "
				+ "(\"" +
				licence.getDescription()+"\", " +
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

	public boolean setMateriel(Materiel materiel)
	{
		String query = "INSERT INTO MATERIEL (description, ID_PROJET) VALUES "
				+ "(\"" +
				//+ tache.getNumero() +", \""+
				materiel.getDescription() +"\", " +
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


	public String[] getObjectif(int id_projet)
	{
		String query = "SELECT OBJECTIF FROM PROJET WHERE ID = "+id_projet+" ;"; 
		try{
			System.out.println(query);
			String[] a = new String[10];
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			int i = 0;
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				a[i] = rs.getString(1);
				++i;
			}            
			System.out.println(a.length);
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

	public String[] getMateriels(int id_projet)
	{
		String query = "SELECT description FROM MATERIEL WHERE id_projet = "+id_projet+" ;"; 
		try{

			String[] a = new String[10];
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			int i = 0;
			while(rs.next() && i < 10)
			{
				a[i] = rs.getString(1);
				++i;
			}            
			System.out.println(a.length);
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

	public String[] getLicences(int id_projet)
	{
		String query = "SELECT description FROM LICENCE WHERE id_projet = "+id_projet+" ;"; 
		try{
			String[] a = new String[10];
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			int i = 0;
			while(rs.next() )
			{
				a[i] = rs.getString(1);
				System.out.println(rs.getString(1));
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

	public String getDate(int id_projet)
	{
		String query = "SELECT DATE FROM PROJET WHERE ID = "+id_projet+" ;";

		try{
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			rs.next();
			System.out.println(rs.getString(1));
			String a = rs.getString(1);

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

	public String getBudget(int id_projet)
	{
		String query2 = "SELECT BUDGET FROM PROJET WHERE ID = "+id_projet+" ;";

		try{
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query2);
			rs.next();
			System.out.println(rs.getString(1));
			String a = rs.getString(1);
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
	//Edit ///
	public int getTasksID(String taskContent, int id_projet){
		System.out.println("get tasks type: ["+taskContent + "] and id project is: "+id_projet);
		String query = "SELECT NUMERO FROM TACHE WHERE ID_PROJET = "+id_projet+" AND CONTENU =  \"" + taskContent + "\";";
		int returnID = 0;
		connection = JDBCMySQLConnection.getConnection();
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			while(rs.next() ){
				returnID = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnID;

	}
	//end edit///
	/// Edit///
	public String getCommentType(String commentText, int id_tache){
		System.out.println("get comment type. Comment:"+commentText);
		String query = "SELECT TYPE FROM COMMENTAIRE WHERE ID_TACHE = "+id_tache+" AND CONTENU = \""+commentText+"\";";
		System.out.println("get comment type query is:"+query);
		String cType = "";
		connection = JDBCMySQLConnection.getConnection();
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ResultSet rs = statement.executeQuery(query);
			while(rs.next())
			{
				System.out.println("===Returning Comment Type=== : " + rs.getString(1));

				switch ( rs.getInt(1) ){
				case 1:
					cType = "Urgent";
					break;

				case 2:
					cType = "Quotidien";
					break;
				case 3:
					cType =  "Informatif";
					break;
				}


			}    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (cType.isEmpty()) {
			return "Normal"; // if no type found, then return Normal.
		}
		else
		{
			return cType;
		}
	}
	///End Edit///

	public boolean setCommentaire(int id_employe, int id_tache, String contenu, int etat)
	{
		String query = "INSERT INTO COMMENTAIRE (ID_EMPLOYE, ID_TACHE, CONTENU, TYPE) VALUES ("
				+ ""+id_employe+", "+id_tache+", \""+contenu+"\", "+etat+");";

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

	public int[] getCommsEtat(int num_tache)
	{
		String query = "SELECT TYPE FROM COMMENTAIRE WHERE ID_TACHE = "+num_tache+";";
		System.out.println(query);
		try{
			int[] a = new int[100];
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			int i = 0;
			while(rs.next() )
			{
				a[i] = rs.getInt(1);
				System.out.println("type "+ rs.getInt(1));
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

	public String[] getCommentaires(int id_employe, int id_tache)
	{
		String query = "SELECT CONTENU FROM COMMENTAIRE WHERE ID_TACHE = "+id_tache+" AND ID_EMPLOYE = "+id_employe+";";
		System.out.println(query);
		try{
			String[] a = new String[100];
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			int i = 0;
			while(rs.next())
			{
				a[i] = rs.getString(1);
				System.out.println("commentaire : "+ rs.getString(1));
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

	public int getIdTache(String contenu,String date)
	{
		String query = "SELECT NUMERO, DATE_FINALE, CONTENU FROM TACHE;";
		try{
			int id = -1;
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next() )
			{
				if(rs.getString(2).equals(date) && rs.getString(3).equals(contenu))
					id = rs.getInt(1);
				System.out.println("id : "+ id);
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
		return -1;
	}

	public String[] getTasksContenu(int id_projet)
	{
		String query = "SELECT CONTENU FROM TACHE WHERE ID_PROJET = "+id_projet+" ;";
		try{
			String[] a = new String[10];
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			int i = 0;
			while(rs.next() )
			{
				a[i] = rs.getString(1);
				System.out.println(" contenu : " + rs.getString(1));
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

	public String[] getTasksEtat(int id_projet)
	{
		String query = "SELECT ETAT FROM TACHE WHERE ID_PROJET = "+id_projet+" ;";
		try{
			String[] a = new String[10];
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			int i = 0;
			while(rs.next() )
			{
				a[i] = rs.getString(1);
				System.out.println(rs.getString(1));
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

	public int countTasks(int id_projet)
	{
		String query = "SELECT COUNT(*) FROM TACHE WHERE ID_PROJET = "+id_projet;
		try{
			String[] a = new String[10];
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			int i = 0,count=0;
			while(rs.next() )
			{
				count = rs.getInt(1);
				System.out.println(rs.getInt(1));
			}            
			return count;
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
		return 0;
	}

	public static void validerTacheChef(int id_tache)
	{

		connection = JDBCMySQLConnection.getConnection();
		System.out.println("id tache  : " + id_tache);
		String query = "UPDATE TACHE SET ETAT = 100 WHERE NUMERO = "+id_tache+";"; 
		System.out.println("valider Tache :");
		try{
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.executeUpdate(query);

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
	}

	public static void addBudgetToDB(int id_projet, int budget)
	{

		connection = JDBCMySQLConnection.getConnection();
		System.out.println("id projet  : " + id_projet);
		String query = "UPDATE PROJET SET BUDGET = "+budget+" WHERE ID = "+id_projet+";"; 
		try{
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.executeUpdate(query);

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
	}
	//Chart//
	public int getTotalTache(int id_projet){
		String query = "SELECT COUNT(*) FROM TACHE WHERE ID_PROJET = " + id_projet + ";" ;
		System.out.println("get total tache query: "+query);
		int totalCount = 0;
		try{

			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next() )
			{
				totalCount = rs.getInt(1);
				System.out.println("Get Total Tache: "+ totalCount);

			}            

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
		return totalCount;


	}
	public int getValidTache(int id_projet){
		String query = "SELECT COUNT(*) FROM TACHE WHERE ID_PROJET = " + id_projet + " AND ETAT = 100" + ";" ;
		int validCount = 0;
		try{

			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while(rs.next() )
			{
				validCount = rs.getInt(1);
				System.out.println("Get Valid Tache: "+ validCount);

			}            

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
		return validCount;


	}

	///End ///
	public static void validerTacheEmp(int id_tache)
	{

		connection = JDBCMySQLConnection.getConnection();
		System.out.println("id tache  : " + id_tache);
		String query = "UPDATE TACHE SET ETAT = 1 WHERE NUMERO = "+id_tache+";"; 
		System.out.println("valider Tache :");
		try{
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.prepareStatement(query);
			statement.executeUpdate(query);

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
	}

	public String[] getTasksDate(int id_projet)
	{
		String query = "SELECT DATE_FINALE FROM TACHE WHERE ID_PROJET = "+id_projet+" ;";
		try{
			String[] a = new String[10];
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			int i = 0;
			while(rs.next() )
			{
				a[i] = rs.getString(1);
				System.out.println(rs.getString(1));
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

	public String[] getTasksValidee(int id_projet)
	{
		String query = "SELECT CONTENU FROM TACHE WHERE ID_PROJET = "+id_projet+" AND ETAT = 1;";
		try{
			String[] a = new String[10];
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			if(!rs.next()) return null;
			int i = 0;
			while(rs.next() )
			{
				a[i] = rs.getString(1);
				System.out.println(rs.getString(1));
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

	public static boolean projetValide(int id_projet)
	{
		String query = "SELECT ETAT FROM TACHE WHERE ID_PROJET = "+id_projet+" ;";
		try{
			int[] a = new int[10];
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			int i = 0;
			while(rs.next() )
			{
				a[i] = rs.getInt("ETAT");
				if (a[i] != 100)
				{
					System.out.print("Exiting ... une tache n'est pas encore validée, projet n'est pas encore validé");
					return false;
				}
				System.out.println(rs.getString("ETAT"));
				++i;
			}   
			JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(), "Ce projet est validé !",
					"Projet validé",
					JOptionPane.ERROR_MESSAGE);
			return true;
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
		return false;
	}

	public String[] getTacheFinaleDate()
	{
		String query ="SELECT DATE_FINALE FROM TACHE ;";

		try{
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			String[] a = new String[20] ;
			int i = 0;
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				a[i] = rs.getString(1);
				i++;
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

	/*
        public static String[] populatingComboBoxWithProjects()
        {
    		String query = "SELECT * FROM PROJET";  //service will be added later 
    		ArrayList<String> comboBoxProjects = new ArrayList<String>();
    		try {			
    			connection = JDBCMySQLConnection.getConnection();
    			statement = connection.createStatement();
    			rs = statement.executeQuery(query);

    			if (rs.next()) {
    				comboBoxProjects.add(rs.getString("OBJECTIF"));		
    			}
    		System.out.println(comboBoxProjects.size());
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
    		String [] projectsArray = comboBoxProjects.toArray(new String[comboBoxProjects.size()]);
    		return projectsArray;        	
        }

	 */
	public static String[] populatingComboBoxWithProjects()
	{
		String query = "SELECT * FROM PROJET";  //service will be added later 
		ArrayList<String> comboBoxProjects = new ArrayList<String>();
		try {			
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);

			if (rs.next()) {
				comboBoxProjects.add(rs.getString("OBJECTIF"));		
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
		String [] projectsArray = comboBoxProjects.toArray(new String[comboBoxProjects.size()]);
		return projectsArray;        	
	}

}
/*public static String[] populatingListWithTasks(String projetObj)
        {
    		String query = "SELECT * FROM PROJET WHERE OBJECTIF = '"+projetObj+"'";  
    		int idProjet = 0;
    		ArrayList<String> listTasks = new ArrayList<String>();
    		try {			
    			connection = JDBCMySQLConnection.getConnection();
    			statement = connection.createStatement();
    			rs = statement.executeQuery(query);

    			if (rs.next()) {
    				idProjet = rs.getInt("ID");	
    				System.out.println(idProjet);
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
    		String query2 = "SELECT * FROM TACHE WHERE ID_PROJET = '"+idProjet+"'";  

    		try {			
    			connection = JDBCMySQLConnection.getConnection();
    			statement = connection.createStatement();
    			rs2 = statement.executeQuery(query2);

    			if (rs.next()) {
    				listTasks.add(rs2.getString("CONTENU"));	
    				System.out.println(rs2.getString("CONTENU"));
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

    		String [] tasksArray = listTasks.toArray(new String[listTasks.size()]);
    		return tasksArray;

        }

}*/

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