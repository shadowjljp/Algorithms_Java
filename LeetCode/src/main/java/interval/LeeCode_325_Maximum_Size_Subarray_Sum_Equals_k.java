package interval;

import java.util.HashMap;
import java.util.Map;

public class LeeCode_325_Maximum_Size_Subarray_Sum_Equals_k {
	public int maxSubArrayLen(int[] nums, int k) {
		int max=0;
		int sum=0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			sum +=nums[i];
			if(sum==k) {
				max = i+1;
			}
			if(map.containsKey(sum-k)) {
				max = Math.max(max, i-map.get(sum-k));
			}
			map.putIfAbsent(sum,i);
		}
		return max;
	}
	public static void main(String[] args) {
		LeeCode_325_Maximum_Size_Subarray_Sum_Equals_k re = new LeeCode_325_Maximum_Size_Subarray_Sum_Equals_k();
		int[] nums = {-2, -1, 2, 1};
		int k =1;
		System.out.println(re.maxSubArrayLen(nums, k));
		
	}

}
