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
		Scanner scan=null;
		//Q.1 Write your code here 
		try {
			scan = new Scanner(new FileInputStream("input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
//		try {
			this.result = Integer.parseInt(scan.nextLine());
			this.pChance = Boolean.parseBoolean(scan.nextLine());
			this.mChance = Boolean.parseBoolean(scan.nextLine());
			this.nop = Integer.parseInt(scan.nextLine());
			this.lock = this;
			
//		}
//		catch(Exception e) {
//			System.out.println(e);			
//		}
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
		for(i=0;i<d.getNoP(); i++) {
			//System.out.println("enter monitor no. " + i);
			
			//Q.2 (b) - 3 Marks
			synchronized(d) {
//				System.out.println("monitor no " + i + " P Chance" + d.isPChance());
				
				//Q.2 (c) - 6 Marks	
				while(d.isPChance()) {	
					try {
						//System.out.println("monitor is going to wait ");
						d.wait();
					} catch (InterruptedException e){
						System.out.println(e);
					}
				}
				
				/*
				 * Uncomment the following two lines after writing
				 * solution for Q.2(a), Q.2(b)and Q.2(c)		 
				 */
				System.out.println("monitor is going to read value ...");
				if(d.getResult() == 0) tails++; else heads++;	
				
				//Q.2 (d) - 6 Marks
				d.setPChance(true);
				d.setMChance(false);
				d.notifyAll();
			
			}
		}
			
		//Q.2 (e) - 3 Marks			
		System.out.println("monitor reads "+ heads + " number of heads");
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
		synchronized(d){
			//Q.3(b) - 3 Marks
			while(d.isMChance()) {
				 try {
					//System.out.println("player waiting ");
					d.wait();
					//Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
			/*
			 * Uncomment the following two lines after writing
			 * solution for Q.3(a) and Q.3(b)		 
			 */
			d.setResult(rand.nextInt(2));
			System.out.println("player is going to write value :" + d.getResult());
			
			//Q.3(c) - 6 Marks	
			d.setMChance(true);
			d.setPChance(false);
			d.notifyAll();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} //end of run method		
}

class Lab10 {
	
	public static void main(String[] args){
		
		Data data = new Data();
		Thread[] players;
		Thread monitor;
		
		//Q.4(a) - 7 Marks
		Player[] p = new Player[data.getNoP()];
		
		players = new Thread[data.getNoP()];
		for(int i=0 ; i < data.getNoP() ; i++) {
			p[i] = new Player(data);
			players[i] = new Thread(p[i]);
			players[i].start();
		}
		
		//Q.4(b) - 3 Marks
		Monitor m = new Monitor(data);
		monitor = new Thread(m); 
		monitor.start();
		
		
	}
}
