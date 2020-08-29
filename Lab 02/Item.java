public class Item {
	private String itemName,itemidNo;
	private int itemQuantity;
	private double itemPrice;
	
	public String nameGet(){
		return itemName;
	}
	public String idGet(){
		return itemidNo;
	}
	public int quantityGet(){
		return itemQuantity;
	}
	public double priceGet(){
		return itemPrice;
	}
	public void nameSet(String x){
		itemName=x;
	}
	public void idSet(String x){
		itemidNo=x;
	}
	public void quantitySet(int x){
		itemQuantity=x;
	}
	public void priceSet(double x){
		itemPrice=x;
	}
	public Item(String a,String b,int c,double d){
		itemName=a;
		itemidNo=b;
		itemQuantity=c;
		itemPrice=d;
	}
	public Item(String a,String b,int c){
		itemName=a;
		itemidNo=b;
		itemQuantity=c;
		itemPrice=500;
	}
	public Item(String a,String b){
		itemName=a;
		itemidNo=b;
		itemQuantity=1;
		itemPrice=500;
	}
	

}
