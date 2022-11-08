package test;



import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import assign2.MyArrayList;

class MyArrayListTest<E> {
	
	
	@Test
	void testMyArrayList() {
		MyArrayList<E> arrlist = new MyArrayList<>();
	}

	@Test
	@DisplayName("testing default size")
	void testDefaultSize() {
		MyArrayList<E> arrlist = new MyArrayList<>();
		assertEquals(0, arrlist.size());
		
	}
	@Test
	@DisplayName("Does size() work?")
	void testForSize() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		MyArrayList<Integer> zeroList = new MyArrayList<>();
		arrlist.add(1);
		arrlist.add(5);
		arrlist.add(12);
		
		assertEquals(3, arrlist.size());
		assertEquals(0, zeroList.size());
	}

	@Test
	void testGet() {
		
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		MyArrayList<String> stringList = new MyArrayList<>();
		arrlist.add(2);
		arrlist.add(10);
		stringList.add("cookie");
		stringList.add("bread");
		stringList.add("zombies");
		
		assertEquals(2, arrlist.get(0));
		assertEquals("bread", stringList.get(1));
	}

	@Test
	@DisplayName("Adding to an array by index")
	void testAddingSetIndexAndValue() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		arrlist.add(8, 2);
		arrlist.add(5,10);
		
		assertEquals(10, arrlist.get(5));
	}
	
	@Test 
	@DisplayName("Does contain() work for true/false?")
	void testContains() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		arrlist.add(2);
		arrlist.add(10);
		arrlist.add(42);
		arrlist.add(54);
		
		
		assertEquals(true, arrlist.contains(42));
		assertEquals(false, arrlist.contains(269));
	}
	
	@Test 
	void testDoesHasNextWork() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		Iterator<Integer> hasnext = arrlist.iterator();
		
		assertEquals(false, hasnext.hasNext());
		
	}
	
	
	@Test 
	void testClearList() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			int random = (int) (Math.random()*100);
			
			arrlist.add(random);
		}
		arrlist.clear();
		
		assertEquals(0, arrlist.size());
		
	}
	
	@Test
	void testRemoveByIndex() {
		
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			int random = (int) (Math.random()*100);
			
			arrlist.add(random);
		}
		
		arrlist.remove(4);
		arrlist.remove(3);
		
		assertEquals(8, arrlist.size());
		
	}
	@Test
	void testRemoveByValue() {
		MyArrayList<String> arrlist = new MyArrayList<>();
		arrlist.add("one");
		arrlist.add("what");
		arrlist.add("gde");
		arrlist.add("java");
		arrlist.add("wahlae");
		arrlist.add("allah");
		
		assertEquals("allah", arrlist.remove("allah"));
		assertEquals(5, arrlist.size());
		
		
		
	}
	@Test 
	void testRemoveShiftElements() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		arrlist.add(3);
		arrlist.add(4);
		arrlist.add(5);
		arrlist.add(7);
		
		arrlist.remove(2);
		assertEquals(3, arrlist.size());
		assertEquals(7, arrlist.get(2));
	}
	
	@Test 
	void testAddAll() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		MyArrayList<Integer> addToList = new MyArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			int random = (int) (Math.random()*100);
			int random2 = (int) (Math.random()*100);
			
			arrlist.add(random);
			addToList.add(random2);
			
		}
		arrlist.addAll(addToList);
		assertEquals(20, arrlist.size());
	}
	
	@Test
	void testIsEmpty() {
		
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		MyArrayList<Integer> anotherArr = new MyArrayList<>();
		
		anotherArr.add(79);
		assertEquals(true, arrlist.isEmpty());
		assertEquals(false, anotherArr.isEmpty());
	}
	
	@Test 
	void testReplaceValueWithSet() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			int random = (int) (Math.random()*100);
			
			arrlist.add(random);
		}
		arrlist.set(5, 68);
		assertEquals(68, arrlist.get(5));
	}
	
	@Test 
	void testToArray() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		MyArrayList<String> stringList = new MyArrayList<>();
		arrlist.add(23);
		arrlist.add(42);
		arrlist.add(59);
		stringList.add("hello");
		stringList.add("world");
		stringList.add("java");
		
		
		Object [] intArray = {23, 42,59};
		Object [] sarray = {"hello", "world", "java"};
		
		assertArrayEquals(intArray, arrlist.toArray());
		assertArrayEquals(sarray, stringList.toArray());
		
		
	}
	
	
	
	
	
	
	
	


}
