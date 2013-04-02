package dataStructuresTests;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import dataStructuresPractice.StacksAndQueues;

public class StackAndQueues {

	StacksAndQueues sAndQ = new StacksAndQueues();
		
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testStackAndQueue(){ 
		assertNull(sAndQ.stack.min());
		
		sAndQ.stack.push(10);
		sAndQ.stack.push(2);
		sAndQ.stack.push(3);
		assertEquals(3, sAndQ.stack.size());
		
		assertEquals(2, (int) sAndQ.stack.min());
		
		sAndQ.stack.pop();
		assertEquals(2, sAndQ.stack.size());
		
		
		
		sAndQ.queue.enqueue(1);
		sAndQ.queue.enqueue(2);
		sAndQ.queue.enqueue(3);
		assertEquals(3, sAndQ.queue.size());
		sAndQ.queue.dequeue();
		assertEquals(2, sAndQ.queue.size());
	}
	
	@Test
	public void testSetOfStacks(){
		// 1st stack, assuming capacity of 2
		sAndQ.setOfStacks.push(1);
		sAndQ.setOfStacks.push(2);
		// 2nd stack
		sAndQ.setOfStacks.push(3);
		sAndQ.setOfStacks.push(4);
		// size ahould be 2 stacks
		assertEquals(2, sAndQ.setOfStacks.stacks.size());
	
		
		sAndQ.setOfStacks.popAt(1);
		// add 2 above and we get null pointer exception
		assertEquals(1, sAndQ.setOfStacks.stacks.elementAt(1).size());
		
		sAndQ.setOfStacks.pop();
		sAndQ.setOfStacks.pop();
		assertEquals(1, sAndQ.setOfStacks.stacks.size());
	}
	
	@Test 
	public void testMyQueue(){
		sAndQ.myQueue.enqueue(0);
		sAndQ.myQueue.enqueue(1);
		sAndQ.myQueue.enqueue(2);
		// check for the three elements added
		assertEquals(3, sAndQ.myQueue.size());
		// top of queue should be the first added 
		assertEquals(0, sAndQ.myQueue.peek().getData());
		
		sAndQ.myQueue.dequeue();
		// size reduces by 1 during deque
		assertEquals(2, sAndQ.myQueue.size());
		
		sAndQ.myQueue.enqueue(2);
		assertEquals(3, sAndQ.myQueue.size());
		
		sAndQ.myQueue.dequeue();
		sAndQ.myQueue.dequeue();
		sAndQ.myQueue.dequeue();
		assertEquals(0, sAndQ.myQueue.size());
		
	}
	
	@Test
	public void testSort(){
		java.util.Stack<Integer> javaStack = new java.util.Stack<Integer>();
		javaStack.push(3);
		javaStack.push(5);
		javaStack.push(1);
		javaStack.push(2);
		
		java.util.Stack<Integer> r = sAndQ.sort(javaStack);
		for(Integer x: r){
			System.out.println(x);
		}
	}
}
