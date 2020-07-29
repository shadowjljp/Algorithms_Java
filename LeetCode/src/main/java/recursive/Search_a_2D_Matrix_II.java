package recursive;

public class Search_a_2D_Matrix_II {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 ||  matrix[0].length==0) return false;
         int r = matrix.length-1;
         int c = matrix[0].length-1;
        return helper(matrix,target,0,r,0,c);
    }
    public boolean helper(int[][] matrix,int target,int rS, int rE, int cS, int cE){
    	  if(rS < 0 || rE >= matrix.length || cS < 0 || cE >= matrix[0].length || rS > rE || cS > cE) return false;
          int cM =cS+(cE-cS)/2;
          int i=rS;
          if(matrix[i][cM]==target) return true;
          while(i<=rE && matrix[i][cM]<=target){   //normal algorithms
              if(matrix[i][cM]==target) return true;
              i++;
             
          }
         
          
          boolean a = helper(matrix,target,rS,i-1,cM+1,cE);// top right            
          boolean b = helper(matrix,target,i,rE,cS,cM-1);//down left  
          return  a||b;
    }
   
    
	public static void main(String[] args) {
		Search_a_2D_Matrix_II re = new Search_a_2D_Matrix_II();
//		int[][] sam = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//		int[][] sam = new int[][] {{-1,3}};
//		int[][] sam = new int[][] {{5,6}};
//		int[][] sam = new int[][] {{1,1}};
		int[][] sam = new int[][] {{1,7,9},{5,9,10}};
		System.out.println(re.searchMatrix(sam,5));
		
	}

}
