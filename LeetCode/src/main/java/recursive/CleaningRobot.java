package recursive;

import java.util.HashSet;
import java.util.Set;

interface Robot {
	  // returns true if next cell is open and robot moves into the cell.
	  // returns false if next cell is obstacle and robot stays on the current cell.
	  boolean move();

	  // Robot will stay on the same cell after calling turnLeft/turnRight.
	  // Each turn will be 90 degrees.
	  void turnLeft();
	  void turnRight();

	  // Clean the current cell.
	  void clean();
	}

public class CleaningRobot {
	public void cleanRoom(Robot robot) {
		Set<String> visited = new HashSet<>();
		int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
		helper(robot,visited,0,0,0,dirs);
	}
	private void helper(Robot robot,Set<String> visited,int x,int y ,int cur,int[][] dirs) {
		String s = x+"-"+y;
		if(visited.contains(s)) {
			return;
		}
		visited.add(s);
		robot.clean();
		
			for(int i=0;i<4;i++) {
				if(robot.move()) {
				 x =x+dirs[cur][i];
				 y =y+dirs[cur][i];
				 helper(robot,visited,x,y,cur,dirs);
				 robot.turnRight();
				 robot.turnRight();
				 robot.move();
				 robot.turnRight();
				 robot.turnRight();
				}
			 cur=(cur+i)%4;
			 robot.turnRight();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
