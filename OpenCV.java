package com.cr.main;




import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.cpp.opencv_core.CvContour;
import com.googlecode.javacv.cpp.opencv_core.CvMemStorage;
import com.googlecode.javacv.cpp.opencv_core.CvPoint;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.CvScalar;
import com.googlecode.javacv.cpp.opencv_core.CvSeq;
import com.googlecode.javacv.cpp.opencv_core.CvSize;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import com.googlecode.javacpp.Loader;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;

import static com.googlecode.javacv.cpp.opencv_imgproc.*;

import java.awt.Rectangle;
import java.awt.Robot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Timer;


public class OpenCV {
	
	static Timer t;
	static int looped=0;
	static List<Integer> xValues = new ArrayList<Integer>();
	static List<Integer> yValues = new ArrayList<Integer>();
	public static void findImage(String input) {
		

		final CanvasFrame canvas = new CanvasFrame("Demo");
		
		canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		
		IplImage img=cvLoadImage(input);
	    CvSize cvSize = cvSize(img.width(), img.height());
	    IplImage gry=cvCreateImage(cvSize, img.depth(), 1);
		
	    cvCvtColor(img, gry, CV_BGR2GRAY);
	    cvThreshold(gry, gry, 200, 255, CV_THRESH_BINARY);
	    cvAdaptiveThreshold(gry, gry, 255, CV_ADAPTIVE_THRESH_MEAN_C, CV_THRESH_BINARY_INV, 11, 5);

	    CvMemStorage storage = CvMemStorage.create();
	    CvSeq contours = new CvContour(null);

	    
	    CvSeq ptr = new CvSeq();
	    

	    int count =1;
	    CvPoint p1 = new CvPoint(0,0),p2 = new CvPoint(0,0);

	    for (ptr = contours; ptr != null; ptr = ptr.h_next()) {

	        CvScalar color = CvScalar.RED;
	        CvRect sq = cvBoundingRect(ptr, 0);

        
            System.out.println("Contour No ="+count);
            System.out.println("X ="+ sq.x()+" Y="+ sq.y());
            System.out.println("Height ="+sq.height()+" Width ="+sq.width());
            System.out.println();
            p1.x(sq.x());
            p2.x(sq.x()+sq.width());
            p1.y(sq.y());
            p2.y(sq.y()+sq.height());
            
      

              
            
            cvDrawContours(img, ptr, color, CV_RGB(0,0,0), -1, CV_FILLED, 8, cvPoint(0,0));
            
            
        	count++;
	            
	            
	            

	    }
	    
	    
	    canvas.showImage(img);
	
		
		cvWaitKey();
		
	 
		
	}
	
	
	
    public ArrayList<Integer> getXList(ArrayList<Integer>x) {
        return x;
    }
    public ArrayList<Integer> getYList(ArrayList<Integer>y) {
        return y;
    }
    public void clearList() {
    	xValues.clear();
    	yValues.clear();
    }

	public static void main(String[] args) throws Exception {
		
		run();

		
		
	}
	
	public static void run() {
		String fileLoc = "C:\\Users\\justi\\eclipse-workspace\\JustinProgram\\open cv image\\Current Screen.PNG";
		try {
			captureScreen(fileLoc);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		findImage(fileLoc);
	
		
	}

	public static void captureScreen(String fileName) throws Exception {
		
		try {
			int x=2560;
			int y =1440;
			Robot robot = new Robot();
			Rectangle rect = new Rectangle(600,600,1200,200);
			
			BufferedImage screesnShot = robot.createScreenCapture(rect);
			
			ImageIO.write(screesnShot, "PNG", 
					new File ("C:\\\\Users\\\\justi\\\\eclipse-workspace\\\\JustinProgram\\\\open cv image\\\\Current Screen.PNG"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
