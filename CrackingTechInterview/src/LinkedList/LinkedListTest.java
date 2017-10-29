package LinkedList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testEmptyList() {
		IntegerLinkedList list = new IntegerLinkedList();
		assertFalse(list.hasCycle());
		assertFalse(list.hasCycleRecursive());
		assertFalse(list.hasCycleRunningPointers());
		assertFalse(list.hasCycleRunningPointersRecursive());
	}
	
	@Test
	public void testOneElementList() {
		IntegerLinkedList list = new IntegerLinkedList();
		list.insert(5);
		assertFalse(list.hasCycle());
		assertFalse(list.hasCycleRecursive());
		assertFalse(list.hasCycleRunningPointers());
		assertFalse(list.hasCycleRunningPointersRecursive());
	}
	
	@Test
	public void testOneCyclicalList() {
		IntegerLinkedList list = new IntegerLinkedList();
		list.insert(5);
		list.insertCycle(0);
		assertTrue(list.hasCycle());
		assertTrue(list.hasCycleRecursive());
		assertTrue(list.hasCycleRunningPointers());
		assertTrue(list.hasCycleRunningPointersRecursive());
	}
	
	@Test
	public void testCyclicalList() {
		IntegerLinkedList list = new IntegerLinkedList();
		list.insert(5);
		list.insert(4);
		list.insert(1);
		list.insert(7);
		list.insert(8);
		list.insertCycle(1);
		assertTrue(list.hasCycle());
		assertTrue(list.hasCycleRecursive());
		assertTrue(list.hasCycleRunningPointers());
		assertTrue(list.hasCycleRunningPointersRecursive());
	}
	
	@Test
	public void testNonCyclicalList() {
		IntegerLinkedList list = new IntegerLinkedList();
		list.insert(5);
		list.insert(4);
		list.insert(1);
		list.insert(7);
		list.insert(8);
		list.insert(1);
		assertFalse(list.hasCycle());
		assertFalse(list.hasCycleRecursive());
		assertFalse(list.hasCycleRunningPointers());
		assertFalse(list.hasCycleRunningPointersRecursive());
	}
}
