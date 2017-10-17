package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.util.StringTokenizer;

//Class for the Rectangle
//it extends the class Shape
//it has two sets of coordinates and a Color
//it is identified by it's shapeType of 1
public class Rectangle extends Shape {

	//value for reactangle's shapeType
	private int rShapeType = 1;

	
	public Rectangle(int xa, int ya, int xb, int yb, Color col) {
		// calls the setShapeType in Shape, passes value of rectangle's shapeType
		setShapeType(rShapeType);
		// calls the setters for the coordinates and Color in Shape,
		// passing the values from Rectangle's constructor
		setX1(xa);
		setY1(ya);
		setX2(xb);
		setY2(yb);
		setColor(col);

	}
	
	//Constructor with StringTokenizer, used with loadPaint
	public Rectangle(StringTokenizer st) {
		String cmd = st.nextToken();
		// gets the corresponding Color object from the 
		// string color in line and set the color
		Color currentColor = getColorfromString(cmd);
		setColor(currentColor);
		// set shapeType for new shape
		setShapeType(rShapeType);
		// set the integers of the shape according to 
		// the integers stored in the file
		setX1(Integer.parseInt( st.nextToken()));
		setY1(Integer.parseInt( st.nextToken()));
		setX2(Integer.parseInt( st.nextToken()));
		setY2(Integer.parseInt( st.nextToken()));
		
	}

	// gets the upper left x coordinate
	public int getUpperLeftX() {return Math.min(getX1(), getX2());}

	// gets the upper left y coordinate
	public int getUpperLeftY() {return Math.min(getY1(), getY2());}

	// gets width
	public int getWidth() {return Math.abs(getX1() - getX2());}

	// gets height
	public int getHeight() {return Math.abs(getY1() - getY2());}

	// Overrides the abstract draw function in Shape
	// Draws the rectangle based on the color and the coordinates
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor()); // sets the color
		g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());

	}

}
