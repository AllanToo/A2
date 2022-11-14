package utilities;

import java.util.NoSuchElementException;

import org.w3c.dom.Node;
import org.w3c.dom.events.EventException;



public class Queue <E> implements QueueADT, Iterator {
	
	// Declare variables
	private static Node front, rear;
	private static int capacity;
	private static int queueArray[];
	private MyDLLNode<E> root;
	private MyDLL<Object> queue = new MyDLL();
	
	
	
	Queue()
	{
		
	}
	//Constructor
	Queue( int size)
	{
		//front = rear = 0;
		capacity = size;
		queueArray = new int [capacity];
		
	}
/* *
 * This method will add the element in the last position of the queue
 * @param toAdd the item to be added to the Queue.
 * @throws NullPointerException raised when a <code>null</code> object
 * s
 */
	@SuppressWarnings("unchecked")
	@Override
	public void enqueue(Object toAdd) throws NullPointerException {
	       
	       capacity++;
	   
	       System.out.println(queue.add(size() -1,toAdd));
		
	}

	@Override
	public Object dequeue() throws EmptyQueueException {
		
		if (isEmpty() == true)
		{
			throw new EmptyQueueException("The Queue is empty");
			
		}
		capacity--;
		return queue.remove(0);
	}

	@Override
	public Object peek() throws EventException {
		
		return queue.get(0);
	}

	@Override
	public void dequeueAll() {
		front = null;
		rear = null;
		capacity = 0;
		
		
	}

	@Override
	public boolean isEmpty() {
	 if (size() == 0)
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
		if (this == that)
			return true;
		if (that == null)
			return false;
		if (!(that instanceof Queue))
			return false;
		Queue other = (Queue) that;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		if (capacity != other.capacity)
			return false;
		return true;
	}

	@Override
	public Object[] toArray() {
		
		return    queue.toArray();
	}

	@Override
	public Object[] toArray(Object[] holder) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFull() {
		     
		return false;
	}

	@Override
	public int size() {
		// last index + 1 
		
		return capacity; 
	}
	@Override
	public boolean hasNext() {
		return queue.hasNext();
		}
	@Override
	public Object next() throws NoSuchElementException {
		
		return queue.next();
	}

}
