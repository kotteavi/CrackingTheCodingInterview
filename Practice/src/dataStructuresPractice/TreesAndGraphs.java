package dataStructuresPractice;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;


public class TreesAndGraphs {

	public binarySearchTree tree;
	public Node root;

	public TreesAndGraphs() {
		this.tree = new binarySearchTree();
		this.root  = new Node(50);
	}
	
	// Create a Node
	public class Node {
		Node left;
		Node right;
		int value;
		private int depth;

		public Node(int value) {
			this.left = null;
			this.right = null;
			this.value = value;
			this.depth = 0;
		}

		public int getValue() {
			return value;
		}
		
		public void setDepth(int val){
			this.depth = val;
		}
		public int getDepth(){
			return depth;
		}

	}
	
	public class binarySearchTree{

		private int size =0;
		private int depth =0;
		Map<Integer, ArrayList<Integer>> data = new Hashtable<Integer, ArrayList<Integer>>();
		
		// recursion problem
		public void insert(Node node, int value) {
			depth++;
			// if value is greater than root
			if (value > node.getValue()) {
				// input to its right if it is not null
				if (node.right != null)
					insert(node.right, value);
				else{
					node.right = new Node(value);
					size ++;
					node.right.setDepth(depth);
					depth = 0;
				}
			}
			// if value less then root
			else if (value < node.getValue()) {
				// input to its left if it is not null
				if (node.left != null)
					insert(node.left, value);
				else{
					node.left = new Node(value);
					size ++;
					node.left.setDepth(depth);
					depth=0;
				}
			}
		}
		
		public int size(){
			return size;
		}
		
		// we would need to do this recursively as well
		public void printValues(Node node) {
			// print current node's values
			System.out.println(" val " + node.getValue() + " depth " + node.getDepth());
			// if not null print its left and right values
			if (node.left != null) {
				// System.out.println(node.left.value);
				printValues(node.left);
			}
			if (node.right != null) {
				// System.out.println(node.right.value);
				printValues(node.right);
			}
		}
		
//		public void isInBalance() {
//
//		}
		
		private void traverse (Node node){
			
			if(data.containsKey(node.depth)){
				data.get(node.depth).add(node.value);
			}
			else{
				// input the key and the value
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(node.value);
				
				data.put(node.depth, list);
			}
			
			if(node.left != null){
				traverse(node.left);
			}
			if(node.right != null){
				traverse(node.right);
			}
		}
		
		// prints to console all the values at each depth 
		public void printDepthValues(Node root){
			java.util.Iterator<Integer> iter = data.keySet().iterator();
			while(iter.hasNext()){
				Integer key = (Integer)iter.next();
				ArrayList<Integer> values = (ArrayList<Integer>)data.get(key);
				
				StringBuffer str = new StringBuffer();
				str.append(" Depth:" + key + " values: " );
				for(Integer val: values){
					str.append(val + ", ");
				}
				System.out.println(str.toString());
			}
		}
		
		// 4.4
		// list for each depth
		public Map<Integer, ArrayList<Integer>> trackEachDepth(Node root){
			
			traverse(root);
			return data;
		}
	}
	
	
	
}
