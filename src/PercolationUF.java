
public class PercolationUF implements IPercolate {

	private final int VTOP;
	private final int VBOTTOM;

	public PercolationUF (int n, IUnionFind finder) {
		finder.initialize(n*n + 2);
		VTOP = n*n;
		VBOTTOM = n*n + 1;
		
	}
	@Override
	public void open(int row, int col) {
		
			
	}
	
	@Override
	public boolean isOpen(int i, int j) {
		
		return false;
	}
	@Override
	public boolean isFull(int i, int j) {
		// TODO complete isFull
		return false;
	}
	@Override
	public boolean percolates() {
		// TODO complete percolates
		return false;
	}
	
	@Override
	public int numberOfOpenSites() {
		//TODO complete numberOfOpenSites
		return 0;
	}
}
