package age;

import java.awt.Color;
import java.awt.event.*;

/**
 * Listener for JButtons in DrawingView
 * @author Arshana Jain
 * @version October 24, 2016
 */
public class DrawingButtonListener implements ActionListener{
	private DrawingBoardController controller;
	private DrawingBoard board;
	
	/**
	 * Creates a DrawingButtonListener
	 * @param controller DrawingBoardController this is connected to
	 */
	public DrawingButtonListener(DrawingBoardController controller, DrawingBoard board){
		this.controller = controller;
		this.board = board;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		//shapeButtons
		if(e.getActionCommand().equals("Circle")){
			controller.setCurrentAction("circle");
		}
		else if(e.getActionCommand().equals("Tee")){
			controller.setCurrentAction("tee");
		}
		else if(e.getActionCommand().equals("Delta")){
			controller.setCurrentAction("delta");
		}
		else if(e.getActionCommand().equals("Remove")){
			if(board.getReference() != null){
				board.removeShape();
			}
		}
		//colorButtons
		else if(e.getActionCommand().equals("Blue")){
			controller.setCurrentColor(Color.BLUE);
		}
		else if(e.getActionCommand().equals("Cyan")){
			controller.setCurrentColor(Color.CYAN);
		}
		else if(e.getActionCommand().equals("Gray")){
			controller.setCurrentColor(Color.LIGHT_GRAY);
		}
		else if(e.getActionCommand().equals("Green")){
			controller.setCurrentColor(Color.GREEN);
		}
		else if(e.getActionCommand().equals("Magenta")){
			controller.setCurrentColor(Color.MAGENTA);
		}
		else if(e.getActionCommand().equals("Orange")){
			controller.setCurrentColor(Color.ORANGE);
		}
		else if(e.getActionCommand().equals("Pink")){
			controller.setCurrentColor(Color.PINK);
		}
		else if(e.getActionCommand().equals("Yellow")){
			controller.setCurrentColor(Color.YELLOW);
		}
		//sizeButtons
		else if(e.getActionCommand().equals("Small")){
			controller.setCurrentSize(40);
		}
		else if(e.getActionCommand().equals("Medium")){
			controller.setCurrentSize(80);
		}
		else if(e.getActionCommand().equals("Large")){
			controller.setCurrentSize(120);
		}
	}
}
