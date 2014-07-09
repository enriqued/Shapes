package com.motionPoint;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class is used to create rectangle objects
 *
 */
public class Rectangle implements Shape {
	
	private int x, y, width, height, speed, direction;
	private Color color;
	
	/**
	 * Rectangle constructor
	 * @param x initial position on the x-axis
	 * @param y initial position on the y-axis
	 * @param width
	 * @param height
	 * @param color
	 */
	public Rectangle(int x, int y, int width, int height, Color color){
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	@Override
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public void move(){
		move((int)(speed * Math.cos(Math.toRadians(direction))), 
				(int)(speed * Math.sin(Math.toRadians(direction))));
	}

	@Override
	public void draw(Graphics g) {
		
		Color oldColor = g.getColor();//By creating this variable, we can go back to the original color after we set a color for the rectangle.
		g.setColor(color);
		g.drawRect(x, y, width, height);
		g.setColor(oldColor);
	}

	@Override
	public void fill(Graphics g) {
		
		Color oldColor = g.getColor();
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(oldColor);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	public int getHeight(){
		return height;
	}

	@Override
	public void setDirection(int degrees) {
		direction = degrees % 360;//Using the modulus operator to determine the direction of the rectangle
	}

	@Override
	public void setSpeed(int s) {
		speed = s;
	}

	@Override
	public void turn(int degrees) {
		direction = (direction + degrees) % 360;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

}
