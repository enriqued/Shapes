package com.motionPoint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import static com.motionPoint.MainGame.*;


/**
 * This class is responsible for adding mouse functionality(mouseDragged) to the main game.
 * Extends MouseMotionAdapter.
 *
 */
public class PanelMotionListener extends MouseMotionAdapter{
	
	public void mouseDragged(MouseEvent event){
		
		//If the mouse is pressing one of the circles.
		if(selectedCircle != null){
			
			//Compute the distance and move the selected shape
			int newX = event.getX();
			int newY = event.getY();
			
			int dx = newX - x;
			int dy = newY - y;
			
			selectedCircle.move(dx, dy);
			x = newX;
			y = newY;
		}
			
	}
}
