package mz;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Maze extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*for maze*/
	private NumberCell[][] maze;
	private Wall[] wall;
	private Random random;
	/*for GUI setting*/
	private static final int INIT_SIZE = 800;
	private GridLayout grid;
	/*form a  maze first*/
	public Maze(int column,int row) { 
		//internal walls numbers
		int internalWalls = 2 * column * row-(column+row);
		this.wall = new Wall[internalWalls];
		this.maze = new NumberCell[column][row];
		this.random = new Random();
		int num=0;
		  for (int i = 0; i < row; i++) {
	            for (int j = 0; j < column; j++) {
	            	this.maze[i][j] = new NumberCell();
	            	if(j==column-1) { //the most east side cell need east wall
	            		this.maze[i][j].setEast(true);
	            	}
	            	if(i==row-1) { //the most South side cell need South wall
	            		this.maze[i][j].setSouth(true);
	            	}
	            	if(i==row-1 && j==column-1) { //exit point don`t need east wall
	            		this.maze[i][j].setEast(false);
	            	}
	            	if(i==0 && j==0) { //starting point don`t need west wall
	            		 this.maze[i][j].setWest(false);
	            	}
	            	if(i<row-1) { //store only the inside wall exclude the periphery walls
	            		this.wall[num++] = new Wall(i,j,'h');
	            	}
	            	if(j<column-1) { //store only the inside wall exclude the periphery walls
	            		this.wall[num++] = new Wall(i,j,'v');
	            	}
	          }
	       }
	   }
	/*Start taking down wall randomly*/
	public void generateMaze() {
		
        int rows = this.getNumRows();
        int cols = this.getNumCols();
      

        /* The number of cells in the maze. */
        int numCells = rows * cols;

        /* DisjSets class from text book. */
        DisjSets disjoint = new DisjSets(numCells);
       
        /* While there are more than two subsets in the maze, remove walls. */
        int count;
        do{
        	 count=0;
        	for(int i =0;i<numCells-2;i++) {
        		if(disjoint.find(i) !=disjoint.find(i+1)) {
        			count++;
        		}
        	}
        	
            /* Find a random wall in the 1D array of walls to delete. */
            Wall randWall = this.wall[this.random.nextInt(this.wall.length)];

            int row = randWall.getRow();
            int col = randWall.getColumn();
            int currentCell = row * cols + col;

            /* orientation is horizontal. */
            if (randWall.getOrientation() == 'h') {

                int adjCell = (row + 1) * cols + col; //adjacent cell

                /* If there is no path between the cells, knock down a wall. */
                if (disjoint.find(currentCell) != disjoint.find(adjCell)) {
                    this.maze[row + 1][col].setNorth(false);
                    disjoint.union(disjoint.find(currentCell), disjoint.find(adjCell));
                }

            } else /* orientation is vertical */ {

                int adjCell = row * cols + col + 1;

                /* If there is no path between the cells, knock down a wall. */
                if (disjoint.find(currentCell) != disjoint.find(adjCell)) {
                    this.maze[row][col + 1].setWest(false);
                    disjoint.union(disjoint.find(currentCell), disjoint.find(adjCell));
                }

            }
        }while(count>1);
	}
	
	

	  public int getNumRows() {
	        return this.maze.length;
	    }
	  public int getNumCols() {
	        return this.maze[0].length;
	    }
	  public NumberCell MazeLocation(int row,int col) {
		  return this.maze[row][col];
	  }
	  
	  //GUI image part:
	  public void Setting() {
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(INIT_SIZE, INIT_SIZE);
			this.grid = new GridLayout(getNumRows(), getNumCols());
			this.setLayout(this.grid);
	  }
	  public void ShowGUI() {
			for (int row = 0; row < getNumRows(); row++) {
				for (int col = 0; col < getNumCols(); col++) {
					this.add(new MyImage(this.findImageFilePath(MazeLocation(row, col))));
				}
			}
			this.setVisible(true);
		}

		private String findImageFilePath(NumberCell cell) {
			String path = "";
			if (!cell.hasNorth())
				path += "n";

			if (!cell.hasSouth())
				path += "s";

			if (!cell.hasEast())
				path += "e";

			if (!cell.hasWest())
				path += "w";

			if (path.equals(""))
				path = "se";

			return "src/mz/tiles/wall_" + path + ".png";

		}

		private class MyImage extends JLabel {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			// for image
			ImageIcon imageIcon;

			public MyImage(String path) {
				this.imageIcon = new ImageIcon(path);
			}
			
			  
		        public void paintComponent(Graphics g) {
		            super.paintComponent(g);
		            g.drawImage(this.imageIcon.getImage(), 0, 0, 
		                getWidth(), getHeight(), this);
		        }
		}
}
