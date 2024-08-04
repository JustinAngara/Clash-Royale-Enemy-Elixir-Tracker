package com.cr.main;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class ImprovedClashRoyale {
	static List <String> cards = new ArrayList<String>();
	static Timer t;
	static String fileLoc="C:\\Users\\justi\\eclipse-workspace\\JustinProgram\\image\\Clash Royale";
	public void addCards() {
		cards.add(fileLoc+"\\Valk.PNG");
		cards.add(fileLoc+"\\Log.PNG");
		cards.add(fileLoc+"\\Mega Knight.PNG");
		cards.add(fileLoc+"\\Mortar.PNG");
		cards.add(fileLoc+"\\Bats.PNG");
		cards.add(fileLoc+"\\Dart Goblin.PNG");
		cards.add(fileLoc+"\\Bats.PNG");
		cards.add(fileLoc+"\\Bandit.PNG");
	}
    public static int[] imageLocation(String fileNameWithPath) {
        BufferedImage bi = readImage(fileNameWithPath);
        BufferedImage image = null;
        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
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
    
    public void run() {
    	t = new Timer(200,(ActionEvent e)->{
	    	for(int i = 0;i<cards.size();i++) {
	    		if(imageLocation(cards.get(i))!=null) {
	    			System.out.println(cards.get(i).substring(fileLoc.length()));
	    		}
	    	}
    	});
    	t.start();
    }
    public static void main(String[] args) {
    	t = new Timer(200,(ActionEvent e)->{
	    	for(int i = 0;i<cards.size();i++) {
	    		if(imageLocation(cards.get(i))!=null) {
	    			System.out.println(cards.get(i).substring(fileLoc.length()));
	    		}
	    	}
    	});
    	t.start();
    }
}
