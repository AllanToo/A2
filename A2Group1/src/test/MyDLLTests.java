package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import utilities.MyDLL;

public class MyDLLTests {
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
      
      @Test
      void insertElementAtSpecificIndex( )
      {
    	  MyDLL<Integer> dll = new MyDLL<Integer>();
    	  dll.add(2, 24);
    	  int index = dll.get(2);
    	  
    	  assertEquals(dll.contains(index), 24);
      }
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
