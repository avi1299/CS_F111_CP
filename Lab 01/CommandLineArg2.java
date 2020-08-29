/* This program takes 10 integer arguments as an input from command line, parse the command line arguments to integers, finds the sum of these 10 numbers and print the sum */

class CommandLineArg2 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=0; i<args.length; i++){
			sum += Integer.parseInt(args[i]);
		}
		System.out.println("Sum = " + sum);
	}
}