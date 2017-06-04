package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class EmployeeView2Formulaire {

	public static JFrameWithBackgroundImage employeeView2Formulaire;

	public EmployeeView2Formulaire() {
		initialize();
	}

	private void initialize() {
		employeeView2Formulaire = new JFrameWithBackgroundImage("image.png");
		employeeView2Formulaire.setBounds(100, 100, 400, 400);
		employeeView2Formulaire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employeeView2Formulaire.setLocationRelativeTo(null);
		employeeView2Formulaire.setVisible(true);
	}

}
