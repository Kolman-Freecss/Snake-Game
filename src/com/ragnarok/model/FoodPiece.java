package com.ragnarok.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.ragnarok.controller.utils.Vector2;

public class FoodPiece implements Drawable{

	private Vector2 position;
	private int size;
	
	public FoodPiece(int gameContainerWidth, int gameContainerHeight) {
		
		this.size = 10;
		position = new Vector2();
		Random random = new Random();
		int randX = random.nextInt(gameContainerWidth - 1);
		int randY = random.nextInt(gameContainerHeight - 1);
		position.X = ((randX + 5) / 10) * 10;
		position.Y = ((randY + 5) / 10) * 10;
	}
	
	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	@Override
	public void draw(Graphics g) {

		g.setColor(Color.RED);
		g.fillRect(this.position.getX(), this.position.getY(), this.size, this.size);
		
	}
	
	
	
}
