package utilities;

import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E>, Iterator<E> {
                 MyDLLNode<E> head, tail, current;
                
                public MyDLL( )
                {
                	this.head = this.tail = null;
                }
	@Override
	public boolean hasNext() {
		return current != null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() throws NoSuchElementException {
		   if (!hasNext()) throw new NoSuchElementException();
           current = current.next;
          return (E) current;
	}

	@Override
	public int size() {
		int count = 0;
        while (current != null)
        {
                count++;
                current = current.next;
        }
 
        return count;
	}

	@Override
	public void clear() {
		   head = null;
		   tail = null;
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
	
		 MyDLLNode newNode = new MyDLLNode <E>( toAdd);
		 if (head == null)
		 {
			 head = newNode;
			 head = newNode;
			 return true;
		 }
		 
		 else if (index == 0)
		 {
			 newNode.next = head;
			 head.prev = newNode;
			 head = newNode;
			 return true;
		 }
		 
		 else if (index == size()) {
			 newNode.prev  = tail;
			 tail.next = newNode;
			 tail = newNode;
			 return true;
		 }
		 
		 else 
		 {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			tail.next = null;
				return true;
			 
		 }
		
	
	
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
	
		return false;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
	
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {

		return null;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
	
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		
		return null;
	}

	@Override
	public boolean isEmpty() {
	
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
	
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		
		return null;
	}

	@Override
	public Object[] toArray() {
	
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		
		return null;
	}

}
