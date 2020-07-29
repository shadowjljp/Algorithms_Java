package mz;
/*Building maze will use it*/
public class NumberCell {
	private boolean north;
	private boolean south;
	private boolean east;
	private boolean west;
	
	public NumberCell() {
		//avoid multiple walls at the same place, every cell`s default is n&w like ---
																	// 			   |
		this.north=true;
		this.west=true;
		this.south =false;
		this.east = false;
	}
	//whether north has wall or not
	public boolean hasNorth() {
		return north;
	}

	public void setNorth(boolean north) {
		this.north = north;
	}

	public boolean hasSouth() {
		return south;
	}

	public void setSouth(boolean south) {
		this.south = south;
	}

	public boolean hasEast() {
		return east;
	}

	public void setEast(boolean east) {
		this.east = east;
	}

	public boolean hasWest() {
		return west;
	}

	public void setWest(boolean west) {
		this.west = west;
	}
	
}