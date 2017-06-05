package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

public class ThisIsJustForTesting {

	private JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public ThisIsJustForTesting() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		
		/*UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, null);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);
		panelForm2.add(datePicker);*/

		
		
		ImagePanel panelForm3= new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		panelForm3.setBounds(0, 57, 592, 310);
		frame.getContentPane().add(panelForm3);
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
		
		JButton btnSuivantFormulaire3 = new JButton("Suivant");
		btnSuivantFormulaire3.setBounds(333, 244, 96, 27);
		panelForm3.add(btnSuivantFormulaire3);
	}
}
