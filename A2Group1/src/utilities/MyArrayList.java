package assign2;

import java.util.Iterator;

public class MyArrayList<E> implements ListADT<E>, Iterable<E>{

	private static final long serialVersionUID = 1L;
	private E[] array;
	private int size;
	private static final int INITIAL_CAPACITY = 10;
	
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.array = (E[]) new Object[INITIAL_CAPACITY];
		this.size = 0;
	}
	@Override
	public int size() {
		
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		array = null;
		array = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
		
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		
		checkForIndexException(index);
		
		add(toAdd);
		
		//shift elements
		for(int i = size - 1; i > index; i--) {
			array[i] = array[i - 1];
		}
		array[index] = toAdd;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		
		//make bigger array if things are maxxed out
		if(size >= array.length) {
			E[] biggerArray =  (E[]) new Object[array.length * 2];
			System.arraycopy(array, 0, biggerArray, 0, array.length);
			array = biggerArray;
		}
		array[size] = toAdd;
		size++;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {

		for(int i = 0; i < toAdd.size(); i++) {
			add(toAdd.get(i));
		}
		
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		
		return array[index];
		
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		
		//check if index goes out of bounds
		checkForIndexException(index);
		
		E removedElement = array[index];
		
		for(int i = index; i < size - 1; i++) {
			
			array[i] = array[i + 1];
		}
		
		array[size - 1] = null;
		size--;
		
		return removedElement;
	  }
	

	@Override
	public E remove(E toRemove) throws NullPointerException {
		E removedElement = toRemove;
		
		for(int i = 0; i < size; i++) {
			
			if(array[i].equals(toRemove)) {
				
				remove(i);
			}
		}
		
		return removedElement;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		
		checkForIndexException(index);
		
		array[index] = toChange;
		
		return array[index] = toChange;
	}

	@Override
	public boolean isEmpty() {
		if (size <= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		
		for(int i = 0; i < size; i++) {
			//go through the arraylist from 0 - size, if it finds the specified value, return true
			if(array[i].equals(toFind)) {
				
				return true;
			}
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		
		return toArray(toHold);
	}

	@Override
	public Object[] toArray() {
		 @SuppressWarnings("unchecked")
		E[] sizearray = (E[]) new Object[size];
		 
		 for(int i = 0; i < size; i++) {
			 sizearray[i] = array[i];
		 }
		 
		
		return sizearray;
	}

	public void checkForIndexException(int index) {
		if(index < 0 || index > array.length) {
			throw new IndexOutOfBoundsException("You messed up." + " " +  index + " " + "is out of bounds. fix it");
		}
}
	
	
	//inner class
	@SuppressWarnings("hiding")
	class MyIterator<E> implements Iterator<E> {
		private int current;
		private MyArrayList<E> items;
		
		public MyIterator(MyArrayList<E> items){
			this.items = items;
			this.current = 0;
		}
		
		
		public boolean hasNext() {
			return this.current < this.items.size();
		}

		
		@Override
		public E next() {
			
			E ansa = items.get(current);
			current++;
			return ansa;
			
		}
	}

//if (!hasNext()) {
//	
//}
//	return  (T) MyArrayList.this.array[current++] ;

	@Override
	public Iterator<E> iterator() {
		return new MyIterator<E>(this);
		
	}
	
}


