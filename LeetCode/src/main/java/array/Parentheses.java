package array;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {
	 List<String> result = new ArrayList<>();

	    public List<String> generateParenthesis(int n) {
	        int left =0,right=0;
	        generateResult( n, left, right,"");
	     return   result;
	    }
	    public void generateResult(int n,int left,int right,String str){
	        if(str.length() ==2*(n)){
	           result.add(str);
	            return;
	        }
	        
	        if(left<n){
	        	//why  str += "(" output will be [ (()), (()( ] ???? 
	        	//only str + "(" works correctly as the output become [ (()), ()() ]
	            generateResult(n, left+1, right, str+"(" );
	        }
	        if(right<left){
	        	//why  str += "(" output will be [ (()), (()( ] ????  
	        	//only str + "(" works correctly as the output become [ (()), ()() ]
	            generateResult(n, left, right+1,  str + ")");
	        }
	    }
	public static void main(String[] args) {
		Parentheses p = new Parentheses();
	System.out.println(	p.generateParenthesis(2));
	}

}
