package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class WallsandGate286 {
	public void wallsAndGates(int[][] rooms) {
		for(int i=0;i<rooms.length;i++) {
			for(int j=0;j<rooms[i].length;j++) {
				if(rooms[i][j]==0)
				dfs(rooms,i,j,0);
			}
		}
	}
	private void dfs(int[][] rooms, int i, int j, int k) {
		if(i<0 || j<0 || i>=rooms.length || j>=rooms[i].length || rooms[i][j]<k) return;
		rooms[i][j]=k;
		dfs(rooms,i+1,j,k+1);
		dfs(rooms,i,j+1,k+1);
		dfs(rooms,i-1,j,k+1);
		dfs(rooms,i,j-1,k+1);
	}
	public void wallsAndGatesBFS(int[][] rooms) {
		int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0;i<rooms.length;i++) {
			for(int j=0;j<rooms[i].length;j++) {
				if(rooms[i][j]==0) queue.offer(new int[] {i,j});
			}}
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int distance = rooms[cur[0]][cur[1]];
			for(int[] dir : dirs) {
				int x=  cur[0]+dir[0];
				int y = cur[1]+dir[1];
				if(x>=0 && x<rooms.length && y>=0 && y<rooms[0].length && rooms[x][y]>distance+1) {
					if(rooms[x][y]==Integer.MAX_VALUE) {
						rooms[x][y]=distance+1;
						queue.offer(new int[] {x,y});
					}
				}
			}
				
			
		}
	}
	public void print(int[][] target) {
		for(int[] t : target) {
			for(int a : t) {
				System.out.print(a+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		WallsandGate286 re = new WallsandGate286();
		int[][] rooms = new int[][] {{Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE},{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},{Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},{0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}};
		re.wallsAndGatesBFS(rooms);
		re.print(rooms);
	}

}
