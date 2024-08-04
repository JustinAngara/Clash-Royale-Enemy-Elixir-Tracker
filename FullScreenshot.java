package com.cr.main;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class FullScreenshot {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullScreenshot window = new FullScreenshot();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FullScreenshot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { //660 1080
		frame = new JFrame();
		frame.setBounds(0, 0, 2560, 1440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
		
		Icon icon;
		icon = new ImageIcon("C:\\Users\\justi\\eclipse-workspace\\JustinProgram\\image\\Clash2.PNG");
		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.setBounds(0, 0, 2560, 1440);
		frame.getContentPane().add(lblNewLabel);
		
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setBackground(new Color(0, 0, 0, 0));
		
		

	}
}

