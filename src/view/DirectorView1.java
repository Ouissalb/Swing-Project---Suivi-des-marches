package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Panel;

public class DirectorView1 {
	public static JFrameWithBackgroundImage directorView1;

	public DirectorView1() {
		initialize();
	}

	private void initialize() 
	{
		directorView1 = new JFrameWithBackgroundImage("green3.jpg");
		directorView1.setBounds(100, 100, 600, 400);
		directorView1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		directorView1.setLocationRelativeTo(null);
		directorView1.getContentPane().setLayout(null);
	}
}
