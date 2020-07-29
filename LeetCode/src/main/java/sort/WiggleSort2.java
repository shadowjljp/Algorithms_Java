package sort;

import java.io.UnsupportedEncodingException;

public class WiggleSort2 {
	 public void wiggleSort(int[] nums) {
	        for(int i=0;i<nums.length-1;i++){
	            if(i%2==0 && nums[i] >= nums[i+1] ){
	                if(nums[i]==nums[i+1]){
	                    int k = i+1;
	                    while(nums[i+1]==nums[k+1] || nums[i]>nums[k+1]){
	                        k++;
	                    }
	                        int temp = nums[i+1];
	                        nums[i+1] = nums[k+1];
	                        nums[k+1] = temp;
	                    
	                        continue;
	                }
	                int temp = nums[i];
	                nums[i]=nums[i+1];
	                nums[i+1]=temp;
	            }else if( i%2==1 && nums[i] <= nums[i+1]){
	                 if(nums[i]==nums[i+1]){
	                    int k = i+1;
	                    while(nums[i+1]==nums[k+1] || nums[i]<nums[k+1]){
	                        k++;
	                    }
	                        int temp = nums[i+1];
	                        nums[i+1] = nums[k+1];
	                        nums[k+1] = temp;
	                    
	                        continue;
	                }
	                int temp = nums[i];
	                nums[i]=nums[i+1];
	                nums[i+1]=temp;
	            }
	        }
	    }
	public static void main(String[] args) {
		WiggleSort2 re = new WiggleSort2();
		int[] nums= {1,2,2,1,2,1,1,1,1,2,2,2};
		re.wiggleSort(nums);
		for(int n : nums) {
			//System.out.println(n+" , ");
			
		}
		   
	}

}
