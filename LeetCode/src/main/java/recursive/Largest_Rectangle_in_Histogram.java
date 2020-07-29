package recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Largest_Rectangle_in_Histogram {
	public static int largestRectangleArea(int[] height) {
	    if (height == null || height.length == 0) {
	        return 0;
	    }
	    int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
	    int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
	    lessFromRight[height.length - 1] = height.length;
	    lessFromLeft[0] = -1;

	    for (int i = 1; i < height.length; i++) {
	        int p = i - 1;

	        while (p >= 0 && height[p] >= height[i]) {
	            p = lessFromLeft[p];
	        }
	        lessFromLeft[i] = p;
	    }

	    for (int i = height.length - 2; i >= 0; i--) {
	        int p = i + 1;

	        while (p < height.length && height[p] >= height[i]) {
	            p = lessFromRight[p];
	        }
	        lessFromRight[i] = p;
	    }

	    int maxArea = 0;
	    for (int i = 0; i < height.length; i++) {
	        maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
	    }

	    return maxArea;
	}
	
	 public List<List<Integer>> subsets(int[] nums) {
		    List<List<Integer>> list = new ArrayList<>();
		    Arrays.sort(nums);
		    backtrack(list, new ArrayList<>(), nums, 0);
		    return list;
		}

		private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
		    list.add(new ArrayList<>(tempList));
		    for(int i = start; i < nums.length; i++){
		        tempList.add(nums[i]);
		        backtrack(list, tempList, nums, i + 1);
		        tempList.remove(tempList.size() - 1);
		    }
		    
		}
		 public List<List<Integer>> subsetsWithDup(int[] nums) {
			    List<List<Integer>> list = new ArrayList<>();
			    Arrays.sort(nums);
			    backtrack2(list, new ArrayList<>(), nums, 0);
			    return list;
			}

			private void backtrack2(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
			    list.add(new ArrayList<>(tempList));
			    for(int i = start; i < nums.length; i++){
			        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
			        tempList.add(nums[i]);
			        backtrack2(list, tempList, nums, i + 1);
			        tempList.remove(tempList.size() - 1);
			    }
			}
			public List<List<Integer>> permuteUnique(int[] nums) {
			    List<List<Integer>> list = new ArrayList<>();
			    Arrays.sort(nums);
			    backtrack3(list, new ArrayList<>(), nums, new boolean[nums.length]);
			    return list;
			}

			private void backtrack3(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
			    if(tempList.size() == nums.length){
			        list.add(new ArrayList<>(tempList));
			    } else{
			        for(int i = 0; i < nums.length; i++){
			            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
			            used[i] = true; 
			            tempList.add(nums[i]);
			            backtrack3(list, tempList, nums, used);
			            used[i] = false; 
			            tempList.remove(tempList.size() - 1);
			        }
			    }
			}
			  public List<String> letterCombinations(String digits) {
			        StringBuilder sb = new StringBuilder();
			        List<String> res = new ArrayList<>();
			         if(digits==null || digits.length()==0) return res;
			        char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
			        helper(res,sb,0,digits,map);
			        return res;
			    }
			    public void helper(List<String> res, StringBuilder sb,int start,String digits,char[][] map){
			        if(start==digits.length()){
			            res.add(sb.toString());
			            return;
			        }else{
			            int num = digits.charAt(start)-'0';
			            for(int i=0;i<map[num].length;i++){
			               sb.append(map[num][i]);
			            helper(res,sb,start+1,digits,map);
			            sb.deleteCharAt(sb.length()-1); 
			            }
			            
			        }
			    }
	public static void main(String[] args) {
		Largest_Rectangle_in_Histogram re = new Largest_Rectangle_in_Histogram();
		int[] height = {2,1,5,6,2,3};
		//re.largestRectangleArea(height);
		int[] nums= {1,2,3};
		//re.subsets(nums);
		int[] nums2= {1,2,2};
		//re.subsetsWithDup(nums2);
		int[] nums3= {1,1,2};
		//re.permuteUnique(nums3);
		String digits ="235";
		re.letterCombinations(digits);
	}
}
