package containers;

public class QueueArray<T> {
	
	private T[] queue;
	private int head;
	private int tail;
	private int capacity;
	
	@SuppressWarnings("unchecked")
	public QueueArray() {
		this.capacity = 100;
		this.head = -1;
		this.tail = -1;
		this.queue = (T[]) new Object[this.capacity];
	}
	
	@SuppressWarnings("unchecked")
	public QueueArray(int capacity) {
		this.capacity = capacity;
		this.head = -1;
		this.tail = -1;
		this.queue = (T[]) new Object[this.capacity];
	}
	
	public int size() {
		return ((this.tail - this.head + this.capacity) % this.capacity) + 1;
	}
	
	public void push(T elem) {
		
		if((this.tail + 1) % this.capacity == this.head) {
			
			this.resize();
			
		}
		
		if(this.tail == -1) {
			this.head++;
		}
		
		this.tail = (this.tail + 1) % this.capacity;
		this.queue[this.tail] = elem;
	}
	
	@SuppressWarnings("unchecked")
	private void resize() {
		
		QueueArray<T> aux = new QueueArray<>(this.capacity);
		
		while(!this.isEmpty()) {
			
			aux.push(this.pop());
			
		}
		
		this.queue = (T[]) new Object[2 * this.capacity];
		
		while(!aux.isEmpty()) {
			
			this.push(aux.pop());
			
		}
		
	}

	public T pop() {
		
		T result = this.front();
		
		if(this.head == this.tail) {
			
			this.head = -1;
			this.tail = -1;
			
		} else {
		
			this.head = (this.head + 1) % this.capacity;
			
		}
		
		return result;
	}
	
	public T front() {
		return this.queue[this.head];
	}
	
	public boolean isEmpty() {
		return this.head == -1;
	}
	
	public void clear() {
		
		while(!this.isEmpty()) {
			
			this.pop();
			
		}
		
	}
	
}
