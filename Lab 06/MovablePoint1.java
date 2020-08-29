
public class MovablePoint1 implements Movable{
	int x,y,xSpeed,ySpeed;


	
	public MovablePoint1(int x, int y, int xSpeed, int ySpeed) {
		super();
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	@Override
	public String toString() {
	return "Point at (" + x + "," + y + ")";
	}
	
	// Implement abstract methods defined in the interface Movable
	
	@Override
	public void moveUp() {
	y-=ySpeed;
	}
	@Override
	public void moveDown() {
	y+=ySpeed;
	}
	@Override
	public void moveLeft() {
	x-=xSpeed;
	}
	@Override
	public void moveRight() {
	x+=xSpeed;
	}
}
