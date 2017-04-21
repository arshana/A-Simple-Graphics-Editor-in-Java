package age;

import java.awt.*;
import java.util.*;

import javax.swing.*;

/**
 * View of the GUI
 * @author Arshana Jain
 * @version October 24, 2016
 */
public class DrawingView extends JPanel implements DrawingBoardView {
	private DrawingBoard board;
	
	/**
	 * Creates a DrawingView
	 * @param board DrawingBoard this views
	 */
	public DrawingView(DrawingBoard board){
		super();
		this.setPreferredSize(new Dimension(640, 480));
		this.board = board;
	}

	@Override
	public void notifyView() {
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		ArrayList<Shape> shapes = (ArrayList<Shape>) board.getCopy();
		Iterator<Shape> itr = shapes.iterator();
		while(itr.hasNext()){
			Shape currShape = itr.next();
			currShape.drawShape(g);
		}
		if(board.getReference() != null){
			board.getReference().drawBorder(g);
		}
	}
}