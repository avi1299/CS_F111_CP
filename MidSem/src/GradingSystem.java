import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class Course {
	private String code;
	private int units;
	public Course(String code, int units) {
		super();
		this.code = code;
		this.units = units;
	}
	public String getCode() {
		return code;
	}
	public int getUnits() {
		return units;
	}
}

abstract class Student {
	protected double cgpa;
	protected String id;
	protected int no_of_courses;
	protected String[] courses;
	protected String[] grades;
	public Student(String[] record) {
		this.no_of_courses = Integer.parseInt(record[1]);
		this.id = record[2];
		this.courses = new String[no_of_courses];
		this.grades = new String[no_of_courses];
		int i=3;
		for(int j=0; j<no_of_courses; j++, i++)
			courses[j] = record[i];
		int x = i;
		for(int j=0; i<(x+no_of_courses); j++, i++)
			grades[j] = record[i];
	}
	public double calculateCGPA() {
		int totalUnits = 0;
		double gradeWeight = 0;
		for(int i=0; i<no_of_courses; i++) {
			Integer mulFactor = GradingSystem.getGrademap().get(grades[i]);
			Course course = GradingSystem.getCoursemap().get(courses[i]);
			int units = course.getUnits();
			totalUnits += units;
			gradeWeight += units * mulFactor;
			cgpa = gradeWeight/totalUnits;
		}
		return cgpa;
	}
}

public class GradingSystem {
	private static Student[] arrStu = null;
	private static Course[] arrCourses = null;
	private static final HashMap<String, Integer> gradeMap = new HashMap<String, Integer>();
	private static final HashMap<String, Course> courseMap = new HashMap<String, Course>();
	public static void main(String[] args) {
		String str;
		int line_no = 0;
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		try {
			br1 = new BufferedReader(new FileReader("F:\\student.txt"));
			br2 = new BufferedReader(new FileReader("F:\\courses.txt"));
			//initialize student array
			while ((str = br1.readLine()) != null) { line_no++; }
			arrStu = new Student[line_no];
			line_no = 0; //reset line_no
			//initialize courses array
			while ((str = br2.readLine()) != null) { line_no++; }
			arrCourses = new Course[line_no];
			line_no = 0; //reset line_no
			br1 = new BufferedReader(new FileReader("F:\\student.txt")); //reinitialize br1
			br2 = new BufferedReader(new FileReader("F:\\courses.txt")); //reinitialize br2
			//initialize elements of student array
			while ((str = br1.readLine()) != null) {
				String[] st = str.split("~|#");
				if(st[0].equalsIgnoreCase("ug")){
					arrStu[line_no] = new UG(st);
				} else {
					arrStu[line_no] = new PG(st);
				}
				line_no++;
			}
			line_no = 0; //reset line_no
			//initialize elements of courses array - ask them to use string tokenizer here
			while ((str = br2.readLine()) != null) {
				String[] st = str.split("~");
				arrCourses[line_no] = new Course(st[0], Integer.parseInt(st[1]));
				line_no++;
			}
			initializeGradeMap();
			initializeCourseMap();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//exhibit polymorphism and find cgpa of all students
		for(Student s : arrStu) {
			s.calculateCGPA();
			System.out.println(s.toString());
		}
	}
	private static void initializeGradeMap(){
		gradeMap.put("A", 10);
		gradeMap.put("A-", 9);
		gradeMap.put("B", 8);
		gradeMap.put("B-", 7);
		gradeMap.put("C", 6);
		gradeMap.put("C-", 5);
		gradeMap.put("D", 4);
		gradeMap.put("E", 2);
	}
	private static void initializeCourseMap(){
		for(int i=0; i<arrCourses.length; i++){
			courseMap.put(arrCourses[i].getCode(), arrCourses[i]);
		}
	}
	public static HashMap<String, Integer> getGrademap() {
		return gradeMap;
	}
	public static HashMap<String, Course> getCoursemap() {
		return courseMap;
	}
}

class PG extends Student {
	private boolean thesis;
	public PG(String[] record) {
		super(record);
		if("Thesis".equalsIgnoreCase(record[3]))
			this.thesis = true;
	}
	public double calculateCGPA() {
		if(false != thesis){
			Integer mulFactor = GradingSystem.getGrademap().get(grades[0]);
			Course course = GradingSystem.getCoursemap().get("Thesis");
			int units = course.getUnits();
			if(mulFactor >= 8)
				cgpa = (units * mulFactor)/units + 0.1;
			else
				cgpa = (units * mulFactor)/units;
		}
		else {
			super.calculateCGPA();
		}
		return cgpa;
	}
	@Override
	public String toString() {
		return "PG [ id = " + id + " cgpa = " + cgpa + "]";
	}
}

class UG extends Student {
	public UG(String[] record) {
		super(record);
	}
	public String toString() {
		return "UG [ id = " + id + " cgpa = " + cgpa + "]";
	}
}