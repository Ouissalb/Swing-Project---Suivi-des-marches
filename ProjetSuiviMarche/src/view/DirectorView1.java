/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author boughriba
 */
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

	private void initialize() {
		directorView1 = new JFrameWithBackgroundImage("green2.jpg");
		directorView1.setBounds(0, 0, 400, 400);
		//to make the window appear in the center
		directorView1.setLocationRelativeTo(null);
		directorView1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		directorView1.getContentPane().setLayout(null);
	}
}
