package age;

import java.awt.Point;
import java.awt.event.*;

/**
 * Listener for Mouse in DrawingView
 * @author Arshana Jain
 * @version October 24, 2016
 */
public class DrawingMouseListener implements MouseListener, MouseMotionListener{
	private DrawingBoard board;
	private DrawingBoardController controller;
	
	//starting point of mouse when dragged
	private Point startPoint;
	//ending point of mouse when dragged
	private Point endPoint;
	
	/**
	 * Creates a DrawingMouseListener
	 * @param board DrawingBoard this listens to
	 * @param controller DrawingBoardController this is connected to
	 */
	public DrawingMouseListener(DrawingBoard board, DrawingBoardController controller){
		this.board = board;
		this.controller = controller;
		startPoint = null;
		endPoint = null;
	}

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mousePressed(MouseEvent e) {
		startPoint = e.getPoint();
		endPoint = startPoint;
		if(controller.getCurrentAction() == null){
			board.coordinateOn((int)startPoint.getX(), (int)startPoint.getY());
		}
		else{ 
			//shape
			if(controller.getCurrentAction().equals("circle")){
				startPoint.setLocation(startPoint.getX(), startPoint.getY());
				board.addShape(new Circle(startPoint, controller.getCurrentSize()));
				controller.setCurrentAction(null);
				controller.setCurrentSize(40);
			}
			else if(controller.getCurrentAction().equals("tee")){
				startPoint.setLocation(startPoint.getX(), startPoint.getY());
				board.addShape(new Tee(startPoint, controller.getCurrentSize()));
				controller.setCurrentAction(null);
				controller.setCurrentSize(40);
			}
			else if(controller.getCurrentAction().equals("delta")){
				startPoint.setLocation(startPoint.getX(), startPoint.getY());
				board.addShape(new Delta(startPoint, controller.getCurrentSize()));
				controller.setCurrentAction(null);
				controller.setCurrentSize(40);
			}
			//color
			if(controller.getCurrentColor() != null){
				board.getReference().setColor(controller.getCurrentColor());
				controller.setCurrentColor(null);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		startPoint = null;
		endPoint = null;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(board.getReference() != null){
			endPoint = e.getPoint();
			board.moveShape((int)(endPoint.getX() - startPoint.getX()), (int)(endPoint.getY() - startPoint.getY()));
			startPoint = endPoint;
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {	}
	@Override
	public void mouseMoved(MouseEvent e) {}
}