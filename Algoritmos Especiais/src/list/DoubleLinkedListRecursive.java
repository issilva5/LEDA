package list;

import java.util.Arrays;

public class DoubleLinkedListRecursive<T> extends SingleLinkedListRecursive<T> implements DoubleLinkedList<T> {
	
	private DoubleLinkedListRecursive<T> previous;
	
	public DoubleLinkedListRecursive() {
		super();
	}
	
	public DoubleLinkedListRecursive(T data, DoubleLinkedListRecursive<T> next,
			DoubleLinkedListRecursive<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insert(T element) {
		
		if (element != null) {
			
			if (this.next == null) {
				
				if (this.data == null) {
					
					this.data = element;
					
				} else {
					
					this.next = new DoubleLinkedListRecursive<T>();
					this.next.data = element;
					
					DoubleLinkedListRecursive<T> aux = (DoubleLinkedListRecursive<T>) this.next;
					aux.previous = this;
					
				}
				
			} else {
				
				this.next.insert(element);
				
			}
			
		}
		
	}

	@Override
	public void insertFirst(T element) {
		
		if (element != null) {
			
			DoubleLinkedListRecursive<T> aux = new DoubleLinkedListRecursive<T>(this.data, (DoubleLinkedListRecursive<T>) this.next, this.previous);
			this.data = element;
			this.next = aux;
			
		}
		
	}

	@Override
	public void removeFirst() {
		
		if (!this.isEmpty()) {
			
			if (this.next != null) {
				
				this.data = this.next.data;
				this.next = this.next.next;
				
			} else {
				
				this.data = null;
				
			}
			
		}
		
	}

	@Override
	public void removeLast() {
		
		if (!this.isEmpty()) {

			if (this.next != null) {
				
				DoubleLinkedListRecursive<T> aux = (DoubleLinkedListRecursive<T>) this.next;
				aux.removeLast();
				
			} else {
				
				if (this.size() == 1) {
					
					this.removeFirst();
					
				} else {
				
					this.previous.next = null;
					
				}
				
			}
			
		}
		
	}

}
