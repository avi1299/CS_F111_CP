
public class MovableCircle implements Movable{
	private int radius;
	private MovablePoint1 center;
	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		this.radius = radius;
		this.center = new MovablePoint1(x,y,xSpeed,ySpeed);
	}
	@Override
	public void moveUp(){
		center.y-=center.ySpeed;
	}
	@Override
	public void moveDown(){
		center.y+=center.ySpeed;
	}
	@Override
	public void moveLeft(){
		center.x-=center.xSpeed;
	}
	@Override
	public void moveRight(){
		center.x+=center.xSpeed;
	}
	@Override
	public String toString() {
		return "Circle at (" + center.x + "," + center.y + ") with radius "+radius;
	}
}
