package dataStructuresTests;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import dataStructuresPractice.LinkedList.Node;

public class LinkedList {
	
	private dataStructuresPractice.LinkedList linkedList= new dataStructuresPractice.LinkedList();
	
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testNode(){
		
		// Insert two nodes to linkedl list
		linkedList.head.appendToTail(2);
		linkedList.head.appendToTail(3);
		
		assertEquals(3, linkedList.numOfNodes());
	}
	
	@Test 
	public void testDeleteNode(){
		// Insert two nodes to linkedl list
		linkedList.head.appendToTail(2);
		linkedList.head.appendToTail(3);
		linkedList.deleteNode(1);
//		linkedList.printLinkedList(head);
		assertEquals(2, linkedList.numOfNodes());
	}
	
	@Test 
	public void testRemoveDuplicates(){
		linkedList.head.appendToTail(1);
		linkedList.head.appendToTail(2);
		linkedList.head.appendToTail(2);
		linkedList.head.appendToTail(3);
		linkedList.head.appendToTail(3);
		linkedList.head.appendToTail(4);
		linkedList.head.appendToTail(4);
		linkedList.head.appendToTail(3);
		linkedList.head.appendToTail(1);
		linkedList.removeDuplicates();
//		linkedList.printLinkedList(head);
		assertEquals(4, linkedList.numOfNodes());
		
	}
	
	@Test
	public void testNodeFromLast(){
		linkedList.head.appendToTail(2);
		linkedList.head.appendToTail(3);
		Node node = linkedList.nodeFromLast(1);
		assertEquals(2, node.getData());
		
		// test cases to test
		// out of bound index?
		// only head present 
	}
	
	@Test
	public void testGetNode(){
		linkedList.head.appendToTail(2);
		linkedList.head.appendToTail(3);
		Node node = linkedList.getNode(2);
		assertEquals(3, node.getData());
		
		// have to test for a number non existent
	}

	@Test
	public void testDeleteNextNode(){
		linkedList.head.appendToTail(2);
		linkedList.head.appendToTail(3);
		
//		linkedList.printLinkedList(head);
		
		Node node = linkedList.getNode(0);
		linkedList.deleteNextNode(node);
		assertEquals(2, linkedList.numOfNodes());
		
//		linkedList.printLinkedList(head);
		
		// how else can we break our code?
		// non existant nodes
		// last node in list (this does not work fine)
		// first node in list (this works fine)
	}
	
	@Test
	public void testAddInReverse(){
		linkedList.head.appendToTail(2);
		linkedList.head.appendToTail(9);
		
		linkedList.head2.appendToTail(2);
		linkedList.head2.appendToTail(3);
		linkedList.head2.appendToTail(5);
		
		linkedList.addInReverse(linkedList.head, linkedList.head2);
//		linkedList.printLinkedList(linkedList.addInReverse(linkedList.head, linkedList.head2));
		
		// can still test
		// give null values
		// give all values above 9, see what happens at the end value
	}
}
