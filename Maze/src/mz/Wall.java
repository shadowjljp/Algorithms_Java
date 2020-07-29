package mz;

/*Indicate the location of the walls so we can delete some of them randomly with ease*/
public class Wall {
	private int row;
	private int column;
	private char orientation;
	
	public Wall(int r,int col,char ori) {
		this.row= r;
		this.column = col;
		this.orientation = ori;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public char getOrientation() {
		return orientation;
	}
	public void setOrientation(char orientation) {
		this.orientation = orientation;
	}
	
	
	
}
