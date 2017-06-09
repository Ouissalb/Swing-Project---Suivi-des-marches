package model;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import view.*;
import controller.*;


public class MainApp {
	public static void main(String[] args) 
	{		
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try {
					LoginWindow loginWindow = new LoginWindow();

				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
		try 
		{
			DatabaseQueries demo = new DatabaseQueries();
			Employee employee = demo.getEmployee("Egregory");
			System.out.println(employee);			
		} 
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
		}		
	}


}