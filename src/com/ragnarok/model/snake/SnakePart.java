package com.ragnarok.model.snake;

import com.ragnarok.model.Positions;

public class SnakePart {

	private int size;
	private int[] position;
	private SnakePart previous;
	
	public SnakePart(int[] position, SnakePart previous) 
	{
		this.position = position;
		this.previous = previous;
	}
	
	public SnakePart(int positionX, int positionY, SnakePart previous)
	{
		this.size = 10;
		this.position = new int[Positions.MAX_POSITIONS];
		this.position[Positions.X.getPosition()] = positionX;
		this.position[Positions.Y.getPosition()] = positionY;
		this.previous = previous;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int getPositionX() {
		return this.position[Positions.X.getPosition()];
	}
	
	public void setPositionX(int x) 
	{
		this.position[Positions.X.getPosition()] = x; 
	}
	
	public int getPositionY() {
		return this.position[Positions.Y.getPosition()];
	}
	
	public void setPositionY(int y) 
	{
		this.position[Positions.Y.getPosition()] = y; 
	}

	public int[] getPosition() {
		return position;
	}

	public void setPosition(int[] position) {
		this.position = position;
	}

	public SnakePart getPrevious() {
		return previous;
	}

	public void setPrevious(SnakePart previous) {
		this.previous = previous;
	}

}
