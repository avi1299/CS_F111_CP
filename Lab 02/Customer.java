public class Customer {
	private String name,idNo;
	private double balance;
	private Item item;
	
	public Customer(String a,String b, double c){
		name=a;
		idNo=b;
		balance=c;
		item=new Item("a","b");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public double getBalance() {
		return balance;
	}
	public Item getItem() {
		return item;
	}
	public Customer(String a,String b){
		name=a;
		idNo=b;
		balance=5000;
		item=new Item("a","b");
	}
	public void print(){
		System.out.println("Item Name: "+item.nameGet());
		System.out.println("Item IdNo: "+item.idGet());
		System.out.println("Item Quantity: "+item.quantityGet());
		System.out.println("Item Price: "+item.priceGet());
		balance-=item.priceGet();
		System.out.println("Balance after purchasing: "+balance);
	}
	public void buyItem(Item item){
		if(item.quantityGet()<1)
			System.out.println("Order not valid");
		else if(item.priceGet()>balance)
			System.out.println("Insufficient Balance");
		else{
			this.item=item;
			this.print();
		}		
	}
	
}
