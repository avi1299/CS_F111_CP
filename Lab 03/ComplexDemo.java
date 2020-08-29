public class ComplexDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complex c1=new Complex(3,4);
		Complex c2=new Complex(0,1);
		Complex c=c1.divide(c2);
		System.out.println(c.getRealPart()+"+i"+c.getImaginaryPart());
	}

}
