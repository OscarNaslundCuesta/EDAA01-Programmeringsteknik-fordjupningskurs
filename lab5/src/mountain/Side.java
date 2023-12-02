package mountain;

public class Side {
	private Point p1, p2;
	
	public Side(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
	
	//@Override
	public boolean equals(Side obj) {
	return (this.p1 == obj.p1 && this.p2 == obj.p2 || this.p1 == obj.p2 && this.p2 == obj.p1);
	}
	
	//not used
	@Override
	public int hashCode() {
	return p1.hashCode() + p2.hashCode();
	}
	
	@Override
	public String toString() {
	    return "Side[p1=" + p1 + ", p2=" + p2 + "]";
	}

}
