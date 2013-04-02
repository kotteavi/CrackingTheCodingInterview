package dataStructuresPractice;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

public class LinkedList {
	public Node head = new Node(1);
	public Node head2 = new Node(1);
	
	// Create a sample linked list
	public class Node{
		 Node next = null;
		 int data;
		
		public Node(int d){
			this.data = d;
		}
		// any new addition gets added to the end of the list
		public void appendToTail(int d){
			Node end = new Node(d);
			
			Node n = this;
			while (n.next != null){ n = n.next;}
			n.next = end;
		}
		
		public int getData() {return data;}
	}
	
	public Node getNode(int index){
		Node n = head;
		if(index == 0) return head;
		else {
			int i = 1;
			while (n.next != null){
				if(i == index){
					return n.next;
				}
				n = n.next;
				i++;
			}
			return head;
		}
		
	}
	
	public void printLinkedList(Node h){
		Node n = h;
		System.out.println(" head " + n.data);
		while(n.next != null){
			System.out.println(" data: " + n.next.data);
			n=n.next;
		}
	}
	
	public int numOfNodes(){
		int num = 1;
		
		Node n = head;
		while(n.next != null) {
			num++;
			n = n.next; 
		}
		return num;
	}
	
	// remove a node
	public void deleteNode(int d){
		Node n = head;
		if(n.data == d){
			head = head.next;
		}
		while(n.next != null){
			if(n.next.data == d){
				n.next = n.next.next;
			}
			n = n.next;
		}
	}
	
	// remove duplicates from linked list
	public void removeDuplicates(){
		
		Set<Integer> set = new HashSet<Integer>();
		
		Node n = head;
		boolean isValidAdd = set.add(n.data);
		if(!isValidAdd) n.next = n.next.next;
		while(n.next!=null){
			isValidAdd = set.add(n.next.data);
			if(!isValidAdd && n.next.next!=null){
				n.next = n.next.next;
			}
			else if (!isValidAdd && n.next.next==null){
				n.next = null;
			}
			else
				n= n.next;
		}
		// How can we solve this without a temoporary buffer?
	}
	
	// Find the nth to last elemnt of a singly linked list
	public Node nodeFromLast(int index){
		int i = 1;
		Node n = head;
		// get last node
		while (n.next!=null){
			n=n.next;
			i++;
		}
		
		Node n2 = head;
		int diff = i - index;
		int i2 =1;
		
		while (n2.next!=null){
			if(i2==diff){
				return n2;
			}
			else{
				n2=n2.next;
				i2++;
			}
		}
		
		return head;
	}
	
	// 2.3
	public void deleteNextNode(Node node){
		Node n = null;
		if(node.next != null){
			 n = node.next;
			 // copy contents from the next node
			 node.data = n.data;
		}
		
		if(n.next !=null){
			node.next = n.next;	
		}
		else {
			node.next = null;
		}
	}
	
	// 2.4
	public Node addInReverse(Node h1, Node h2){
		Node sumHead = new Node(h1.data + h2.data);
		
		Node n = h1;
		Node n2 = h2;
		
		boolean isH1Limited = false;
		while(n.next != null && n2.next != null){
			// take care of a situation where we have a number greater than 9
			int sum = n.next.data + n2.next.data;
			int remainder = sum - 10;
			
			if(sum<=9) sumHead.appendToTail(sum);
			else {
				sumHead.appendToTail(remainder);
				// 1 is carried to the next one
				// add the 1 to which ever has a number in the next
			}
			n = n.next;
			n2 = n2.next;
			
			if (n.next == null) {
				isH1Limited = true;
				if(remainder>=0) n2.next.data = n2.next.data + 1; 
			}
			if (n2.next == null) {
				if(remainder>=0) n.next.data = n.next.data + 1;
				isH1Limited = false;
			} 
		}
		
		if (isH1Limited){
			// add the rest of n2
			while(n2.next != null){
				sumHead.appendToTail(n2.next.data);
				n2 = n2.next;
			}
		}
		else {
			// add the rest of n1
			while(n.next != null){
				sumHead.appendToTail(n.next.data);
				n = n.next;
			}
		}
		
		printLinkedList(sumHead);
		return sumHead;
		
	}
	
	// 2.5
	
}
