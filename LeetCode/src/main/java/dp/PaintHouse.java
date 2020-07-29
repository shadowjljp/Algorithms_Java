package dp;

public class PaintHouse {
	public int minCost(int[][] costs) {
		int[][] dp = costs;
		for(int i=1;i<costs.length;i++) {
			dp[i][0]=dp[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
			dp[i][1]=dp[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
			dp[i][2]=dp[i][2]+Math.min(dp[i-1][1],dp[i-1][0]);
		}
		int r =costs.length-1;
		return Math.min(dp[r][0], Math.min(dp[r][1], dp[r][2]));
	}
	public static void main(String[] args) {
		PaintHouse re = new PaintHouse();
		int[][] costs= {{17,2,17},{16,16,5},{14,3,19}};
		System.out.println(re.minCost(costs));
	}

}
