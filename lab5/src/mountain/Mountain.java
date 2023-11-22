package mountain;

import java.util.HashMap;
import java.util.Map.Entry;

import fractal.*;

public class Mountain extends Fractal {
	private Point p1, p2, p3;
    private double dev;
    private HashMap<Side, Point> sideMap = new HashMap<>();

	/** Creates an object that handles Mountain's fractal. 
	 */
	public Mountain(Point p1, Point p2, Point p3, double dev) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.dev = dev;
	}

	/**
	 * Returns the title.
	 * @return the title
	 */
    @Override
	public String getTitle() {
		return "Mountain's fractal";
	}

	/** Draws the fractal.  
	 * @param turtle the turtle graphic object
	 */
    @Override
	public void draw(TurtleGraphics turtle) {
    	fractalLine(turtle, order, p1, p2, p3, dev);
	}
    
	public void drawLine(TurtleGraphics turtle, Point p1, Point p2) {
    	turtle.moveTo(p1.getX(), p1.getY());
		turtle.forwardTo(p2.getX(), p2.getY());
	}
	
	public Point getMid(Point p1, Point p2, double dev) {		
		Side side = new Side(p1, p2);
		
		
		if (sideMap.containsKey(side)) {
			Point midPoint = sideMap.get(side);
			//sideMap.remove(side);
			System.out.println("old midpoint!");
			return midPoint; //return old mid-point
		}
				
    	int midX = ((p1.getX() + p2.getX()) / 2) + (int) RandomUtilities.randFunc(dev);
    	int midY = ((p1.getY() + p2.getY()) / 2) + (int) RandomUtilities.randFunc(dev);
    	
    	Point midPoint = new Point(midX, midY);
    	sideMap.put(side, midPoint);
    	
    	return midPoint;
	}

	/* 
	 * Reursive method: Draws a recursive line of the mountain. 
	 */
	private void fractalLine(TurtleGraphics turtle, int order, Point p1, Point p2, Point p3, double dev) {
		if (order == 0) {
			drawLine(turtle, p1, p2);
			drawLine(turtle, p2, p3);
			drawLine(turtle, p3, p1);
		} else {
			Point midP1P2 = getMid(p1, p2, dev);
	        Point midP2P3 = getMid(p2, p3, dev);
	        Point midP3P1 = getMid(p3, p1, dev);

	        fractalLine(turtle, order - 1, p1, midP1P2, midP3P1, dev/2);
	        fractalLine(turtle, order - 1, p2, midP2P3, midP1P2, dev/2);
	        fractalLine(turtle, order - 1, p3, midP3P1, midP2P3, dev/2);
	        fractalLine(turtle, order - 1, midP1P2, midP2P3, midP3P1, dev/2);
		}
	}

}
