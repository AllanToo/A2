package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


import org.junit.Test;
import utilities.MyStack;





class MyStackTest {
	/**
	 * testing constructor
	 */
	@Test
	void testMyStack() {
		MyStack<?> stack = new MyStack<Object>();
	}
	/**
	 * testing to see if push() works
	 */
	@Test
	void testPush() {
		MyStack<?> stack = new MyStack<Object>();
		
		stack.push(32);
		
		assertEquals(32, stack.peek());
	}
	
	/**
	 * testing to see if pop() method works
	 */
	@Test
	void testPop() {
		MyStack<?> stack = new MyStack<Object>();
		stack.push("hello");
		stack.push("world");
		stack.push(32);
		stack.pop();
		assertEquals("world", stack.peek());
	}
	/**
	 * testing to see if peek() method works
	 */
	@Test
	void testPeek() {
		MyStack<?> stack = new MyStack<Object>();
		stack.push("apple pie");
		assertEquals("apple pie", stack.peek());
	}
	/**
	 * testing to see if clear() method works
	 * we're using size() method to see if clear() method works.
	 */
	@Test
	void testClear() {
		MyStack<?> stack = new MyStack<Object>();
		stack.push(23);
		stack.push(53);
		stack.clear();
		assertEquals(0, stack.size());
	}
	/**
	 * testing the method when the stack is/is not empty
	 */
	@Test
	void testIsEmpty() {
		MyStack<?> stack = new MyStack<Object>();
		MyStack<?> emptyStack = new MyStack<Object>();
		stack.push(24);
		assertEquals(false, stack.isEmpty());
		assertEquals(true, emptyStack.isEmpty());
		
		
	}
	/**
	 * testing toArray() method to see if it can return an array
	 */
	@Test
	void testToArray() {
		MyStack<?> stack = new MyStack<Object>();
		stack.push(2);
		stack.push(5);
		stack.push(7);
		stack.push(10);
		Object[] a = stack.toArray();
		Object[] array = {2,5,7,10};
		assertArrayEquals(array,a);
		
	}
	/**
	 * testing contains() method for both true/false values
	 */
	@Test
	void testContains() {
		MyStack<?> stack = new MyStack<Object>();
		stack.push(23);
		stack.push(25);
		stack.push(77);
		stack.push(65);
		assertEquals(true, stack.contains(77));
	}
	/**
	 * testing the search() method 
	 */
	@Test
	void testSearch() {
		MyStack<?> stack = new MyStack<Object>();
		stack.push(23);
		stack.push(53);
		stack.push(null);
		stack.push(65);
		stack.push(4);
		stack.push(666);
		assertEquals(3, stack.search(65));
		assertEquals(4, stack.search(4));
	}

	@Test
	void testIterator() {
		MyStack<?> stack = new MyStack<Object>();
		stack.iterator();
	}
	/**
	 * testing the equals() method. it compares each value from both arrays and it returns true if two stacks compared are equal.
	 */
	@Test
	void testEqualsStackADTOfObject() {
		MyStack<Integer> stack = new MyStack<Integer>();
		MyStack<Integer> stack2 = new MyStack<Integer>();
		MyStack<Integer> stackFalse = new MyStack<Integer>();
		
		stack.push(6);
		stack.push(4);
		stack.push(5);
		stack2.push(6);
		stack2.push(4);
		stack2.push(5);
		stackFalse.push(4);
		stackFalse.push(2);
		assertEquals(true, stack.equals(stack2));
		assertEquals(false, stack.equals(stackFalse));
	
	}
	/**
	 * test for size
	 */
	@Test
	void testSize() {
		MyStack<?> stack = new MyStack<Object>();
		stack.push(2);
		stack.push("dog");
		stack.push("poppy");
		assertEquals(3, stack.size());
	}

}
