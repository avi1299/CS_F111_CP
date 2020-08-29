
public class StaticExample {
	static{
		System.out.println("This is the first static block");
	}
	public StaticExample(){
		System.out.println("This is constructor");
	}
	public static String staticString="Static Variable";
	
	static{
		System.out.println("This is the second static block and "+staticString);
	}
	
	public static void main(String[] args) {
		StaticExample statEx= new StaticExample();
		StaticExample.staticMethod2();
	}
	
	static{
		staticMethod();
		System.out.println("this is a third Static Block");
	}
	public static void staticMethod(){
		System.out.println("This is a static method");
	}
	public static void staticMethod2(){
		System.out.println("this is static method2");
	}

}
