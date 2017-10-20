package BinarySearchTree;

/**
 * In the spirit of time:
 * 	1. Boilerplate codes (such as getters/setters) are not needed.
 * 	2. Instance variables have public access.
 * 
 * @author jngui
 *
 */
public class Node {
	int value;
	
	Node leftNode;
	Node rightNode;
	
	int leftSubtreeNodes;
	int rightSubtreeNodes;
	
	public Node(int value) {
		this.value = value;
	}
}
