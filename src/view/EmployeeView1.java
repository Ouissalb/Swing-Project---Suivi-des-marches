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
import controller.DataProc;
import controller.FileHandling;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import model.DatabaseQueries;

public class EmployeeView1 {

    public static JFrameWithBackgroundImage employeeView1;
    private DataProc dataProc = new DataProc();
    public static String currentProjectSelectedByEmployee;
    static int index;
    
    private Toolbar toolbar ;

    
    public EmployeeView1() {
	initialize();
    }
    
    
    private void initialize() {
	employeeView1 = new JFrameWithBackgroundImage("/image.png");
	employeeView1.setBounds(100, 100, 400, 400);
	employeeView1.setLocationRelativeTo(null);
	employeeView1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	employeeView1.getContentPane().setLayout(null);
	
	JButton exprimerProjet = new JButton("Exprimer un nouveau projet");
		
	//Ajout d'un nouveau projet
	exprimerProjet.addActionListener(new ActionListener() 
	{
            public void actionPerformed(ActionEvent arg0) 
            {
		EmployeeView2Formulaire employeeView2Form = new EmployeeView2Formulaire();
            }
	});
	
        exprimerProjet.setBounds(67, 50, 244, 45);
        employeeView1.getContentPane().add(exprimerProjet);
	
        	
        String[] combo  = this.dataProc.getProjects(); 
        
	JComboBox comboBox = new JComboBox(combo);
	// va contenir les projets apres leurs création
	comboBox.setBounds(67, 255, 244, 32);
	employeeView1.getContentPane().add(comboBox);
        
    
    toolbar = new Toolbar();
            
    this.toolbar.setFileListener(new FileListener()
    {
        @Override
        public void fileChoosed(FileEvent f) 
        {
            System.out.println("SOurce "+ f.getSource());
            JButton button = f.getSourceBtn();

            if ( button == toolbar.getLoad_btn() )
                FileHandling.load_file(f,"projects");
            else
                FileHandling.load_file(f,"tasks");
                
            employeeView1.setVisible(false);
            initialize();
        }
    });
         
    toolbar.setBounds(0, 0, 400, 32);
    employeeView1.getContentPane().add(toolbar);
        
	JButton btnOk = new JButton("Valider");
	btnOk.setBounds(67, 299, 244, 45);
	employeeView1.getContentPane().add(btnOk);
		
        //JComboBox comboBox = new JComboBox(DatabaseQueries.populatingComboBoxWithProjects());
		currentProjectSelectedByEmployee = comboBox.getSelectedItem().toString();
                
		// va contenir les projets apres leurs création
	
                
		btnOk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
                                index = comboBox.getSelectedIndex();
                                ++index;
				EmployeeView3Bis employeeView3 = new EmployeeView3Bis();
				EmployeeView1.employeeView1.setVisible(false);
			}
                });
                
	JPanel panel = new JPanel();
	panel.setBounds(67, 211, 244, 32);
	employeeView1.getContentPane().add(panel);
		
	JLabel selectionnerProjetExistant = new JLabel("Selectionner un projet :");
	selectionnerProjetExistant.setHorizontalAlignment(SwingConstants.TRAILING);
	panel.add(selectionnerProjetExistant);
	employeeView1.setLocationRelativeTo(null);
	employeeView1.setVisible(true);
    }
}
