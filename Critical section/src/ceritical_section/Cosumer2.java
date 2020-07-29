package ceritical_section;

public class Cosumer2 {
	Producer p;
	public Producer Consumer2() {
		 p = Producer.getFIFO(8);
		 return p;
	}
	public void setNum(int i,int x) {
		p.setSum(i,x);
	}
	public static void main(String[] args) {
		Consumer1 c = new Consumer1();
		c.setNum(0, 1);
		Cosumer2 c2 = new Cosumer2();
		Producer p = c2.Consumer2();
		p.setSum(1,2 );
		for(int i : p.getSum())
		System.out.println(i);
	}

}
