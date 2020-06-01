package HeapExercises;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * A tester class of MaxHeap.
 * 
 * @author javanese-javanerd
 */
public class MaxHeapTest {

	/**
	 * Heap structure:
	 * 
	 * 		81
	 *  11     19
	 * 7  10  8  19
	 * 
	 */
	@Test
	public void test_insert() {
		MaxHeap<Integer> heap = new MaxHeap<>();
		
		heap.insert(19);
		heap.insert(11);
		heap.insert(81);
		heap.insert(7);
		heap.insert(10);
		heap.insert(8);
		heap.insert(19);
		
		assertNotNull("ERROR: heap should not be empty", heap.isEmpty());
	}
	
	@Test
	public void test_extract() {
		MaxHeap<String> heap = new MaxHeap<>();
		assertNull(heap.extract());
		
		heap.insert("19");
		String extracted = heap.extract();
		assertNotNull(extracted);
		assertEquals("19", extracted);
		assertTrue(heap.isEmpty());
		
		heap.insert("11");
		heap.insert("19");
		extracted = heap.extract();
		assertNotNull(extracted);
		assertEquals("19", extracted);
		assertFalse(heap.isEmpty());
		
		heap = new MaxHeap<String>();
		heap.insert("11");
		heap.insert("19");
		heap.insert("81");
		extracted = heap.extract();
		assertEquals("81", extracted);
		assertFalse(heap.isEmpty());
		extracted = heap.extract();
		assertEquals("19", extracted);
		assertFalse(heap.isEmpty());
		extracted = heap.extract();
		assertEquals("11", extracted);
		assertTrue(heap.isEmpty());
	}
	
	@Test
	public void test_full() {
		MaxHeap<Integer> heap = new MaxHeap<>();
		
		heap.insert(19);
		heap.insert(1);
		heap.insert(8);
		heap.insert(7);
		heap.insert(1);
		heap.insert(8);
		heap.insert(19);
		
		assertTrue(81 == heap.extract());
		assertTrue(19 == heap.extract());
		assertTrue(19 == heap.extract());
		assertTrue(11 == heap.extract());
		assertTrue(10 == heap.extract());
		assertTrue(8 == heap.extract());
		assertTrue(7 == heap.extract());
	}
}
