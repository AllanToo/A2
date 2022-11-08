package utilities;

public class MyDLLNode<E> {
      public E element;
      public MyDLLNode<E> prev, next;
      
      // constructor
      public MyDLLNode(E element)
      {
    	  this.element = element;
      }
      public MyDLLNode ( E elem, MyDLLNode<E> prev, MyDLLNode<E> next)
      {
    	  this.element = elem;
    	  this.prev = prev;
    	  this.next = next;
    	  
      }
      
}
