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
    	  //MyDLL<Integer> dll = new MyDLL<Integer>();
      }
      
      @Test
      void addAllElementsToTheList( )
      {
    	  //MyDLL<Integer> dll = new MyDLL<Integer>();
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
