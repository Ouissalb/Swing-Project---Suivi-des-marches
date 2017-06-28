package view;

import java.awt.EventQueue;
import controller.DataProc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sproject {

	  private DataProc dataProc = new DataProc();
	private JFrame frame;
    static int index;
    static  boolean selectedProject;

	public Sproject() {
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
		
		String[] combo  = this.dataProc.getProjects(); 
		JComboBox selectP = new JComboBox(combo);
		selectP.setBounds(37, 67, 264, 26);
		panel.add(selectP);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
            	index = selectP.getSelectedIndex();
                ++index;
               selectedProject = true;
                frame.dispose();
			}
		});
		btnOk.setBounds(124, 125, 96, 27);
		panel.add(btnOk);
		
		JLabel lblSelectionnerUnProjet = new JLabel("Selectionner un projet");
		lblSelectionnerUnProjet.setBounds(37, 25, 183, 17);
		panel.add(lblSelectionnerUnProjet);
		frame.setVisible(true);
	}
}
