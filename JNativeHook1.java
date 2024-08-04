package com.cr.main;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;



public class JNativeHook1 implements NativeKeyListener {

	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode() == NativeKeyEvent.VC_1) {
			ElixrTracker.enemyElixr-=1;
			
		}
		if (arg0.getKeyCode() == NativeKeyEvent.VC_2) {
			ElixrTracker.enemyElixr-=2;
		}
		if (arg0.getKeyCode() == NativeKeyEvent.VC_3) {
			ElixrTracker.enemyElixr-=3;
		}
		if (arg0.getKeyCode() == NativeKeyEvent.VC_4) {
			ElixrTracker.enemyElixr-=4;
		}
		if (arg0.getKeyCode() == NativeKeyEvent.VC_5) {
			ElixrTracker.enemyElixr-=5;
		}
		if (arg0.getKeyCode() == NativeKeyEvent.VC_6) {
			ElixrTracker.enemyElixr-=6;
		}
		if (arg0.getKeyCode() == NativeKeyEvent.VC_7) {
			ElixrTracker.enemyElixr-=7;
		}
		if (arg0.getKeyCode() == NativeKeyEvent.VC_8) {
			ElixrTracker.enemyElixr-=8;
		}
		if (arg0.getKeyCode() == NativeKeyEvent.VC_9) {
			ElixrTracker.enemyElixr-=9;
		}
		System.out.println(ElixrTracker.enemyElixr);
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) {
		JNativeHook1 c = new JNativeHook1();
		c.run();
	}

	public static void run() {

		GlobalScreen.addNativeKeyListener(new JNativeHook1());
		LogManager.getLogManager().reset();

		// Get the logger for "org.jnativehook" and set the level to off.
		Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
		//logger.setLevel(Level.OFF);
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			
	

			System.exit(1);
		}

	}

}
