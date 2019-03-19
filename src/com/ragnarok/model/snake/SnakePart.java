package com.ragnarok.model.snake;

import com.ragnarok.controller.utils.Vector2;

public class SnakePart {

	private int size;
	private Vector2 position;
	private SnakePart previous;
	
	public SnakePart(Vector2 position, SnakePart previous) 
	{
		this.size = 10;
		this.position = position;
		this.previous = previous;
	}
	
	public SnakePart(int positionX, int positionY, SnakePart previous)
	{
		this.size = 10;
		this.position = new Vector2(positionX, positionY);
		this.previous = previous;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int getPositionX() {
		return this.position.getX();
	}
	
	public void setPositionX(int x) 
	{
		this.position.setX(x); 
	}
	
	public int getPositionY() {
		return this.position.getY();
	}
	
	public void setPositionY(int y) 
	{
		this.position.setY(y); 
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public SnakePart getPrevious() {
		return previous;
	}

	public void setPrevious(SnakePart previous) {
		this.previous = previous;
	}

}
