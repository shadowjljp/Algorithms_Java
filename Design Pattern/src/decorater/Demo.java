package decorater;

public class Demo {

	public static void main(String[] args) {
		Discount coupon = new Coupon();
		coupon.printName();
		coupon.discount();
		System.out.println("\nBelow is after decorated.\n");
		Discount enhanceCoupon = new AdditionDiscount(coupon);
		enhanceCoupon.printName();
		enhanceCoupon.discount();
	}

}
