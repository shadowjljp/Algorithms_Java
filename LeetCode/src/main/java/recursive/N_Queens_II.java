package recursive;

public class N_Queens_II {
    int count=0;
    int[][] matrix;
   public int totalNQueens(int n) {
    matrix = new int[n][n];
      
       return helper(matrix,count,0);
   }
   public int helper(int[][] matrix,int count,int row){
       for(int j=0;j<matrix[0].length;j++){
           if(!is_under_attack(matrix,j,row)){
               //place queen
               matrix[row][j]=1;
               if(row+1==matrix.length){
                   count++;
               }else{
                   count=helper(matrix,count,row+1);
                   //next row
                   //delete queen
                   matrix[row][j]=0;
               }
             
           }
          
       }
       return count;
   }
   public boolean is_under_attack(int[][] matrix,int j,int row){
       int[][] dirs = {{1,1},{1,-1},{-1,1},{-1,-1},{1,0},{0,1},{0,-1},{-1,0}};
       for(int[] dir : dirs){
           for(int i=0;i<matrix.length;i++){
               if(row+dir[0]*i >=matrix.length ||j+dir[1]*i>=matrix[0].length||row+dir[0]*i<0 ||j+dir[1]*i<0){
               break;
           }
               if(matrix[row+dir[0]*i][j+dir[1]*i]==1) return true;
           }
       }
       return false;
   }
	public static void main(String[] args) {
		N_Queens_II res = new N_Queens_II();
		System.out.println(res.totalNQueens(4));
	}

}
