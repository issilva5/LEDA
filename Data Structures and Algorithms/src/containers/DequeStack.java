package containers;

public class DequeStack<T> {
	
	private DoubleEndedQueueArray<T> stack;
	
	public DequeStack() {
		this.stack = new DoubleEndedQueueArray<>();
	}
	
	public DequeStack(int capacity) {
		this.stack = new DoubleEndedQueueArray<>(capacity);
	}
	
	public void push(T elem) {
		this.stack.pushFront(elem);
	}

	public T pop() {
		return this.stack.popFront();
	}
	
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}
	
	public T top() {
		return this.stack.front();
	}
	
	public int size() {
		return this.stack.size();
	}
	
	public void clear() {
		this.stack.clear();
	}
	
}
