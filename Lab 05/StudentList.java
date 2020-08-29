
public class StudentList {
	public static Student[] list=new Student[10];
	public static int count=0;
	
	public static void addStudent(Student std){
		if (count>=10) return;
		list[count]=std;
		count++;
	}
	public static Student[] getStudentsWithAge(int age){
		Student[] newlist= new Student[count];
		int j=0;
		for(int i=0;i<list.length;i++){
			if (list[i].getAge()==age){
				newlist[j]=list[i];
				j++;
			}
		}
		return newlist;
	}
	public static Student[] getStudentsWithLastName(String lastName){
		Student[] newlist= new Student[count];
		int j=0;
		for(int i=0;i<list.length;i++){
			if (list[i].getNameVariable().getLname().equals(lastName)){
				newlist[j]=list[i];
				j++;
			}
		}
		return newlist;
	}
	public static Student[] getStudentsInRange(int minAge, int maxAge){
		Student[] newlist= new Student[count];
		int j=0;
		for(int i=0;i<list.length;i++){
			if ((list[i].getAge()>=minAge)&&(list[i].getAge()<=maxAge)){
				newlist[j]=list[i];
				j++;
			}
		}
		return newlist;
	}
	
}
