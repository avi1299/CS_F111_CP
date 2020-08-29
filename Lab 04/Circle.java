// Define the Circle class
public class Circle{ // Save as "Circle.java"
	// Private variables
	private double radius;
	private String color;
	// Constructors (overloaded)
	public Circle() { // 1st Constructor
		radius = 1.0;
		color = "red";
	}
	public Circle(double r) { // 2nd Constructor
		radius = r;
		color = "red";
	}
	public Circle(double r, String c) { // 3rd Constructor
		radius = r;
		color = c;	
	}
	//Public Methods
	public double getRadius() {
		return radius;
	}
	public String getColor() {
		return color;
	}
	public double getArea(){
		return radius*radius*Math.PI;
	}
}
	

