
public class BOX {
	private double length,width,height;
	BOX(double l,double b,double h){
		length=l;
		width=b;
		height=h;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String toString(){
		return "Length:"+length+" Width:"+width+" Height:"+height; 
	}
	public double area(){
		return 2 * (length * width + width*height + height*length); 
	}
	public double volume() { return length*width*height;} 
	public static void swapBoxes(BOX b1, BOX b2) {
		BOX temp = b1; b1 = b2; b2 = temp; 
	}
}
