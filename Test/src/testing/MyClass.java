package testing;

public class MyClass {

	public static void recursive(int n) {
		if(n==0) {
			System.out.println(n);
		}else if (n > -1) {
			System.out.println(n);
			recursive(n - 1);
			System.out.println(n);
		}
	}

	public static void main(String args[]) {
		int n = 5;
		recursive(n);
	}
}
