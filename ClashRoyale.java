package com.cr.main;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

public class ClashRoyale {
	static List<String> currentDeck = new ArrayList<String>();
	static List<Integer> xValue = new ArrayList<Integer>();
	static int y = 1265;

	public static void run() throws AWTException {
		setup();
		currentDeck.set(0, Info.printChar(1118,y));
		currentDeck.set(1, Info.printChar(1263,y));
		currentDeck.set(2, Info.printChar(1408,y));
		currentDeck.set(3, Info.printChar(1553,y));

		
	}
	public static void setup() {
		Info.elixrPos.add(1132);
		Info.elixrPos.add(1185);
		Info.elixrPos.add(1241);
		Info.elixrPos.add(1299);
		Info.elixrPos.add(1353);
		Info.elixrPos.add(1405);
		Info.elixrPos.add(1460);
		Info.elixrPos.add(1519);
		Info.elixrPos.add(1570);
		Info.elixrPos.add(1624);
		
		
		Info.averageColor.add(145); // spear gob W
		Info.averageColor.add(118); //mortar W 
		Info.averageColor.add(192);//arrow
		Info.averageColor.add(91);//musk
		Info.averageColor.add(156);//mk W
		Info.averageColor.add(49);//id
		Info.averageColor.add(190);//valk
		Info.averageColor.add(204);//bats W
		Info.averageColor.add(115);//X Bow W
		Info.name.add("Spear gob");
		Info.name.add("Mortar");
		Info.name.add("Arrow");
		Info.name.add("Musk");
		Info.name.add("Mega Knight");
		Info.name.add("Inferno Dragon");
		Info.name.add("Valk");
		Info.name.add("Bats");
		Info.name.add("X Bow");
		currentDeck.add(null);
		currentDeck.add(null);
		currentDeck.add(null);
		currentDeck.add(null);
		xValue.add(1118);
		xValue.add(1263);
		xValue.add(1408);
		xValue.add(1553);
	}
}
