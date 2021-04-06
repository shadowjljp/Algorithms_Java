package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<Integer> temp= new ArrayList<>();
	        Arrays.sort(candidates);
	        List<List<Integer>> result = new ArrayList<>();
	        int subsum=0;
	        backtrack(temp,result,candidates,target,0,subsum);
	        return result;
	    }
	    public void backtrack(List<Integer> temp,List<List<Integer>> result,int[] candidates,int target,int start,int subsum){
	      if(subsum > target){

	    	  return;
	      }else if(subsum==target){
	          result.add(new ArrayList<>(temp));
	      }else{
	          for(int i=start;i<candidates.length;i++){
	              subsum +=candidates[i];
	              temp.add(candidates[i]);
	              backtrack(temp,result,candidates,target,i,subsum);
	              temp.remove(temp.size()-1);
	              subsum-=candidates[i];
	          }
	      }
	    }
	public static void main(String[] args) {
		Combination_Sum cs = new Combination_Sum();
		int[] candidates = new int[] {2,3,6,7};
		int target=7;
		cs.combinationSum(candidates, target);
	}

}
