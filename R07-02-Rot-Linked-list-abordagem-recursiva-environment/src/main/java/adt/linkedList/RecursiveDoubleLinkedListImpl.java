package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data, RecursiveDoubleLinkedListImpl<T> next, RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	public RecursiveDoubleLinkedListImpl(T data) {
		super(data);
	}

	public RecursiveDoubleLinkedListImpl(T data, RecursiveDoubleLinkedListImpl<T> previous) {
		super(data);
		this.previous = previous;
	}


	@Override
	public void insert(T element) {

		if (element != null) {

			if (this.isEmpty()) {

				this.data = element;

			} else {

				if (this.next == null) {

					this.next = new RecursiveDoubleLinkedListImpl<>(element);
					((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this;

				} else {

					this.next.insert(element);

				}

			}

		}

	}

	@Override
	public void remove(T element) {

		if (!this.isEmpty()) {

			if (this.data.equals(element)) {

				if (this.size() == 1) {

					this.data = null;

				} else {

					((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this.previous;
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

	@Override
	public void insertFirst(T element) {

		if (element != null) {

			if (this.isEmpty()) {

				this.data = element;

			} else {

				RecursiveDoubleLinkedListImpl<T> auxNode = new RecursiveDoubleLinkedListImpl<T>(this.data, (RecursiveDoubleLinkedListImpl<T>) this.next, this);
				this.data = element;
				this.next = auxNode;

			}

		}

	}

	@Override
	public void removeFirst() {

		if (!this.isEmpty()) {

			if (this.next == null) {

				this.data = null;

			} else {

				((RecursiveDoubleLinkedListImpl<T>) this.next).previous = null;
				this.data = this.next.data;
				this.next = this.next.next;

			}

		}

	}

	@Override
	public void removeLast() {

		if (!this.isEmpty()) {

			if (this.next == null) {

				this.previous.next = null;

			} else {

				((RecursiveDoubleLinkedListImpl<T>) this.next).removeLast();

			}

		}

	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
