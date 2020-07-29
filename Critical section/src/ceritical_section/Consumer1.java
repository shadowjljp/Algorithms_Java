package ceritical_section;

public class Consumer1 {
	Producer p;
	public Consumer1() {
		 p = Producer.getFIFO(8);
	}
	public void setNum(int i,int x) {
		p.setSum(i,x);
	}
}
