package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BST {
	Node root;
	
	/**
	 * Insert a new node to this binary search tree.
	 * 
	 * @param value
	 */
	public void insert(int value) {
		if (null == root) {
			root = new Node(value);
			return;
		}
		
		insertHelper(root, value);
	}
	
	private void insertHelper(Node node, int value) {
		if (node.value == value) {
			return;
		}
		
		Node child = new Node(value);
		if (null == node.leftNode && value < node.value) {
			node.leftNode = child;
			node.leftSubtreeNodes++;
			return;
		}
		else if (null == node.rightNode && value > node.value) {
			node.rightNode = child;
			node.rightSubtreeNodes++;
			return;
		}
		
		if (value < node.value) {
			// insert to left node
			node.leftSubtreeNodes++;
			insertHelper(node.leftNode, value);
		}
		else if (value > node.value) {
			// insert to right node
			node.rightSubtreeNodes++;
			insertHelper(node.rightNode, value);
		}
	}
	
	/**
	 * Find the k-th largest value
	 * 
	 * Limitation:
	 * 1. k can't be greater than total nodes
	 * 
	 * Using in-order traversal algorithm (right child, current, left child) to explore the tree and populate the array list.
	 * 
	 * Time and space complexity: 
	 * 	At best and in average: O(log n) when it only need to traverse the right side of tree.
	 *  At worst, O(n) when it has to traverse the left side of tree.
	 *  
	 */
	public int kThHighestElement(Node node, int k) {
		List<Integer> kHighestList = new ArrayList<Integer>();
		Integer counter = 0;
		
		kThHighestHelper(node, k, kHighestList, counter);
		
		return kHighestList.get(k-1);
	}
	
	private void kThHighestHelper(Node node, int k, List<Integer> kHighestList, Integer counter) {
		if (counter >= k) return;
		
		if (null != node.rightNode) {
			kThHighestHelper(node.rightNode, k, kHighestList, counter);
		}
		
		counter++;
		kHighestList.add(node.value);
		
		if (null != node.leftNode) {
			kThHighestHelper(node.leftNode, k, kHighestList, counter);
		}
	}
	
	/**
	 * Find the k-th smallest value
	 * 
	 * Limitation:
	 * 1. k can't be greater than total nodes
	 * 
	 * Using in-order traversal algorithm (left child, current, right child) to explore the tree and populate the array list.
	 * 
	 * Time and space complexity: 
	 * 	At best and in average: O(log n) when it only need to traverse the right side of tree.
	 *  At worst, O(n) when it has to traverse the left side of tree.
	 *  
	 */
	public int kThLowestElement(Node node, int k) {
		List<Integer> kLowestList = new ArrayList<Integer>();
		Integer counter = 0;
		
		kThLowestElementHelper(node, k, kLowestList, counter);
		
		return kLowestList.get(k-1); 
	}
	
	public void kThLowestElementHelper(Node node, int k, List<Integer> kLowestList, Integer counter) {
		if (counter >= k) {
			return;
		}
		
		if (null != node.leftNode) {
			kThLowestElementHelper(node.leftNode, k, kLowestList, counter);
		}
		
		counter++;
		kLowestList.add(node.value);
		
		if (null != node.rightNode) {
			kThLowestElementHelper(node.rightNode, k, kLowestList, counter);
		}
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	/**
	 * Determine if a given binary tree is of BST.
	 * 
	 * Time complexity: O(n) as we have to travel to all nodes.
	 * Space complexity: O(1) as we don't create new data structure in the process.
	 * 
	 * Assumptions:
	 * 1. There shall be no duplication in input tree.
	 * 2. Input tree should be of type binary tree.
	 */
	public boolean isBinarySearchTree(Node root) {
		// empty tree is not a BST
		if (null == root) return false;
		
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	/**
	 * Recursively analyze if a node has value exceeding its supposed min and max values.
	 * For all child-nodes reside to the left of current node, their max value shouldn't exceed current node's value.
	 * For all child-nodes reside to the right of current node, their min value shouldn't exceed current node's value.
	 * 
	 * @param node
	 * @param min
	 * @param max
	 * @return
	 */
	private boolean isBST(Node node, int min, int max) {
		
		if (null == node) {
			return true;
		}
		
		if (node.value < min && node.value > max) {
			return false;
		}
		
		return isBST(node.leftNode, min, node.value) &&
				isBST(node.rightNode, node.value, max);
	}
	
	/**
	 * BST structure looks like the following:
	 * 
	 *       50
	 *   30      70
	 * 20  40  60  80
	 *   
	 * @param args
	 */
	public static void main (String args[]) {
		BST tree = new BST();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		
		System.out.println("1st highest element: " + tree.kThHighestElement(tree.getRoot(), 1));
		System.out.println("3rd highest element: " + tree.kThHighestElement(tree.getRoot(), 3));
		System.out.println("4th highest element: " + tree.kThHighestElement(tree.getRoot(), 4));
		System.out.println("7th highest element: " + tree.kThHighestElement(tree.getRoot(), 7));
		
		System.out.println("1st lowest element: " + tree.kThLowestElement(tree.getRoot(), 1));
		System.out.println("3rd lowest element: " + tree.kThLowestElement(tree.getRoot(), 3));
		System.out.println("4th lowest element: " + tree.kThLowestElement(tree.getRoot(), 4));
		System.out.println("7th lowest element: " + tree.kThLowestElement(tree.getRoot(), 7));
	}
}
