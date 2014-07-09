package com.motionPoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.motionPoint.MainGame.*;

/**
 * This class stops the timer instantiated in the MainGame class.
 *
 */
public class StopButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		timer.stop();
		
	}

}
