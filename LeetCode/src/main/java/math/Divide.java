package math;

public class Divide {
	 public int divide(int dividend, int divisor) {
	        if(dividend == Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
	        boolean sign = (dividend<0)==(divisor<0);
	       int res = div(-Math.abs(dividend), -Math.abs(divisor));
	        return sign ? res:-res;
	    }
	    public int div(int dividend,int divisor){
	        if(divisor<dividend) return 0;
	        int sum = divisor;
	        int re=1;
	        while(dividend<=sum+sum && sum+sum<sum){
	            sum+=sum;
	            re+=re;
	        }
	        return re+div(dividend-sum,divisor);
	    }
	public static void main(String[] args) {
		Divide re = new Divide();
		System.out.println(re.divide(-2147483648, 1));
		
	}

}
