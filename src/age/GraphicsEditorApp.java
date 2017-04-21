package age;

import java.awt.*;
import javax.swing.*;

/**
 * Ties the Graphics Editor together
 * Similar to a test class
 * @author Arshana Jain
 * @version October 24, 2016
 */
public class GraphicsEditorApp {
	/**
	 * Creates a visual representation of the DrawingBoard
	 * @param args command-line arguments
	 */
	public static void main(String[] args){
		//setup JFrame
		JFrame frame = new JFrame("GraphicsEditorApp");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//create DrawingBoard and add Shapes
		DrawingBoard board = new DrawingBoard();
		board.addShape(new Circle(new Point(100, 100), 40));
		board.addShape(new Tee(new Point(200, 200), 40));
		board.addShape(new Delta(new Point(300, 300), 40));
		
		//setup DrawingBoardController
		DrawingBoardController controller = new DrawingBoardController(board);
		frame.getContentPane().add(controller);
		
		frame.pack();
		frame.setVisible(true);
	}
}