package utilities;

import java.util.NoSuchElementException;

import org.w3c.dom.Node;
import org.w3c.dom.events.EventException;

public class MyQueue <E> implements QueueADT, Iterator {
	
	// Declare variables
	private static Node front, rear;
	static int capacity;
	private static int queueArray[];
	MyDLLNode<E> root;
	private MyDLL<Object> queue = new MyDLL();
	
	
	
	MyQueue()
	{
		
	}
	//Constructor
	MyQueue( int size)
	{
		//front = rear = 0;
		capacity = size;
		queueArray = new int [capacity];
		
	}

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
		MyQueue other = (MyQueue) that;
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
		return queue.toArray(holder);
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