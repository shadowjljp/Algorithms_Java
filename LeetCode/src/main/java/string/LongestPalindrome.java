package string;

public class LongestPalindrome {
	  public String longestPalindrome(String s) {
	        int mid = s.length()/2;
	        int end = s.length();
	        String startPoint = s.substring(0,1);
	        String result = "";
	        for(int i=0;i<end;i++){
	             result = "" ;
	            
	            for(int j =0;j+i<s.length();j++){
	            	if(i-j>0) {
	            		if(s.charAt(i-j) == s.charAt(i+j)){
		                    result = s.substring(i-j,i+j+1);
		                }

	            	}
	                	if(result !=null) {
	                		
	                	result = startPoint.length()<= result.length() ? result :startPoint;
	                	startPoint = result;
	                }
	                
	            }
	        }
			return result;
	    }
	public static void main(String[] args) {
		LongestPalindrome l = new LongestPalindrome();
		System.out.println( l.longestPalindrome("babad"));
	}

}
