
public class Manager extends Employee{
	private String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Manager(String name,double salary,String department){
		super(name,salary);
		this.department=department;
	}
	@Override public String toString(){
		return "Name= "+this.getName()+" ,Salary= "+this.getSalary()+" Department= "+department+"\n";
	}
}
