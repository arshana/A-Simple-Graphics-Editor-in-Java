package age;

import java.awt.*;

/** Represents a circle
 * @author Arshana Jain
 * @version October 24, 2016
 */
public class Circle extends AbstractShape {
	//radius of Circle
	private int radius;
	
	/**
	 * Create a Circle
	 * @param center center point of circle; must have integer coordinates
	 * @param radius radius of circle; must be greater than 0
	 * @throws IllegalArgumentException if center point is not valid
	 * @throws IllegalArgumentException if radius is not valid
	 */
	public Circle(Point center, int radius){
		super();
		//checks center validity
		if(center.getX() != (int)center.getX() || center.getY() != (int)center.getY()){
			throw new IllegalArgumentException("Center is not valid.");
		}
		//checks radius validity
		if(radius < 1){
			throw new IllegalArgumentException("Radius is not valid.");
		}
		this.radius = radius;
		moveUpperLeftTo((int)center.getX() - radius, (int)center.getY() - radius);
	}

	@Override
	public boolean isOn(int x, int y) {
		//uses equation of a circle
		return ((int)Math.pow(x - (getUpperLeft().getX() + radius), 2) + (int)Math.pow(y - (getUpperLeft().getY() + radius), 2)) <= (int)Math.pow(radius, 2);
	}
	
	@Override
	public String toString(){
		String ret = "Circle is ";
		if(!this.isSelected()){
			ret += "not ";
		}
		ret += "selected and the center is currently at (" + (this.getUpperLeft().getX() + radius) + ", " + (this.getUpperLeft().getY() + radius) + ").";
		return ret;
	}

	@Override
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.fillOval((int)getUpperLeft().getX(), (int)getUpperLeft().getY(), radius * 2, radius * 2);
	}

	@Override
	public void drawBorder(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval((int)getUpperLeft().getX(), (int)getUpperLeft().getY(), radius * 2, radius * 2);
	}
}