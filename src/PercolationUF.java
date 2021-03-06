
public class PercolationUF implements IPercolate {

	private int myOpenCount;
	private final int VTOP;
	private final int VBOTTOM;
	private final IUnionFind myFinder; 
	private final boolean [][]myGrid; 

	public PercolationUF (int n, IUnionFind finder) {
		finder.initialize(n*n + 2); 
		myFinder = finder;
		VTOP = n*n;
		VBOTTOM = n*n + 1;
		myGrid = new boolean[n][n];
		myOpenCount = 0;
	}
	@Override
	public void open(int row, int col) {
		if(!inBounds(row,col)) {
			throw new IndexOutOfBoundsException (
					String.format("(%d,%d) not in bounds", row,col));
		}
		if(myGrid[row][col] == true) {
			return;
		}
		myGrid[row][col] = true;
		myOpenCount++;
		
		if(row == 0) {
			myFinder.union(helper(row,col), VTOP);
		}
		if(row == myGrid.length - 1) {
			myFinder.union(helper(row,col), VBOTTOM);
		}
		
		if(inBounds(row+1, col) && myGrid[row+1][col] == true) {
			myFinder.union(helper(row+1, col), helper(row, col));
		}
		if(inBounds(row, col+1)&& myGrid[row][col+1] == true ) {
			myFinder.union(helper(row, col+1), helper(row, col));
		}
		if(inBounds(row-1,col) && myGrid[row-1][col] == true) {
			myFinder.union(helper(row-1, col), helper(row, col));
		}
		if(inBounds(row,col-1) && myGrid[row][col-1] == true) {
			myFinder.union(helper(row, col-1), helper(row, col));
		}
	}
	public int helper(int row, int col) {
		int size = myGrid.length;
		int val = row*size + col;
		return val;
	}
	@Override
	public boolean isOpen(int i, int j) {
		if(!inBounds(i,j)) {
			throw new IndexOutOfBoundsException (
					String.format("(%d,%d) not in bounds", i,j));
		}
		return myGrid[i][j] == true; 
	}
	@Override
	public boolean isFull(int i, int j) {
		if (! inBounds(i,j)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", i,j));
		}
		if(myFinder.connected(VTOP, helper(i,j))) {
			return true;
		}
			return false;
	}
	@Override
	public boolean percolates() {
		return myFinder.connected(VTOP, VBOTTOM);
	}
	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}
	protected boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}

}
