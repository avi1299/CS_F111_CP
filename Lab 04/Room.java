class Room{
	double length, breadth, height;
	Room(){//default constructor for class Room
		this.length=-1;
		this.breadth=-1;
		this.height=-1;
	}
	//overloading the constructor
	//3 Parameterized constructor for the class Room
	Room(double l, double b, double h) {
		this.length=l;
		this.breadth=b;
		this.height=h;
		}
	Room(double len) {// Single parameterized constructor
		this.length=this.breadth=this.height=len;
		}
	double volume() {
		return length*breadth*height;
	}
}