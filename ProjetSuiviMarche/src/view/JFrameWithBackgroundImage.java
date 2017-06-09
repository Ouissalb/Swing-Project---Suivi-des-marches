package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author boughriba
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
	
public class JFrameWithBackgroundImage extends JFrame
{
	/*JButton b1;
	JLabel l1;*/
    public JFrameWithBackgroundImage(String imageFilename)
    {
	setTitle("Suivi des marchés");
	setSize(400,400);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(true);

	getContentPane().setLayout(new BorderLayout());
	setContentPane(new JLabel(new ImageIcon(imageFilename)));
	getContentPane().setLayout(new FlowLayout());
	getContentPane().setLayout(new BorderLayout());
	setSize(399,399);
	setSize(400,400);
    }
}


