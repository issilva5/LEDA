package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {

		T front = null;

		if (!this.isEmpty()) {

			front = this.array[0];

		}

		return front;

	}

	@Override
	public boolean isEmpty() {

		return this.tail == -1;

	}

	@Override
	public boolean isFull() {

		return this.tail == (this.array.length - 1);

	}

	private void shiftLeft() {

		for (int i = 0; i < this.tail; i++) {

			this.array[i] = this.array[i+1];

		}

		this.tail--;

	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		if(this.isFull()) {

			throw new QueueOverflowException();

		}

		if(element != null) {

			this.tail++;
			this.array[this.tail] = element;

		}

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if (this.isEmpty()) {

			throw new QueueUnderflowException();

		}
		
		T front = this.head();
		this.shiftLeft();

		return front;

	}

}
