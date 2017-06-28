package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controller.DataProc;
import controller.NotificationHandler;
import controller.SetVisibility;
import model.DatabaseQueries;
import view.EmployeeView3Bis.WhiteYellowCellRenderer;

public class ChefProjetView1 {

	public DataProc dp = new DataProc();
	public DatabaseQueries dbq = new DatabaseQueries();
	public static JFrameWithBackgroundImage chefProjetView1;
    public static int[] etats ;
    public static int id_tache;

    
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;



	public ChefProjetView1() {
		System.out.println("lalala" +id_tache);
		etats = dp.getCommsEtat(id_tache);
        for(int i = 0 ; i < etats.length; i++)
            System.out.println("etats : "+ etats[i]);
		initialize();
	}


	public static int num_tache = 1;
	DefaultListModel<String> comlistmodel = new DefaultListModel();

	JPanel mainPanelChef1;
	ImagePanel panelForm4;
	JPanel mainPanelChef2;
	ImagePanel panelChef1;
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
		NotificationHandler fh = new NotificationHandler();
		fh.start_handling();

		chefProjetView1 = new JFrameWithBackgroundImage("/white.jpg");
		chefProjetView1.setBounds(100, 100, 600, 400);
		chefProjetView1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chefProjetView1.getContentPane().setLayout(null);
		chefProjetView1.setLocationRelativeTo(null);


		ImagePanel panelForm4= new ImagePanel("/green3.jpg");
		panelForm4.setBounds(0, 45, 592, 299);
		chefProjetView1.getContentPane().add(panelForm4);
		panelForm4.setLayout(null);
		/*
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 444, 26);
		mainPanelChef1.add(toolBar);*/

