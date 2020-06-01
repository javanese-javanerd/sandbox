package HeapExercises;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MinHeapTest {

	@Test
	public void test_full() {
		MinHeap heap = new MinHeap();
		assertEquals(10, heap.getCapacity());
		assertEquals(0, heap.getSize());
		
		heap.insert(19);
		heap.insert(11);
		heap.insert(81);
		heap.insert(7);
		heap.insert(10);
		heap.insert(8);
		heap.insert(19);
		heap.insert(26);
		heap.insert(21);
		heap.insert(84);
		assertEquals(10, heap.getCapacity());
		assertEquals(10, heap.getSize());
		
		heap.insert(18);
		assertEquals(20, heap.getCapacity());
		assertEquals(11, heap.getSize());
		
		assertTrue(7 == heap.extract());
		assertTrue(8 == heap.extract());
		assertTrue(10 == heap.extract());
		assertTrue(11 == heap.extract());
		assertTrue(18 == heap.extract());
		assertTrue(19 == heap.extract());
		assertTrue(19 == heap.extract());
		assertTrue(21 == heap.extract());
		assertTrue(26 == heap.extract());
		assertTrue(81 == heap.extract());
		assertTrue(84 == heap.extract());
	}
}
