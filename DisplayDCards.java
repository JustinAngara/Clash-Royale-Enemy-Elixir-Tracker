package com.cr.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DisplayDCards {

	private JFrame frame;
	static String loc;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayDCards window = new DisplayDCards();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws AWTException 
	 * @throws IOException 
	 */
	public DisplayDCards() throws IOException, AWTException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws AWTException 
	 * @throws IOException 
	 */
	private void initialize() throws IOException, AWTException {
		frame = new JFrame();
		frame.setBounds(0, 0, 2560, 1440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
		takeSS();
		Icon icon;
		loc="C:\\\\Users\\\\justi\\\\eclipse-workspace\\\\JustinProgram\\\\image\\\\Clash Royale\\\\temp.png";
		icon = new ImageIcon(loc);
		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.setBounds(0, 0, 2560, 1440);
		frame.getContentPane().add(lblNewLabel);
		
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setBackground(new Color(0,0,0,0));
		
	}
	
	public void takeSS() throws IOException, AWTException {


	
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(2974, 728, 3447-2974, 795-728));
		ImageIO.write(image, "png", new File("C:\\Users\\justi\\eclipse-workspace\\JustinProgram\\image\\Clash Royale\\temp.png"));
	}


}