		JPanel panelNotif = new ImagePanel("/icon3.png");
		panelNotif.setBounds(539, 0, 53, 46);
		chefProjetView1.getContentPane().add(panelNotif);
		panelNotif.setVisible(true);
		panelNotif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessageBoxes.vousAvezUneNotification();
			}
		});


		ImageIcon openIcon = createImageIcon("/Sicon1.png", "icon 1");
		ImageIcon saveIcon = createImageIcon("/Sicon2.png", "icon 2");
		ImageIcon newIcon = createImageIcon("/Sicon3.png", "icon 3");
		ImageIcon taskIcon = createImageIcon("/Sicon5.png", "icon 5");


		Action openAction = new AbstractAction("Afficher un projet", openIcon) {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if (Sproject.selectedProject)
				{
					//panelForm4.setVisible(false);
					SetVisibility.setComponentVisibility(chefProjetView1, JPanel.class, false);
					//Sproject sp = new Sproject();
					openProjectPanel();
				}
				else
					JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(), "Vous n'avez selectionné aucun projet",
							"Inane error",
							JOptionPane.ERROR_MESSAGE);

			}
		};
		Action saveAction = new AbstractAction("Selectionner un projet", saveIcon) {
			@Override
			public void actionPerformed(ActionEvent e) {
				Sproject sp = new Sproject();
				System.out.println("SElect un projet");
				if (Sproject.selectedProject)
				{
					SetVisibility.setComponentVisibility(chefProjetView1, JPanel.class, false);
					openProjectPanel();
				}
			}
		};
		/*Action newAction = new AbstractAction("New", newIcon) {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("New File");
			}
		};*/


		JMenuItem openMenuItem = new JMenuItem(openAction);
		JMenuItem saveMenuItem = new JMenuItem(saveAction);
		//	JMenuItem newMenuItem = new JMenuItem(newAction);

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		//	fileMenu.add(newMenuItem);
		menuBar.add(fileMenu);

		Action statAction = new AbstractAction("Statistiques", newIcon) { //Statistiques actionListener
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Statistiques");
				//get total Tache and Validated Tache
				int totalTache = dp.getTotalTache(Sproject.index);
				int validTache = dp.getValidTache(Sproject.index);
				// Add labels
				String[] labelChart = {"Valid","Not Valid"};
				int percent = 0;
				// if at least one valid task, then calculate. Otherwise leave at 0.
				if (validTache != 0){
					//System.out.println("Inside calculate. Valid: "+validTache+". Total : "+totalTache);
					percent = (validTache * 100) / totalTache;
				}
				//add values to chart. Invalid tasks are 100% - valid tasks
				int[] valueChart = {percent, 100-percent} ;
				System.out.println("calling graph. percent : "+percent );
				// Create graph 
				GraphStat pieChart = new GraphStat(labelChart, valueChart);

			}
		};

		JMenuItem statActionTest = new JMenuItem(statAction);
		JMenu statsMenu = new JMenu("Statistiques");
		statsMenu.add(statActionTest);

		menuBar.add(statsMenu);




		Action validertaskAction = new AbstractAction("Valider une tache", taskIcon) {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sproject.selectedProject)
				{
					SetVisibility.setComponentVisibility(chefProjetView1, JPanel.class, false);
					// createAndDisplayValidatingTasksPanel();
					openTaskPanel();
				}
				else 
				{
					JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(), "Vous n'avez selectionné aucun projet",
							"Inane error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		};

		Action validerCommentairestaskAction = new AbstractAction("Afficher les commentaires", taskIcon) {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (Sproject.selectedProject)
				{
					SetVisibility.setComponentVisibility(chefProjetView1, JPanel.class, false);
					afficherCommentaires();
				}
				else
					JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(), "Vous n'avez selectionné aucun projet",
							"Inane error",
							JOptionPane.ERROR_MESSAGE);
			}
		};

		/*	Action afficherTachesSignaleAction = new AbstractAction("Afficher les les taches signalées", taskIcon) {
			@Override
			public void actionPerformed(ActionEvent e) {
				SetVisibility.setComponentVisibility(chefProjetView1, JPanel.class, false);
				createAndDisplayReportTasksPanel();
			}
		};*/

		JMenuItem taskActionTest = new JMenuItem(validertaskAction);
		//	JMenuItem afficherTaches = new JMenuItem(afficherTachesSignaleAction);
		JMenuItem taskActionValidate = new JMenuItem(validerCommentairestaskAction);
		JMenu taskMenu = new JMenu("Taches");
		taskMenu.add(taskActionTest);
		//taskMenu.add(afficherTaches);
		taskMenu.add(taskActionValidate);
		menuBar.add(taskMenu);



		chefProjetView1.setJMenuBar(menuBar);

	}
	public static  ImageIcon createImageIcon(String path,
			String description) {
		java.net.URL imgURL = ChefProjetView1.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	public void openProjectPanel()
	{

		panelChef1= new ImagePanel("/green3.jpg");
		panelChef1.setBounds(0, 45, 592, 299);
		chefProjetView1.getContentPane().add(panelChef1);
		panelChef1.setLayout(null);

		JPanel panelThatWillChange = new JPanel();
		panelThatWillChange.setBounds(33, 30, 356, 222);
		panelChef1.add(panelThatWillChange);

		JButton btnObjectif = new JButton("Objectif");
		btnObjectif.setBounds(427, 30, 121, 27);
		panelChef1.add(btnObjectif);

		btnObjectif.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{

				showObjectives();
				panelThatWillChange.setVisible(false);

			}
		});





		JButton btnTaches = new JButton("Budjet");
		btnTaches.setBounds(427, 69, 121, 27);
		panelChef1.add(btnTaches);

		btnTaches.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				addTasksEnCours();				
				panelThatWillChange.setVisible(false);				
			}
		});

		JButton btnTachesValides = new JButton("Date finale");
		btnTachesValides.setBounds(427, 108, 121, 27);
		panelChef1.add(btnTachesValides);

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
		panelChef1.add(btnMatriel);

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
		panelChef1.add(btnLicenses);

		btnLicenses.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				showLicenses();			
				panelThatWillChange.setVisible(false);

			}
		});

		JButton btnNewButton_1 = new JButton("État");
		btnNewButton_1.setBounds(427, 225, 121, 27);
		panelChef1.add(btnNewButton_1);

		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				showDateAntState();			
				panelThatWillChange.setVisible(false);

			}
		});

		panelChef1.setVisible(true);
	}

	public void showObjectives()
	{
		hidePanels();
		panelThatWillChange2 = new JPanel();
		panelThatWillChange2.setBounds(33, 30, 356, 222);
		panelChef1.add(panelThatWillChange2);
		String[] objectifs = dp.getObjectif(Sproject.index);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 356, 222);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panelThatWillChange2.add(textArea);
		panelThatWillChange2.setVisible(true);
		textArea.setText(objectifs[0]);

	}


	public void showMateriel()
	{
		hidePanels();
		panelThatWillChange3 = new JPanel();
		panelThatWillChange3.setBounds(33, 30, 356, 222);
		panelChef1.add(panelThatWillChange3);
		/*JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 356, 222);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panelThatWillChange3.add(textArea);*/


		String[] materiels = dp.getMateriels(Sproject.index);

		DefaultListModel<String> list1model = new DefaultListModel();

		for(int i = 0; i < materiels.length; i++)
			if(materiels[i] != null)
				list1model.addElement("materiel "+i+" : "+materiels[i]);

		JList list1 = new JList(list1model);
		panelThatWillChange3.add(list1);

		panelThatWillChange3.setVisible(true);
		//textArea.setText(materiels);
	}

	public void showLicenses()
	{
		hidePanels();
		panelThatWillChange4 = new JPanel();
		panelThatWillChange4.setBounds(33, 30, 356, 222);
		panelChef1.add(panelThatWillChange4);
		/*JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 356, 222);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panelThatWillChange4.add(textArea);
		panelThatWillChange4.setVisible(true);
		textArea.setText("The project's licenses will be written here !");*/

		String[] licences = dp.getLicences(Sproject.index);

		DefaultListModel<String> list2model = new DefaultListModel();
		for(int i = 0; i < licences.length; i++)
			if(licences[i] != null)
				list2model.addElement("licence "+i+" : "+licences[i]+"\n");    

		JList list2 = new JList(list2model);
		panelThatWillChange4.add(list2);
		panelThatWillChange4.setVisible(true);
	}

	public void showDateAntState()
	{
		hidePanels();
		panelThatWillChange5 = new JPanel();
		panelThatWillChange5.setBounds(33, 30, 356, 222);
		panelChef1.add(panelThatWillChange5);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 356, 222);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panelThatWillChange5.add(textArea);
		panelThatWillChange5.setVisible(true);
		textArea.setText("The project's limit date, duration, budget and state will be shown here !");
		String[] task_etat = dp.getTasksEtat(Sproject.index);            
		// task_etat[2] = " Date de fin : ";
		//   JTextField tfet = new JTextField("");

		if(task_etat[num_tache-1].equals("0"))
			textArea.setText("en cours");
		else
			textArea.setText("terminée");

	}



	public void addTasksEnCours()
	{
		hidePanels();
		panelThatWillChange6 = new JPanel();
		panelThatWillChange6.setBounds(33, 30, 356, 222);
		panelThatWillChange6.setLayout(null);

		//JList listTaches = new JList();

		/*	String[] listTEmpt = {"Something", " Antoher" };
		JList<String> listTaches = new JList<String>(listTEmpt);
		listTaches.setBounds(0, 0, 356, 222);
		panelThatWillChange6.add(listTaches);*/
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 356, 222);
		textArea.setLineWrap(true);
		textArea.setText(dp.getBudget(Sproject.index));
		textArea.setWrapStyleWord(true);
		panelThatWillChange6.add(textArea);
		//	chefProjetView1.getContentPane().add(panelThatWillChange6);

		panelChef1.add(panelThatWillChange6);
		panelThatWillChange6.setVisible(true);
	}

	public void addTasksValidees()
	{
		hidePanels();
		panelThatWillChange7 = new JPanel();
		panelThatWillChange7.setBounds(33, 30, 356, 222);
		panelThatWillChange7.setLayout(null);

		//JList listTaches = new JList();
		String[] task_date = dp.getTasksDate(Sproject.index);
		JTextField df = new JTextField(task_date[num_tache-1]);
		df.setBounds(0, 0, 356, 222);
		//    p2.add(df);

		/*JList<String> listTaches = new JList<String>(listTEmpt);
		listTaches.setBounds(0, 0, 356, 222);*/
		panelThatWillChange7.add(df);
		panelChef1.add(panelThatWillChange7);

		//	chefProjetView1.getContentPane().add(panelThatWillChange7);
		panelThatWillChange7.setVisible(true);
	}


	public void createAndDisplayValidatingTasksPanel()
	{
		panelValidateTask= new ImagePanel("/green3.jpg");
		panelValidateTask.setBounds(0, 45, 592, 299);
		chefProjetView1.getContentPane().add(panelValidateTask);
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
		chefProjetView1.getContentPane().add(panelReportTask);
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

		String[] licences = dp.getLicences(Sproject.index);
		ImagePanel panelAfficherCommentaires= new ImagePanel("/green3.jpg");
		panelAfficherCommentaires.setBounds(0, 45, 592, 299);
		chefProjetView1.getContentPane().add(panelAfficherCommentaires);
		panelAfficherCommentaires.setLayout(null);

		JComboBox<String> comboBoxSElectTask = new JComboBox<String>();
		comboBoxSElectTask.setBounds(171, 12, 233, 26);
		//comboBoxSElectTask.addItem("Select Task number");
		panelAfficherCommentaires.add(comboBoxSElectTask);
		String[] task_contenu = dp.getTasksContenu(Sproject.index);

		String[] task_date = dp.getTasksDate(Sproject.index);

		id_tache = dp.getIdTache(task_contenu[num_tache-1],task_date[num_tache-1]);
		System.out.println("id tache:"+id_tache);
		/*if(comms[0] != null)
           {
               System.out.println(comms[0]);
               comlistmodel.addElement("commentaire 1 : "+comms[0]+" %\n");
           }  */  

		JList<String> commentaires = new JList<String>(comlistmodel);
        commentaires.setCellRenderer( new WhiteYellowCellRenderer() );

		commentaires.setBounds(77, 74, 428, 190);

		panelAfficherCommentaires.add(commentaires);

		panelAfficherCommentaires.setVisible(true);
		////edit///
		String[] comms = dp.getCommentaires(Sproject.index,id_tache);

		for (String currentTask: task_contenu){
			if (currentTask != null && !currentTask.isEmpty()){
				comboBoxSElectTask.addItem(currentTask);
			}
		}
		comboBoxSElectTask.addItemListener( new ItemListener () {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				/*int currentItem = comboBoxSElectTask.getSelectedIndex();
				int taskid = dp.getTasksID(comboBoxSElectTask.getItemAt(comboBoxSElectTask.getSelectedIndex()), Sproject.index);

				String[] currentComment = dp.getCommentaires(Sproject.index,taskid);
				System.out.println("selected index: "+currentItem);
				
				id_tache = dp.getIdTache(task_contenu[num_tache-1],task_date[num_tache-1]);
	            commentaires.setCellRenderer( new WhiteYellowCellRenderer() );


                etats = dp.getCommsEtat(id_tache);
                for(int i = 0 ; i < etats.length; i++)
                    System.out.println("etats : "+ etats[i]);

				String currentType = dp.getCommentType(currentComment[0], taskid);
				DefaultListModel<String> temp = new DefaultListModel<String>();
				if (currentComment != null && currentComment[0] != null && !currentComment[0].isEmpty()){


					temp.addElement("\""+currentComment[0] + "\"" + " <Type :> ["+currentType+"]");
				}
				else {
					temp.addElement(" No comment ");
				}
				commentaires.setModel(temp);*/
				
				etats = dp.getCommsEtat(id_tache+1);
                for(int i = 0 ; i < etats.length; i++)
                    System.out.println("etats hgahaghagahgahg: "+ etats[i]);
				
                String[] comms = dp.getCommentaires(Sproject.index,id_tache+1);
	            
	            System.out.println(comms[0]);
	            for(int i = 0; i < licences.length; i++)
	                if(comms[i] != null)
	                {
	                    System.out.println(comms[i]);
	                    comlistmodel.addElement(""+(i+1)+" : "+comms[i]+" %\n");
	                }    
	                            
	            JList commentaires = new JList(comlistmodel);
	            commentaires.setCellRenderer( new WhiteYellowCellRenderer() );
			}
		});
		////// End edit////
	}


	private void hidePanels(){

		if ( panelThatWillChange1 != null) panelThatWillChange1.setVisible(false);
		if ( panelThatWillChange2 != null) panelThatWillChange2.setVisible(false);
		if ( panelThatWillChange3 != null) panelThatWillChange3.setVisible(false);
		if ( panelThatWillChange4 != null) panelThatWillChange4.setVisible(false);
		if ( panelThatWillChange5 != null) panelThatWillChange5.setVisible(false);
		if ( panelThatWillChange6 != null) panelThatWillChange6.setVisible(false);
		if ( panelThatWillChange7 != null) panelThatWillChange7.setVisible(false);

		if ( panelThatWillChange1 != null) chefProjetView1.getContentPane().remove(panelThatWillChange1);

		if ( panelThatWillChange2 != null) chefProjetView1.getContentPane().remove(panelThatWillChange2);
		if ( panelThatWillChange3 != null) chefProjetView1.getContentPane().remove(panelThatWillChange3);
		if ( panelThatWillChange4 != null) chefProjetView1.getContentPane().remove(panelThatWillChange4);
		if ( panelThatWillChange5 != null) chefProjetView1.getContentPane().remove(panelThatWillChange5);
		if ( panelThatWillChange6 != null) chefProjetView1.getContentPane().remove(panelThatWillChange6);
		if ( panelThatWillChange7 != null) chefProjetView1.getContentPane().remove(panelThatWillChange7);
		chefProjetView1.revalidate();
		chefProjetView1.repaint();
	}

	public void openTaskPanel()
	{

		ImagePanel panelForTasks= new ImagePanel("/green3.jpg");
		panelForTasks.setBounds(0, 45, 592, 299);

		chefProjetView1.getContentPane().add(panelForTasks);
		panelForTasks.setLayout(null);

		JLabel lblNumTache = new JLabel("N° Tache : "+num_tache);
		lblNumTache.setBounds(232, 35, 114, 17);
		lblNumTache.setForeground(Color.white);
		panelForTasks.add(lblNumTache);

		JLabel lblContenu = new JLabel("Contenu : ");
		lblContenu.setBounds(83, 81, 76, 17);
		lblContenu.setForeground(Color.white);
		panelForTasks.add(lblContenu);

		String[] task_contenu = dp.getTasksContenu(Sproject.index);


		textField = new JTextField();
		textField.setBounds(232, 79, 277, 21);
		textField.setColumns(10);
		textField.setText(task_contenu[num_tache-1]);
		panelForTasks.add(textField);


		String[] task_date = dp.getTasksDate(Sproject.index);

		JLabel lblDateFinale = new JLabel("Date finale :");
		lblDateFinale.setBounds(83, 141, 97, 17);
		lblDateFinale.setForeground(Color.white);
		panelForTasks.add(lblDateFinale);

		JTextField textField_1 = new JTextField(task_date[num_tache-1]);
		textField_1.setBounds(232, 139, 277, 21);
		panelForTasks.add(textField_1);
		textField_1.setColumns(10);


		String[] task_etat = dp.getTasksEtat(Sproject.index);      

		JLabel lblEtat = new JLabel("Etat:");
		lblEtat.setForeground(Color.white);
		lblEtat.setBounds(83, 206, 51, 17);

		textField_2 = new JTextField();
		textField_2.setBounds(232, 204, 277, 21);
		panelForTasks.add(textField_2);
		textField_2.setColumns(10);

		if(task_etat[num_tache-1].equals("0"))
			textField_2.setText("en cours");
		else
			textField_2.setText("terminée");


		panelForTasks.add(lblEtat);



		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(198, 250, 96, 27);
		panelForTasks.add(btnValider);

		btnValider.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				DatabaseQueries.validerTacheChef(dp.getIdTache(task_contenu[num_tache-1],task_date[num_tache-1]));
				DatabaseQueries.projetValide(Sproject.index);
			}});

		JButton btnNext = new JButton("Next");
		btnNext.setBounds(318, 250, 96, 27);
		panelForTasks.add(btnNext);

		btnNext.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(dp.countTasks(Sproject.index) - num_tache != 0)
				{
					++num_tache;
					panelForTasks.setVisible(false);
					openTaskPanel();
					//  initialize();
					// panelForTasks.setVisible(true);

				}
				else
				{
					JOptionPane.showMessageDialog(LoginWindow.getJFrameForLoginWindow(), "Il n y a plus de taches",
							"Inane error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	private static class WhiteYellowCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
            Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
          
            System.out.println(etats[index]);
            if(etats[index] == 1)
                c.setBackground(Color.RED);
            if(etats[index] == 2)
                c.setBackground(Color.white);
            if(etats[index] == 3)
                c.setBackground(Color.GREEN);
          
            return c;
        }
	}

}
