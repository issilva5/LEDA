package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {

		if (this.isFull()) {

			throw new StackOverflowException();

		}

		this.top.insertFirst(element);

	}

	@Override
	public T pop() throws StackUnderflowException {

		if (this.isEmpty()) {

			throw new StackUnderflowException();

		}

		T aux = this.top();

		this.top.removeFirst();

		return aux;

	}

	@Override
	public T top() {

		T top = null;

		if (!this.isEmpty()) {

			T[] aux = this.top.toArray();
			top = aux[0];

		}

		return top;

	}

	@Override
	public boolean isEmpty() {

		return this.top.isEmpty();

	}

	@Override
	public boolean isFull() {

		return this.size == this.top.size();

	}

}
