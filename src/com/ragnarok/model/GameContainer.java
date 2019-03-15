package com.ragnarok.model;

import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class GameContainer extends JPanel{

	private static final long serialVersionUID = -4568841046563810604L;
	
	private int gameSpeed;
	private int minGameSpeed;

	public GameContainer(int windowWidth, int windowHeight, int gameSpeed, int minGameSpeed) {
		this.setWindowWidth(windowWidth);
		this.setWindowHeight(windowHeight);
		this.gameSpeed = gameSpeed;
		this.minGameSpeed = minGameSpeed;
	}
	
	public GameContainer() {
	}

	public int getWindowHeight()
	{
		return (int) this.getSize().getHeight();
	}
	
	public int getWindowWidth()
	{
		return (int) this.getSize().getWidth();
	}
	
	public void setWindowWidth(int width)
	{
		this.setSize(this.getWindowWidth(), width);
	}

	public void setWindowHeight(int height) 
	{
		this.setSize(this.getWindowWidth(), height);
	}

	public int getGameSpeed() 
	{
		return gameSpeed;
	}

	public void setGameSpeed(int gameSpeed) 
	{
		this.gameSpeed = gameSpeed;
	}

	public int getMinGameSpeed() 
	{
		return minGameSpeed;
	}

	public void setMinGameSpeed(int minGameSpeed) 
	{
		this.minGameSpeed = minGameSpeed;
	}
	
	@Override
	public abstract void paintComponents(Graphics g);

}
