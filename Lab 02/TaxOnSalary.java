import java.util.Scanner;
public class TaxOnSalary {

	private double salary;
	private boolean isPANsubmitted;
	Scanner in = new Scanner(System.in);
	public TaxOnSalary(boolean a){
		isPANsubmitted=a;
		salary=1000.00;
	}
	public TaxOnSalary(){
		isPANsubmitted=false;
		salary=0.0;
	}
	public double getSalary() {
		return salary;
	}
	public boolean isPANsubmitted() {
		return isPANsubmitted;
	}
	public double calculateTax(){
		if ((salary<180000)&&(isPANsubmitted))
			return 0.0;
		if ((salary<180000)&&(!isPANsubmitted))
			return 0.05*salary;
		if ((salary<500000)&&(salary>180000))
			return 0.1*salary;
		if ((salary<1000000)&&(salary>500000))
			return 0.2*salary;
		if ((salary<1000000))
			return 0.3*salary;
		return 0.0;
	}
	public void inputSalary(){
		System.out.println("Enter Salary = ");
		salary=in.nextDouble();
	}
}
