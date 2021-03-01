package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Moreon1091 {
	//private int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
	
    public char[][] shortestPathBinaryMatrix(char[][] grid,int x,int y) {
    	int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    	int m = grid.length;
    	int n = grid[0].length;
    	Queue<int[]> queue = new LinkedList<>();
    	Map<String,int[]> prev = new HashMap<>();
    	boolean[][] visited = new boolean[m][n];
    	queue.add(new int[] {x,y});
    	while(!queue.isEmpty()) {
    		int size=  queue.size();
    		while(size >0) {
    			int[] curr = queue.poll();
    			if(grid[curr[0]][curr[1]]=='E') {
    				return buildPath(grid,x,y,curr,prev);
    			}
    			for(int[] dir:dirs) {
    				int nextX = dir[0]+curr[0];
    				int nextY= dir[1]+curr[1];
    				if(nextX>=0 && nextX<m && nextY>=0 && nextY <n && visited[nextX][nextY]==false &&(grid[nextX][nextY]=='.' || grid[nextX][nextY]=='E')) {
    					visited[nextX][nextY]=true;
    					queue.add(new int[] {nextX,nextY});
    					
    					prev.put(nextX+"-"+nextY, curr);
    					
    				}
    			}
    			size--;
    		}
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	return null;
    	
    	
/*
        int m = grid.length;
        int n = grid[0].length;
        Map<String,int[]> prev = new HashMap<>();

        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y}); //start point
      
//        int ans=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] pop = queue.remove();
                if(grid[pop[0]][pop[1]]=='E') {
                    return markPath(prev,grid,x,y,pop);
                }
                for (int k=0;k<4;k++) {
                    int nextX = dir[k][0]+pop[0];
                    int nextY = dir[k][1]+pop[1];

                    if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && !visited[nextX][nextY] && (grid[nextX][nextY]=='.' || grid[nextX][nextY]=='E')  ) {
                        queue.add(new int[]{nextX,nextY});
                        int[] array = new int[2];
                        array[0]=nextX;
                        array[1]=nextY;                     
                        prev.putIfAbsent(array[0]+" "+array[1],pop);
                        visited[nextX][nextY]=true;
                    }

                }
            }
 //           ans++;
        }

        return null;*/
    }
    private char[][] buildPath(char[][] grid, int x, int y, int[] curr, Map<String, int[]> prev) {
		while( curr[0]!=x || curr[1] !=y) {
			int[] array = prev.get(curr[0]+"-"+curr[1]);
			if(array[0] !=x || array[1] !=y)
			grid[array[0]][array[1]]='*';
			curr[0]=array[0];
			curr[1]=array[1];
		}
		return grid;
	}
	public char[][] markPath(Map<String,int[]> prev,char[][] grid, int x, int y, int[] pop){
    	 int m = grid.length;
         int n = grid[0].length;
         int i=pop[0];
         int j=pop[1];
         while( pop[0] !=x || pop[1] !=y) {
        	 int[] pre = prev.get(pop[0]+" "+pop[1]);
        	 grid[pre[0]][pre[1]]='*';
        	 pop[0]=pre[0];
        	 pop[1]=pre[1];
         }
		return grid;
    }
	public static void main(String[] args) {
		Moreon1091 re = new Moreon1091();
		char[][] matrix= {
		 {'#','#','#','.','.','.','#','#','.','.'}
		,{'.','.','.','.','#','.','.','.','.','#'}
		,{'#','.','.','#','#','#','.','#','.','#'}
		,{'S','#','.','#','.','#','.','#','.','.'}
		,{'.','.','.','#','.','.','.','E','#','.'}}; //E=(4,2)   S=(3,0)
	
		char[][] res = re.shortestPathBinaryMatrix(matrix,3,0);
		for(char[] first: res) {
			for(char c : first) {
				System.out.print(c);
			}
			System.out.println();
		}

	}

}
