
public class Student {
	private Name name;
	private int age;
	public Name getNameVariable() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return (name.getName()+" " + Integer.toString(age));
	}
	public Student(Name name,int age){
		this.name=name;
		this.age=age;
	}
}
