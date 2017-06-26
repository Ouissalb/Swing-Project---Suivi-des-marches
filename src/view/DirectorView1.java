package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import controller.SetVisibility;

public class DirectorView1 {

	public static JFrameWithBackgroundImage directorView1;

	public DirectorView1() {
		initialize();
	}
	JPanel mainPanelDir1;
	ImagePanel panelForm4;
	JPanel mainPanelDir2;
	ImagePanel panelDir1;
	JPanel panelThatWillChange1;
	JPanel panelThatWillChange2;
	JPanel panelThatWillChange3;
	JPanel panelThatWillChange4;
	JPanel panelThatWillChange5;
	JPanel panelThatWillChange6;
	JPanel panelThatWillChange7;
	JPanel panelValidateTask;
	JPanel panelReportTask;
	

	private void initialize() 
	{
		
		directorView1 = new JFrameWithBackgroundImage("/white.jpg");
		directorView1.setBounds(100, 100, 600, 400);
		directorView1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		directorView1.getContentPane().setLayout(null);
		directorView1.setLocationRelativeTo(null);
		

		ImagePanel panelForm4= new ImagePanel("/green3.jpg");
		panelForm4.setBounds(0, 45, 592, 299);
		directorView1.getContentPane().add(panelForm4);
		panelForm4.setLayout(null);
		
		
		
		
		
		/*
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 444, 26);
		mainPanelChef1.add(toolBar);*/
		
		JPanel panelNotif = new ImagePanel("/icon3.png");
		panelNotif.setBounds(539, 0, 53, 46);
		directorView1.getContentPane().add(panelNotif);
		panelNotif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessageBoxes.vousAvezUneNotification();
			}
		});
		

				ImageIcon openIcon = new ImageIcon(
	                 ThisIsJustForTesting.class.getResource("/Sicon1.png"));
	            ImageIcon saveIcon = new ImageIcon(
	                    ThisIsJustForTesting.class.getResource("/Sicon2.png"));
	            ImageIcon newIcon = new ImageIcon(
	                    ThisIsJustForTesting.class.getResource("/Sicon3.png"));
	            ImageIcon taskIcon = new ImageIcon(
	                    ThisIsJustForTesting.class.getResource("/Sicon5.png"));
	            
	            
	            Action openAction = new AbstractAction("Ouvrir un projet", openIcon) {
	                @Override
	                public void actionPerformed(ActionEvent e) 
	                {
	                	//panelForm4.setVisible(false);
	                	SetVisibility.setComponentVisibility(directorView1, JPanel.class, false);
	                	openProjectPanel();
	                }
	            };
	            Action saveAction = new AbstractAction("Fermer un projet", saveIcon) {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    System.out.println("Fermer un projet");
	                }
	            };
	            Action newAction = new AbstractAction("New", newIcon) {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    System.out.println("New File");
	                }
	            };

	            
	            JMenuItem openMenuItem = new JMenuItem(openAction);
	            JMenuItem saveMenuItem = new JMenuItem(saveAction);
	            JMenuItem newMenuItem = new JMenuItem(newAction);

	            JMenuBar menuBar = new JMenuBar();
	            JMenu fileMenu = new JMenu("File");
	            fileMenu.add(openMenuItem);
	            fileMenu.add(saveMenuItem);
	            fileMenu.add(newMenuItem);
	            menuBar.add(fileMenu);
	            
	            Action statAction = new AbstractAction("Statistiques", newIcon) {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    System.out.println("Statistiques");
	                }
	            };
	            
	            JMenuItem statActionTest = new JMenuItem(statAction);
	            JMenu statsMenu = new JMenu("Statistiques");
	            statsMenu.add(statActionTest);
	            
	            menuBar.add(statsMenu);
	            
	            
	            
	            
	            Action validertaskAction = new AbstractAction("Valider une tache", taskIcon) {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	SetVisibility.setComponentVisibility(directorView1, JPanel.class, false);
	                    createAndDisplayValidatingTasksPanel();
	                }
	            };
	            
	            Action validerCommentairestaskAction = new AbstractAction("Afficher les commentaires", taskIcon) {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	SetVisibility.setComponentVisibility(directorView1, JPanel.class, false);
	                	 afficherCommentaires();
	                }
	            };
	            
	            Action afficherTachesSignaleAction = new AbstractAction("Afficher les les taches signalées", taskIcon) {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                	SetVisibility.setComponentVisibility(directorView1, JPanel.class, false);
	                	createAndDisplayReportTasksPanel();
	                }
	            };
	            
	            JMenuItem taskActionTest = new JMenuItem(validertaskAction);
	            JMenuItem afficherTaches = new JMenuItem(afficherTachesSignaleAction);
	            JMenuItem taskActionValidate = new JMenuItem(validerCommentairestaskAction);
	            JMenu taskMenu = new JMenu("Taches");
	            taskMenu.add(taskActionTest);
	            taskMenu.add(afficherTaches);
	            taskMenu.add(taskActionValidate);
	            menuBar.add(taskMenu);
	            
	            
	            
	            directorView1.setJMenuBar(menuBar);

		}
	
	public void openProjectPanel()
	{

		panelDir1= new ImagePanel("/green3.jpg");
		panelDir1.setBounds(0, 45, 592, 299);
		directorView1.getContentPane().add(panelDir1);
		panelDir1.setLayout(null);
		
		JPanel panelThatWillChange = new JPanel();
		panelThatWillChange.setBounds(33, 30, 356, 222);
		panelDir1.add(panelThatWillChange);
		
		JButton btnObjectif = new JButton("Objectif");
		btnObjectif.setBounds(427, 30, 121, 27);
		panelDir1.add(btnObjectif);
		
		btnObjectif.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				showObjectives();
				panelThatWillChange.setVisible(false);
				
			}
		});
		
		JButton boutonAllouer = new JButton("Allouer budget");
		boutonAllouer.setBounds(65, 264, 121, 20);
		panelDir1.add(boutonAllouer);
		
		boutonAllouer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
			//TODO
				
			}
		});
		
		JButton btnArreterService = new JButton("Arreter service");
		btnArreterService.setBounds(233, 264, 121, 20);
		panelDir1.add(btnArreterService);
		
		btnObjectif.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//TODO
			}
		});
		
		
		JButton btnTaches = new JButton("Taches en cours");
		btnTaches.setBounds(427, 69, 121, 27);
		panelDir1.add(btnTaches);
		
		btnTaches.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				addTasksEnCours();				
				panelThatWillChange.setVisible(false);				
			}
		});
		
		JButton btnTachesValides = new JButton("Taches validées");
		btnTachesValides.setBounds(427, 108, 121, 27);
		panelDir1.add(btnTachesValides);
		
		btnTachesValides.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelThatWillChange.setVisible(false);
				addTasksValidees();						
			}
		});
		
		
		JButton btnMatriel = new JButton("Matériel");
		btnMatriel.setBounds(427, 147, 121, 27);
		panelDir1.add(btnMatriel);
		
		btnMatriel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				showMateriel();
				
				panelThatWillChange.setVisible(false);
				
			}
		});
		
		
		JButton btnLicenses = new JButton("Licenses");
		btnLicenses.setBounds(427, 186, 121, 27);
		panelDir1.add(btnLicenses);
		
		btnLicenses.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				showLicenses();			
				panelThatWillChange.setVisible(false);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Date et état");
		btnNewButton_1.setBounds(427, 225, 121, 27);
		panelDir1.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				showDateAntState();			
				panelThatWillChange.setVisible(false);
				
			}
		});
		
		panelDir1.setVisible(true);
	}
	
	public void showObjectives()
	{
		hidePanels(2);
		panelThatWillChange2 = new JPanel();
		panelThatWillChange2.setBounds(33, 30, 356, 222);
		panelDir1.add(panelThatWillChange2);
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
		panelThatWillChange3.setBounds(33, 30, 356, 222);
		panelDir1.add(panelThatWillChange3);
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
		panelThatWillChange4.setBounds(33, 30, 356, 222);
		panelDir1.add(panelThatWillChange4);
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
		panelThatWillChange5.setBounds(33, 30, 356, 222);
		panelDir1.add(panelThatWillChange5);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 356, 222);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panelThatWillChange5.add(textArea);
		panelThatWillChange5.setVisible(true);
		textArea.setText("The project's limit date, duration, budget and state will be shown here !");
	}

	
	
	public void addTasksEnCours()
	{
		hidePanels(6);
		panelThatWillChange6 = new JPanel();
		panelThatWillChange6.setBounds(33, 30, 356, 222);
		panelThatWillChange6.setLayout(null);
		
		//JList listTaches = new JList();

		String[] listTEmpt = {"Something", " Antoher" };
		JList<String> listTaches = new JList<String>(listTEmpt);
		listTaches.setBounds(0, 0, 356, 222);
		panelThatWillChange6.add(listTaches);
	//	directorView1.getContentPane().add(panelThatWillChange6);
		panelDir1.add(panelThatWillChange6);
		panelThatWillChange6.setVisible(true);
	}
	
	public void addTasksValidees()
	{
		hidePanels(7);
		panelThatWillChange7 = new JPanel();
		panelThatWillChange7.setBounds(33, 30, 356, 222);
		panelThatWillChange7.setLayout(null);
		
		//JList listTaches = new JList();

		String[] listTEmpt = {"the first elment of the list", " Antoher element" };
		JList<String> listTaches = new JList<String>(listTEmpt);
		listTaches.setBounds(0, 0, 356, 222);
		panelThatWillChange7.add(listTaches);
		panelDir1.add(panelThatWillChange7);
		
	//	directorView1.getContentPane().add(panelThatWillChange7);
		panelThatWillChange7.setVisible(true);
	}
	
	
	public void createAndDisplayValidatingTasksPanel()
	{
		panelValidateTask= new ImagePanel("/green3.jpg");
		panelValidateTask.setBounds(0, 45, 592, 299);
		directorView1.getContentPane().add(panelValidateTask);
		panelValidateTask.setLayout(null);
		
		JList listForTasks = new JList();
		listForTasks.setBounds(79, 41, 441, 158);
		listForTasks.setSelectionBackground(Color.green);
		panelValidateTask.add(listForTasks);
		
		JButton btnValiderTask = new JButton("Valider les tâches sélectionnées");
		btnValiderTask.setBounds(185, 211, 213, 27);
		panelValidateTask.add(btnValiderTask);
		
		btnValiderTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		panelValidateTask.setVisible(true);
	}
	
	public void createAndDisplayReportTasksPanel()
	{
		panelReportTask= new ImagePanel("/green3.jpg");
		panelReportTask.setBounds(0, 45, 592, 299);
		directorView1.getContentPane().add(panelReportTask);
		panelReportTask.setLayout(null);
		
		JList listForTasks = new JList();
		listForTasks.setBounds(79, 41, 441, 158);
		listForTasks.setSelectionBackground(Color.green);
		panelReportTask.add(listForTasks);
		
		JButton btnValiderTask = new JButton("Annuler les tâches sélectionnées");
		btnValiderTask.setBounds(185, 211, 213, 27);
		panelReportTask.add(btnValiderTask);
		
		btnValiderTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		panelReportTask.setVisible(true);
	}
	
	public void afficherCommentaires()
	{
		
		ImagePanel panelAfficherCommentaires= new ImagePanel("/green3.jpg");
		panelAfficherCommentaires.setBounds(0, 45, 592, 299);
		directorView1.getContentPane().add(panelAfficherCommentaires);
		panelAfficherCommentaires.setLayout(null);
		
		JComboBox comboBoxSElectTask = new JComboBox();
		comboBoxSElectTask.setBounds(171, 12, 233, 26);
		panelAfficherCommentaires.add(comboBoxSElectTask);
		
		JList list = new JList();
		list.setBounds(77, 74, 428, 190);

		panelAfficherCommentaires.add(list);
		
		panelAfficherCommentaires.setVisible(true);
	}
	
	
	private void hidePanels(int currentPanel){

		if (currentPanel != 1 && panelThatWillChange1 != null) panelThatWillChange1.setVisible(false);
		if (currentPanel != 2 && panelThatWillChange2 != null) panelThatWillChange2.setVisible(false);
		if (currentPanel != 3 && panelThatWillChange3 != null) panelThatWillChange3.setVisible(false);
		if (currentPanel != 4 && panelThatWillChange4 != null) panelThatWillChange4.setVisible(false);
		if (currentPanel != 5 && panelThatWillChange5 != null) panelThatWillChange5.setVisible(false);
		if (currentPanel != 6 && panelThatWillChange6 != null) panelThatWillChange6.setVisible(false);
		if (currentPanel != 7 && panelThatWillChange7 != null) panelThatWillChange7.setVisible(false);

		}

	
}
