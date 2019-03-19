package com.ragnarok.model.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.ragnarok.controller.utils.Vector2;
import com.ragnarok.model.Drawable;
import com.ragnarok.model.FoodPiece;

public class Snake implements Drawable{

	private SnakePart first;
	private SnakePart last;
	private List<SnakePart> body;
	private Vector2 speed;
	private Vector2 direction;
	
	/*				DEFECT VALUES				*/
	
	public Snake() 
	{
		this(500, 500);
	}
	
	public Snake(int initialPositionX, int initialPositionY) 
	{
		this(new Vector2(initialPositionX, initialPositionY));
	}
	
	/*					END			 			*/
	
	public Snake(Vector2 initialPosition) 
	{
		this.first = new SnakePart(initialPosition, null);
		this.last = new SnakePart(initialPosition.getX(), initialPosition.getY() + this.first.getSize(), this.first);
		this.body = new ArrayList<>();
		this.body.add(first);
		this.body.add(last);
		this.speed = new Vector2(0, 1);
		this.direction = new Vector2(0, -1);
	}

	public void move()
	{	
		for(int i = (body.size() - 1); i > 0; i--)
		{
			SnakePart snakePart = body.get(i);
			SnakePart previous = snakePart.getPrevious();
			snakePart.setPositionX(previous.getPositionX());
			snakePart.setPositionY(previous.getPositionY());
		}
		first.setPositionX(first.getPositionX() + first.getSize() * speed.X);
		first.setPositionY(first.getPositionY() + first.getSize() * speed.Y);
	}
	
	public void grow()
	{
		SnakePart aux = last;
		last = new SnakePart(aux.getPositionX(), aux.getPositionY(), aux);
		body.add(last);
	}
	
	public boolean collidesWithItself()
	{
		for(int i = 1; i < body.size(); i++)
		{
			SnakePart snakePart = body.get(i);
			if(first.getPosition().equals(snakePart.getPosition()))
				return true;
		}
		return false;
	}
	
	public boolean collidesWithFood(FoodPiece food)
	{
		return first.getPosition().equals(food.getPosition());
	}
	
	public boolean isOutOfScreen(int screenWidth, int screenHeight)
	{
		if(first.getPositionX() + first.getSize() > screenWidth || first.getPositionX() < 0)
			return true;
		else if(first.getPositionY() + first.getSize() > screenHeight || first.getPositionY() < 0)
			return true;
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		//Get the relative rectangle with the position X and Y and fill it with the respective color that we defined above.
		for(SnakePart part : this.body)
		{
			g.fillRect(part.getPositionX(), part.getPositionY(), part.getSize(), part.getSize());
		}
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

	public Vector2 getSpeed() {
		return speed;
	}

	public void setSpeed(Vector2 speed) {
		this.speed = speed;
	}

	public Vector2 getDirection() {
		return direction;
	}

	public void setDirection(Vector2 direction) {
		this.direction = direction;
	}
	
}
