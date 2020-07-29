package recursive;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	  public List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> res = new ArrayList<>();
	        helper(res, new ArrayList<Integer>(), k, 1, n-k+1);
	        return res;
	    }
	    public void helper(List<List<Integer>>res,ArrayList<Integer> list,int kLeft,int from,int to){
	        if(kLeft==0){ res.add(new ArrayList<Integer>(list)); return ;}
	        for(int i=from;i<=to;i++){
	            list.add(i);
	            helper(res,list,kLeft-1,i+1,to+1);
	            list.remove(list.size()-1);
	            
	        }
	    }
	public static void main(String[] args) {
		Combinations re = new Combinations();
		re.combine(4, 3);
	}

}
