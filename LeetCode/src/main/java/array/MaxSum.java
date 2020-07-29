package array;

public class MaxSum {
	   public int maxSubArray(int[] nums) {
		    int l =0,r=nums.length-1;
		        return maxBothArray(nums,l,r);
		    }
	   public int maxMiddleArray(int[] nums,int l,int r,int m) {
		   //add left half
		   int sum=0;
		   int leftSum = Integer.MIN_VALUE;
		   for(int i=m;i>=l;i--) {
			  // sum =Math.max(sum+nums[i], nums[i]);
			   sum +=nums[i];
			   if(sum>leftSum) {
				   leftSum=sum;
			   }
		   }
		   //add right half
		   sum=0;
		   int rightSum = Integer.MIN_VALUE;
		   for(int i=m+1;i<=r;i++) {
			 // sum =Math.max(sum+nums[i], nums[i]);
			   sum +=nums[i];
			   if(sum>rightSum) {
				   rightSum = sum;
			   }
		   }
		   //return total
		  
		   return  leftSum+rightSum;
	   }
	   public int maxBothArray(int[] nums,int l,int r) {
		   if(l ==r) return nums[l];
		   
		   int m=(l+r)/2;
		   int temp = Math.max(maxBothArray(nums,l,m), maxBothArray(nums,m+1,r));
		int result =Math.max(temp,maxMiddleArray(nums,l,r,m) );
		   return result;
		   
		    
	   }
/*	   public int maxBothArray1(int[] nums,int l,int r) {
		   if(l ==r) return nums[l];
		   
		   int m=(l+r)/2;
		 
		   int temp = Math.max(maxBothArray1(nums,l,m), maxBothArray1(nums,m+1,r));
		   return temp;
		   
		    
	   }*/
	public static void main(String[] args) {
			MaxSum m = new MaxSum();
			int[] nums ={-2,1,-3,4,-1,2,1,-5,4};
			int[] nums1 ={1,2,3,4,5,6,7,8,9};
				//{2, 3, 4, 5, 7};
				//
				//
			 int l =0,r=nums1.length-1;
			System.out.println(m.maxSubArray(nums));
//			System.out.println(m.maxBothArray1(nums1,l,r));
	}

}
