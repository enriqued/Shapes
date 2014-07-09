package com.motionPoint;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

/**
 * This is the main class of my desktop app.
 * This app displays different shapes moving up and down and side to side. You can increase or decrease the speed of the shapes by clicking buttons.
 * The user can also drag a circle to another position.
 * @author Enrique Delgado
 * @version 1.2
 * 
 */
public class MainGame extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	static JFrame frame;
	
	//Frame dimensions
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	
	private static JButton startButton;
	private static JButton stopButton;
	private static JButton decreaseSpeedButton;
	private static JButton increaseSpeedButton;
	private static JButton url;
	private static JButton test;
	
	protected static Circle c1, c2, selectedCircle;
	
	protected static Rectangle r1, selectedRectangle;
	
	protected  static int x,y, dx, dy;//Used to track mouse coordinates
	private Point p1, p2, p3;
	protected  static Timer timer;
	static MainGame game;
	static JPanel south;
	
	public static void main(String[] args){
		
		createFrame();
		createButtons();
		
		//Initializing the game
		game = new MainGame(Color.WHITE);
		
		//creating the south panel
		south = new JPanel(new FlowLayout());
		
		addActionListeners();
		addButtons();
				
		//Adding both panels to the frame
		frame.add(game, BorderLayout.CENTER);
		frame.add(south, BorderLayout.SOUTH);
		
	}
	
	/**
	 * This is the constructor of the MainGame.
	 * @param backColor
	 */
	public MainGame(Color backColor){
		
		setBackground(backColor);
		
		//Setting some random positions
		p1 = new Point(200,100);
		p2 = new Point(100,100);
		p3 = new Point(300,100);
		
		//If the point coordinates are bigger than the JFrame throw an exception.
		if(p1.x > WIDTH || p1.y > HEIGHT) throw new IllegalArgumentException("The point coordinates cannot be bigger than the frame.");
		
		if(p2.x > WIDTH || p2.y > HEIGHT) throw new IllegalArgumentException("The point coordinates cannot be bigger than the frame.");
		
		if(p3.x > WIDTH || p3.y > HEIGHT) throw new IllegalArgumentException("The point coordinates cannot be bigger than the frame.");
		
		//Instantiating two circles using the Point and Color classes.
		c1 = new Circle(p1.x,p1.y,25,Color.RED);
		c2 = new Circle(p2.x,p2.y,50,Color.BLUE);
		
		//Instantiating one rectangle using the Point and Color classes.
		r1 = new Rectangle(p3.x, p3.y, 25, 50, Color.YELLOW);
		
		//Setting speed of the first circle.
		c1.setSpeed(2);
		
		//Setting speed and direction of the second circle.
		c2.setSpeed(1);
		c2.setDirection(90);
		
		//Setting the speed and direction of the first rectangle.
		r1.setSpeed(3);
		r1.setDirection(90);
		
		//the letter "d" stands for displacement. These two Integer would determine how fast the circles would move
		dx = 5;
		dy = 5;
		
		selectedCircle = null;
		selectedRectangle = null;
		
		//Initializing listener
		PanelListener pl = new PanelListener();
		PanelMotionListener pml = new PanelMotionListener();
		
		//Adding listeners to the panel directly
		addMouseListener(pl);
		addMouseMotionListener(pml);
		repaint();
		
		//Instantiating a timer
		timer = new Timer(30,this);//We can pass "this" because the MainGame class implements ActionListener
		timer.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);//We need to call the super constructor first in order to work.
		
		//Drawing different shapes.
		c1.fill(g);
		c2.draw(g);
		r1.fill(g);
	}
	
	/**
	 * This method creates the JFrame for the game and also adds a little logo on the top left corner.
	 */
	public static void createFrame(){
		
		//Creating a little red square used as a logo on the top left of the frame
		BufferedImage image = new BufferedImage(50,50,BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();
		
		g.setColor(Color.RED);
		g.fillRect(0, 0, 25, 25);
		
		frame = new JFrame("Game");
		frame.setIconImage(image);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());//Setting up the frame layout.
		
		//Setting size and visibility of the frame
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
	}
	
	/**
	 * This method creates four buttons to interact with the shapes.
	 */
	public static void createButtons(){
		
		//Creating buttons
		increaseSpeedButton = new JButton("IncreaseSpeed");
		stopButton = new JButton("Stop");
		startButton = new JButton("Start");
		decreaseSpeedButton = new JButton("DecreaseSpeed");
		url = new JButton("go to URL");
	}
	
	/**
	 * This method add the buttons to the south panel.
	 */
	public static void addButtons(){
		
		//Adding the buttons the the south panel
		south.add(stopButton);
		south.add(startButton);
		south.add(increaseSpeedButton);
		south.add(decreaseSpeedButton);
		south.add(url);
	}
	
	/**
	 * This method initializes four listeners and add them to the buttons.
	 * Stop, start, increase and decrease.
	 */
	public static void addActionListeners(){
		
		//Initializing listeners
		StopButtonListener stop = new StopButtonListener();
		StartButtonListener start = new StartButtonListener();
		IncreaseSpeedButtonListener increase = new IncreaseSpeedButtonListener();
		DecreaseSpeedButtonListener decrease = new DecreaseSpeedButtonListener();
		URLButtonListener link = new URLButtonListener();
		
		//Adding functionality to the buttons via actionListeners
		increaseSpeedButton.addActionListener(increase);
		decreaseSpeedButton.addActionListener(decrease);
		stopButton.addActionListener(stop);
		startButton.addActionListener(start);
		url.addActionListener(link);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		c1.move();
		c2.move();
		r1.move();
		
		int x = c1.getX();
		int y = c2.getY();
		
		int rectY = r1.getY();
		
		int radius = c1.getRadius();
		int radius2 = c2.getRadius();
		int width = getWidth();
		int height = getHeight();
		
		//This conditional construct will keep the shapes inside the JFrame, making them turn every time they reach a border of the JFrame. 
		if(x - radius <= 0 || x + radius >= width)
			c1.turn(180);
		
		if(y - radius2 <= 0 || y + radius2 >= height)
			c2.turn(180);
		
		if(rectY + r1.getHeight()  <= 50 || rectY + r1.getHeight() >= height)
			r1.turn(180);
		
		//We need to repaint for the changes to take effect.
		repaint();

	}
	
	/**
	 * Returns point 1
	 * @return point 1
	 */
	public Point getP1(){
		return p1;
	}
	
	/**
	 * Returns point 2
	 * @return point 2
	 */
	public Point getP2(){
		return p2;
	}
	
	/**
	 * Returns point 3
	 * @return point 3
	 */
	public Point getP3(){
		return p3;
	}
	
}


