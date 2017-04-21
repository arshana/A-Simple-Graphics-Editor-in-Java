package age;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Represents a drawing board
 * @author Arshana Jain
 * @version October 24, 2016
 */
public class DrawingBoard {
	//list of Shapes
	private ArrayList<Shape> shapeList;
	private ArrayList<DrawingBoardView> viewers;
	
	/**
	 * Create a DrawingBoard
	 */
	public DrawingBoard(){
		shapeList = new ArrayList<Shape>();
		viewers = new ArrayList<DrawingBoardView>();
	}
	
	/**
	 * Adds a viewer
	 * @param view viewer to add
	 */
	public void addViewer(DrawingBoardView view){
		if(view != null){
			viewers.add(view);  
			view.notifyView();
		}
	}
	
	/**
	 * Notifies all viewers that they need to "refresh"
	 */
	public void notifyAllViewers(){
		Iterator<DrawingBoardView> itr = viewers.iterator();
		while(itr.hasNext()){
			DrawingBoardView view = itr.next();
			view.notifyView();
		}
	}
	
	/**
	 * Adds a Shape to DrawingBoard
	 * @param newShape Shape to add
	 */
	public void addShape(Shape newShape){
		deselectShape();
		shapeList.add(newShape);
		shapeList.get(shapeList.size() - 1).setSelected(true);
		notifyAllViewers();
	}
	
	/**
	 * Checks if a Shape is selected
	 * @return true if a Shape is selected
	 */
	private boolean isShapeSel(){
		if(shapeList.size() == 0){
			return false;
		}
		return shapeList.get(shapeList.size() - 1).isSelected();
	}
	
	/**
	 * Deselects a Shape if it is selected
	 */
	private void deselectShape(){
		if(isShapeSel()){
			shapeList.get(shapeList.size() - 1).setSelected(false);
		}
	}
	
	/**
	 * Checks which Shape, if any, the given point is on in DrawingBoard
	 * @param x x-coordinate to check
	 * @param y y-coordinate to check
	 */
	public void coordinateOn(int x, int y){
		deselectShape();
		boolean found = false;
		int counter = shapeList.size() - 1;
		while(counter >= 0 && !found){
			if(shapeList.get(counter).isOn(x, y)){
				found = true;
				shapeList.add(shapeList.get(counter));
				shapeList.remove(counter);
				shapeList.get(shapeList.size() - 1).setSelected(found);
			}
			counter--;
		}
		notifyAllViewers();
	}
	
	/**
	 * Returns a reference to the selected Shape
	 * @return reference to selected Shape
	 */
	public Shape getReference(){
		if(shapeList.size() > 0 && isShapeSel()){
				return shapeList.get(shapeList.size() - 1);
		}
		return null;
	}
	
	/**
	 * Removes selected Shape
	 * @throws IllegalStateException if no Shape is selected
	 */
	public void removeShape(){
		if(!isShapeSel()){
			throw new IllegalStateException("No shape selected.");
		}
		shapeList.remove(shapeList.get(shapeList.size() - 1));
		if(shapeList.size() > 0){
			shapeList.get(shapeList.size() - 1).setSelected(true);
		}
		notifyAllViewers();
	}
	
	/**
	 * Sets color of selected Shape
	 * @param color what to set Shape's color to
	 * @throws IllegalStateException if no Shape selected
	 */
	public void setColor(Color color){
		if(!isShapeSel()){
			throw new IllegalStateException("No shape selected.");
		}
		shapeList.get(shapeList.size() - 1).setColor(color);
		notifyAllViewers();
	}
	
	/**
	 * Moves shape
	 * @param changeInX how much to move the Shape on the x-axis
	 * @param changeInY how much to move the Shape on the y-axis
	 * @throws IllegalStateException if no Shape selected
	 */
	public void moveShape(int changeInX, int changeInY){
		if(!isShapeSel()){
			throw new IllegalStateException("No shape selected.");
		}
		shapeList.get(shapeList.size() - 1).shiftUpperLeftBy(changeInX, changeInY);
		notifyAllViewers();
	}
	
	/**
	 * Returns a copy of list of Shapes in DrawingBoard
	 * @return copy of list of Shapes in DrawingBoard
	 */
	public List<Shape> getCopy(){
		ArrayList<Shape> copy = new ArrayList<Shape>(shapeList);
		return copy;
	}
}