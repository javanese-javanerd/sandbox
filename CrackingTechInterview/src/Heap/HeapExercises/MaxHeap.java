package Heap.HeapExercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Although visually we represent a heap as a binary tree, it's actually much more efficient to implement it using an array.
 * Given an index of a parent node 'p', its left child's index is at 2p+1 while its right child is at 2p+2.
 * Given an index of a child node 'c', its parent index is at (c-1)/2.
 * 
 * There are only two operations in a heap data structure:
 * 1. Insert (followed by a siftUp operation)
 * 2. Delete (followed by a siftDown operation)
 * 
 * Both operations have a time complexity of O(log n).
 * 
 * Heap is good when we need to gain access to biggest/smallest element of a collection.
 * Caveat: heap allows duplicate entry.
 * 
 * Assumptions:
 * 1. Heap is of type generic.
 * 
 * @author javanese-javanerd
 */
public class MaxHeap<T extends Comparable<T>> {
	List<T> elements;
	
	public MaxHeap() {
		this.elements = new ArrayList<T>();
	}
	
	/**
	 * Insert a given element into max heap.
	 * 
	 * @param element
	 */
	public void insert(T element) {
		elements.add(element);
		shiftUp();
	}
	
	private void shiftUp() {
		if (elements.size() == 1) {
			return;
		}
		
		int newlyInsertedIndex = elements.size()-1;
		while (newlyInsertedIndex > 0) {
			int parentIndex = (newlyInsertedIndex-1)/2;
			if(elements.get(newlyInsertedIndex).compareTo(elements.get(parentIndex)) > 0) {
				swap(newlyInsertedIndex, parentIndex);
			}
			else {
				break;
			}
			newlyInsertedIndex = parentIndex;
		}
	}

	private void swap(int index1, int index2) {
		T temp = elements.get(index2);
		elements.set(index2, elements.get(index1));
		elements.set(index1, temp);
	}
	
	/**
	 * Extract the maximum element from heap.
	 * 
	 */
	public T extract() {
		if (null == elements || elements.isEmpty()) return null;
		if (elements.size() == 1) return elements.remove(0);
		
		T element = getElementAt(0);
		elements.set(0, elements.remove(elements.size()-1));
		
		shiftDown(0);
		return element;
	}
	
	private void shiftDown(int index) {
		if (elements.size() == 1) return;
		
		// pick the bigger out of the two children
		int leftChildIndex = index*2 +1;
		int rightChildIndex = index*2 + 2;
		
		if (compare(leftChildIndex, rightChildIndex) >= 0) {
			// use leftChild
			if (getElementAt(leftChildIndex).compareTo(getElementAt(index)) > 0) {
				swap(leftChildIndex, index);
			}
			else {
				return;
			}
		}
		else {
			// use rightChild
			if (getElementAt(rightChildIndex).compareTo(getElementAt(index)) > 0) {
				swap(rightChildIndex, index);
			}
			else {
				return;
			}
		}
	}
	
	private T getElementAt(int position) {
		T element = null;
		try {
			element = elements.get(position);
		}
		catch (Exception e) {}
		
		return element;
	}
	
	private int compare(int leftIndex, int rightIndex) {
		
		if (null == getElementAt(leftIndex) && null == getElementAt(rightIndex)) return 0;
		else if (null == getElementAt(leftIndex)) return -1;
		else if (null == getElementAt(rightIndex)) return 1;
		
		return getElementAt(leftIndex).compareTo(getElementAt(rightIndex));
	}
	
	public String toString()	{
		if (elements.isEmpty()) return "";
		
		StringBuffer sb = new StringBuffer();
		
		for (T element : elements) {
			sb.append(element.toString()).append(" ");
		}
		
		return sb.toString().trim();
	}
	
	public boolean isEmpty() {
		return elements.isEmpty();
	}
}
