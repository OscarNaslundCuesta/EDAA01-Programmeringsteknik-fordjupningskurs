package fractal;

import koch.Koch;
import mountain.Mountain;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		Point p1 = new Point(100, 20);
		Point p2 = new Point(20, 500);
		Point p3 = new Point(580, 480);
		fractals[0] = new Mountain(p1, p2, p3, 30);
		fractals[1] = new Koch(300);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}
