package com.cr.main;

import java.awt.AWTException;

public class Duo extends ClashGUI{

	public Duo() throws AWTException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		try {
			ClashGUI clashGUI = new ClashGUI();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClashGUI.main(args);
		
	}
	
}
