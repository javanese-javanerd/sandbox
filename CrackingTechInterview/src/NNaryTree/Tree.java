package NNaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
	
	public Tree() {}
	
	public List<List<String>> nodeByLevel(Node root){
		if (null == root) return null;
		
		List<List<String>> levels = new ArrayList<List<String>>();
		
		Queue<Node> toBeProcessed = new LinkedList<Node>();
		toBeProcessed.add(root);
		while (! toBeProcessed.isEmpty()) {
			// empty toBeProcessed immediately
			Queue<Node> tempQueue = new LinkedList<Node>();
			while(! toBeProcessed.isEmpty()) {
				tempQueue.add(toBeProcessed.poll());
			}
			
			// add children back to toBeProcessed queue and compile returned list
			List<String> nodeData = new ArrayList<String>();
			while (null != tempQueue.peek()) {
				Node node = tempQueue.poll();
				nodeData.add(node.data);
				toBeProcessed.addAll(node.children);
			}
			
			levels.add(nodeData);
		}
		
		return levels;
	}
	
	public void printNodeByLevel(Node root) {
		if (null == root) return;
		
		List<Node> queue= new ArrayList<Node>();
		queue.add(root);
		printNodeHelper(queue);
	}
	
	private void printNodeHelper(List<Node> queue) {
		if (null == queue || queue.isEmpty()) return;
		
		// empty the queue immediately --> transfer nodes into a temp list
		List<Node> tempQ = new ArrayList<Node>();
		Iterator<Node> iter = queue.iterator();
		while(iter.hasNext()) {
			Node node = iter.next();
			tempQ.add(node);
			iter.remove();
		}
		
		// iterate temp lists, add their children into queue and do operation.
		for (int index = 0; index < tempQ.size(); index++) {
			Node node = tempQ.get(index);
			queue.addAll(node.children);
			System.out.print(node.data + " ");
		}
		System.out.println();
		
		// call helper recursively
		printNodeHelper(queue);
	}
	
	class Node {
        String data;
        List<Node> children;

        Node(String value, Node... children) {
            this.data = value;
            this.children = new ArrayList<>(Arrays.asList(children));
        }

        @Override
        public String toString() {
            return "Node{" + "'" + data + "'}";
        }
    }
	
	final Node TEST_TREE =
            new Node("a",
                    new Node("b",
                            new Node("c", new Node("d"), new Node("e"), new Node("f"))),
                    new Node("g"),
                    new Node("h",
                            new Node("i"),
                            new Node("j"),
                            new Node("k", new Node("l"), new Node("m")))

            );


    public static void main(String[] args) {
        
        Tree tree = new Tree();

        tree.printNodeByLevel(tree.TEST_TREE);
        
        List<List<String>> result = tree.nodeByLevel(tree.TEST_TREE);
        for (int i = 0; i < result.size(); i++) {
            List<String> strings = new ArrayList<>(result.get(i)); // ArrayList has nice toString
            System.out.println(String.format("Nodes at depth %d -> %s", i, strings));

        }
    }
}
