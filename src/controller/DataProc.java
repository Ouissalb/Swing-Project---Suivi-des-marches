/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author boughriba
 */

import java.sql.Date;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import model.*;
import view.*;
public class DataProc 
{
	private DatabaseQueries dbQuerie = new DatabaseQueries();
	// to hide the login window once the user is connected
	public static boolean loggedInOrNot = false;

	public boolean login(String username, String password, String typeSalarie)
	{
		if (dbQuerie.matchingUsername(username, typeSalarie))
		{
			if (dbQuerie.isThePasswordCorrect(username, password, typeSalarie))
			{
				if(DatabaseQueries.directorLoggedIn)
				{
					DirectorView1 directorView1 = new DirectorView1();
				}
				else if (DatabaseQueries.employeLoggedIn)
				{
					EmployeeView1 employeView1 = new EmployeeView1();
				}
				else if (DatabaseQueries.chefProjetLoggedIn)
				{
					ChefProjetView1 chefProjetView1 = new ChefProjetView1();
				}

				loggedInOrNot = true;
				return true;
			}
			else
			{ 
				MessageBoxes.incorrectPassword();	
				return false;
			}
		}
		else
		{
			MessageBoxes.usernameDoesntExist();		
			return false; 
		}
	}

	public void loggedInSuccessfully(String username, String password, String typeSalarie)
	{
		if (login(username, password, typeSalarie)== true)
			System.out.println("logged in");
		else
			System.out.println("some issue happened");
	}

	public static void showTheNextWindow()
	{
		if(DatabaseQueries.directorLoggedIn)
		{
			DirectorView1.directorView1.setVisible(true);
		}
		else if (DatabaseQueries.employeLoggedIn)
		{
			EmployeeView1.employeeView1.setVisible(true);
		}
		else if (DatabaseQueries.chefProjetLoggedIn)
		{
			//ChefProjetView1.chefProjetView1.setVisible(true);
		}		
	}

	public String[] getProjects()
	{
		return this.dbQuerie.getProjects();
	}

	public String[] getObjectif(int id_projet)
	{
		return this.dbQuerie.getObjectif(id_projet);
	}

	public String[] getMateriels(int id_projet)
	{
		return this.dbQuerie.getMateriels(id_projet);
	}

	public String[] getLicences(int id_projet)
	{
		return this.dbQuerie.getLicences(id_projet);
	}

	public String getDate(int id_projet)
	{
		return this.dbQuerie.getDate(id_projet);
	}

	public String getBudget(int id_projet)
	{
		return this.dbQuerie.getBudget(id_projet);
	}

	public String[] getTasksContenu(int id_projet)
	{
		return this.dbQuerie.getTasksContenu(id_projet);
	}

	public String[] getTasksDate(int id_projet)
	{
		return this.dbQuerie.getTasksDate(id_projet);
	}

	public String[] getTasksEtat(int id_projet)
	{
		return this.dbQuerie.getTasksEtat(id_projet);
	}

	public int countTasks(int id_projet)
	{
		return this.dbQuerie.countTasks(id_projet);
	}

	public String[] getTasksValidee(int id_projet)
	{
		return this.dbQuerie.getTasksValidee(id_projet);
	}

	public String[] getCommentaires(int id_employe,int id_tache)
	{
		return this.dbQuerie.getCommentaires(id_employe,id_tache);
	}

	public int getIdTache(String contenu,String date)
	{
		return this.dbQuerie.getIdTache(contenu,date);
	}
	public String getCommentType(String commentText,int id_tache)//// Edit
	{
		return this.dbQuerie.getCommentType(commentText,id_tache);
	}
	public int getTasksID(String taskContent, int id_projet) /// Edit
	{
		return this.dbQuerie.getTasksID(taskContent, id_projet);
	}

	public boolean setCommentaire(int id_employe, int id_tache, String contenu,int etat)
	{
		return this.dbQuerie.setCommentaire(id_employe,id_tache,contenu,etat);
	}

	public int[] getCommsEtat(int num_tache)
	{
		return this.dbQuerie.getCommsEtat(num_tache);
	}

	//Chart//
	public int getTotalTache(int id_projet){
		return this.dbQuerie.getTotalTache(id_projet);
	}
	public int getValidTache(int id_projet){
		return this.dbQuerie.getValidTache(id_projet);
	}

	///END///

	/*
        public int getProjectId()
        {
            return this.dbQuerie.getProjectId();
        }
	 */
}