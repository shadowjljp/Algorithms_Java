package ch2;

public class MultipleThread implements Animal{

	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Animal.a);
		//System.out.println(MultiThreadImpl.getB());
		
	}

	@Override
	public void animalSound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
