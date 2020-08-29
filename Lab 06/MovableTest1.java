
public class MovableTest1 {

	public static void main(String[] args){
		Movable m1 = new MovablePoint1(5, 6, 10,12); // upcast
		System.out.println(m1);
		m1.moveLeft();
		System.out.println(m1);
		Movable m2 = new MovableCircle(2, 1, 2, 20,5); // upcast
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);
	}
}
