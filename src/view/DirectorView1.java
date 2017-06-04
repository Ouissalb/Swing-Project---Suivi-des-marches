package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class DirectorView1 {


	/**
	 * Create the application.
	 */
	public DirectorView1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrameWithBackgroundImage directorView1 = new JFrameWithBackgroundImage();
		directorView1.setBounds(100, 100, 700, 300);
		directorView1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
