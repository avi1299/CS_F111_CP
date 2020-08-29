
public class HourlyWorker extends Worker{
	private int hours_Worked;

	public HourlyWorker(String name, double salary_rate,int hours_Worked) {
		super(name, salary_rate);
		this.hours_Worked=hours_Worked;
		// TODO Auto-generated constructor stub
	}
	public double computePay(){
		return hours_Worked*this.getSalary_rate();
	}
	
	
}
