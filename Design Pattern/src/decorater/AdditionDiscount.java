package decorater;

public class AdditionDiscount extends Decorator{

	public AdditionDiscount(Discount decoratedDiscount) {
		super(decoratedDiscount);
	}
	@Override
	public void printName() {
		decoratedDiscount.printName();
		conditionalDiscount(decoratedDiscount);
		
		
	}

	private void conditionalDiscount(Discount decoratedDiscount) {
		System.out.println("Free shipping for order over $90");
	}

	private void additionalDiscount(Discount decoratedDiscount) {
		System.out.println("Extra 10% discount");
	}
	@Override
	public void discount() {
		decoratedDiscount.discount();
		additionalDiscount(decoratedDiscount);
	}
}
