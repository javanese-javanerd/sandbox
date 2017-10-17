package Question1;

/**
 * A helper object to store boundary values.
 */
public class Bound {
	private int from, to;
	public Bound(int from, int to) {
		this.from = from;
		this.to= to;
	}
	
	public int getFrom() {
		return this.from;
	}
	
	public int getTo() {
		return this.to;
	}
}
