package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	 public List<List<Integer>> threeSum(int[] nums) {
		  List<List<Integer>> result = new ArrayList<>();
		  int l,r ;
		  Arrays.sort(nums);
		  
		  for(int i=0;i<nums.length-2;i++) {
			  l = i+1;
			  r=nums.length-1;
			  while(l<r) {
				  int compare = nums[i]+nums[l]+nums[r];
				  while(l<r && nums[i]==nums[i+1]&&i<nums.length-3){
	                    i++;
	                }
				  if(compare ==0) {
               while(l<r && nums[l]==nums[l+1]) {
					  l++;
				  }
				  while(l<r && nums[r]==nums[r-1]) {
					  r--;
				  }
					  List<Integer> temp = new ArrayList<>();
					  temp.add(nums[i]);
					  temp.add(nums[l]);
					  temp.add(nums[r]);
					  result.add(temp);
					  l++;
                     r--;
				  }else if(compare<0) {
					  l++;
				  }else {
					  r--;
				  }
			  }
		  }
		return result;
	    }
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		ThreeSum t = new ThreeSum();
		List<List<Integer>> r = t.threeSum(nums);
		for(List<Integer> a:r) {
				System.out.println(a);
		}
	}

}
