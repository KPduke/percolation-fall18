import java.util.*;

public class PercolationBFS extends PercolationDFSFast{

	public PercolationBFS(int n) {
		super(n);
	}
	@Override
	protected void dfs(int row, int col) {
		
		if(!inBounds(row,col)) {
			throw new IndexOutOfBoundsException (
					String.format("(%d,%d) not in bounds", row,col));
		}
		int size = myGrid.length;
		int val = row*size + col;
		
		Queue<Integer> queInt = new LinkedList<>();  
		
		myGrid[row][col] = FULL;
		queInt.add(val);
		
		while(queInt.size() !=0) {
			int value = queInt.remove();
		
			int nrow = value/size;
			int ncol = value%size;
			
			if(inBounds(nrow-1, ncol)&& !isFull(nrow-1, ncol) && isOpen(nrow-1, ncol)){
				myGrid[nrow-1][ncol] = FULL;
				int newval = (nrow -1) * size + ncol;
				queInt.add(newval);
			} 
			if(inBounds(nrow+1, ncol) && !isFull(nrow+1, ncol) && isOpen(nrow +1, ncol)) {
				myGrid[nrow+1][ncol] = FULL;
				int newval = (nrow +1) * size + ncol;
				queInt.add(newval);
			}
			if(inBounds(nrow, ncol+1) && !isFull(nrow, ncol+1) && isOpen(nrow, ncol+1)) {
				myGrid[nrow][ncol+1] = FULL;
				int newval = nrow * size + (ncol+1);
				queInt.add(newval);
			}
			if(inBounds(nrow, ncol -1) && !isFull(nrow, ncol-1) && isOpen(nrow, ncol-1)) {
					myGrid[nrow][ncol-1] = FULL;
					int newval = nrow * size + (ncol-1);
					queInt.add(newval);
			}
		}
	}
}

