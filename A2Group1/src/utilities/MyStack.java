package assign2;

import java.util.EmptyStackException;
import java.util.Iterator;

public class MyStack implements StackADT<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int top;
	private MyArrayList<Object> stack;
	
	public MyStack() {
		this.stack = new MyArrayList<>();
		this.top = -1;
	}
	
	@Override
	public void push(Object toAdd) throws NullPointerException {
		top++;
		stack.add(toAdd);
		
	}

	@Override
	public Object pop() throws EmptyStackException {
		stack.remove(top);
		top--;
		return null;
	}

	@Override
	public Object peek() throws EmptyStackException {
		
		return stack.get(top);
	}

	@Override
	public void clear() {
		stack.clear();
		
	}

	@Override
	public boolean isEmpty() {
		
		return stack.isEmpty();
		
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
	public boolean contains(Object toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int search(Object toFind) {
		
		return 0;
	}

	@Override
	public Iterator<Object> iterator() {
		return stack.iterator();
	}

	@Override
	public boolean equals(StackADT<Object> that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return stack.size();
	}
}