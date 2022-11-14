package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import utilities.Queue;

public class QueueTest {
	@Test
	void addObject() {
		Queue<Integer> que = new Queue<Integer>(0);
		que.enqueue(23);
		que.enqueue(42);
		que.enqueue(56);
		que.enqueue(78);
		que.enqueue(95);
		
		assertTrue(que.size() > 0);
	}
	
	void removeObject() {
		
	}
	
	void peekObject() {
		
	}
	
	void removeAllObjects() {
		
	}
	
	void checkIfEmpty() {
		Queue<Integer> que = new Queue<Integer>(0);
		
		assertTrue(que.isEmpty());
	}
	
	void checkIfFull() {
		Queue<Integer> que = new Queue<Integer>(0);
		
		assertTrue(que.isFull());
	}
	
	void checkQueueSize() {
		Queue<Integer> que = new Queue<Integer>(0);
		que.enqueue(19);
		que.enqueue(7);
		que.enqueue(62);
		que.enqueue(35);
		que.enqueue(80);
		
		assertEquals(que.size(), 5);
	}
}
