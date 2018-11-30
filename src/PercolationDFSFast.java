
public class PercolationDFSFast extends PercolationDFS {

	public PercolationDFSFast(int n) {
		super(n);	
	
	}
	@Override
	protected void updateOnOpen(int row, int col) {
		
		//int j = 0;
		//if j == 1;
		
		
		if(row == 0){
			myGrid[row][col] = FULL;	
		}
		else if(isFull(row -1, col) && inBounds(row-1, col)){
			myGrid[row][col] = FULL;
		}
		else if(isFull(row+1, col) && inBounds(row+1, col)) {
			myGrid[row][col] = FULL;
		}
		else if(isFull(row, col+1) && inBounds(row, col+1)) {
			myGrid[row][col] = FULL;
		}
		else if(isFull(row, col - 1) && inBounds(row, col -1)) {
				myGrid[row][col] = FULL;
		}
		if (myGrid[row][col] == FULL) {
			dfs(row, col);
		}
		
	} 
	
}
	

