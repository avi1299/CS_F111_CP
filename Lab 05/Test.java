import java.io.IOException;
import java.util.Scanner;
public class Test {
	public static Student readStudent() throws IOException{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the First Name: ");
		String f = in.next();
		System.out.println("Enter the Middle Name: ");
		String m = in.next();
		System.out.println("Enter the Last Name: ");
		String l = in.next();
		System.out.println("Enter the choice for delimiter: ");
		int delim = in.nextInt();
		System.out.println("Enter the Age: ");
		int a = in.nextInt();
		String finalName;
		if (delim==1)
			finalName = (f+","+m+","+l);
		else
			finalName = (l+";"+m+";"+f);
		Name name=new Name(finalName);
		
		Student s = new Student(name,a);
		return s;
		
	}
	public static void main (String args[]) throws IOException{
		for(int i=0;i<10;i++){
			StudentList.addStudent(Test.readStudent());
		}
		for(int i=0;i<StudentList.getStudentsWithAge(20).length;i++){
			System.out.println(StudentList.getStudentsWithAge(20)[i]+"\n");
		}
		for(int i=0;i<StudentList.getStudentsWithLastName("Sharma").length;i++){
			System.out.println(StudentList.getStudentsWithLastName("Sharma")[i]+"\n");
		}
		for(int i=0;i<StudentList.getStudentsInRange(16, 20).length;i++){
			System.out.println(StudentList.getStudentsInRange(16, 20)[i]+"\n");
		}	
	}

}
