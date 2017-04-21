package age;

import java.awt.*;

/** Represents a tee
 * @author Arshana Jain
 * @version October 24, 2016
 */
public class Tee extends AbstractShape{
	//height of Tee
	private int height;
	
	/**
	 * Creates a Tee
	 * @param upperLeftCorner upper left corner of Tee; must have integer coordinates
	 * @param height height of Tee; must be multiple of 10 and greater than 0
	 * @throws IllegalArgumentException if height is not valid
	 * @throws IllegalArgumentException if upper left corner is not valid
	 */
	public Tee(Point upperLeftCorner, int height){
		super();
		//checks height validity
		if(height % 10 != 0 || height < 10){
			throw new IllegalArgumentException("Height is not valid.");
		}
		//checks upperLeftCorner validity
		if(upperLeftCorner.getX() != (int)upperLeftCorner.getX() || upperLeftCorner.getY() != (int)upperLeftCorner.getY()){
			throw new IllegalArgumentException("Upper left corner point is not valid.");
		}
		moveUpperLeftTo((int)upperLeftCorner.getX(), (int)upperLeftCorner.getY());
		this.height = height;
	}

	@Override
	public boolean isOn(int x, int y) {
		//thickness of Tee
		int thickness = height / 5;
		//checks horizontal portion and then checks vertical portion
		return (x >= getUpperLeft().getX() && x <= (getUpperLeft().getX() + height) 
				&& y >= getUpperLeft().getY() && y <= (getUpperLeft().getY() + thickness)) 
				|| (x >= (getUpperLeft().getX() + (thickness * 2)) && x <= (getUpperLeft().getX() + (thickness * 3)) 
				&& y > (getUpperLeft().getY() + thickness) && y <= (getUpperLeft().getY() + height));
	}
	
	@Override
	public String toString(){
		String ret = "Tee is ";
		if(!this.isSelected()){
			ret += "not ";
		}
		ret += "selected and the upper left corner is currently at (" + this.getUpperLeft().getX()+ ", " + this.getUpperLeft().getY() + ").";
		return ret;
	}
	
	/**
	 * Returns an array of the x-coordinates of any corners of Tee
	 * @return array of the x-coordinates of any corners of Tee
	 */
	private int[] getXPoints(){
		int thickness = height / 5;
		return new int[]{((int)getUpperLeft().getX()), ((int)getUpperLeft().getX() + height), ((int)getUpperLeft().getX() + height), 
				((int)getUpperLeft().getX() + thickness * 3), ((int)getUpperLeft().getX() + thickness * 3), ((int)getUpperLeft().getX() + thickness * 2), 
				((int)getUpperLeft().getX() + thickness * 2), ((int)getUpperLeft().getX())};
	}
	
	/**
	 * Returns an array of the y-coordinates of any corners of Tee
	 * @return array of the y-coordinates of any corners of Tee
	 */
	private int[] getYPoints(){
		int thickness = height / 5;
		return new int[]{((int)getUpperLeft().getY()), ((int)getUpperLeft().getY()), ((int)getUpperLeft().getY() + thickness), 
				((int)getUpperLeft().getY() + thickness), ((int)getUpperLeft().getY() + height), ((int)getUpperLeft().getY() + height), 
				((int)getUpperLeft().getY() + thickness), ((int)getUpperLeft().getY() + thickness)};
	}
	
	@Override
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.fillPolygon(getXPoints(), getYPoints(), 8);
	}

	@Override
	public void drawBorder(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawPolygon(getXPoints(), getYPoints(), 8);
	}
}