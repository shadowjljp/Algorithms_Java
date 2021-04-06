package decorater;

public class Coupon implements Discount{

	@Override
	public void printName() {
		System.out.println("This is a Coupon.");
	}

	@Override
	public void discount() {
		System.out.println("Here is the discount: 10% off!");
	}

}
