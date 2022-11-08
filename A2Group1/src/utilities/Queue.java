package utilities;

import org.w3c.dom.events.EventException;

public class Queue <E> implements QueueADT{
	
	// Declare variables
	private  E frontElement;
	private E lastElement;
	private   Object[]  array;
	private static int length;
	private static int count;
	
	
	//Constructor
	Queue( int size)
	{
		frontElement = lastElement = null;
		length = size;
		array = new Object[length];
	}
/* *
 * This method will add the element in the last position of the queue
 * @param toAdd the item to be added to the Queue.
 * @throws NullPointerException raised when a <code>null</code> object
 * 
 */
	@Override
	public void enqueue(Object toAdd) throws NullPointerException {
		   if (isFull())
		   {
			   System.out.println("Queue is full ");
			   
		   }
		   
		//   lastElement = (lastElement +1) % length;
	//	   array[lastElement] = toAdd;
		   count++;
		
	}

	@Override
	public Object dequeue() throws EventException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object peek() throws EventException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dequeueAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
	 if (size() == 0 )
	 {
		 return true;
	 }
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(QueueADT that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] holder) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFull() {
		 
		return (size() == length);
	}

	@Override
	public int size() {
		// last index + 1 
		
		return length; 
	}

}
