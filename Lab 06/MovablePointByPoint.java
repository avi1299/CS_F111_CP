
public class MovablePointByPoint implements Comparator<MovablePoint1>{
	public int compare(MovablePoint1 a,MovablePoint1 b){
		if ((a.xSpeed==b.xSpeed)&&(a.ySpeed==b.ySpeed))
			return 1;
		return 0;
	}
}
