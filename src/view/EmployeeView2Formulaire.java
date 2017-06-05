package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JEditorPane;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.DateLabelFormatter;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class EmployeeView2Formulaire {
	private JProgressBar progressBarFormulaire1;
	
	// Pour remplir les comboBox
	String jours = "Jours";
	String mois = "Mois";
	String semaines = "Semaines";
	String annees = "Années";
	String[] comboBoxElementsforForm1And2 = { jours, mois, semaines, annees };
	
	//******
	private ImagePanel panelForm2;
	private String MaterialValue;
	private String LicenseValue;
	
	/*  Materials will be saved in this arraylist, and you have access to them from another package
	 * using EmployeeView2Formulaire.getMaterialsSaisisArraylist ... same for the rest
	 */
	private static ArrayList listeDesMaterielsSaisis;  
	private static ArrayList listeDesLicensesSaisies;  
	
	public String getMaterialValue()
	{
		return MaterialValue;
	}
	
	public String getLicenseValue()
	{
		return LicenseValue;
	}
	
	public static ArrayList getlisteDesMaterielsSaisis()
	{
		return listeDesMaterielsSaisis;
	}
	
	public static ArrayList getlisteDesLicensesSaisies()
	{
		return listeDesLicensesSaisies;
	}
	


	public static JFrameWithBackgroundImage employeeView2Formulaire;

	public EmployeeView2Formulaire() {
		initialize();
	}

	private void initialize() {
		employeeView2Formulaire = new JFrameWithBackgroundImage("green3.jpg");
		employeeView2Formulaire.setBounds(100, 100, 600, 400);
		employeeView2Formulaire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employeeView2Formulaire.setLocationRelativeTo(null);
		employeeView2Formulaire.getContentPane().setLayout(null);
		
		
		ImagePanel panelForm1 = new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		panelForm1.setBounds(0, 57, 592, 310);
		employeeView2Formulaire.getContentPane().add(panelForm1);
		panelForm1.setLayout(null);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(277, 36, 263, 46);
		panelForm1.add(editorPane_1);
		
		Label objectifProjetLabel = new Label("Objectif :");
		objectifProjetLabel.setBackground(Color.WHITE);
		objectifProjetLabel.setFont(UIManager.getFont("PasswordField.font"));
		objectifProjetLabel.setAlignment(Label.CENTER);
		objectifProjetLabel.setBounds(63, 36, 177, 27);
		panelForm1.add(objectifProjetLabel);
		
		Label dureeProjet = new Label("Durée :");
		dureeProjet.setBackground(Color.WHITE);
		dureeProjet.setFont(UIManager.getFont("PasswordField.font"));
		dureeProjet.setAlignment(Label.CENTER);
		dureeProjet.setBounds(63, 108, 177, 27);
		panelForm1.add(dureeProjet);
		
		JSpinner spinnerDuree = new JSpinner();
		spinnerDuree.setBounds(277, 108, 123, 27);
		panelForm1.add(spinnerDuree);
		
		/* POPULATING THE COMBOBOX */

		
		JComboBox comboBoxDuree = new JComboBox(comboBoxElementsforForm1And2);
		comboBoxDuree.setBounds(412, 108, 128, 46);
		panelForm1.add(comboBoxDuree);
		
		Label labelBudget = new Label("Budget (MDH)  :");
		labelBudget.setBackground(Color.WHITE);
		labelBudget.setFont(UIManager.getFont("PasswordField.font"));
		labelBudget.setAlignment(Label.CENTER);
		labelBudget.setBounds(63, 180, 177, 27);
		panelForm1.add(labelBudget);
		
		
		
		JButton btnSuivant = new JButton("Suivant");
		btnSuivant.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// Some conditions must be added
				// User can't click on suivant unless all fields have been filled
				//same for all suivant buttons
				panelForm1.setVisible(false);
				progressBarFormulaire1.setValue(45);
				createAndDisplaySecondFormPanel();
				}
		});
		btnSuivant.setBounds(334, 257, 96, 27);
		panelForm1.add(btnSuivant);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnAnnuler.setBounds(442, 257, 96, 27);
		panelForm1.add(btnAnnuler);
	
		
		JSpinner spinnerBudget = new JSpinner();
		spinnerBudget.setBounds(277, 180, 263, 27);
		panelForm1.add(spinnerBudget);
		
		
	/*************************************************************************
	 * 
	 *       Le 2eme panel ( ajouter une tache)	
	 */
		
		
	/*****************************************************************************
	 *   FIN DE LA FENETRE 2	
	 */
	
		
		progressBarFormulaire1 = new JProgressBar();
		progressBarFormulaire1.setBounds(221, 12, 159, 30);
		employeeView2Formulaire.getContentPane().add(progressBarFormulaire1);
		employeeView2Formulaire.setVisible(true);
	}
	

	public  void createAndDisplaySecondFormPanel()
	{
		ImagePanel panelForm2 = new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		panelForm2.setBounds(0, 57, 592, 310);
		employeeView2Formulaire.getContentPane().add(panelForm2);
	
		panelForm2.setLayout(null);
		Label contenuTacheLabel = new Label("Contenu :");
		contenuTacheLabel.setBackground(Color.WHITE);
		contenuTacheLabel.setFont(UIManager.getFont("PasswordField.font"));
		contenuTacheLabel.setAlignment(Label.CENTER);
		//contenuTacheLabel.setBounds(52, 33, 131, 43);
		contenuTacheLabel.setBounds(52, 32, 131, 27);
		panelForm2.add(contenuTacheLabel);
		
		
	
		
		JEditorPane ajouterTacheContenu = new JEditorPane();
		ajouterTacheContenu.setBounds(275, 33, 263, 43);
		panelForm2.add(ajouterTacheContenu);
		
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");

		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model,p );
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(275, 101, 263, 27);
		panelForm2.add(datePicker);
	
		
		Label dateFinaleTache = new Label("Date finale :");
		dateFinaleTache.setBackground(Color.WHITE);
		dateFinaleTache.setFont(UIManager.getFont("PasswordField.font"));
		dateFinaleTache.setAlignment(Label.CENTER);
		dateFinaleTache.setBounds(52, 101, 131, 27);
		panelForm2.add(dateFinaleTache);
		
		Label dureeTache = new Label("Durée :");
		dureeTache.setBackground(Color.WHITE);
		dureeTache.setFont(UIManager.getFont("PasswordField.font"));
		dureeTache.setAlignment(Label.CENTER);
		dureeTache.setBounds(52, 167, 131, 27);
		panelForm2.add(dureeTache);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(407, 167, 131, 27);
		panelForm2.add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(275, 167, 106, 27);
		panelForm2.add(spinner);
		
		JButton ajouterAutreTache = new JButton("Ajouter une autre tache");
		ajouterAutreTache.setBounds(52, 251, 158, 27);
		panelForm2.add(ajouterAutreTache);
		
		JButton btnAnnulerForm2 = new JButton("Annuler");
		btnAnnulerForm2.setBounds(442, 251, 96, 27);
		panelForm2.add(btnAnnulerForm2);
		
		JButton btnSuivantForm2 = new JButton("Suivant");
		btnSuivantForm2.setBounds(332, 251, 96, 27);
		panelForm2.add(btnSuivantForm2);
		
		ajouterAutreTache.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//check if everything is filled
				//save first task to database by calling a function from the otehr package
				// Empty the form
				
				}
		});
		
		btnSuivantForm2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				panelForm2.setVisible(false);
				progressBarFormulaire1.setValue(75);
				createAndDisplayThirdFormPanel();
				}
		});
		
		btnAnnulerForm2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO
				}
		});
		
		/*JLabel lblDateWillBe = new JLabel("DATE WILL BE AT THIS POSITION");
		lblDateWillBe.setBounds(275, 101, 263, 27);
		panelForm2.add(lblDateWillBe);*/
		
		panelForm2.setVisible(true);
	}
	
	public  void createAndDisplayThirdFormPanel()
	{
		ImagePanel panelForm3= new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		panelForm3.setBounds(0, 57, 592, 310);
		employeeView2Formulaire.getContentPane().add(panelForm3);
		panelForm3.setLayout(null);
		
		JButton btnAjouterMateriel = new JButton("Ajouter un matériel");
		btnAjouterMateriel.setBounds(227, 64, 155, 42);
		panelForm3.add(btnAjouterMateriel);
		
		JButton btnAjouterLicense = new JButton("Ajouter une license");
		btnAjouterLicense.setBounds(227, 141, 155, 42);
		panelForm3.add(btnAjouterLicense);
		
		JButton btnAnnulerFormulaire3 = new JButton("Annuler");
		btnAnnulerFormulaire3.setBounds(453, 244, 96, 27);
		panelForm3.add(btnAnnulerFormulaire3);
		
		JButton btnTerminerFormulaire3 = new JButton("Terminer");
		btnTerminerFormulaire3.setBounds(333, 244, 96, 27);
		panelForm3.add(btnTerminerFormulaire3);
		panelForm3.setVisible(true);
		
		btnAjouterMateriel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				  MaterialValue = JOptionPane.showInputDialog("Veuillez saisir un matériel");  
				  // check if user didn't enter anything
				  //save each value in the arrayList that will be accessed from the other package
				  //same for Licenses
				  //save the elements of the arraylist in the database value in the database ..etc
				}
		});
		
		btnAjouterLicense.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				LicenseValue = JOptionPane.showInputDialog("Veuillez saisir une license");  
				}
		});
		
		btnTerminerFormulaire3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// go back to the other window (or close the application)
				}
		});
		
		btnAnnulerFormulaire3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// Close the application
				}
		});
	}
	
}
