package com.ragnarok.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.ragnarok.controller.utils.Vector2;
import com.ragnarok.model.FoodPiece;
import com.ragnarok.model.GameContainer;
import com.ragnarok.model.snake.Snake;

public class BaseGame {

	private static final int WINDOW_WIDTH = 800;
	private static final int WINDOW_HEIGHT = 600;
	private static int GAME_SPEED = 100;
	private static int MIN_GAME_SPEED = 20;
	
	private static GameContainer container;
	private static Snake snake;
	private static FoodPiece foodPiece;
	private JFrame frame;
	
	public BaseGame() 
	{
		init();
	}
	
	public void init()
	{
		//Snake in the position 0 0 (that's in the top left corner of the screen).
		snake = new Snake(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2);
		//Init the Frame where we will add the container component in it.
		frame = new JFrame("Snake Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
		
		container = new GameContainer(WINDOW_WIDTH, WINDOW_HEIGHT, GAME_SPEED, MIN_GAME_SPEED)
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				//TODO Fix it.
				snake.draw(g);
				if(foodPiece != null) foodPiece.draw(g);
			}
			
		};
		
		//Assign of Key Bindings.
		frame.addKeyListener(new KeyListener() {
			@Override public void keyTyped(KeyEvent e) {}
			@Override public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				int keyCode = e.getKeyCode();
			    switch( keyCode ) 
			    { 
			        case KeyEvent.VK_UP:
			        	if( ! snake.getSpeed().equals(new Vector2(0, 1)))
			        		snake.setSpeed(new Vector2(0, -1));
			            break;
			        case KeyEvent.VK_DOWN:
			        	if( ! snake.getSpeed().equals(new Vector2(0, -1)))
			        		snake.setSpeed(new Vector2(0, 1));
			            break;
			        case KeyEvent.VK_LEFT:
			        	if( ! snake.getSpeed().equals(new Vector2(1, 0)))
			        		snake.setSpeed(new Vector2(-1, 0));
			            break;
			        case KeyEvent.VK_RIGHT :
			        	if( ! snake.getSpeed().equals(new Vector2(-1, 0)))
			        		snake.setSpeed(new Vector2(1, 0));
			            break;
			        default:
			        	break;
			     }
				
			}
		});
		frame.add(container);
		frame.setSize(container.getWindowWidth(), container.getWindowWidth());
		frame.setVisible(true);
		foodPiece = new FoodPiece((int)container.getSize().getWidth(), (int)container.getSize().getHeight());
	}
	
	public void gameLoop() 
	{
		while (true)
		{
			if(snake.collidesWithFood(foodPiece))
			{
				foodPiece = new FoodPiece((int)container.getSize().getWidth(), (int)container.getSize().getHeight());
				snake.grow();
				GAME_SPEED = GAME_SPEED > MIN_GAME_SPEED ? GAME_SPEED - 1 : GAME_SPEED;
			}
			snake.move();
			this.frame.repaint();
			if(snake.collidesWithItself() || snake.isOutOfScreen((int)container.getSize().getWidth(), (int)container.getSize().getHeight()))
				break;
			try {
				Thread.sleep(GAME_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
