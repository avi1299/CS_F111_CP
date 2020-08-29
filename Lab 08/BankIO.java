package TestBank;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class BankIO {
	public static void readFile(String filename, Bank bank){
		Scanner in;
		try {
			in = new Scanner(new File(filename));
			while(in.hasNext()){
				bank.add(readAccount(in));
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("\n*****ERROR*****: " + "No file by such name\n");
			System.exit(1);
		}
	}
	public static BankAccount readAccount(Scanner in){
		int accNo=in.nextInt();
		double bal=in.nextDouble();
		BankAccount b=new BankAccount(bal,accNo);
		return b;
	}
	public static void write(String filename, Bank bank){
		PrintWriter out;
		try {
		out = new PrintWriter(filename);
		out.write(bank.toString());
		out.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("\n*****ERROR*****: " + "No file by such name\n");
			System.exit(1);
		}
	}

}
