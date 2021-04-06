package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,nums,new ArrayList<>(),0);
        return result;
    }
    public void backtrack(List<List<Integer>> result,int[] nums,List<Integer> list,int start){
        result.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(result,nums,list,i+1);
            list.remove(list.size()-1);
        }
    }
	public static void main(String[] args) {
		Subsets subset = new Subsets();
		int[] nums= new int[] {1,2,3};
		subset.subsets(nums);
	}
}
