package string;

import java.util.Stack;

public class DecodeString394 {
	 public String decodeString(String s) {
	        StringBuilder sb = new StringBuilder();
	        Stack<Integer> stack = new Stack<>();
	        for(int i=0;i<s.length();i++){
	        	char c = s.charAt(i);
	            if(Character.isDigit(c)){
	                stack.push(c-'0');
	            }else if(Character.isLetter(c)){
	            	int index = s.substring(i).indexOf("]");
	            	String frag = s.substring(i,index+i);
	            	i=index+i;
	                Integer cur = stack.pop();
	                while(cur>0){
	                    sb.append(frag);
	                    cur--;
	                }
	            }
	        }
	        return sb.toString();
	    }
	public static void main(String[] args) {
		DecodeString394 re = new DecodeString394();
		String s = "3[a2[c]]";
		System.out.println(re.decodeString(s));
		
	}

}
