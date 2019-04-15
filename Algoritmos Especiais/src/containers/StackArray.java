package containers;

public class StackArray<T> {
	
	private T[] stack;
	private int size;
	private int capacity;
	
	@SuppressWarnings("unchecked")
	public StackArray() {
		this.capacity = 100;
		this.stack = (T[]) new Object[this.capacity];
		this.size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public StackArray(int capacity) {
		this.capacity = capacity;
		this.stack = (T[]) new Object[this.capacity];
		this.size = 0;
	}
	
	public void push(T elem) {
		
		if(this.size == this.capacity) {
			
			this.resize();
			
		}
		
		this.stack[this.size++] = elem;
	}
	
	@SuppressWarnings("unchecked")
	private void resize() {
		
		StackArray<T> aux = new StackArray<>(this.capacity);
		
		while(!this.isEmpty()) {
			
			aux.push(this.pop());
			
		}
		
		this.stack = (T[]) new Object[this.capacity * 2];
		
		while(!aux.isEmpty()) {
			
			this.push(aux.pop());
			
		}
		
	}

	public T pop() {
		return this.stack[this.size--];
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public T top() {
		return this.stack[this.size - 1];
	}
	
	public int size() {
		return this.size;
	}
	
	public void clear() {
		
		while(!this.isEmpty()) {
			
			this.pop();
			
		}
		
	}
	
}
