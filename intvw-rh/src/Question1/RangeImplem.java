package Question1;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @see Range.java
 */
public class RangeImplem implements Range{
	
	private List<Bound> boundList;
	
	public RangeImplem() {
		boundList = new CopyOnWriteArrayList<Bound>(); 
	}
	
	@Override
	public Range newRange(int from, int to) {
		// reset bound list
		boundList = new CopyOnWriteArrayList<Bound>(); 
		
		// add new bound
		Bound bound = new Bound(from, to);
		boundList.add(bound);
		
		return this;
	}

	@Override
	public boolean isIn(int value) {
		if (null == boundList || boundList.isEmpty()) return false;
		
		for(Bound bound : boundList) {
			if (bound.getFrom() <= value && bound.getTo() >= value)
				return true;
		}
		
		return false;
	}

	@Override
	public int min() {
		if (null == boundList || boundList.isEmpty()) return 0;
		
		Integer min = null;
		for (Bound bound : boundList) {
			if (bound.getFrom() < bound.getTo()) {
				if (null == min) {
					min = bound.getFrom();
				}
				else if (min > bound.getFrom()) {
					min = bound.getFrom();
				}
			}
		}
		
		return min;
	}

	@Override
	public int max() {
		if (null == boundList || boundList.isEmpty()) return 0;
		
		Integer max = null;
		for (Bound bound : boundList) {
			if (bound.getTo() > bound.getFrom()) {
				if (null == max) {
					max = bound.getTo();
				}
				else if (max < bound.getTo()) {
					max = bound.getTo();
				}
			}
		}
		
		return max;
	}

	@Override
	public Range add(Range r) {
		if (null == r || r.getRanges().isEmpty()) return this;
		
		for (Object obj : r.getRanges()) {
			Bound bound = (Bound)obj;
			this.boundList.add(bound);
		}
		
		return this;
	}
	
	@Override
	public Range subtract(Range r) {
		if (null == r || r.getRanges().isEmpty()) return this;
		
		List<Bound> removeMe = new CopyOnWriteArrayList<Bound>();
		List<Object> toBeRemoved = r.getRanges();
		for (Object object : toBeRemoved) {
			Bound candidate = (Bound)object;
			for (Bound bound : boundList) {				
				if (bound.getFrom() == candidate.getFrom() && bound.getTo() == candidate.getTo()) {
					removeMe.add(bound);
				}
			}	
		}
		boundList.removeAll(removeMe);
		
		return this;
	}
	
	@Override
	public List getRanges() {
		return this.boundList;
	}
}
