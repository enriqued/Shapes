package com.motionPoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.motionPoint.MainGame.*;

/**
 * This class is responsible for decreasing the speed of the shape objects. 
 *
 */
public class DecreaseSpeedButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Decreasing speed
		c1.setSpeed(c1.getSpeed() - 1);
		c2.setSpeed(c2.getSpeed() -1);
		r1.setSpeed(r1.getSpeed() -1);
		
	}

}
