class SomeOther{
	public static void main(String[]args){
		//Write the exact location of s
		System.out.println(StaticOuter.StaticInner.s);
		//To access nonstatic members we need an object or 'this'
		StaticOuter.StaticInner si = new StaticOuter.StaticInner();
		//No 'this' exists in static context!
		System.out.println(si.nonstatic);
		System.out.println(si.s);
	}
}