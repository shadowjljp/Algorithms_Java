package binarySearch;

public class Sqrt {
	 public int mySqrt(int x) {
	        int l =1;
	        int r=x;
	        while(r>=l){
	            int m =(r+l)>>>1;
	            if(m==x/m){
	                return m;
	            }else if(m> x/m){
	                r=m-1;
	            }else{
	                if((m+1)>x/(m+1)){
	                    return m;
	                }
	                l=m+1;
	            }
	        }
	        return r;
	    }

	public static void main(String[] args) {
		Sqrt res = new Sqrt();
		System.out.println(res.mySqrt(2147395599));
		
	}

}
