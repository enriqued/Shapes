package com.motionPoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class URLButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			java.awt.Desktop.getDesktop().browse(new URI("http://www.google.com"));
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		}
		
	}

}
