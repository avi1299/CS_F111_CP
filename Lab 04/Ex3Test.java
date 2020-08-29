class A { public int a =100;  public A(){System.out.println(a);}} // End of class A
class B extends A { public int a =80; public B(){System.out.println(a); }} // End of class B
class C extends B { public int a =60; public C(){System.out.println(a);}} // End of class C
class D extends C { public int a =40; public D(){System.out.println(a);}} // End of class D
class E extends D{
public int a =10;
public void show(){
int a =0;
System.out.println(a);
// Write Java statements to display the values of
// all a’s used in this file on System.out
} // End of show() Method
}// End of class E
class Ex3Test{
public static void main(String args[]){
new E().show(); // This is an example of anonymous object
A a1 = new E();
D d1 = (D) a1;
// what’s wrong with this statement? And There is no show method in D
}// End of main()
}
// End of class EX3Test