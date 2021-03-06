/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author boughriba
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import controller.*;

public class LoginWindow {

        public static String user_logged_in = "";
        
	private static JFrame frameForLoginWindow;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private String password = "";
	private String comboBoxContent = "";
	private static JFrameWithBackgroundImage frameWithBackgroundImage;
	private DataProc dataProc = new DataProc();
        
        
	public LoginWindow() {
		initialize();
	}
        
	public static JFrameWithBackgroundImage getJFrameForLoginWindow()
	{
		return  frameWithBackgroundImage;
	}

	private void initialize() 
	{
            String employeCB = "Employe";
            String directeurCB = "Directeur";
            String chefProjetCB = "Chef de projet";
            String[] listeDesSalaries = { employeCB, directeurCB, chefProjetCB };
            
            frameWithBackgroundImage = new JFrameWithBackgroundImage("/image.png");
            frameWithBackgroundImage.getContentPane().setLayout(null);
		
            JButton btnLogin = new JButton("Login");

            btnLogin.setBounds(137, 261, 117, 55);
            frameWithBackgroundImage.getContentPane().add(btnLogin);
		
            usernameField = new JTextField();
            usernameField.setBounds(124, 82, 147, 35);
            usernameField.setText("Egregory");
            frameWithBackgroundImage.getContentPane().add(usernameField);
            usernameField.setColumns(10);
	
            passwordField = new JPasswordField();
            passwordField.setBounds(124, 143, 147, 35);
            passwordField.setText("Egregory1");
            frameWithBackgroundImage.getContentPane().add(passwordField);
		
            JComboBox comboBox = new JComboBox(listeDesSalaries);
            comboBox.setBounds(124, 202, 147, 26);
		
            frameWithBackgroundImage.getContentPane().add(comboBox);
		
            
            // 
            comboBox.addItemListener( new ItemListener () {

            	@Override
            	public void itemStateChanged(ItemEvent arg0) {
            	// TODO Auto-generated method stub
            	int currentItem = comboBox.getSelectedIndex();
            	switch (currentItem){
            	case 0:
            	usernameField.setText("First username");
            	passwordField.setText("kasdjfkasdjfakdsjf");
            	break;
            	case 1:
            	usernameField.setText("Twilliams");
            	passwordField.setText("Twilliams1");
            	break;
            	case 2:
            	usernameField.setText("Mnicolas");
            	passwordField.setText("Mnicolas1");
            	break;
            	}

            	}
            	});
		
            try {
            	System.out.println(hashPassword(password));
            } catch (NoSuchAlgorithmException e) {
            		// TODO Auto-generated catch block
            	e.printStackTrace();
            }
		
            btnLogin.addActionListener(new ActionListener() 
            {
    		public void actionPerformed(ActionEvent arg0) 
		{
                    password = new String(passwordField.getPassword());
                    //whoIsLogingIn();
				
                    comboBoxContent = comboBox.getSelectedItem().toString();
                    switch (comboBoxContent)
                    {
                        case "Directeur":
                            try 
                            {
                                dataProc.loggedInSuccessfully(usernameField.getText(), hashPassword(password), "DIRECTEUR");
                            } catch (NoSuchAlgorithmException e) 
                            {
					    	// TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            break;
                            
			case "Employe":
                            try 
                            {
				dataProc.loggedInSuccessfully(usernameField.getText(), hashPassword(password), "EMPLOYE");
                            }
			    catch (NoSuchAlgorithmException e) 
                            {
				// TODO Auto-generated catch block
				e.printStackTrace();
                            }
                            break;
			
                        case "Chef de projet":
                            try 
                            {
				dataProc.loggedInSuccessfully(usernameField.getText(), hashPassword(password),"CHEF_DE_PROJET");
                            }
			    catch (NoSuchAlgorithmException e) 
                            {
				// TODO Auto-generated catch block
				e.printStackTrace();
                            }
                            break;
                    }
            
                if (DataProc.loggedInOrNot)
                    {
			frameWithBackgroundImage.setVisible(false);
                        user_logged_in = usernameField.getText();
			DataProc.showTheNextWindow();
                    }
	}
			
    });
}
	
	//encrypting password with md5
	private static String hashPassword(String message) throws NoSuchAlgorithmException 
	{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(message.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
	}
}
