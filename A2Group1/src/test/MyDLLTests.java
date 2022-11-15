package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import utilities.MyDLL;

public class MyDLLTests {
      /**
	 * This method is to test if the size of the DLL will
	 * equal to that of the amount added in said list.
	 */
      @Test
      void returnSizeFromTheList( )
      {
    	  MyDLL<Integer> zeroDll = new MyDLL<Integer>();
    	  MyDLL<Integer> numDll = new MyDLL<Integer>();
    	  numDll.add(4);
    	  numDll.add(7);
    	  numDll.add(19);
    	  numDll.add(12);
    	  
    	  assertEquals(4, numDll.size());
    	  assertEquals(0, zeroDll.size());
      }
      
      /**
     * This method is to test the removal of elements within
     * the list.
     */
      @Test
      void removeElementsFromList( )
      {
    	  MyDLL<String> dll = new MyDLL<String>();
    	  dll.add("Hello");
    	  dll.add("Okay");
    	  dll.add("Alright");
    	  dll.add("Goodbye");
    	  
    	  dll.remove("Goodbye");
    	  assertFalse(dll.contains("Goodbye"));
      }
      
      /**
     * This method is to insert an element at a specific
     * index within the list.
     */
      @Test
      void insertElementAtSpecificIndex( )
      {
    	  MyDLL<Integer> dll = new MyDLL<Integer>();
    	  dll.add(2, 24);
    	  int index = dll.get(2);
    	  
    	  assertEquals(dll.contains(index), 24);
      }
      
      /**
     * This method is to add an element to the end of the
     * list.
     */
      @Test
      void addElementToTheEndList( )
      {
    	  MyDLL<Integer> dll = new MyDLL<Integer>();
    	  dll.add(2);
    	  dll.add(3);
    	  dll.add(9);
    	  dll.add(16);
    	  
    	  int last = dll.size();
    	  
    	  int index = dll.get(last);
    	  
    	  dll.add(last, 34);
    	  
    	  assertEquals(index, 34);
      }
      
      /**
     * This method is to test adding all the elements of a
     * list into another list.
     */
      @Test
      void addAllElementsToTheList( )
      {
    	  MyDLL<String> dllOne = new MyDLL<String>();
    	  dllOne.add("Hello, ");
    	  dllOne.add("This");
    	  dllOne.add("is");
    	  dllOne.add("Sparta.");
    	  
    	  MyDLL<String> dllTwo = new MyDLL<String>();
    	  dllTwo.add(" Nevermind, ");
    	  dllTwo.add("This");
    	  dllTwo.add("is");
    	  dllTwo.add("Thebes.");
    	  
    	  dllOne.addAll(dllTwo);
    	  
    	  assertTrue(dllOne.contains("Thebes"));
      }
      
      /**
     * This method is to test getting a specific element using
     * the index within the list.
     */
      @Test
      void getElementInSpecifiedIndex( )
      {
    	  MyDLL<Integer> dll = new MyDLL<Integer>();
    	  int index = dll.get(2);
    	  
    	  dll.add(24);
    	  dll.add(34);
    	  dll.add(44);
    	  dll.add(54);
    	  
    	  dll.get(2);
    	  assertEquals(dll.contains(index), 44); 
      }
      
}
