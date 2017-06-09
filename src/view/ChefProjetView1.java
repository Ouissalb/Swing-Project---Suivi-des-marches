package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class ChefProjetView1 {

	public static JFrameWithBackgroundImage chefProjetView1;

	public ChefProjetView1() {
		initialize();
	}
	JPanel mainPanelChef1;
	ImagePanel panelForm4;
	JPanel mainPanelChef2;

	private void initialize() 
	{
		chefProjetView1 = new JFrameWithBackgroundImage("white.jpg");
		chefProjetView1.setBounds(100, 100, 600, 400);
		chefProjetView1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chefProjetView1.setLocationRelativeTo(null);
		chefProjetView1.getContentPane().setLayout(null);
		
	    panelForm4= new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		panelForm4.setBounds(0, 46, 592, 321);
		chefProjetView1.getContentPane().add(panelForm4);
		panelForm4.setLayout(null);
		
		JPanel sidePanelChef1 = new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/blue2.png");
		sidePanelChef1.setBounds(0, -45, 150, 366);
		panelForm4.add(sidePanelChef1);
		sidePanelChef1.setLayout(null);
		
		JButton btnValiderChef1 = new JButton("Validation");
		
		mainPanelChef1 =  new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		mainPanelChef1.setBounds(148, 0, 444, 321);
		panelForm4.add(mainPanelChef1);
		mainPanelChef1.setLayout(null);
		
		btnValiderChef1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanelChef1.setVisible(false);
				validerTacheChef();
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
		
		
		JPanel panelNotif = new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/icon3.png");
		panelNotif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessageBoxes.vousAvezUneNotification();
			}
		});
		panelNotif.setBounds(539, 0, 53, 46);
		chefProjetView1.getContentPane().add(panelNotif);
	}
	
	public void validerTacheChef()
	{
		mainPanelChef2 =  new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		mainPanelChef2.setBounds(148, 0, 444, 321);
		panelForm4.add(mainPanelChef2);
		mainPanelChef2.setLayout(null);
		
		JList list = new JList();
		list.setBounds(47, 36, 344, 186);
		mainPanelChef2.add(list);
		
		JButton validerTaches = new JButton("Valider");
		validerTaches.setBounds(168, 240, 96, 27);
		mainPanelChef2.add(validerTaches);
		mainPanelChef2.setVisible(true);
	}

}
