package us.awpwo;

public class UF {

	protected int[] id;
	
	public UF(int N) {
		id = new int[N];
		for (int i = 0; i < N; ++i) {
			id[i] = i;
		}
	}
	
	public void union(int p, int q) {
	}
	
	public boolean connected(int p, int q) {
		return false;
	}
	
}