package age;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/** Represents a shape
 * @author Arshana Jain
 * @version October 24, 2016
 */
public interface Shape {
	/**
	 * Determines whether point (x, y) is on the Shape
	 * @param x x-coordinate of point
	 * @param y y-coordinate of point
	 * @return true if the point (x,y) is on the Shape, false if not
	 */
	public boolean isOn(int x, int y);
	
	/**
	 * Determines whether or not the Shape is selected
	 * @return true if this Shape is selected, false if not
	 */
	public boolean isSelected();
	
	/**
	 * Selects or de-selects Shape
	 * @param sel tells whether to select or deselect Shape
	 */
	public void setSelected(boolean sel);
	
	/**
	 * Determines color of Shape
	 * @return color of Shape
	 */
	public Color getColor();
	
	/**
	 * Changes color of Shape
	 * @param color what to set this.color to
	 */
	public void setColor(Color color);
	
	/**
	 * Shifts upper-left corner of Shape
	 * @param deltaX units to shift shape by on x-axis
	 * @param deltaY units to shift shape by on y-axis
	 */
	public void shiftUpperLeftBy(int deltaX, int deltaY);
	
	/**
	 * Where to move the upper-left corner of the Shape to
	 * @param newX what to set the x-coordinate to
	 * @param newY what to set the y-coordinate to
	 */
	public void moveUpperLeftTo(int newX, int newY);
	
	/**
	 * Returns upper-left corner point of the Shape
	 * @return upper-left corner point
	 */
	public Point getUpperLeft();
	
	/**
	 * Draws the Shape
	 * @param g Graphics to draw shape in
	 */
	public void drawShape(Graphics g);
	
	/**
	 * Draws outline of Shape (only occurs if Shape selected)
	 * @param g
	 */
	public void drawBorder(Graphics g);
	
	/**
	 * Provides a String representation of Shape's state
	 * @return String representation of Shape's state
	 */
	public String toString();
}