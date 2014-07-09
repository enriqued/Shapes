package com.motionPoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.motionPoint.MainGame.*;

/**
 * This class is responsible for increasing the speed of the objects.
 *
 */
public class IncreaseSpeedButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Increasing speed
		c1.setSpeed(c1.getSpeed() + 1);
		c2.setSpeed(c2.getSpeed() + 1);
		r1.setSpeed(r1.getSpeed() + 1);
	}

}
