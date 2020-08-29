/*public class RetailStore {
	private int[] itemId = {1001,1002,1003,1004,1005};
	private double[] price = {13.50, 18.00, 19.50, 25.50};
	private double computePrice(int value) {
		// method to compute the price of the item.
		// it returns the price
		for (int i = 0; i<price.length; ++i) {
			// note the use of price.length.
			// it gives the length of the array
			if (itemId[i] == value) {
				return price[i];
			}
		}
		// method which takes in the index and
		// returns the price of the item
		return price[value];
	}

	public static void main(String[] args) {
		//main method. Execution begins here 
		RetailStore retailOne = new RetailStore(); 
		System.out.println("price of item id 1002 is " + retailOne.computePrice(1003));
		System.out.println("price of item id 1004 is "+ retailOne.computePrice(1004));
		/* System.out.println("price of item id 1009 is "+ retailOne.computePrice(1007)); */
		/* un-comment the above line and see the output.
		 * Why there is no compilation error? 
	}

}

*/

public class RetailStore {
	private int[] itemId;
	private double[] price;
	private String itemName[];
	/* The constructor is used here for the initialization purpose*/
	public RetailStore() { 
		itemId = new int[] { 1001, 1002, 1003, 1004, 1005 };
		price = new double[] { 950.00, 750.00, 450.00, 350.00, 250.00 };
		itemName = new String[] { "Yonex Tennis Racket-950","Yonex Badminton Racket-750", "Silvers Badminton Racket-450","Cosco Badminton shuttle-350", "Cosco Tennis Racket-250" };
		}
	protected double computePrice(int value) { 
		// method to compute the price of the item. it returns the price 
		for (int i = 0; i<price.length; ++i) {
			// note the use of price.length. it gives the length of the array 
			if (itemId[i] == value) {
				return price[i]; 
				}
			} 
		return price[value];
		}
	protected String fetchDescription(int value) {
		// method to compute the description of the item. it returns the // description 
		for (int i = 0; i<price.length; ++i) {
			// note the use of price.length. it gives the length of the array 
			if (itemId[i] == value) {
				return itemName[i];
				} 
			}
		return null; 
	}
}
