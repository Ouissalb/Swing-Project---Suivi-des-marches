package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

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
		frame = new JFrameWithBackgroundImage("/white.jpg");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		ImagePanel panelForm4= new ImagePanel("/green3.jpg");
		panelForm4.setBounds(0, 47, 592, 297);
		frame.getContentPane().add(panelForm4);
		panelForm4.setLayout(null);
		
		JPanel panelThatWillChange = new JPanel();
		panelThatWillChange.setBounds(33, 30, 356, 222);
		panelForm4.add(panelThatWillChange);
		panelThatWillChange.setLayout(null);
		
		JButton btnMatriel = new JButton("Matériel");
		btnMatriel.setBounds(427, 147, 121, 27);
		panelForm4.add(btnMatriel);
		
		JButton btnLicenses = new JButton("Licenses");
		btnLicenses.setBounds(427, 186, 121, 27);
		panelForm4.add(btnLicenses);
		
		JButton boutonAllouer = new JButton("Allouer budget");
		boutonAllouer.setBounds(65, 264, 121, 20);
		panelForm4.add(boutonAllouer);
		
		JButton btnArreterService = new JButton("Arreter service");
		btnArreterService.setBounds(233, 264, 121, 20);
		panelForm4.add(btnArreterService);
		
		JList listTaches = new JList();
		listTaches.setBounds(33, 12, 356, 222);
		panelForm4.add(listTaches);
		/*
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 444, 26);
		mainPanelChef1.add(toolBar);*/
		
		JPanel panelNotif = new ImagePanel("icon3.png");
		panelNotif.setBounds(539, 0, 53, 46);
		frame.getContentPane().add(panelNotif);
		panelNotif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessageBoxes.vousAvezUneNotification();
			}
		});
		

				ImageIcon openIcon = ChefProjetView1.createImageIcon("/Sicon1.png", " Sicon1");
	            ImageIcon saveIcon = ChefProjetView1.createImageIcon("/Sicon2.png", " Sicon2");
	            ImageIcon newIcon = ChefProjetView1.createImageIcon("/Sicon3.png", "Sicon3");
	            ImageIcon taskIcon = ChefProjetView1.createImageIcon("/Sicon5.png", "Sicon5");
	            
	            
	            Action openAction = new AbstractAction("Ouvrir un projet", openIcon) {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    System.out.println("Ouvrir un projet");
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
	                    System.out.println("Taches");
	                }
	            };
	            
	            Action validerCommentairestaskAction = new AbstractAction("Afficher les commentaires", taskIcon) {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    System.out.println("Taches");
	                }
	            };
	            
	            Action afficherTachesSignaleAction = new AbstractAction("Afficher les taches signalées", taskIcon) {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    System.out.println("Taches");
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
	            
	            
	            
	            frame.setJMenuBar(menuBar);

	            
	            /*
	             * 
	             */
		
	            
	}
}
