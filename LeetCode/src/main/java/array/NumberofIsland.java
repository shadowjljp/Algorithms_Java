package array;

public class NumberofIsland {
public int numIslands(char[][] grid) {
	int hori = grid.length;
	int vert = grid[0].length;
	int count=0;
	for(int i=0;i<vert;i++) {
		for(int j=0;j<hori;j++) {
			if((i==vert-1||grid[i+1][j] =='0' ) &&(j==hori-1 || grid[i][j+1] =='0')) {
				count++;
			}
		}
	}
	return count;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
