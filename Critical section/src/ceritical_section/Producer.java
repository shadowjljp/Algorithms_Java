package ceritical_section;


public class Producer {
	private static Producer p;
		private  int[] sum;

		public int[] getSum() {
			return sum;
		}

		public void setSum(int i,int x) {
			this.sum[i] = x;
		}
		
		public static Producer getFIFO(int i) {
			if(p ==null) {
				synchronized (Producer.class) {
					if(p==null) {
						
						p = new Producer( i);
						
					
					}
				}
			}
			return p;
		}
		public Producer(int i) {
			sum = new int[i];
			sum[0]=0;
			sum[1]=0;
		}
		
}
