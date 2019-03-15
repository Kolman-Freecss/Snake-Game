package com.ragnarok.model;

public enum Positions {

	X (0),
	Y (1);
	
	public static final int MAX_POSITIONS = 2;
	private int position;
	
	Positions(int position) {
		this.position = position;
	}
	
	public int getPosition() 
	{
		return this.position;
	}
	
}
