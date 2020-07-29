package recursive;

import java.util.HashMap;
import java.util.Map;

public class Fib_with_Memoization {
	 public int fib(int N) {
	        Map<Integer,Integer> map = new HashMap<>();
	        return helper(N,map);
	       
	    }
	    public int helper(int N,Map<Integer,Integer> map){
	        if(map.containsKey(N)){
	            return map.get(N);
	        }
	        int res;
	         if(N<2){
	            res= N;
	        }else{
	            res= fib(N-1)+fib(N-2);
	        }
	        map.put(N,res);
	        return res;
	    }
	public static void main(String[] args) {
		Fib_with_Memoization re = new Fib_with_Memoization();
		re.fib(4);
	}

}
