package dp;

public class DungeonGame {
	  public int calculateMinimumHP(int[][] dungeon) {
		  int min = dungeon[0][0];
	        int r =dungeon.length;
	        int c = dungeon[0].length;
	        for(int i=0;i<r;i++){
	            for(int j=0;j<c;j++){
	            	if(j==c-1 && i==r-1) {
	            		dungeon[i][j] = dungeon[i][j];
	            	}else 	if(j==c-1) {
	            		dungeon[i][j]+=dungeon[i+1][j];
	            	}else if(i==r-1) {
	            		dungeon[i][j]+=dungeon[i][j+1];
	            	}else {
	            		 dungeon[i][j]+=Math.max(dungeon[i+1][j],dungeon[i][j+1]);
	            	}
	                if(dungeon[i][j]<min){
	                    min=dungeon[i][j];
	                }
	            }
	        }
	        for(int i=0;i<r;i++){
	        	
	            for(int j=0;j<c;j++){
	            	System.out.println(dungeon[i][j]);
	            }
	            System.out.println();}
	        return min<0 ? 1-min : min;
	  }
	public static void main(String[] args) {
		DungeonGame re = new DungeonGame();
		int[][] dungeon = new int[][] {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		re.calculateMinimumHP(dungeon);
	}

}
