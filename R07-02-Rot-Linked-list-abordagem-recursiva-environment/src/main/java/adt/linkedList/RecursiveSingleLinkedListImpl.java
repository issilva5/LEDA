package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	public RecursiveSingleLinkedListImpl(T data) {
		this.data = data;
	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {

		int size = 0;

		if (!this.isEmpty()) {

			if (this.next == null) {

				size = 1;

			} else {

				size = 1 + this.next.size();

			}

		}

		return size;

	}

	@Override
	public T search(T element) {

		T result = null;

		if (element != null) {

			if (!this.isEmpty()) {

				if (this.data.equals(element)) {

					result = element;

				} else {

					if (this.next != null) {

						result = this.next.search(element);

					}

				}

			}

		}

		return result;

	}

	@Override
	public void insert(T element) {

		if (element != null) {

			if (this.isEmpty()) {

				this.data = element;

			} else {

				if (this.next == null) {

					this.next = new RecursiveSingleLinkedListImpl<>(element);

				} else {

					this.next.insert(element);

				}

			}

		}

	}

	@Override
	public void remove(T element) {

		if (element != null) {

			if (!this.isEmpty()) {

				if (this.data.equals(element)) {

					if (this.size() == 1) {

						this.data = null;

					} else {

						this.data = this.next.data;
						this.next = this.next.next;

					}

				} else {

					if (this.next != null) {

						this.next.remove(element);

					}

				}

			}

		}

	}

	@Override
	public T[] toArray() {

		T[] array = (T[]) new Object[this.size()];

		if (!this.isEmpty()) {
			this.toArray(array, 0);
		}

		return array;

	}

	private void toArray(T[] array, int i) {

		array[i] = this.data;

		if (this.next != null) {

			this.next.toArray(array, i+1);

		}

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
