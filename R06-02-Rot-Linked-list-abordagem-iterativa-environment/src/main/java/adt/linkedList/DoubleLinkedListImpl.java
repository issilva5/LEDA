package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {

		if (element != null) {

			if (this.isEmpty()) {

				this.setHead(new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>()));
				this.last = (DoubleLinkedListNode<T>) this.getHead();

			} else {

				this.setHead(new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>) this.getHead(), new DoubleLinkedListNode<T>()));

			}

		}

	}

	@Override
	public void removeFirst() {

		if (!this.isEmpty()) {

			if (this.size() == 1) {

				this.setHead(this.getHead().getNext());
				this.last = (DoubleLinkedListNode<T>) this.getHead();

			} else {

				this.setHead(this.getHead().getNext());

			}

		}

	}

	@Override
	public void removeLast() {

		if (!this.isEmpty()) {

			if (this.size() == 1) {

				this.last = this.last.getPrevious();
				this.setHead(this.last);

			} else {

				this.last = this.last.getPrevious();

			}

		}

	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
