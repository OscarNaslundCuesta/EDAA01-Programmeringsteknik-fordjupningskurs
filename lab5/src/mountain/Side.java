package mountain;

public class Side {
	private Point p1, p2;
	
	public Side(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
	
	//@Override
	public boolean equals(Side side2) {
	return (this.p1 == side2.p1 && this.p2 == side2.p2 || this.p1 == side2.p2 && this.p2 == side2.p1);
	}
	
	@Override
	public int hashCode() {
	return p1.hashCode() + p2.hashCode();
	}

}
