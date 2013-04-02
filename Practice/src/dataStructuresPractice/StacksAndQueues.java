package dataStructuresPractice;

public class StacksAndQueues {

	public Stack stack = new Stack();
	public Queue queue = new Queue();
	public SetOfStacks setOfStacks = new SetOfStacks();
	public MyQueue myQueue = new MyQueue();
	
	
	
	// Create a Node
	public class Node {
		Node next = null;
		int data;

		public Node(int data) {
			this.data = data;
		}
		public int getData(){
			return data;
		}
	}

	// Create an implementation of queue and a Stack
	public class Stack {
		Node top = null;
		Integer min = null;
		Integer size = 0;

		public Node pop() {
			if (top != null) {
				Node n = top;
				top = top.next;
				size--;
				return n;
			}

			return null;
		}

		public void push(int num) {
			if(top!= null && num < top.data){
				// min != null
				min = num;
			} 
			
			Node n = new Node(num);
			n.next = top;
			top = n;
			size++;
		}
		
		public int size(){
			return size;
		}
		
		public Integer min(){
			return min;
		}
	
		public Node peek(){
			return top;
		}
		
	}

	public class Queue {
		Node top = null;
		Node bottom = null;
		Integer size = 0;

		// last in
		public void enqueue(int num) {
			if (top == null) {
				top = new Node(num);
				top.next = bottom;
			} else {
				Node n = top;
				while (n.next != bottom) {
					n = n.next;
				}
				Node n2 = new Node(num);
				n2.next = bottom;
				n.next = n2;
				
			}
			size++;
		}

		// first out
		public Node dequeue() {
			if(top == null){
				return null;
			}
			else {
				Node n = top;
				top = top.next;
				size--;
				return n;
			}
		}
		
		public int size(){
			return size;
		}
	}

	// 3.3
	public class SetOfStacks{
		
		public java.util.Stack<Stack> stacks = new java.util.Stack<StacksAndQueues.Stack>();
		
		private int capicity = 2;
		public Stack stack = new Stack();
		
		public void push(int num){
			if(stack.size == capicity-1){
				stack.push(num);
				stacks.add(stack);
				stack = new Stack();
			}
			else
				stack.push(num);
		}
		
		public Node pop(){
			if(stacks.isEmpty()){
				return stack.pop();
			}
			
			Stack top = stacks.peek();
			Node topPop = top.pop();
			
			if(top.size() == 0){
				stacks.pop();
				return topPop;
			}
			
			return topPop;
		}
		
		public void popAt(int index){
			stacks.elementAt(index).pop();
		}
		
		// learn how to throw error, when input is invalid
		// throw an error when u get an invalid index in popAt
		
	}
	
	// 3.5
	public class MyQueue{
		public Stack s1 = new Stack();
		public Stack s2 = new Stack();
		private int size = 0;
		
		public void enqueue(int num){
			size++;
			while (s2.size!=0){
				s1.push(s2.peek().data);
				s2.pop();
			}
			s1.push(num);
		}
		
		public Node dequeue(){
			size--;
			while(s1.size() != 0){
				s2.push(s1.peek().data);
				s1.pop();
			}
			s2.pop();
			return s2.pop();
		}
		
		public int size(){
			return size;
		}
		
		public Node peek(){
			if(s2.size != 0) return s2.peek();
			else if (s1.size!=0){
				while(s1.size() != 0){
					s2.push(s1.peek().data);
					s1.pop();
				}
				return s2.peek();
			}
			else return null;
		}
	}
	
	// 3.6
	public java.util.Stack<Integer> sort(java.util.Stack<Integer> s){
		java.util.Stack<Integer> r = new java.util.Stack<Integer>();
		while(!s.isEmpty()){
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp){
				s.push(r.pop());
			}
			r.push(tmp);
		}
		System.out.println("r peek " + r.peek());
		return r;
	}
	
}
