package com.cr.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.Timer;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import com.rl.main.JNativeHook;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ScoreEvaluation {

	private JFrame frame;
	static Timer t;
	static Robot robot;
	static Color elixr = new Color(150,33,210);
	int y= 685;
	private static List <Integer> elixrPos = new ArrayList<Integer>();
	private static List <Integer> myElixrPos = new ArrayList<Integer>();
	static int elixrScore;
	static int previousElixr;
	static int myElixr;
	static int enemyElixr;
	static boolean startTracking;
	static int count;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		addElixr();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreEvaluation window = new ScoreEvaluation();
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
	public ScoreEvaluation() {
		initialize();
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setUndecorated(true);
		frame.setBackground(new Color(1.0f,1.0f,1.0f,0.01f));
		
		frame.setBounds(475, 600, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(148, 0, 211));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(66, 124, 258, 75);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(148, 0, 211));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel_1.setBounds(66, 23, 258, 75);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(148, 0, 211));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel_1_1.setBounds(66, 227, 258, 75);
		frame.getContentPane().add(lblNewLabel_1_1);

		
		t = new Timer(15,(ActionEvent e)->{
			
			try {
				

				enemyElixr=getEnemyElixr();
				myElixr=getElixr();				
				elixrScore=myElixr-enemyElixr;


			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(elixrScore>=1) {
				lblNewLabel.setText("Elixr: +"+elixrScore);
			}else {
				lblNewLabel.setText("Elixr: "+elixrScore);
			}
			lblNewLabel_1_1.setText("My Elixr: "+myElixr);
			lblNewLabel_1.setText("Enemy Elixr: "+enemyElixr);
			
			
		});
		t.start();
	}
	

	private static void addElixr() {
		
		elixrPos.add(3098);
		elixrPos.add(3128);
		elixrPos.add(3165);
		elixrPos.add(3190);
		elixrPos.add(3322);
		elixrPos.add(3255);
		elixrPos.add(3284);
		elixrPos.add(3315);
		elixrPos.add(3350);
		elixrPos.add(3378);

		

		myElixrPos.add(1132);
		myElixrPos.add(1185);
		myElixrPos.add(1241);
		myElixrPos.add(1299);
		myElixrPos.add(1353);
		myElixrPos.add(1405);
		myElixrPos.add(1460);
		myElixrPos.add(1519);
		myElixrPos.add(1570);
		myElixrPos.add(1624);
	}
	
	public static int getElixr() throws AWTException {
		robot = new Robot();
		int sum = 0;
		Color grabPixelLocation = robot.getPixelColor(330,1407);
		for (int i=0;i<myElixrPos.size();i++) {
			grabPixelLocation=robot.getPixelColor(myElixrPos.get(i), 1407);
			if(grabPixelLocation.getRed()>=elixr.getRed()) {	
				sum++;
			}
		}
		return sum;
	}
	public int getEnemyElixr() throws AWTException {
		
		robot = new Robot();
		int sum = 0;
		Color grabPixelLocation = robot.getPixelColor(330,y);
		for (int i=0;i<elixrPos.size();i++) {
			grabPixelLocation=robot.getPixelColor(elixrPos.get(i), y);
			if(grabPixelLocation.getRed()>=elixr.getRed()) {	
				sum++;
				
			}
		}
		
		return sum;
	}
}
