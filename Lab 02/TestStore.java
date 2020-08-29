
public class TestStore {

	public static void main(String[] args) {
		Customer c = new Customer("Avi","001");
		Item i1=new Item("a","1",2,50);
		Item i2=new Item("b","1",3,100);
		c.buyItem(i1);
		c.buyItem(i2);
	}

}
