package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {

		T peak = null;

		if (!this.isEmpty()) {

			peak = this.array[this.top];

		}

		return peak;

	}

	@Override
	public boolean isEmpty() {

		return this.top == -1;

	}

	@Override
	public boolean isFull() {

		return this.top == (this.array.length - 1);

	}

	@Override
	public void push(T element) throws StackOverflowException {

		if (this.isFull()) {

			throw new StackOverflowException();

		}

		if (element != null) {
			this.top++;
			this.array[this.top] = element;
		}

	}

	@Override
	public T pop() throws StackUnderflowException {

		if (this.isEmpty()) {

			throw new StackUnderflowException();

		}

		T peak = this.top();
		this.top--;
		return peak;

	}

}
