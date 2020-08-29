// Demonstrating the use of Overloaded constructors
class OverloadedConstructors{
	public static void main(String args[]){
		Room a=new Room(20,30,40);
		Room b=new Room();
		Room c=new Room(10);
		double vol;
		vol=a.volume();
		System.out.println("Volume of room a is " + vol);
		vol=b.volume();
		System.out.println("Volume of room b is " + vol);
		vol=c.volume();
		System.out.println("Volume of room c is " + vol);
	}
}