package Heap;

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
		MaxHeap<Integer> heap = new MaxHeap<Integer>();
		
		heap.insert(new Integer(19));
		heap.insert(new Integer(11));
		heap.insert(new Integer(81));
		heap.insert(new Integer(7));
		heap.insert(new Integer(10));
		heap.insert(new Integer(8));
		heap.insert(new Integer(19));
		
		assertNotNull("ERROR: heap should not be empty", heap.isEmpty());
	}
	
	@Test
	public void test_extract() {
		MaxHeap<String> heap = new MaxHeap<String>();
		assertNull(heap.extract());
		
		heap.insert(new String("19"));
		String extracted = heap.extract();
		assertNotNull(extracted);
		assertEquals("19", extracted);
		assertTrue(heap.isEmpty());
		
		heap.insert(new String("11"));
		heap.insert(new String("19"));
		extracted = heap.extract();
		assertNotNull(extracted);
		assertEquals("19", extracted);
		assertFalse(heap.isEmpty());
		
		heap = new MaxHeap<String>();
		heap.insert(new String("11"));
		heap.insert(new String("19"));
		heap.insert(new String("81"));
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
		MaxHeap<Integer> heap = new MaxHeap<Integer>();
		
		heap.insert(new Integer(19));
		heap.insert(new Integer(11));
		heap.insert(new Integer(81));
		heap.insert(new Integer(7));
		heap.insert(new Integer(10));
		heap.insert(new Integer(8));
		heap.insert(new Integer(19));
		
		assertTrue(81 == heap.extract());
		assertTrue(19 == heap.extract());
		assertTrue(19 == heap.extract());
		assertTrue(11 == heap.extract());
		assertTrue(10 == heap.extract());
		assertTrue(8 == heap.extract());
		assertTrue(7 == heap.extract());
	}
}
