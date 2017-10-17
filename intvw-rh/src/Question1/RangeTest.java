package Question1;

public class RangeTest {
	

	public static void main(String args[]) {
		Range r = new RangeImplem();
		Range r2 = new RangeImplem();
		Range r3 = new RangeImplem();
		
		// 3 is within 1 and 5
		System.out.println("Should return true: " + r.newRange(1,5).isIn(3) );
		
		// 6 is not within 1 and 5 
		System.out.println("Should return false: " + r.newRange(1,5).isIn(6) );
		System.out.println("Min: " + r.min());
		System.out.println("Max: " + r.max());
		
		// create a range [1,5], then reset the range to [8,10], and verify if 5 is not within 8 and 10.
		System.out.println("Should return false: " + r.newRange(1,5).add(r.newRange(8,10)).isIn(5));
		System.out.println("Min: " + r.min());
		System.out.println("Max: " + r.max());
		
		// create a range [1,5], then create another range [8,10], and verify if 5 is within 1 and 5.
		System.out.println("Should return true: " + r.newRange(1,5).add(r2.newRange(8,10)).isIn(5));
		
		// create a range [1,5], then create another range [8,10], and verify if 6 is out of range.
		System.out.println("Should return false: " + r.newRange(1,5).add(r2.newRange(8,10)).isIn(6));
		System.out.println("Min: " + r.min());
		System.out.println("Max: " + r.max());
		
		System.out.println("Should return false: " + r.newRange(1,5).add(r2.newRange(8,10)).subtract(r3.newRange(1, 5)).isIn(5));
		System.out.println("Min: " + r.min());
		System.out.println("Max: " + r.max());
	}
	
}
