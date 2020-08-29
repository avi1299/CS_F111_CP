import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

class Data {
	
	private int result;
	private boolean pChance;
	private boolean mChance;
	private Object lock;
	private int nop;
	
	public Data(){ // 8 Marks
		Scanner scan;
		//Q.1 Write your code here 
	}

	public int getResult() {
		return result;
	}

	public void setResult(int value) {
		this.result = value;
	}

	public boolean isPChance() {
		return pChance;
	}

	public void setPChance(boolean pChance) {
		this.pChance = pChance;
	}

	public boolean isMChance() {
		return mChance;
	}

	public void setMChance(boolean mChance) {
		this.mChance = mChance;
	}

	public Object getLock() {
		return lock;
	}

	public int getNoP() {
		return nop;
	}	
}

class Monitor implements Runnable {

	private Data d;
	private int tails = 0;
	private int heads = 0;
	
	public Monitor(Data d){
		this.d = d;
	}
	
	public void run() {
		int i;
		PrintWriter outStream;
		Object obj = d.getLock();
		
		//Q.2 (a) - 2 Marks
		
		//Q.2 (b) - 3 Marks
		
		//Q.2 (c) - 6 Marks	
		
		/*
		 * Uncomment the following two lines after writing
		 * solution for Q.2(a), Q.2(b)and Q.2(c)		 
		 */
		//System.out.println("monitor is going to read value ...");
		//if(d.getResult() == 0) tails++; else heads++;
		
		//Q.2 (d) - 6 Marks
		
		//Q.2 (e) - 3 Marks				
	}
}

class Player implements Runnable{
	private Data d;
	Random rand = new Random();
	
	public Player(Data d) {
		this.d = d;
	}
	
	public void run() {
		
		Object obj = d.getLock();
		
		//Q.3(a) - 3 Marks
		
		//Q.3(b) - 3 Marks
		
		/*
		 * Uncomment the following two lines after writing
		 * solution for Q.3(a) and Q.3(b)		 
		 */
		//d.setResult(rand.nextInt(2));
		//System.out.println("player is going to write value :" + d.getResult());
		
		//Q.3(c) - 6 Marks			
	
	} //end of run method		
}

class Lab10 {
	
	public static void main(String[] args){
		
		Data data = new Data();
		Thread[] players;
		Thread monitor;
		
		//Q.4(a) - 7 Marks
		
		//Q.4(b) - 3 Marks
	}
}
