package string;

import java.util.Stack;

public class Test {
	 public int longestSubstring(String s, int k) {
	        int d=0;
	        for(int numUniqueTarget =1;numUniqueTarget <=26;numUniqueTarget++){
	            d= Math.max(d,helper(s,k,numUniqueTarget));
	        }
	        return d;
	    }
	    public int helper(String s,int k ,int numUniqueTarget){
	        int[] map = new int[128];
	        int numUnique =0;
	        int numNoLessThanK =0;
	        int start=0; int end=0;
	        int d=0;
	        while(end<s.length()){
	            if(map[s.charAt(end)]++ ==0) numUnique++;
	            if(map[s.charAt(end++)]==k) numNoLessThanK++;
	            
	            
	            while(numUnique>numUniqueTarget){
	                if (map[s.charAt(start)]-- == k) numNoLessThanK--; // decrement map[c] after this statement
	            if (map[s.charAt(start++)] == 0) numUnique--; // inc begin after this statement
	            }
	            
	             if (numUnique == numUniqueTarget && numUnique == numNoLessThanK)
	            d = Math.max(end - start, d);
	        }
	        return d;
	    }
	    public void origninal() {
	    	int a=0;
	    	int b=0;
	    	add(a,b);
	    	System.out.println("a= "+a+" b= "+b);
	    }
	    public void add(int a,int b) {
	    	a=1;
	    	b=1;
	    }
	    public String decodeString(String s) {
	        Stack<Integer> numStack = new Stack<>();
	        Stack<StringBuilder> stack = new Stack<>();
	        StringBuilder sb = new StringBuilder();
	        int num=0;
	        for(int i=0;i<s.length();i++){
	            char c = s.charAt(i);
	            if(Character.isDigit(c)){
	                num = 10*num +c-'0';
	            }else if(c=='['){
	                stack.push(sb);
	                numStack.push(num);
	                sb = new StringBuilder();
	                num=0;
	            }else if(c==']'){
	                num = numStack.pop();
	                StringBuilder cur =stack.pop();
	                while(num >0){
	                   cur.append(sb);
	                   num--;
	                } 
	                sb = cur;
	            }else{
	                sb.append(c);
	            }
	        }
	        return sb.toString();
	    }
	public static void main(String[] args) {
		/*String myStr = "Helloz";
		  String s = " lee                            tc  od e ";
		  //regex
		  System.out.println(s.trim().replaceAll("\\s+"," "));
	    System.out.println("result= "+myStr.indexOf("z"));
	    //char to number
	    int a = myStr.charAt(5) - 'a';
	    System.out.println("number is "+a);
	    
	    byte[] array2 = null;
		byte [] array3 = null;
		try {
			array2 = myStr.getBytes("UTF-8");
			array3 = myStr.getBytes();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    for(byte b1: array2){
            System.out.print(b1);
         }
	    
	    
        System.out.print("\ndefault Charset encoding:");
        for(byte b2: array3){
           System.out.print(b2);
        }*/
//		int n=27;
//		System.out.println((char)('A' + (n % 26)));
		Test t =new Test();
//		System.out.println(t.romanToInt("LVIII"));
//		String s = new String(new char[3]).replace('\0', ' ');
//		System.out.println("s"+s+"s");
//		t.longestSubstring("abdadfasdg", 2);
		//t.origninal();
//		boolean i= true|| false;
	//	System.out.println(i);
		String s = "3[a]2[bc]";
		System.out.println(t.decodeString(s));
		
	}

}
