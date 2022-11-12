package assign2;

import java.util.EmptyStackException;
import java.util.Iterator;

public class MyStack<E> implements StackADT<Object>, Iterable<Object>{

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
		Object returnValue = stack.remove(top);
		top--;
		return returnValue;
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
		return stack.toArray();
	}

	@Override
	public Object[] toArray(Object[] holder) throws NullPointerException {

		return stack.toArray(holder);
	}

	@Override
	public boolean contains(Object toFind) throws NullPointerException {
		for(int i = 0; i < stack.size(); i++) {
			//go through the arraylist from 0 - size, if it finds the specified value, return true
			if(stack.get(i) == toFind) {
				return true;
			}
		}
		return false;
	}
	

	@Override
	public int search(Object toFind) {

		for(int i = 0; i < stack.size(); i++) {
			if(stack.get(i) == toFind) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Iterator<Object> iterator() {
		return stack.iterator();
	}

	@Override
	public boolean equals(StackADT<Object> that) {
		
		for (int i = top; i > 0; i--) {
			//if this.peek() does not equal stack.remove()
			if(stack.get(i) != that.peek()) {
				return false;
		}
			that.pop();
	}
		return true;
	}

	@Override
	public int size() {

		return stack.size();
	}
}
