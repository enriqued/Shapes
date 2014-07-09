package com.motionPoint;

import java.awt.Graphics;

/**
 * By creating this interface we can create other shapes like rectangles or triangles using these methods.
 * This interface is used for all shapes.
 */
public interface Shape {
	
	public void move(int x, int y);
	public void move();
	public void draw(Graphics g);
	public void fill(Graphics g);
	public int getX();
	public int getY();
	public void setDirection(int degrees);
	public void setSpeed(int s);
	public void turn(int degrees);
	public int getSpeed();
}
