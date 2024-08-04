package com.cr.main;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.Color;

public class ClashRoyaleAuto {

	private JFrame frame;
	static List <String> cards = new ArrayList<String>();
	static Timer t;
	static String fileLoc="C:\\Users\\justi\\eclipse-workspace\\JustinProgram\\image\\Clash Royale";
	public static void addCards() {
		cards.add(fileLoc+"\\Valk.PNG");
		cards.add(fileLoc+"\\Log.PNG");
		cards.add(fileLoc+"\\Mega Knight.PNG");
		cards.add(fileLoc+"\\Mortar.PNG");
		cards.add(fileLoc+"\\Bats.PNG");
		cards.add(fileLoc+"\\Dart Goblin.PNG");
		cards.add(fileLoc+"\\Bats.PNG");
		cards.add(fileLoc+"\\Bandit.PNG");
		cards.add(fileLoc+"\\Electro Wiz.PNG");
	}
	public static void addCycle() {
		cards.add(fileLoc+"\\Log.PNG");
		cards.add(fileLoc+"\\X Bow.PNG");
		
	}
	public String getCard() {
		return null;
	}
    public static int[] imageLocation(String fileNameWithPath) {
        BufferedImage bi = readImage(fileNameWithPath);
        BufferedImage image = null;
        try {
            image = new Robot().createScreenCapture(new Rectangle(1051,1201,1630-1051,1354-1201));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {

                boolean invalid = false;
                int k = x, l = y;
                for (int a = 0; a < bi.getWidth(); a++) {
                    l = y;
                    for (int b = 0; b < bi.getHeight(); b++) {
                        if (bi.getRGB(a, b) != image.getRGB(k, l)) {
                            invalid = true;
                            break;
                        } else {
                            l++;
                        }
                    }
                    if (invalid) {
                        break;
                    } else {
                        k++;
                    }

                }

                if (!invalid) {
                    int[] locs = new int[2];
                    locs[0] = k - (bi.getWidth() / 2);
                    locs[1] = l - (bi.getHeight() / 2);
                    return locs;
                }
            }
        }
        return null;
    }
    public static BufferedImage readImage(String path) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }
    
    public static void run() {
    	addCycle();
    	t = new Timer(200,(ActionEvent e)->{
	    	for(int i = 0;i<cards.size();i++) {
	    		if(imageLocation(cards.get(i))!=null) {
	    			
	    			System.out.println(cards.get(i).substring(fileLoc.length()));
	    			cards.remove(i);
	    			i--;
	    		}
	    	}
    	});
    	t.start();
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		run();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClashRoyaleAuto window = new ClashRoyaleAuto();
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
	public ClashRoyaleAuto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0,0));
		frame.setBounds(0, 0, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

	}
}
