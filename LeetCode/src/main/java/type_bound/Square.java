package type_bound;

public class Square extends Shape {// Unfinished
	public static void main(String[] args) {
		Square s1 = new Square();
		Square s2 = new Square();
	
		Square[] arr= {s1,s2};
		findMax();
	}
}
