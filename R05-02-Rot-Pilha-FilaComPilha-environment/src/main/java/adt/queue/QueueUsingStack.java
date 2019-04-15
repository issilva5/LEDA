package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {

		try {

			if(element != null) {

				this.stack1.push(element);

			}

		} catch (StackOverflowException s) {

			throw new QueueOverflowException();

		}

	}

	@Override
	public T dequeue() throws QueueUnderflowException {

		T front = null;

		try {

			do {

				front = this.stack1.pop();
				this.stack2.push(front);

			} while (!this.stack1.isEmpty());

			this.stack2.pop();

			while (!this.stack2.isEmpty()) {

				this.stack1.push(this.stack2.pop());

			}

		} catch (StackUnderflowException s) {

			throw new QueueUnderflowException();

		} catch (StackOverflowException s) {



		}

		return front;

	}

	@Override
	public T head() {

		T front = null;

		try {

			do {

				front = this.stack1.pop();
				this.stack2.push(front);

			} while (!this.stack1.isEmpty());

			while (!this.stack2.isEmpty()) {

				this.stack1.push(this.stack2.pop());

			}

		} catch (StackUnderflowException s) {



		} catch (StackOverflowException s) {



		}

		return front;
	}

	@Override
	public boolean isEmpty() {

		return this.stack1.isEmpty();

	}

	@Override
	public boolean isFull() {

		return this.stack1.isFull();

	}

}
