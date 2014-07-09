package com.motionPoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  static com.motionPoint.MainGame.*;

/**
 * This class starts the timer instantiated in the MainGame class.
 *
 */
public class StartButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		timer.start();
		
	}

}
