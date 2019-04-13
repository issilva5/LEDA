package containers;

import java.util.Iterator;

public class DoubleEndedQueueArray<T> implements Iterator<T>, Iterable<T> {
	
	private T[] deque;
	
	public void pushFront(T elem) {
		
	}
	
	public void pushBack(T elem) {
		
	}
	
	public T popFront() {
		return null;
	}
	
	public T popBack() {
		return null;
	}
	
	public T front() {
		return null;
	}
	
	public T back() {
		return null;
	}
	
	public int size() {
		return 0;
	}
	
	public boolean isEmpty() {
		return true;
	}
	
	public void clear() {
		
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		return this;
	}
	
}
