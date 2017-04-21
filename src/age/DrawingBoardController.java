package age;

import java.awt.*;

import javax.swing.*;

/**
 * Controller for the Views
 * Mostly focused on DrawingView
 * @author Arshana Jain
 * @version October 24, 2016
 */
public class DrawingBoardController extends JPanel {
	private DrawingBoard board;
	//holds whether a Shape is about to be created
	private String currentAction;
	private JPanel colorButtons;
	private Color currentColor;
	private JPanel sizeButtons;
	private int currentSize;
	
	/**
	 * Creates a DrawingBoardController
	 * @param board DrawingBoard this controls
	 */
	public DrawingBoardController(DrawingBoard board){
		//changes layout manager to BorderLayout
		super(new BorderLayout());
		
		this.board = board;
		currentAction = null;
		currentColor = null;
		currentSize = 40;
		
		//create viewers
		DescriptionView descripView = new DescriptionView(board);
		DrawingView drawView = new DrawingView(board);
		
		this.add(descripView, BorderLayout.NORTH);
		this.add(drawView, BorderLayout.CENTER);
		
		//add Viewers
		board.addViewer(descripView);
		board.addViewer(drawView);
		
		//sets up DrawingMouseListener
		DrawingMouseListener mouseListener = new DrawingMouseListener(board, this);
		drawView.addMouseListener(mouseListener);
		drawView.addMouseMotionListener(mouseListener);
		
		//sets up shapeButtons JPanel
		JPanel shapeButtons = new JPanel();
		shapeButtons.setPreferredSize(new Dimension(95, 100));
		JButton circleButton = new JButton("Circle");
		JButton teeButton = new JButton("Tee");
		JButton deltaButton = new JButton("Delta");
		JButton removeButton = new JButton("Remove");
		shapeButtons.add(deltaButton);
		shapeButtons.add(teeButton);
		shapeButtons.add(circleButton);
		shapeButtons.add(removeButton);
		this.add(shapeButtons, BorderLayout.WEST);
		
		//sets up colorButtons JPanel
		colorButtons = new JPanel();
		JButton blueButton = new JButton("Blue");
		blueButton.setBackground(Color.BLUE);
		JButton cyanButton = new JButton("Cyan");
		cyanButton.setBackground(Color.CYAN);
		JButton grayButton = new JButton("Gray");
		grayButton.setBackground(Color.LIGHT_GRAY);
		JButton greenButton = new JButton("Green");
		greenButton.setBackground(Color.GREEN);
		JButton magentaButton = new JButton("Magenta");
		magentaButton.setBackground(Color.MAGENTA);
		JButton orangeButton = new JButton("Orange");
		orangeButton.setBackground(Color.ORANGE);
		JButton pinkButton = new JButton("Pink");
		pinkButton.setBackground(Color.PINK);
		JButton redButton = new JButton("Red");
		redButton.setBackground(Color.RED);
		JButton yellowButton = new JButton("Yellow");
		yellowButton.setBackground(Color.YELLOW);
		colorButtons.add(blueButton);
		colorButtons.add(cyanButton);
		colorButtons.add(grayButton);
		colorButtons.add(greenButton);
		colorButtons.add(magentaButton);
		colorButtons.add(orangeButton);
		colorButtons.add(pinkButton);
		colorButtons.add(yellowButton);
		this.add(colorButtons, BorderLayout.SOUTH);
		colorButtons.setVisible(false);
		
		//sets up sizeButtons JPanel
		sizeButtons = new JPanel();
		sizeButtons.setPreferredSize(new Dimension(95, 100));
		JButton smallButton = new JButton("Small");
		JButton mediumButton = new JButton("Medium");
		JButton largeButton = new JButton("Large");
		sizeButtons.add(smallButton);
		sizeButtons.add(mediumButton);
		sizeButtons.add(largeButton);
		this.add(sizeButtons, BorderLayout.EAST);
		sizeButtons.setVisible(false);
		
		//sets up DrawingButtonListener
		DrawingButtonListener buttonListener = new DrawingButtonListener(this, board);
		circleButton.addActionListener(buttonListener);
		teeButton.addActionListener(buttonListener);
		deltaButton.addActionListener(buttonListener);
		removeButton.addActionListener(buttonListener);
		blueButton.addActionListener(buttonListener);
		cyanButton.addActionListener(buttonListener);
		grayButton.addActionListener(buttonListener);
		greenButton.addActionListener(buttonListener);
		magentaButton.addActionListener(buttonListener);
		orangeButton.addActionListener(buttonListener);
		pinkButton.addActionListener(buttonListener);
		yellowButton.addActionListener(buttonListener);
		smallButton.addActionListener(buttonListener);
		mediumButton.addActionListener(buttonListener);
		largeButton.addActionListener(buttonListener);
	}
	
	/**
	 * Sets what, if any, shapeButton is currently pressed
	 * @param action shapeButton's keyword
	 */
	public void setCurrentAction(String action){
		currentAction = action;
		if(currentAction != null){
			colorButtons.setVisible(true);
		}
		else{
			colorButtons.setVisible(false);
		}
	}
	
	/**
	 * Returns shapeButton's keyword
	 * @return shapeButton's keyword
	 */
	public String getCurrentAction(){
		return currentAction;
	}
	
	/**
	 * Sets what, if any, colorButton is currently pressed
	 * @param color color to make new Shape
	 */
	public void setCurrentColor(Color color){
		currentColor = color;
		colorButtons.setVisible(false);
		if(currentColor != null){
			sizeButtons.setVisible(true);
		}
		else{
			sizeButtons.setVisible(false);
		}
	}
	
	/**
	 * Returns selected color
	 * @return selected color
	 */
	public Color getCurrentColor(){
		return currentColor;
	}
	
	/**
	 * Sets what, if any, sizeButton is currently pressed
	 * @param size size to make new Shape
	 */
	public void setCurrentSize(int size){
		currentSize = size;
		sizeButtons.setVisible(false);
	}
	
	/**
	 * Returns selected size
	 * @return selected size
	 */
	public int getCurrentSize(){
		return currentSize;
	}
}