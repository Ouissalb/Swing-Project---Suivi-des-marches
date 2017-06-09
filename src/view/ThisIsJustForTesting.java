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
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

		ImagePanel panelForm4= new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		panelForm4.setBounds(0, 46, 592, 321);
		frame.getContentPane().add(panelForm4);
		panelForm4.setLayout(null);
		
		JPanel sidePanelChef1 = new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/blue2.png");
		sidePanelChef1.setBounds(0, -45, 150, 366);
		panelForm4.add(sidePanelChef1);
		sidePanelChef1.setLayout(null);
		
		JButton btnValiderChef1 = new JButton("Validation");
		btnValiderChef1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnValiderChef1.setFont(new Font("Dialog", Font.BOLD, 11));
		btnValiderChef1.setBounds(23, 91, 98, 49);
		sidePanelChef1.add(btnValiderChef1);
		
		JButton btnDeroulementChef = new JButton("Déroulement");
		btnDeroulementChef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeroulementChef.setFont(new Font("Dialog", Font.BOLD, 11));
		btnDeroulementChef.setBounds(23, 174, 98, 49);
		sidePanelChef1.add(btnDeroulementChef);
		
		JButton btnStatistiques = new JButton("Statistiques");
		btnStatistiques.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStatistiques.setFont(new Font("Dialog", Font.BOLD, 11));
		btnStatistiques.setBounds(23, 260, 98, 49);
		sidePanelChef1.add(btnStatistiques);
		
		JPanel mainPanelChef1 =  new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		mainPanelChef1.setBounds(148, 0, 444, 321);
		panelForm4.add(mainPanelChef1);
		mainPanelChef1.setLayout(null);
		
		JList list = new JList();
		list.setBounds(47, 36, 344, 186);
		mainPanelChef1.add(list);
		
		JButton validerTaches = new JButton("Valider");
		validerTaches.setBounds(168, 240, 96, 27);
		mainPanelChef1.add(validerTaches);
		
		JPanel panelNotif = new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/icon3.png");
		panelNotif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessageBoxes.vousAvezUneNotification();
			}
		});
		panelNotif.setBounds(539, 0, 53, 46);
		frame.getContentPane().add(panelNotif);

		
	}
}
