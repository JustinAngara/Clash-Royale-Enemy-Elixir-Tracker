package com.cr.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class ClashGUI extends ClashRoyaleAuto{

	private JFrame frame;
	static Timer t;
	static Random random;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClashGUI window = new ClashGUI();
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
	 */
	public ClashGUI() throws AWTException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws AWTException 
	 */
	private void initialize() throws AWTException {
		ClashRoyale.run();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int y = ClashRoyale.y;
		t = new Timer(1000,(ActionEvent e)->{
			try {
				
				duo();
				
			
				for(int i = 0;i<ClashRoyale.currentDeck.size();i++) {
					ClashRoyale.currentDeck.set(i, Info.printChar(ClashRoyale.xValue.get(i), y));
					System.out.println("I: "+i+" Card: "+ClashRoyale.currentDeck.get(i));
				}
				
				//comboOne();
				
				randomMove();
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		t.start();
	}
	
	public void buttonJ() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_J);
		r.keyRelease(KeyEvent.VK_J);

	}
	public void duo() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		Color grabPixelLocation = robot.getPixelColor(1192,1394);
		if(grabPixelLocation.getRed()==255) {
			mouseClick(3111,700);
			buttonJ();
			Thread.sleep(500);
			mouseClick(1142,700);
			buttonJ();
		}
	}
	public void randomMove() throws AWTException, InterruptedException {
		random = new Random();
		int y = 1090;
		int x = 1248;
		for(int i = 0;i<ClashRoyale.currentDeck.size();i++) {
			
			y=random.nextInt(1080 - 660 + 1) + 660;
			if(Info.getElixr()>=6) {
				if(ClashRoyale.currentDeck.get(i).equals("X Bow")) {
					clickOne(translate(i));
					mouseClick(1254,666);
				}
			}
			
			if(Info.getElixr()==10) {
				if(ClashRoyale.currentDeck.get(i).equals("Mega Knight") || ClashRoyale.currentDeck.get(i).equals("Inferno Dragon")) {
					clickOne(translate(i));
					mouseClick(x,y);
				}
			}
			
			/*
			if(Info.getElixr()>=4) {
				if(ClashRoyale.currentDeck.get(i).equals("Mortar")) {
					clickOne(translate(i));
					mouseClick(1254,666);
				}
				
				if(ClashRoyale.currentDeck.get(i).equals("Valk") || ClashRoyale.currentDeck.get(i).equals("Musk")) {
					clickOne(translate(i));
					mouseClick(x,y+50);
					
				}
			}
			*/
			if(Info.getElixr()>=3) {
				if(ClashRoyale.currentDeck.get(i).equals("Spear gob") || ClashRoyale.currentDeck.get(i).equals("Bats") ) {
					clickOne(translate(i));
					mouseClick(1248,1090);
					
					
				}
				
				if(ClashRoyale.currentDeck.get(i).equals("Arrow")) {
					clickOne(translate(i));
					mouseClick(1049,312+120);
					
				}
				Thread.sleep(3500);
			}
			

		}
		

	}
	public void comboOne() throws AWTException, InterruptedException {
		int x =0;
		int f = 0;
		int l = 0;
		for(int i = 0;i<ClashRoyale.currentDeck.size();i++) {
			if(ClashRoyale.currentDeck.get(i).equals("Inferno Dragon")) {
				x++;
				f = i;
			} else if(ClashRoyale.currentDeck.get(i).equals("Mega Knight")) {
				x++;
				l=i;
			}	
		}
		if(Info.getElixr()==10 && x==2) {
			clickOne(translate(f));
			mouseClick(1248,1090);
			clickOne(translate(l));
			mouseClick(1248,1090);
		}
	}
	
	
	public int translate(int x) {
		if(x==0) {
			return 49;
		} else if(x==1) {
			return 50;
		} else if (x==2) {
			return 51;
		} else {
			return 52;
		}
		
	}
	
	public static void mouseClick(int x, int y) throws AWTException{
	    Robot bot = new Robot();
	    bot.mouseMove(x, y);    
	    bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	
	public void clickOne(int x) throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.keyPress(x);
	    Thread.sleep(100);
	    robot.keyRelease(x);
	}

}
