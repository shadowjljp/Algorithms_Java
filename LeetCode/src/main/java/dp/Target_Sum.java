package dp;

public class Target_Sum {
	 public int findTargetSumWays(int[] nums, int S) {
	        int sum =0;
	        for(int num : nums){
	            sum +=num;
	        }
	        int target = S +sum;
	        if(target%2 !=0){
	            return 0;
	        }
	        target /= 2;
	        return helper(nums,target);
	        
	    }
	    public int helper(int[] nums,int s){
	        int[] dp = new int[s+1];
	        dp[0]=1;
	        for(int num :nums){
	            for(int i=s;i>=num;i--){
	                dp[i] =dp[i]+dp[i-num];
	            }
	        }
	        return dp[s];
	    }
	public static void main(String[] args) {
		Target_Sum t = new Target_Sum();
		int[] nums = {1000};
		System.out.println(t.findTargetSumWays(nums, 1000));
		
	}

}
