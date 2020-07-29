package tree;

public class tester {
	public boolean isMirror(int a,int b){
		return a==b;
	}
	public static void main(String[] args) {
		tester t = new tester();
		final int NUMS = 4000;
        final int GAP  =   37;
        int i = GAP;
        int count =0;
        
        while( i != 0) {
        	i = ( i + GAP ) % NUMS;
        	count++;
        }
        int a=1;
        int b=1;
        System.out.println(count);
        System.out.println(t.isMirror(a, b));
	}

}
