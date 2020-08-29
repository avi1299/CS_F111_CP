
public class Complex {
	private double realPart,imaginaryPart;
	public Complex(){
		this.realPart=0;
		this.imaginaryPart=0;
	}
	public Complex(double real,double imag){
		this.realPart=real;
		this.imaginaryPart=imag;
	}
	public Complex(double real){
		this.realPart=real;
		this.imaginaryPart=0;
	}
	public double getRealPart() {
		return realPart;
	}
	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}
	public double getImaginaryPart() {
		return imaginaryPart;
	}
	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}
	public Complex add(Complex otherNumber){
		return new Complex(this.realPart+otherNumber.realPart,this.imaginaryPart+otherNumber.imaginaryPart);
	}
	public Complex subtract(Complex otherNumber){
		return new Complex(this.realPart-otherNumber.realPart,this.imaginaryPart-otherNumber.imaginaryPart);
	}
	public Complex multiply(Complex otherNumber){
		return new Complex(this.realPart*otherNumber.realPart-this.imaginaryPart*otherNumber.imaginaryPart,this.realPart*otherNumber.imaginaryPart+this.imaginaryPart*otherNumber.realPart);
	}
	public Complex divide(Complex otherNumber){
		double coeff=otherNumber.realPart*otherNumber.realPart+otherNumber.imaginaryPart*otherNumber.imaginaryPart;
		return new Complex((this.realPart*otherNumber.realPart+this.imaginaryPart*otherNumber.imaginaryPart)/coeff,(-this.realPart*otherNumber.imaginaryPart+this.imaginaryPart*otherNumber.realPart)/coeff);
	}
	
}
