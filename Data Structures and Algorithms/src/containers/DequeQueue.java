package containers;

public class DequeQueue<T> {
	
	private DoubleEndedQueueArray<T> queue;

	public DequeQueue() {
		this.queue = new DoubleEndedQueueArray<>();
	}

	public DequeQueue(int capacity) {
		this.queue = new DoubleEndedQueueArray<>(capacity);
	}
	
	public int size() {
		return this.queue.size();
	}
	
	public void push(T elem) {
		this.queue.pushFront(elem);
	}

	public T pop() {
		return this.queue.popBack();
	}
	
	public T front() {
		return this.queue.back();
	}
	
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}
	
	public void clear() {
		this.queue.clear();
	}
	
}
