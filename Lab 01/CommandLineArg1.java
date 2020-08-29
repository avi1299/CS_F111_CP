/* This program expects some string as command line arguments, then it simply outputs the command line arguments to the console*/

class CommandLineArg1 {
	public static void main(String[] args) {
		for(int i=0; i<args.length; i++){
			System.out.println("args["+ i +"] =" + args[i]);
		}
	}
}