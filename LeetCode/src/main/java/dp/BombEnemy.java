package dp;

public class BombEnemy {
	    public int maxKilledEnemies(char[][] grid) {
	    	int res=0;
	    	int m = grid.length;
	    	int n = grid[0].length;
	    	int row=0;
	    	int[] col =new int[n];;
	    	for(int i=0;i<m;i++) {
	    		for(int j=0;j<n;j++) {
	    			if(j==0 || grid[i][j-1]=='W') {
	    				row=0;
	    				for(int k=j;k<n && grid[i][k] != 'W';k++) {
	    					if(grid[i][k]=='E') {
		    					row++;
		    				}
	    				}
	    			}
	    			if(i==0 || grid[i-1][j]=='W') {
	    				col[j] =0; 
	    				for(int k=i;k<m && grid[k][j] !='W';k++) {
	    					if(grid[k][j] =='E') {
	    						col[j] +=1;
	    					}
	    				}
	    			}
	    			if(grid[i][j]=='0' && row+col[j] >res) {
	    				res = row + col[j];
	    			}
	    		}
	    	}
	    return res;
	    }
	    
	    public static void main(String[] args) {
	    	BombEnemy re=  new BombEnemy();
	    	char[][] grid = {{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
	    	System.out.println(re.maxKilledEnemies(grid));
	    	
		}

}
