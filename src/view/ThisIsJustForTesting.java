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
		frame = new JFrameWithBackgroundImage("white.jpg");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		ImagePanel panelForm4= new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/green3.jpg");
		panelForm4.setBounds(0, 45, 592, 299);
		frame.getContentPane().add(panelForm4);
		panelForm4.setLayout(null);
		
		JPanel panelThatWillChange = new JPanel();
		panelThatWillChange.setBounds(33, 30, 356, 222);
		panelForm4.add(panelThatWillChange);
		panelThatWillChange.setLayout(null);
		
		JList listTaches = new JList();
		listTaches.setBounds(0, 0, 356, 222);
		panelThatWillChange.add(listTaches);
		
		JButton btnMatriel = new JButton("Matériel");
		btnMatriel.setBounds(427, 147, 121, 27);
		panelForm4.add(btnMatriel);
		
		JButton btnLicenses = new JButton("Licenses");
		btnLicenses.setBounds(427, 186, 121, 27);
		panelForm4.add(btnLicenses);
		
		JButton btnNewButton_1 = new JButton("État et budget");
		btnNewButton_1.setBounds(427, 225, 121, 27);
		panelForm4.add(btnNewButton_1);
		/*
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 444, 26);
		mainPanelChef1.add(toolBar);*/
		
		JPanel panelNotif = new ImagePanel("/home/ouissal/workspace/ProjetSuiviDesMarches/img/icon3.png");
		panelNotif.setBounds(539, 0, 53, 46);
		frame.getContentPane().add(panelNotif);
		panelNotif.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessageBoxes.vousAvezUneNotification();
			}
		});
		

				ImageIcon openIcon = new ImageIcon(
	                 ThisIsJustForTesting.class.getResource("/resources/images/icon1.png"));
	            ImageIcon saveIcon = new ImageIcon(
	                    ThisIsJustForTesting.class.getResource("/resources/images/icon2.png"));
	            ImageIcon newIcon = new ImageIcon(
	                    ThisIsJustForTesting.class.getResource("/resources/images/icon3.png"));
	            ImageIcon taskIcon = new ImageIcon(
	                    ThisIsJustForTesting.class.getResource("/resources/images/icon5.png"));
	            
	            
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
