package com.cr.main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Info {
	static List <Integer> elixrPos = new ArrayList<Integer>();
	static List <Integer> averageColor = new ArrayList<Integer>();
	static List<String> name = new ArrayList<String>();

	static int y = 1400;
	static Color elixr = new Color(150,33,210);
	static Robot robot;
	static int n;
	static int c;
	/* 
		elixr
	 	current cards in deck
	*/
	
	public static int getElixr() throws AWTException {
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
	public static String printChar(int x, int y) throws AWTException {
        int[] numbers = averageColor.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
		
		List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
		
		

		n = getAverage(x,y);
		c = list.stream()
		            .min(Comparator.comparingInt(l -> Math.abs(l - n)))
		            .orElseThrow(() -> new NoSuchElementException("No value present"));
		
		return getChar(c);

		
		
		
	}
	
	public static String getChar(int x) {
		
		for(int i = 0;i<averageColor.size();i++) {
			if(averageColor.get(i)==x)
				return name.get(i);
		}
		
		return null;
	}
	
	public static int getAverage(int x, int z) throws AWTException {
		robot = new Robot();
		Color grabPixelLocation = robot.getPixelColor(x,z);
		return (grabPixelLocation.getRed()+grabPixelLocation.getGreen()+grabPixelLocation.getBlue()) /3;
	}
	public static String getColor(int x, int y) throws AWTException{
		robot = new Robot();
		Color grabPixelLocation = robot.getPixelColor(x,y);
		return grabPixelLocation+" Average: "+getAverage(x,y);
	}
}
