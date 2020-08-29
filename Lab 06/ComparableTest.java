import java.util.*;
public class ComparableTest {
	public static void main(String[] args){
		MovableCircle1[] mc=new MovableCircle1[5];
		mc[0]=new MovableCircle1(1,5,6,3,7);
		mc[1]=new MovableCircle1(2,5,6,3,3);
		mc[2]=new MovableCircle1(3,5,6,3,5);
		mc[3]=new MovableCircle1(4,5,6,3,1);
		mc[4]=new MovableCircle1(5,5,6,3,9);
		Arrays.sort(mc);;
		for(int i=0;i<mc.length;i++){
			System.out.println(mc[i]);
		}
	}
}
