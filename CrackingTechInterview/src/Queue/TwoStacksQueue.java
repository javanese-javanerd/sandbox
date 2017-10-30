package Queue;

import java.util.Stack;

/**
 * Queue with two stacks implementation.
 * 
 * @author javanese-javanerd
 */
public class TwoStacksQueue {
	public static class MyQueue<T> {
		Stack<T> stackNewestOnTop = new Stack<T>();
		Stack<T> stackOldestOnTop = new Stack<T>();

		/**
		 * Runtime and space complexity: O(1)
		 * 
		 * @param value
		 */
		public void enqueue(T value) { // Push onto newest stack
			stackNewestOnTop.push(value);
		}

		private void emptyNewestStack() {
			if (stackOldestOnTop.isEmpty()) {
				while (!stackNewestOnTop.isEmpty()) {
					stackOldestOnTop.push(stackNewestOnTop.pop());
				}
			}
		}

		/**
		 * Runtime complexity: 
		 * .: In average: O(1)
		 * .: At worst: O(n) where n is the number of element in stacNewestOnTop.
		 * 
		 * @return
		 */
		public T peek() {
			emptyNewestStack();
			return stackOldestOnTop.peek();
		}

		/**
		 * Runtime complexity: 
		 * .: In average: O(1)
		 * .: At worst: O(n) where n is the number of element in stacNewestOnTop.
		 * 
		 * @return
		 */
		public T dequeue() {
			emptyNewestStack();

			return stackOldestOnTop.pop();
		}
	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.enqueue(76);
		queue.enqueue(33);
		System.out.println(queue.dequeue());
		queue.enqueue(23);
		queue.enqueue(97);
		queue.enqueue(21);
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		queue.enqueue(74);
		System.out.println(queue.peek());
	}
}
