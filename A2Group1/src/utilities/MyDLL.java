package utilities;

import java.util.NoSuchElementException;
import java.lang.Iterable;

import org.w3c.dom.Node;

public class MyDLL<E> implements ListADT<E>, Iterator<E> {
                 MyDLLNode<E>  tail, current, head;
	    private int size;
                 
                public MyDLL( )
                {
                	current = head;
                	
                     }
	@Override
	public boolean hasNext() {
		if(head==null) {
			return false;
		}
		if(head!=null) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() throws NoSuchElementException {
		E data=head.getElement();
		head=head.getNext();
		return data;
	}


	@Override
	public void clear() {
		   head = null;
		   tail = null;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
	
		if (index < 0 || index > this.size())
		{
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0)
		{
			MyDLLNode <E> newNode = new MyDLLNode<E> (toAdd, head, null);
			if(head!= null)
			{
				 head.previous = newNode;
			}
			 head = newNode;
	            if(tail == null) { 
	                tail = newNode;
	            }
	            size++;
	            return true;
		}
		
		else if (index == this.size()) {
			MyDLLNode <E> newNode = new MyDLLNode<E> (toAdd, null, tail);
			   if(tail != null) {
	                tail.next = newNode;
	            }
	            tail = newNode;
	            if(head == null) { 
	                head = newNode;
	            }
	            size++;
	            return true;
		}
		else {
            MyDLLNode<E> newNode = new MyDLLNode<E>(toAdd);
            MyDLLNode<E> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode;
            newNode.previous = currentNode.previous;
            currentNode.previous = newNode;
            newNode.previous.next = newNode;
            size++;
            return true;
        }
	
	}
	
	@Override
	public int size() {
		
	return size;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
	       MyDLLNode newNode = new MyDLLNode(toAdd);
	          // if the list is empty, head and tail will point to the newNode
	       if (head == null)
	       {
	    	   head = tail =  newNode;
	    	   head.previous = null;
	    	   tail.next = null;
	    	   size++;
	    	   return true;
	       }
	       
	       else {
	    	   tail.next = newNode;
	    	   newNode.previous = tail;
	    	   tail = newNode;
	    	   tail.next = null;
	    	   size++;
	    	   return true;
	       }
		
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		for(int i = 0; i < toAdd.size(); i++) {
			add(toAdd.get(i));
		}
		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
       if(index < 0 || index >= size())
       {
    	   throw new IndexOutOfBoundsException();
       }
       
      MyDLLNode currentNode = head;
      for(int i = 0; i < index; i++)
      {
    	  currentNode = currentNode.next;
      }
      return  (E) currentNode.getElement();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
	    if(index == 0)
	    {
	    	MyDLLNode oldFirst = head;
	    	head = head.next;
	    	if (head != null)
	    	{
	    		head.previous = null;
	    		
	    	}
	    	else {
	    		tail = null;
	    	}
	    	oldFirst.next = null;
	    	size--;
	    	return (E) oldFirst.element;
	    }
	    else if(index == size() -1)
	    {
	    	MyDLLNode temp = tail;
	    	tail = tail.previous;
	    	if (tail == null)
	    	{
	    		head = null;
	    	}
	    	else {
	    		tail.next = null;
	    	}
	    	size--;
	    	return (E) temp.element;
	    }
	    else {
	    	MyDLLNode<E> previous = null;
	    	MyDLLNode<E> finger = head;
	    	// search for value indexed, keep track of previous
	    	while (index > 0) {
	    	previous = finger;
	    	finger = finger.next;
	    	index--;
	    	}
	    	previous.next = finger.next;
	    	finger.next.previous = previous;
	    	size--;
	    	// finger's value is old value, return it
	    	return finger.element;
	    	}
	    }
	
          
          
	

	@SuppressWarnings("unchecked")
	@Override
	public E remove(E toRemove) throws NullPointerException {
	
	MyDLLNode<E> remove = new MyDLLNode<E> (toRemove);
	MyDLLNode<E> previous = null;
	MyDLLNode<E> finger = head;
	// search for value indexed, keep track of previous
	for(int i = 0; i <= size(); i++)
	{
	if (remove.equals(get(i)) ) {
	previous = finger;
	finger = finger.next;
	
	}
	}
	previous.next = finger.next;
	finger.next.previous = previous;
	size--;
	// finger's value is old value, return it
	
	
		return get(0);
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		      //  remove(index);
		if (index < 0 || index > this.size())
		{
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0)
		{
			remove(index);
			MyDLLNode <E> newNode = new MyDLLNode<E> (toChange, head, null);
			if(head!= null)
			{
				 head.previous = newNode;
			}
			 head = newNode;
	            if(tail == null) { 
	                tail = newNode;
	            }
	            size++;
	       
		}
		
		else if (index == this.size()) {
			remove(index);
			MyDLLNode <E> newNode = new MyDLLNode<E> (toChange, null, tail);
			   if(tail != null) {
	                tail.next = newNode;
	            }
	            tail = newNode;
	            if(head == null) { 
	                head = newNode;
	            }
	            size++;
	     
		}
		else {
			remove(index);
            MyDLLNode<E> newNode = new MyDLLNode<E>(toChange);
            MyDLLNode<E> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode;
            newNode.previous = currentNode.previous;
            currentNode.previous = newNode;
            newNode.previous.next = newNode;
            size++;
        
        }
		return remove(index);
	}

	@Override
	public boolean isEmpty() {
	
		return size == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind == null)
		{
			throw new NullPointerException();
		}
		
		MyDLLNode<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getElement().equals(toFind)) {
                return true;
                
            }
            currentNode = currentNode.next;
              
        }
        return false;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		Object[] result = toHold;
		if(size() > result.length) {
			result = new Object [size()];
			
		}
		
		int i = 0;
		for(Object e: result) {
			result[i] = e;
			i++;
		}
		if(result.length > 1) {
			result[i] = null;
			
		}
		return (E[]) result;
	}

	@Override
	public Object[] toArray() {
		Object [] arr = new Object[size()];
		int i = 0;
		for(Object e: arr)
		{
			arr[i] = e;
			i++;
		}
		return arr;
	}

	@Override
	public Iterator<E> iterator() {
		
		return null;
	}

}
