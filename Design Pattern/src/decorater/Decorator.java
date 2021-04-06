package decorater;

public abstract class Decorator implements Discount {
	protected Discount decoratedDiscount;
	public Decorator(Discount decoratedDiscount) {
		this.decoratedDiscount = decoratedDiscount;
	}
	
	public void printName() {
		decoratedDiscount.printName();
	}
	
	public void discount() {
		decoratedDiscount.discount();
	}
}
