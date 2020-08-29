package TestBank;
import java.util.*;

public class BankFileTester {
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the filename:");
		String filename=in.next();
		Bank bank=new Bank(7);
		BankIO.readFile(filename, bank);
		System.out.println(bank);
		System.out.println("Enter the filename for output:");
		filename=in.next();
		BankIO.write(filename, bank);
		in.close();
	}
}
