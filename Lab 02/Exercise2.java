import java.util.Scanner;
public class Exercise2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sum=0;
		for(int i=0;i<10;i++){
			System.out.println("Enter a number: ");
			sum+=in.nextInt();
		}
		System.out.println("The sum is " + sum);
	}

}
