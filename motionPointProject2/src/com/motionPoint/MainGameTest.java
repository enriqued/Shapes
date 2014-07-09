package com.motionPoint;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;

public class MainGameTest {
	
	MainGame game;
	
	/**
	 * This method will be called before each test because we are using the @before annotation.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception{
		
		game = new MainGame(Color.WHITE);
	}
	
	/**
	 * Call this method to test point coordinates.
	 */
	@Test
	public void testPointCoordinates() {
		
		int x = game.getWidth();
		int y = game.getHeight();
		
		//Testing for point 1
		assert(game.getP1().x < x);
		assert(game.getP1().y < y);
		
		//Testing for point 2
		assert(game.getP2().x < x);
		assert(game.getP2().y < y);
		
		//testing for point 3
		assert(game.getP3().x < x);
		assert(game.getP3().y < y);
		
	}

}
