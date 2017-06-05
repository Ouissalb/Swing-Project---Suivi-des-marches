package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImagePanel extends JPanel
{

	String inputImage;

	public ImagePanel(String image) {
	inputImage = image;

	}

	@Override
	protected void paintComponent(Graphics g) {

	super.paintComponent(g);
	BufferedImage image = null;
	try {
	image = ImageIO.read(new File(inputImage));
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	g.drawImage(image, 0, 0, null);
	}

}



