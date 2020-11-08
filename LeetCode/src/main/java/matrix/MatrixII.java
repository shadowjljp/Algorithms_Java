package matrix;

public class MatrixII {
	
	    public int[][] generateMatrix(int n) {
	        int[][] matrix = new int[n][n];
	        int cb=0,ce=n-1,rb=0,re=n-1;
	        int value=1;
	        while(cb<=ce && rb<=re){
	            for(int i=cb;i<=ce;i++){
	                matrix[rb][i]=value;
	                value++;
	            }
	            rb++;
	            for(int i=rb;i<=re;i++){
	                matrix[i][ce]=value;
	                value++;
	            }
	            ce--;
	            for(int i=ce;i>=cb;i--){
	                matrix[ce][i]=value;
	                value++;
	            }
	            re--;
	            for(int i=re;i>=rb;i--){
	                matrix[i][cb]=value;
	                value++;
	            }
	            cb++;
	        }
	        return matrix;
	    }
	
	public static void main(String[] args) {
		MatrixII m = new MatrixII();
		m.generateMatrix(3);

	}

}
