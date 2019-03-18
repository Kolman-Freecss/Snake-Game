package com.ragnarok.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.ragnarok.model.GameContainer;
import com.ragnarok.model.snake.Snake;

public class BaseGame {

	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 600;
	private static final int GAME_SPEED = 100;
	private static final int MIN_GAME_SPEED = 20;
	
	private GameContainer container;
	private static Snake snake;
	
	public BaseGame() 
	{
		init();
	}
	
	public void init()
	{
		//Snake in the position 0 0 (that's in the top left corner of the screen).
		snake = new Snake(0 , 0);
		//Init the Frame where we will add the container component in it.
		JFrame frame = new JFrame("Snake Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
		
		container = new GameContainer(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_SPEED, MIN_GAME_SPEED)
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponents(Graphics g) {
				//TODO Fill this method.
				
				snake.draw(g);
				
			}
			
		};
		
		//Assign of Key Bindings.
		frame.addKeyListener(new KeyListener() {
			@Override public void keyTyped(KeyEvent e) {/}
			@Override public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	public void gameLoop() 
	{
		
	}
	
}
