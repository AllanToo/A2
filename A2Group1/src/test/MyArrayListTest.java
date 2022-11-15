package test;



import org.junit.Test;

import assign2.MyArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;



class MyArrayListTest<E> {
	
	/**
	 * Test the constructor 
	 */
	@Test
	void testMyArrayList() {
		MyArrayList<E> arrlist = new MyArrayList<>();
	}
	/**
	 * test default size when there are no elements in the arraylist
	 */
	@Test
	void testDefaultSize() {
		MyArrayList<E> arrlist = new MyArrayList<>();
		assertEquals(0, arrlist.size());
		
	/**
	 * Test size() method when there are elements inside the Array
	 */
	}
	@Test
	void testForSize() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		MyArrayList<Integer> zeroList = new MyArrayList<>();
		arrlist.add(1);
		arrlist.add(5);
		arrlist.add(12);
		
		assertEquals(3, arrlist.size());
		assertEquals(0, zeroList.size());
	}
	/**
	 * testing the get() method
	 */
	@Test
	void testGet() {
		
		
		MyArrayList<String> stringList = new MyArrayList<>();
		
		stringList.add("cookie");
		stringList.add("bread");
		stringList.add("zombies");
		
		
		assertEquals("bread", stringList.get(1));
	}

	/**
	 * testing add(int index, E toAdd)
	 */
	@Test
	void testAddingSetIndexAndValue() {
		MyArrayList<String> arrlist = new MyArrayList<>();
		arrlist.add(8, "two");
		arrlist.add(5,"ten");
		
		assertEquals("ten", arrlist.get(5));
	}
	/**
	 * testing the contains() method
	 */
	@Test 
	void testContains() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		arrlist.add(2);
		arrlist.add(10);
		arrlist.add(42);
		arrlist.add(54);
		
		
		assertEquals(true, arrlist.contains(42));
		assertEquals(false, arrlist.contains(269));
	}
	/**
	 * testing hasNext() method from MyIterator nested class. 
	 */
	@Test 
	void testDoesHasNextWork() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		
		
		assertEquals(false, arrlist.iterator().hasNext());
		
	}
	
	/**
	 * testing the clear() method, it should return 0 for the size since its removing all elements.
	 */
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
	/**
	 * testing remove(index) method that removes elements by searching for the specified index.
	 * testing the size to see if it changed after the deletion.
	 */
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
	/**
	 * testing the remove(value) method that removes elements by searching for the specified value.
	 */
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
	/**Testing the remove() method to see if it shifts elements to the left
	 * after deletion.
	 */
	@Test 
	void testRemoveShiftElements() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		arrlist.add(3);
		arrlist.add(4);
		arrlist.add(5);
		arrlist.add(7);
		
		arrlist.remove(2);
		assertEquals(3, arrlist.size());
		assertEquals(Integer.valueOf(7), arrlist.get(2));
	}
	/**
	 * testing the addAll() method to see if it can add values from the second array to teh first one.
	 */
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
	/**
	 * testing if the arraylist that has values and an empty arraylist if it's empty or not
	 */
	@Test
	void testIsEmpty() {
		
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		MyArrayList<Integer> anotherArr = new MyArrayList<>();
		
		anotherArr.add(79);
		assertEquals(true, arrlist.isEmpty());
		assertEquals(false, anotherArr.isEmpty());
	}
	
	/**
	 * testing a method that can replace exsisting index with new values
	 */
	@Test 
	void testReplaceValueWithSet() {
		MyArrayList<Integer> arrlist = new MyArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			int random = (int) (Math.random()*100);
			
			arrlist.add(random);
		}
		arrlist.set(5, 68);
		assertEquals(Integer.valueOf(68), arrlist.get(5));
	}
	/**
	 * testing if the arraylist can return as a normal array
	 */
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
