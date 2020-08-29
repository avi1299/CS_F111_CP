
public class MovableCircle1 implements Movable,Comparable<MovableCircle1>{
	private int radius;
	private MovablePoint1 center;
	public MovableCircle1(int x, int y, int xSpeed, int ySpeed, int radius) {
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
	public int compareTo(MovableCircle1 c){
		if (this.radius>c.radius)
			return +1;
		else if (this.radius<c.radius)
			return -1;
		else
			return 0;
	}
}
