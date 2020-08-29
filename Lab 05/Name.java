import java.util.StringTokenizer;
public class Name {
	private String fname;
	private String mname;
	private String lname;
	public String getFname() {
		return fname;
	}
	public String getMname() {
		return mname;
	}
	public String getLname() {
		return lname;
	}
	public String getName() {
		return (fname + " " + mname + " " + lname);
	}
	public Name(String name){
		if(name.contains(",")){
			StringTokenizer strt=new StringTokenizer(name,",");
			fname=strt.nextToken();
			mname=strt.nextToken();
			lname=strt.nextToken();
		}
		else{
			StringTokenizer strt=new StringTokenizer(name,";");
			lname=strt.nextToken();
			mname=strt.nextToken();
			fname=strt.nextToken();
		}
	}
	@Override
	public String toString() {
		return (fname  + mname  + lname);
	}
	
}
