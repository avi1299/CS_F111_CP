import java.util.Arrays;
public class ComparatorTest {
	public static void main(String[] args){
		MovablePoint1[] mc=new MovablePoint1[5];
		mc[0]=new MovablePoint1(1,5,6,3);
		mc[1]=new MovablePoint1(2,5,6,4);
		mc[2]=new MovablePoint1(3,5,6,3);
		Comparator<MovablePoint1> c1=new MovablePointByPoint();
		System.out.println(c1.compare(mc[0], mc[1]));
		System.out.println(c1.compare(mc[0], mc[2]));
	}
}