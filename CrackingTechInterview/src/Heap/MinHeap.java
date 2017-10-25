package Heap;

/**
 * A min-heap implementation using native array as the underlying data structure.
 * 
 * @author javanese-javanerd
 */
public class MinHeap {

	private int[] heap;
	private int size;
	private int capacity;
	
	public MinHeap() {
		heap = new int[10];
		capacity = 10;
		size = 0;
	}
	
	public int getCapacity() { return capacity; }
	
	public int getSize() { return size; }
	
	public void insert(int element) {
		if (size < capacity) {
			heap[size] = element;
		}
		else {
			doubleCapacity();
			heap[size] = element;
		}
		
		shiftUp(size);
		size += 1;
	}
	
	private void doubleCapacity() {
		capacity = capacity*2;
		int[] largerHeap = new int[capacity];
		for (int index=0; index < heap.length; index++) {
			largerHeap[index] = heap[index];
		}
		heap = largerHeap;
	}
	
	private void shiftUp(int index) {
		if (index == 0) return;
		
		int parentIndex = (index-1) / 2;
		if (heap[parentIndex] > heap[index]) {
			swap(index, parentIndex);
			
			index = parentIndex;
			shiftUp(index);
		}
	}

	private void swap(int firstIndex, int secondIndex) {
		int tmp = heap[secondIndex];
		heap[secondIndex] = heap[firstIndex];
		heap[firstIndex] = tmp;
	}
	
	public int extract() {
		if (size == 0) { return 0; }
		
		int extracted = heap[0];
		removeHead();
		shiftDown(0);
		
		return extracted;
	}
	
	private void removeHead() {
		
		if (size == 1) {
			heap = new int[capacity];
			size = 0;
		}
			
		int[] trimmedHeap = new int[capacity];
		trimmedHeap[0] = heap[size-1];
		for (int index=1; index<size-1; index++) {
			trimmedHeap[index] = heap[index];
		}
		
		size -= 1;
		heap = trimmedHeap;
	}
	
	private void shiftDown(int index) {
		if (size == 1) return;
		
		int rightChildIndex = index*2 + 2;
		
		// give priority to when both left child and right child exist
		if (rightChildIndex < size && rightChildIndex-1 < size) {
			
			// give priority to the left child
			if (heap[rightChildIndex-1] <= heap[rightChildIndex]) {
				if (heap[index] > heap[rightChildIndex-1]){
					// swap with left child
					swap(index, rightChildIndex-1);
					shiftDown(rightChildIndex-1);
				}
			}
			else {
				if (heap[index] > heap[rightChildIndex]){
					// swap with right child
					swap(index, rightChildIndex);
					shiftDown(rightChildIndex);
				}
			}
		}
		else if (rightChildIndex-1 < size && heap[index] > heap[rightChildIndex-1]) {
			// swap with left child
			swap(index, rightChildIndex-1);
			shiftDown(rightChildIndex-1);
		}
		else if (rightChildIndex < size && heap[index] > heap[rightChildIndex]) {
			// swap with right child
			swap(rightChildIndex, index);
			shiftDown(rightChildIndex);
		}
	}
}
