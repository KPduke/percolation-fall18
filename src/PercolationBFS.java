import java.util.*;

public class PercolationBFS extends PercolationDFSFast{

	public PercolationBFS(int n) {
		super(n);
	}
	
	@Override
	protected void dfs(int row, int col) {

		int size = myGrid.length;
		int val = row*size + col;
		
		Queue<Integer> queInt = new LinkedList<>();  
		
		myGrid[row][col] = FULL;
		queInt.add(val);
		
		while(queInt.size() !=0) {
			int value = queInt.remove();
		
			int nrow = value/size;
			int ncol = value%size;
			
			if(!isFull(nrow-1, ncol) && inBounds(nrow-1, ncol) && isOpen(nrow-1, ncol)){
				myGrid[nrow-1][ncol] = FULL;
				int newval = (nrow -1) * size + ncol;
				queInt.add(newval);
			}
			if(!isFull(nrow+1, ncol) && inBounds(nrow+1, ncol) && isOpen(nrow +1, ncol)) {
				myGrid[nrow+1][ncol] = FULL;
				int newval = (nrow +1) * size + ncol;
				queInt.add(newval);
			}
		
			if(!isFull(nrow, ncol+1) && inBounds(nrow, ncol+1) && isOpen(nrow, ncol + 1)) {
				myGrid[nrow][col+1] = FULL;
				int newval = nrow * size + (ncol+1);
				queInt.add(newval);
			}
			if(!isFull(nrow, ncol - 1) && inBounds(nrow, ncol -1) && isOpen(nrow, ncol - 1)) {
					myGrid[nrow][ncol-1] = FULL;
					int newval = nrow * size + (ncol-1);
					queInt.add(newval);
			}
			
		}
		
	}
	
        
	
		
}
