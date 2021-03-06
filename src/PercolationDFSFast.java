
public class PercolationDFSFast extends PercolationDFS {

	public PercolationDFSFast(int n) {
		super(n);	
	}
	@Override
	protected void updateOnOpen(int row, int col) {
		
		if(!inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		if(row == 0){
			dfs(row,col);
		}
		else if(inBounds(row-1, col) && isFull(row -1, col)){
			dfs(row,col);
		}
		else if(inBounds(row+1, col) && isFull(row+1, col)) {
			dfs(row,col);
		}
		else if(inBounds(row, col+1) && isFull(row, col+1)) {
			dfs(row,col);
		}
		else if( inBounds(row, col -1) && isFull(row, col - 1)) {
			dfs(row,col);
		}
		
	} 
	
}
	

