package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class IntegerLinkedList {

	Node head;
	int size;
	
	public IntegerLinkedList() { this.size = 0; }
	
	public void insert(int data) {
		if (null == head) {
			head = new Node(data);
			size++;
			return;
		}
		
		insertHelper(data);
	}
	
	private void insertHelper(int data) {
		Node current = head;
		while (null != current.next) {
			current = current.next;
		}
		
		Node next = new Node(data);
		current.next = next;
		size++;
	}
	
	public boolean insertCycle(int intoIndex) {
		if (size <= intoIndex) return false;
		
		boolean inserted = false;
		
		Node targetNode = head;
		int counter = 0;
		while (counter < intoIndex) {
			targetNode = targetNode.next;
			counter++;
		}
		
		Node tail = head;
		while (null != tail.next)
			tail = tail.next;
		
		tail.next = targetNode;
		inserted = true;
		
		return inserted;
	}
	
	/**
	 * Using set to detect if a linked list has a cycle.
	 * NOTE: Instead of storing the data of a node in the set, we directly store the address reference of such node.
	 * This will ensure the uniqueness of the set. See LinkedListTest.testNonCyclicalList() for such test case.
	 * 
	 * @return
	 */
	public boolean hasCycle() {
		boolean cycleFound = false;
		Set<Node> visited = new HashSet<Node>();
		
		Node current = head;
		while (null != current) {
			visited.add(current);
			current = current.next;
			if (visited.contains(current)) {
				cycleFound = true;
				break;
			}
		}
		
		return cycleFound;
	}
	
	/**
	 * Using set to detect if a linked list has a cycle in a recursive manner.
	 * 
	 * @return
	 */
	public boolean hasCycleRecursive() {
		boolean cycleFound = false;
		Set<Node> visited = new HashSet<Node>();
		
		return hasCycleRescursiveHelper(head, visited, cycleFound);
	}
	
	private boolean hasCycleRescursiveHelper(Node node, Set<Node> visited, boolean cycleFound) {
		if (null == node) return false;
		if (cycleFound) return cycleFound;
		
		if (visited.contains(node)) {
			cycleFound = true;
		}
		visited.add(node);
		
		return hasCycleRescursiveHelper(node.next, visited, cycleFound);
	}
	
	/**
	 * Using the running pointers methodology to detect cycle.
	 * 
	 * @return
	 */
	public boolean hasCycleRunningPointers() {
		if (null == head) return false;
		
		boolean cycleDetected = true;
		Node slow = head;
		Node fast = head.next;
		while(slow != fast) {
			if (null == fast || null == fast.next) {
				cycleDetected = false;
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return cycleDetected;
	}
	
	/**
	 * Using the running pointers methodology recursively to detect cycle.
	 * 
	 * @return
	 */
	public boolean hasCycleRunningPointersRecursive() {
		if (null == head) return false;
		
		return hasCycleRunningPointersRecursiveHelper(head, head.next);
	}
	
	private boolean hasCycleRunningPointersRecursiveHelper(Node slow, Node fast) {
		if (null == fast || null == fast.next) return false;
		
		if (slow == fast) return true;
		
		return hasCycleRunningPointersRecursiveHelper(slow.next, fast.next.next);
	}
	
	public String print() {
		String listContent = "";
		
		Node current = head;
		while (null != current) {
			listContent += current.data + " ";
			current = current.next;
		}
		
		return listContent.trim();
	}
	
	private class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void main(String args[]) {
		IntegerLinkedList list = new IntegerLinkedList();
		
		list.insert(3);
		list.insert(1);
		list.insert(2);
		list.insert(5);
		System.out.println(list.print());
		System.out.println("List contains cycle? " + list.hasCycle());
		System.out.println("List contains cycle? " + list.hasCycleRecursive());
		
		list.insertCycle(1);
		System.out.println("List contains cycle? " + list.hasCycle());
		System.out.println("List contains cycle? " + list.hasCycleRecursive());
	}
}
