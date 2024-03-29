package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		
		if (element != null) {
			
			if (this.isFull()) {
				
				throw new QueueOverflowException();
				
			} else {
			
				this.list.insert(element);
				
			}
			
		}
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if (this.isEmpty()) {
			
			throw new QueueUnderflowException();
			
		}
		
		T head = this.head();
		
		this.list.removeFirst();
		
		return head;
		
	}

	@Override
	public T head() {
		
		T head = null;
		
		if (!this.isEmpty()) {
			
			T[] array = this.list.toArray();
			head = array[0];
			
		}
		
		return head;
		
	}

	@Override
	public boolean isEmpty() {
		
		return this.list.isEmpty();
		
	}

	@Override
	public boolean isFull() {
		
		return this.list.size() == this.size;
		
	}

}
