package age;

import java.awt.Color;
import java.awt.Point;

/** Represents an abstract shape
 * @author Arshana Jain
 * @version October 24, 2016
 */
public abstract class AbstractShape implements Shape{
	private boolean selected;
	private Color color;
	private Point upperLeft;
	
	/**
	 * Create an AbstractShape
	 */
	public AbstractShape(){
		selected = false;
		color = Color.CYAN;
		upperLeft = new Point(0, 0);
	}
	
	@Override
	public boolean isSelected(){
		return selected;
	}
	
	@Override
	public void setSelected(boolean sel){
		selected = sel;
	}
	
	@Override
	public Color getColor(){
		return color;
	}
	
	@Override
	public void setColor(Color color){
		this.color = color;
	}
	
	@Override
	public void shiftUpperLeftBy(int deltaX, int deltaY){
		upperLeft.setLocation(upperLeft.getX() + deltaX, upperLeft.getY() + deltaY);
	}
	
	@Override
	public void moveUpperLeftTo(int newX, int newY){
		upperLeft.setLocation(newX, newY);
	}
	
	@Override
	public Point getUpperLeft(){
		return upperLeft;
	}
}