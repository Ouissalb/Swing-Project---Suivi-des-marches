package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controller.SetVisibility;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Testing {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField budjetF;



	/**
	 * Create the application.
	 */
	public Testing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 353, 197);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 345, 164);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel saisirBudget = new JLabel("Saisir un budjet : ");
		saisirBudget.setBounds(37, 25, 183, 17);
		panel.add(saisirBudget);
		
		budjetF = new JTextField();
		budjetF.setBounds(117, 74, 114, 21);
		panel.add(budjetF);
		budjetF.setColumns(10);
		
		JButton btnConfirmer = new JButton("confirmer");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmer.setBounds(219, 125, 96, 27);
		panel.add(btnConfirmer);
		frame.setVisible(true);

	}
}
