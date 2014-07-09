package com.motionPoint;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static com.motionPoint.MainGame.*;

/**
 * This class is responsible for adding mouse functionality to the main game.
 * Extends MouseAdapter.
 *
 */
public class PanelListener extends MouseAdapter{
	
	public void mousePressed(MouseEvent event){
		
		x= event.getX();
		y = event.getY();
		
		if(c1.containsPoint(x,y))
			selectedCircle = c1;
		else if (c2.containsPoint(x,y))
			selectedCircle = c2;
	}
	
	public void mouseReleased(MouseEvent event){
		
		//Deselect the selected circle
		selectedCircle = null;
	}
}
