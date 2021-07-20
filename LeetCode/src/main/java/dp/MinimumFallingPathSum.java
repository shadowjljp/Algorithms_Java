package dp;

public class MinimumFallingPathSum {
	 public int minFallingPathSum(int[][] matrix) {
	        int n = matrix.length;
	        int[] pre = new int[n];
	        int[] cur = new int[n];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                if(j==n-1){
	                    cur[j] = matrix[i][j] + Math.min(pre[j],pre[j-1]);
	                }else if(j==0){
	                    cur[j] = matrix[i][j] + Math.min(pre[j],pre[j+1]);
	                }else{
	                    cur[j] = matrix[i][j] + Math.min(pre[j],Math.min(pre[j-1],pre[j+1]));
	                } 
	            }
	            pre = cur.clone();
	        }
	        int min=Integer.MAX_VALUE;
	        for(int i=0;i<n;i++){
	            min = Math.min(min,cur[i]);
	        }
	        return min;
	    }
	public static void main(String[] args) {
		MinimumFallingPathSum re = new MinimumFallingPathSum();
		int[][] matrix = {{-19,57},{-40,-5}};
		System.out.print(re.minFallingPathSum(matrix ));
		
	}
}
