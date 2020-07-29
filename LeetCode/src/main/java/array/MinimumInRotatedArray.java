package array;

public class MinimumInRotatedArray {
	 public int findMin(int[] nums) {
	        int l=0, r=nums.length-1;
	        while(l<r){
	            int mid = (r+l)/2;
	            if(Math.abs(nums[mid]-nums[l])<Math.abs(nums[mid]-nums[r])){
	                l = mid;
	            }else{
	                r=mid;
	            }
	        }
	        return nums[l];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
