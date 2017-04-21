package age;

import java.awt.*;

import javax.swing.*;

/**
 * View with description of DrawingBoard
 * @author Arshana Jain
 * @version October 24, 2016
 */
public class DescriptionView extends JTextArea implements DrawingBoardView{
	private DrawingBoard board;
	
	/**
	 * Create a DescriptionView
	 * @param board DrawingBoard this views
	 */
	public DescriptionView(DrawingBoard board){
		this.board = board;
	}

	@Override
	public void notifyView() {
		setText("Number of Shapes: " + board.getCopy().size() + "\nSelected Shape: " + board.getReference());
	}	
}