package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import assign2.MyStack;

class MyStackTest {

	@Test
	void testMyStack() {
		MyStack stack = new MyStack();
	}

	@Test
	void testPush() {
		MyStack stack = new MyStack();
		
		stack.push(32);
		
		assertEquals(32, stack.peek());
	}

	@Test
	void testPop() {
		MyStack stack = new MyStack();
		stack.push("hello");
		stack.push("world");
		stack.push(32);
		stack.pop();
		assertEquals("world", stack.peek());
	}

	@Test
	void testPeek() {
		MyStack stack = new MyStack();
		stack.push("apple pie");
		assertEquals("apple pie", stack.peek());
	}

	@Test
	void testClear() {
		MyStack stack = new MyStack();
		stack.push(23);
		stack.push(53);
		stack.clear();
		assertEquals(0, stack.size());
	}

	@Test
	void testIsEmpty() {
		MyStack stack = new MyStack();
		MyStack emptyStack = new MyStack();
		stack.push(24);
		assertEquals(false, stack.isEmpty());
		assertEquals(true, emptyStack.isEmpty());
		
		
	}

	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	@Test
	void testToArrayObjectArray() {
		fail("Not yet implemented");
	}

	@Test
	void testContains() {
		fail("Not yet implemented");
	}

	@Test
	void testSearch() {
		MyStack stack = new MyStack();
		stack.push(23);
		stack.push(53);
		stack.push(77);
		stack.push(65);
		stack.push(4);
		stack.push(666);
		assertEquals(3, stack.search(65));
		assertEquals(5, stack.search(666));
	}

	@Test
	void testIterator() {
		MyStack stack = new MyStack();
		stack.iterator();
	}

	@Test
	void testEqualsStackADTOfObject() {
		fail("Not yet implemented");
	}

	@Test
	void testSize() {
		MyStack stack = new MyStack();
		stack.push(2);
		stack.push("dog");
		stack.push("poppy");
		assertEquals(3, stack.size());
	}

}
