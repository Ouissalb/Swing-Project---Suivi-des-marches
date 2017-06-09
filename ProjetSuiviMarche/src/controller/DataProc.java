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
        /*
        public int getProjectId()
        {
            return this.dbQuerie.getProjectId();
        }
        */
}