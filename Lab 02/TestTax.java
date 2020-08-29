public class TestTax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaxOnSalary tax1=new TaxOnSalary();
		TaxOnSalary tax2=new TaxOnSalary();
		tax1.inputSalary();
		tax2.inputSalary();
		System.out.println("Tax 1:" +tax1.calculateTax());
		System.out.println("Tax 2:" +tax2.calculateTax());
	}

}
