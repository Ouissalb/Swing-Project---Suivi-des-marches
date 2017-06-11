package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.ProjetCreationController;
import controller.TacheCreationController;
import model.DatabaseQueries;

public class EmployeeView3 {

	public static JFrameWithBackgroundImage employeeView3;

	public EmployeeView3() {
		initialize();
	}
	
	private ImagePanel panelForm4;
	private ImagePanel panelForm6;
	private ImagePanel panelForm5;
	private ImagePanel panelForm7;
	private ImagePanel panelForm8;
	private JPanel projectInfo;
	private JPanel panelThatWillChange2;
	private JPanel panelThatWillChange3;
	private JPanel panelThatWillChange4;
	private JPanel panelThatWillChange5;
	private JPanel panelThatWillChange6;
	private JPanel panelThatWillChange7;
	
	private String commentValue;
	
	private void initialize() 
	{
             
        employeeView3 = new JFrameWithBackgroundImage("blue3.png");
        employeeView3.setBounds(100, 100, 600, 400);
        employeeView3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        employeeView3.setLocationRelativeTo(null);
        employeeView3.getContentPane().setLayout(null);
        

		projectInfo= new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		projectInfo.setBounds(0, 0, 592, 367);
		employeeView3.getContentPane().add(projectInfo);
		projectInfo.setLayout(null);
		
		JPanel panelThatWillChange = new JPanel();
		panelThatWillChange.setBounds(33, 48, 356, 222);
		projectInfo.add(panelThatWillChange);
		
		JButton btnObjectif = new JButton("Objectif");
		btnObjectif.setBounds(427, 48, 121, 27);
		projectInfo.add(btnObjectif);
		
		
		
		btnObjectif.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				showObjectives();
				panelThatWillChange.setVisible(false);
				
			}
		});
		
		JButton boutonSuivant = new JButton("Suivant >");
		boutonSuivant.setBounds(427, 312, 121, 27);
		projectInfo.add(boutonSuivant);
		
		
		boutonSuivant.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				projectInfo.setVisible(false);
				tasksPanel();
			}
		});
		
			
		JButton btnTaches = new JButton("Taches en cours");
		btnTaches.setBounds(427, 87, 121, 27);
		projectInfo.add(btnTaches);
		
		btnTaches.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				panelThatWillChange.setVisible(false);
				addTasksEnCours();	
				
			}
		});
		
		JButton btnTachesValides = new JButton("Taches validées");
		btnTachesValides.setBounds(427, 126, 121, 27);
		projectInfo.add(btnTachesValides);
		
		btnTachesValides.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelThatWillChange.setVisible(false);
				addTasksValidees();		
			
				
			}
		});
		
		
		JButton btnMatriel = new JButton("Matériel");
		btnMatriel.setBounds(427, 165, 121, 27);
		projectInfo.add(btnMatriel);
		
		btnMatriel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				showMateriel();
				
				panelThatWillChange.setVisible(false);
				
			}
		});
		
		
		JButton btnLicenses = new JButton("Licenses");
		btnLicenses.setBounds(427, 204, 121, 27);
		projectInfo.add(btnLicenses);
		
		btnLicenses.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				showLicenses();			
				panelThatWillChange.setVisible(false);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Date et état");
		btnNewButton_1.setBounds(427, 243, 121, 27);
		projectInfo.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				showDateAntState();			
				panelThatWillChange.setVisible(false);
				
			}
		});
		
		projectInfo.setVisible(true);
	}
	
	public void showObjectives()
	{
		hidePanels(2);
		panelThatWillChange2 = new JPanel();
		panelThatWillChange2.setBounds(33, 48, 356, 222);
		projectInfo.add(panelThatWillChange2);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 356, 222);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panelThatWillChange2.add(textArea);
		panelThatWillChange2.setVisible(true);
		textArea.setText("The project's objectif will be written here !");
	}
	
	
	public void showMateriel()
	{
		hidePanels(3);
		panelThatWillChange3 = new JPanel();
		panelThatWillChange3.setBounds(33, 48, 356, 222);
		projectInfo.add(panelThatWillChange3);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 356, 222);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panelThatWillChange3.add(textArea);
		panelThatWillChange3.setVisible(true);
		textArea.setText("The project's materials will be written here !");
	}
	
	public void showLicenses()
	{
		hidePanels(4);
		panelThatWillChange4 = new JPanel();
		panelThatWillChange4.setBounds(33, 48, 356, 222);
		projectInfo.add(panelThatWillChange4);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 356, 222);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panelThatWillChange4.add(textArea);
		panelThatWillChange4.setVisible(true);
		textArea.setText("The project's licenses will be written here !");
	}
	
	public void showDateAntState()
	{
		hidePanels(5);
		panelThatWillChange5 = new JPanel();
		panelThatWillChange5.setBounds(33, 48, 356, 222);
		projectInfo.add(panelThatWillChange5);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 356, 222);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panelThatWillChange5.add(textArea);
		panelThatWillChange5.setVisible(true);
		textArea.setText("The project's limit date, duration, budget and state will be shown here !");
	}

        
  
	
	public void createAndDisplayValidatingTasksPanel()
	{
		panelForm5= new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		panelForm5.setBounds(0, 57, 592, 310);
		employeeView3.getContentPane().add(panelForm5);
		panelForm5.setLayout(null);
		
		JList listForTasks = new JList();
		listForTasks.setBounds(79, 41, 441, 158);
		listForTasks.setSelectionBackground(Color.green);
		panelForm5.add(listForTasks);
		
		JButton btnValiderTask = new JButton("Valider les tâches sélectionnées");
		btnValiderTask.setBounds(185, 211, 213, 27);
		panelForm5.add(btnValiderTask);
		
		btnValiderTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnTerminertTask = new JButton("Terminer");
		btnTerminertTask.setBounds(467, 258, 96, 27);
		panelForm5.add(btnTerminertTask);
		
		btnTerminertTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelForm5.setVisible(false);
				panelForm4.setVisible(true);
			}
		});
	}
	public void createAndDisplaySignalerTasksPanel()
	{
		panelForm6= new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		panelForm6.setBounds(0, 57, 592, 310);
		employeeView3.getContentPane().add(panelForm6);
		panelForm6.setLayout(null);
		
		// SQL syntax has some error
		JList listForTasks2 = new JList(/*DatabaseQueri
		es.populatingListWithTasks(EmployeeView1.currentProjectSelectedByEmployee)*/);
		listForTasks2.setBounds(79, 41, 441, 158);
		listForTasks2.setSelectionBackground(Color.red);
		panelForm6.add(listForTasks2);
		
		JButton btnSignalerTask = new JButton("Signaler les tâches sélectionnées");
		btnSignalerTask.setBounds(185, 211, 213, 27);
		panelForm6.add(btnSignalerTask);
		
		btnSignalerTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnTerminertTask2 = new JButton("Terminer");
		btnTerminertTask2.setBounds(467, 258, 96, 27);
		panelForm6.add(btnTerminertTask2);
		
		btnTerminertTask2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelForm6.setVisible(false);
				panelForm4.setVisible(true);
			}
		});
	}
	
	public void approveTasksPanel()
	{
		panelForm7= new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		panelForm7.setBounds(0, 57, 592, 310);
		employeeView3.getContentPane().add(panelForm7);
		panelForm7.setLayout(null);
		
		JList listForTasks3 = new JList();
		listForTasks3.setBounds(79, 41, 441, 158);
		panelForm7.add(listForTasks3);
		
		JButton btnApproveTask = new JButton("Approver les tâches sélectionnées");
		btnApproveTask.setBounds(185, 211, 213, 27);
		panelForm7.add(btnApproveTask);
		
		btnApproveTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnTerminertTask2 = new JButton("Terminer");
		btnTerminertTask2.setBounds(467, 258, 96, 27);
		panelForm7.add(btnTerminertTask2);
		
		btnTerminertTask2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelForm7.setVisible(false);
				panelForm4.setVisible(true);
			}
		});
	}
	
	public void commentTasksPannel()
	{
		panelForm8= new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		panelForm8.setBounds(0, 57, 592, 310);
		employeeView3.getContentPane().add(panelForm8);
		panelForm8.setLayout(null);
		
		JList listForComments = new JList();
		listForComments.setBounds(79, 41, 441, 158);
		panelForm8.add(listForComments);
		
		JButton btnCommentTask = new JButton("Commenter la tache sélectionnée");
		btnCommentTask.setBounds(185, 211, 213, 27);
		panelForm8.add(btnCommentTask);
		
		btnCommentTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//il faut vérifier qu'une seule tache est selectionnée
				commentValue = JOptionPane.showInputDialog("Saisir un commentaire"); 
			}
		});
		
		JButton btnTerminertTask2 = new JButton("Terminer");
		btnTerminertTask2.setBounds(467, 258, 96, 27);
		panelForm8.add(btnTerminertTask2);
		
		btnTerminertTask2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelForm8.setVisible(false);
				panelForm4.setVisible(true);
			}
		});
	}
	
	public void addTasksEnCours()
	{
		hidePanels(6);
		panelThatWillChange6 = new JPanel();
		panelThatWillChange6.setBounds(33, 48, 356, 222);
		panelThatWillChange6.setLayout(null);
		projectInfo.add(panelThatWillChange6);
		JList listTaches = new JList();
		listTaches.setBounds(0, 0, 356, 222);
		panelThatWillChange6.add(listTaches);
		panelThatWillChange6.setVisible(true);
	}
	
	public void addTasksValidees()
	{
		hidePanels(7);
		panelThatWillChange7 = new JPanel();
		panelThatWillChange7.setBounds(33, 48, 356, 222);
		panelThatWillChange7.setLayout(null);
		projectInfo.add(panelThatWillChange7);
		JList listTaches = new JList();
		listTaches.setBounds(0, 0, 356, 222);
		panelThatWillChange7.add(listTaches);
		panelThatWillChange7.setVisible(true);
	}
	
	
	
	public void tasksPanel()
	{
		
		  panelForm4= new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
			panelForm4.setBounds(0, 57, 592, 310);
			employeeView3.getContentPane().add(panelForm4);
			panelForm4.setLayout(null);
			
			JButton validerTacheBouton = new JButton("Valider des tâches");
			validerTacheBouton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					panelForm4.setVisible(false);
					createAndDisplayValidatingTasksPanel();
				}
			});
			validerTacheBouton.setBounds(191, 37, 213, 46);
			panelForm4.add(validerTacheBouton);
			
			JButton signalerTachesBouton = new JButton("Signaler des tâches");
			signalerTachesBouton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelForm4.setVisible(false);
					createAndDisplaySignalerTasksPanel();
				}
			});
			signalerTachesBouton.setBounds(191, 95, 213, 46);
			panelForm4.add(signalerTachesBouton);
			
			JButton approuverTachesBouton = new JButton("Approuver les tâches réalisés");
			approuverTachesBouton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelForm4.setVisible(false);
					approveTasksPanel();
				}
			});
			
			JButton btnRetour = new JButton("Retour");
			btnRetour.setBounds(484, 271, 96, 27);
			panelForm4.add(btnRetour);
			btnRetour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EmployeeView1.employeeView1.setVisible(true);
					employeeView3.setVisible(false);
				}
			});
			
			approuverTachesBouton.setBounds(191, 153, 213, 46);
			
			JButton commentTask = new JButton("Commenter des tâches");
			commentTask.setBounds(191, 211, 213, 46);
			panelForm4.add(commentTask);
			
			commentTask.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelForm4.setVisible(false);
					commentTasksPannel();
					
				}
			});
			
			panelForm4.add(approuverTachesBouton);
			panelForm4.setVisible(true);
		
	}
	
	private void hidePanels(int currentPanel){

		//if (currentPanel != 1 && panelThatWillChange1 != null) panelThatWillChange1.setVisible(false);
		if (currentPanel != 2 && panelThatWillChange2 != null) panelThatWillChange2.setVisible(false);
		if (currentPanel != 3 && panelThatWillChange3 != null) panelThatWillChange3.setVisible(false);
		if (currentPanel != 4 && panelThatWillChange4 != null) panelThatWillChange4.setVisible(false);
		if (currentPanel != 5 && panelThatWillChange5 != null) panelThatWillChange5.setVisible(false);
		if (currentPanel != 6 && panelThatWillChange6 != null) panelThatWillChange6.setVisible(false);
		if (currentPanel != 7 && panelThatWillChange7 != null) panelThatWillChange7.setVisible(false);

		}
	
	
}
