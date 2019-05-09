package containers;

public class DoubleEndedQueueArray<T> {
	
	private T[] deque;
	private int head;
	private int tail;
	private int capacity;
	
	public DoubleEndedQueueArray() {
		this(100);
	}
	
	@SuppressWarnings("unchecked")
	public DoubleEndedQueueArray(int capacity) {
		this.capacity = capacity;
		this.deque = (T[]) new Object[this.capacity];
		this.tail = -1;
		this.head = this.capacity;
	}
	
	@SuppressWarnings("unchecked")
	private void resize() {
		
		DoubleEndedQueueArray<T> aux = new DoubleEndedQueueArray<>(this.capacity);
		
		this.copy(this, aux);
		
		this.capacity *= 2;
		
		this.deque = (T[]) new Object[this.capacity];
		
		this.head = this.capacity;
		this.tail = -1;
		
		this.copy(aux, this);
		
	}
	
	public void pushFront(T elem) {
		
		if(this.size() == this.capacity) {
			
			this.resize();
			
		}
		
		this.head = (this.head - 1 + this.capacity) % this.capacity;
		this.deque[this.head] = elem;
		
	}

	public void pushBack(T elem) {
		
		if(this.size() == this.capacity) {
			
			this.resize();
			
		}
		
		this.tail = (this.tail + 1 + this.capacity) % this.capacity;
		this.deque[this.tail] = elem;
		
	}
	
	public T popFront() {
		
		if(this.isEmpty())
			throw new UnsupportedOperationException();
		
		T aux = this.front();
		
		if(this.size() == 1) {
			
			this.head = this.capacity;
			this.tail = -1;
			
		} else {
		
			this.head = (this.head + 1 + this.capacity) % this.capacity;
			
		}
		
		return aux;
		
	}
	
	public T popBack() {
		
		if(this.isEmpty())
			throw new UnsupportedOperationException();
		
		T aux = this.back();
		
		if(this.size() == 1) {
			
			this.head = this.capacity;
			this.tail = -1;
			
		} else {
		
			this.tail = (this.tail - 1 + this.capacity) % this.capacity;
			
		}
		
		return aux;
		
	}
	
	public T front() {
		
		if(this.isEmpty())
			throw new UnsupportedOperationException();
		
		return this.deque[this.head];
		
	}
	
	public T back() {
		
		if(this.isEmpty())
			throw new UnsupportedOperationException();
		
		return this.deque[this.tail];
		
	}
	
	public int size() {
		return (this.tail - this.head + this.capacity) % this.capacity + 1;
	}
	
	public boolean isEmpty() {
		return this.tail == -1 && this.head == this.capacity;
	}
	
	public void clear() {
		
		while(!this.isEmpty()) {
			
			this.popFront();
			
		}
		
	}
	
	public void copy(DoubleEndedQueueArray<T> from, DoubleEndedQueueArray<T> to) {
		
		while(!from.isEmpty()) {
			
			to.pushFront(from.popFront());
			
		}
		
	}

	@Override
	public String toString() {
		
		String result = "Deque [";
		
		for(int i = 0; i < this.size(); i++) {
			
			result += this.deque[(this.head + i + this.capacity) % this.capacity].toString();
			result += (i < this.size() - 1 ? ", " : "");
			
		}
		
		result += "]";
		
		return result;
		
	}

	public int getHead() {
		return head;
	}

	public int getTail() {
		return tail;
	}

	public int getCapacity() {
		return capacity;
	}
	
}
