package com.ragnarok.controller;

import java.awt.Graphics;

import com.ragnarok.model.GameContainer;
import com.ragnarok.model.snake.Snake;

public class BaseGame {

	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 600;
	private static final int GAME_SPEED = 100;
	private static final int MIN_GAME_SPEED = 20;
	
	private GameContainer container;
	private Snake snake;
	
	public BaseGame() 
	{
		container = new GameContainer(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_SPEED, MIN_GAME_SPEED)
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponents(Graphics g) {
				//TODO Fill this method.
			}
			
		};
		
		
		
	}
	
	public void gameLoop() 
	{
		
	}
	
}
