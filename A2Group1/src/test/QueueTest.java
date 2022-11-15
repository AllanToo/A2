package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import utilities.Queue;

public class QueueTest {
	/**
	 * This method is to test the addition of an object to
	 * the queue.
	 */
	@Test
	void addObject() {
		Queue<Integer> que = new Queue<Integer>();
		que.enqueue(23);
		que.enqueue(42);
		que.enqueue(56);
		que.enqueue(78);
		que.enqueue(95);
		
		assertTrue(que.size() > 0);
	}
	
	/**
	 * This method is to test the removal of the element
	 * that is first on the queue.
	 */
	@Test
	void removeObject() {
		Queue<Integer> que = new Queue<Integer>();
		que.enqueue(12);
		que.enqueue(71);
		que.enqueue(60);
		que.enqueue(85);
		que.enqueue(32);
		
		que.dequeue();
		
		assertNotEquals(que.peek(), 12);
		
	}
	
	/**
	 * This method is to test the calling of the first element
	 * in the queue without removing it.
	 */
	@Test
	void peekObject() {
		Queue<Integer> que = new Queue<Integer>();
		que.enqueue(24);
		que.enqueue(45);
		que.enqueue(50);
		que.enqueue(77);
		
		assertEquals(que.peek(), 24);
	}
	
	/**
	 * This method is to test the removal of all elements
	 * within the queue.
	 */
	@Test
	void removeAllObjects() {
		Queue<Integer> que = new Queue<Integer>();
		que.enqueue(12);
		que.enqueue(71);
		que.enqueue(60);
		que.enqueue(85);
		que.enqueue(32);
		
		que.dequeueAll();
		
		assertTrue(que.isEmpty());
	}
	
	/**
	 * This method is to test the checking of whether the
	 * queue is empty or not.
	 */
	@Test
	void checkIfEmpty() {
		Queue<Integer> que = new Queue<Integer>();
		
		assertTrue(que.isEmpty());
	}
	
	/**
	 * This method is to test the checking of whether the
	 * queue is full or not.
	 */
	@Test
	void checkIfFull() {
		Queue<Integer> que = new Queue<Integer>();
		
		assertTrue(que.isFull());
	}
	
	/**
	 * This method is to test the check of the size of
	 * the queue.
	 */
	@Test
	void checkQueueSize() {
		Queue<Integer> que = new Queue<Integer>();
		que.enqueue(19);
		que.enqueue(7);
		que.enqueue(62);
		que.enqueue(35);
		que.enqueue(80);
		
		assertEquals(que.size(), 5);
	}
}
