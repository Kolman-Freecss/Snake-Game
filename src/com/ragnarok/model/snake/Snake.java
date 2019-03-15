package com.ragnarok.model.snake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.ragnarok.model.Drawable;
import com.ragnarok.model.Positions;

public class Snake implements Drawable{

	private SnakePart first;
	private SnakePart last;
	private List<SnakePart> body;
	private int speed;
	private int[] direction;
	
	/*				DEFECT VALUES				*/
	
	public Snake() 
	{
		this(0, 0);
	}
	
	public Snake(int initialPositionX, int initialPositionY) 
	{
		this(new int[]{initialPositionX, initialPositionY});
	}
	
	/*					END			 			*/
	
	public Snake(int[] initialPosition) 
	{
		this.first = new SnakePart(initialPosition, null);
		this.last = new SnakePart(initialPosition[Positions.X.getPosition()], initialPosition[Positions.Y.getPosition()] + this.first.getSize(), this.first);
		this.body = new ArrayList();
		this.speed = 30;
		this.direction[];
	}

	
	
	@Override
	public void draw(Graphics g) {
		
	}
	
	public SnakePart getFirst() {
		return first;
	}

	public void setFirst(SnakePart first) {
		this.first = first;
	}

	public SnakePart getLast() {
		return last;
	}

	public void setLast(SnakePart last) {
		this.last = last;
	}

	public List<SnakePart> getBody() {
		return body;
	}

	public void setBody(List<SnakePart> body) {
		this.body = body;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int[] getDirection() {
		return direction;
	}

	public void setDirection(int[] direction) {
		this.direction = direction;
	}

}
