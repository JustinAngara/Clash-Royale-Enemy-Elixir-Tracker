package com.cr.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import com.val.main.JNativeHook;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ElixrTracker {

	private JFrame frame;
	static int enemyElixr=6;
	static Timer t;
	static int delay;
	static int j1 =0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElixrTracker window = new ElixrTracker();
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
	public ElixrTracker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JNativeHook1 j = new JNativeHook1();
		j.run();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("~Enemy Elixr: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(0, 51, 231, 48);
		frame.getContentPane().add(lblNewLabel);
		delay = 2800;
	
		t = new Timer(1,(ActionEvent e)->{
			
			lblNewLabel.setText("elixr: "+enemyElixr);
			

			if(j1<delay/2) {
				j1++;
			} else {
				j1=0;
				if(enemyElixr<10) {
					enemyElixr+=1;
				}
			}
			
		});
		
		t.start();
	}
	
	
}
