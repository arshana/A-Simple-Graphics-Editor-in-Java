package age;

import java.awt.*;
/** Represents a delta
 * @author Arshana Jain
 * @version October 24, 2016
 */
public class Delta extends AbstractShape{
	//height of Delta
	private int height;
	
	/**
	 * Create a Delta
	 * @param apex top point of triangle; must have integer coordinates
	 * @param height height of triangle; must be greater than two and even
	 * @throws IllegalArgumentException if height is not valid
	 * @throws IllegalArgumentException if apex is not valid
	 */
	public Delta(Point apex, int height){
		super();
		//checks height validity
		if(height % 2 != 0 || height < 2){
			throw new IllegalArgumentException("Height is not valid.");
		}
		//checks apex validity
		if(apex.getX() != (int)apex.getX() || apex.getY() != (int)apex.getY()){
			throw new IllegalArgumentException("Apex is not valid.");
		}
		moveUpperLeftTo((int)apex.getX() - (height / 2), (int)apex.getY());
		this.height = height;
	}

	@Override
	public boolean isOn(int x, int y) {
		//treats each line of a triangle separately
		return((y <= (getUpperLeft().getY() + height) && y >= getUpperLeft().getY())							
				&& (x <= (getUpperLeft().getX() + (height / 2)) + ((y - getUpperLeft().getY()) / 2))		
				&& (x >= (getUpperLeft().getX() + (height / 2)) - ((y - getUpperLeft().getY()) / 2)));		
	}
	
	@Override
	public String toString(){
		String ret = "Delta is ";
		if(!this.isSelected()){
			ret += "not ";
		}
		ret += "selected and the apex is currently at (" + (this.getUpperLeft().getX() + (height / 2)) + ", " + this.getUpperLeft().getY() + ").";
		return ret;
	}
	
	/**
	 * Returns an array of the x-coordinates of any corners of Delta
	 * @return array of the x-coordinates of any corners of Delta
	 */
	private int[] getXPoints(){
		return new int[]{((int)getUpperLeft().getX() + (height / 2)), ((int)getUpperLeft().getX()), ((int)getUpperLeft().getX() + height)};
	}
	
	/**
	 * Returns an array of the y-coordinates of any corners of Delta
	 * @return array of the y-coordinates of any corners of Delta
	 */
	private int[] getYPoints(){
		return new int[]{((int)getUpperLeft().getY()), ((int)getUpperLeft().getY() + height), ((int)getUpperLeft().getY() + height)};
	}
	
	@Override
	public void drawShape(Graphics g) {
		g.setColor(getColor());
		g.fillPolygon(getXPoints(), getYPoints(), 3);
	}

	@Override
	public void drawBorder(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawPolygon(getXPoints(), getYPoints(), 3);
	}
}