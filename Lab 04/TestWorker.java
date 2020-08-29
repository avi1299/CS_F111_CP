
public class TestWorker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FullTimeWorker a=new FullTimeWorker("Avi",100,240);
		HourlyWorker b=new HourlyWorker("Avinash",50,60);
		System.out.println(a.computePay());
		System.out.println(b.computePay());
	}

}
