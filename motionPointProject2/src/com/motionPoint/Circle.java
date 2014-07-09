package com.motionPoint;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class is used to create circle objects
 *
 */
public class Circle {
	
	private int centerX, centerY, radius, speed, direction;
	private Color color;
	
	/**
	 * This constructor takes 4 parameters.
	 * x and y specify the position of the circle and r stands for radius.
	 * @param x
	 * @param y
	 * @param r
	 * @param color
	 */
	public Circle(int x, int y, int r, Color color){
		centerX = x;
		centerY = y;
		radius = r;
		this.color = color;
	}
	
	/**
	 * Call this to draw a circle.
	 */
	public void draw(Graphics g){
		Color oldColor = g.getColor();//By creating this variable, we can go back to the original color after we set a color for the circle
		g.setColor(color);
		g.drawOval(centerX - radius, centerY - radius, radius *2, radius * 2);
		g.setColor(oldColor);
	}
	
	/**
	 * Call this to fill a circle
	 */
	public void fill(Graphics g){
		Color oldColor = g.getColor();
		g.setColor(color);
		g.fillOval(centerX - radius, centerY - radius, radius * 2, radius *2);
		g.setColor(oldColor);
	}
	
	public int getX(){
		return centerX;
	}
	
	/**
	 * This method is unique to the circle class
	 */
	public int getRadius(){
		return radius;
	}
	/**
	 * call this to see if a point is inside a circle.
	 * If it returns true, it means that the point is inside the circle.
	 */
	public boolean containsPoint(int x, int y){
		
		int xSquared = (x - centerX) * (x - centerX);
		int ySquared = (y - centerY) * (y - centerY);
		int rSquared = radius * radius;
		return xSquared + ySquared - rSquared <= 0;
	}
	
	
	public void setSpeed(int s){
		speed = s;
	}
	
	public void setDirection(int degrees){
		direction = degrees % 360;//Using the modulus operator to determine the direction of the circle
	}
	
	public void turn(int degrees){
		direction = (direction + degrees) % 360;
	}
	
	
	/**
	 * This method is going to use the move method with 2 parameters(x,y).
	 */
	public void move(){
		move((int)(speed * Math.cos(Math.toRadians(direction))), 
				(int)(speed * Math.sin(Math.toRadians(direction))));
	}

	public void move(int x, int y) {
		centerX += x;
		centerY += y;
		
	}
	
	public int getSpeed(){
		return speed;
	}

	public int getY() {
		return centerY;
	}

}
