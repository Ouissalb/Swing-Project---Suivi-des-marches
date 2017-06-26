package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import model.DatabaseQueries;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class EmployeeView1 {

	public static JFrameWithBackgroundImage employeeView1;
	public static String currentProjectSelectedByEmployee;

	public EmployeeView1() {
		initialize();
	}

	private void initialize() {
		employeeView1 = new JFrameWithBackgroundImage("/image.png");
		employeeView1.setBounds(100, 100, 400, 400);
		employeeView1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employeeView1.getContentPane().setLayout(null);
		
		JButton exprimerProjet = new JButton("Exprimer un nouveau projet");
		
		//Ajout d'un nouveau projet
		exprimerProjet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				EmployeeView2Formulaire employeeView2Form = new EmployeeView2Formulaire();
				EmployeeView1.employeeView1.setVisible(false);
				
			}
		});
		exprimerProjet.setBounds(67, 24, 244, 45);
		employeeView1.getContentPane().add(exprimerProjet);
		
		JButton btnOk = new JButton("Valider");
		btnOk.setBounds(67, 299, 244, 45);
		employeeView1.getContentPane().add(btnOk);
		
		JComboBox comboBox = new JComboBox(DatabaseQueries.populatingComboBoxWithProjects());
		currentProjectSelectedByEmployee = comboBox.getSelectedItem().toString();
		// va contenir les projets apres leurs création
		
		comboBox.setBounds(67, 255, 244, 32);
		employeeView1.getContentPane().add(comboBox);
		
		btnOk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				EmployeeView3 employeeView3 = new EmployeeView3();
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
