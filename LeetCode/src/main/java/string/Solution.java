package string;

public class Solution {
	 public String numberToWords(int num) {
	        String[] base ={"Zero","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine ","Ten ","Eleven ","Twelve ","Thirteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen Nineteen "};
	        String[] tenth = {"","Ten ","Twenty ","Thirty ","Fourty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
	       
	        StringBuilder sb = new StringBuilder();
	        int B= num/1000000000;
	        if(B !=0){
	            sb.append(base[B]+"Billion ");
	        }
	        int M = num%1000000000/1000000;
	        if(M !=0){
	            spiral(M,base,tenth,sb);
	            sb.append("Million ");
	        }
	        int T = num%1000000/1000;
	        if(T !=0){
	           spiral(T,base,tenth,sb);
	            sb.append("Thousand ");
	        }
	        int H = num%1000;
	        if(H !=0){
	            spiral(H,base,tenth,sb);
	        }
	        return sb.toString();
	    }
	     public void spiral(int num,String[] base,String[] tenth,StringBuilder sb){
	         if(num/100 !=0){
	             String n = base[num/100];
	             sb.append(n+"Hundred ");
	         }
	         if(num%100 !=0){
	             int n =num%100;
	             if(n<20){
	                 sb.append(base[n]);
	             }else{
	                 n=num%100/10;
	                 sb.append(tenth[n]+base[num%10]);
	             }
	         }
	     }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numberToWords(0));
	}

}
