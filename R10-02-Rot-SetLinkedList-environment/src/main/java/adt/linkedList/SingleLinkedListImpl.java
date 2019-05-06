package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {

		return this.head.isNIL();

	}

	@Override
	public int size() {

		int size = 0;

		SingleLinkedListNode<T> auxNode = this.head;

		while (!auxNode.isNIL()) {

			size++;
			auxNode = auxNode.getNext();

		}

		return size;

	}

	@Override
	public T search(T element) {

		T returnValue = null;

		if (element != null) {

			SingleLinkedListNode<T> auxNode = this.head;

			while (!auxNode.isNIL()) {

				if (auxNode.getData().equals(element)) {

					returnValue = element;
					break;

				}

				auxNode = auxNode.getNext();

			}

		}

		return returnValue;

	}

	@Override
	public void insert(T element) {

		if (element != null) {

			SingleLinkedListNode<T> auxNode = this.head;

			while (!auxNode.isNIL()) {

				auxNode = auxNode.getNext();

			}

			auxNode.setNext(new SingleLinkedListNode<T>());
			auxNode.setData(element);

		}

	}

	@Override
	public void remove(T element) {

		if (element != null) {

			if (!this.isEmpty()) {

				SingleLinkedListNode<T> previousNode = this.head;

				if (previousNode.getData().equals(element)) {

					this.head = previousNode.getNext();

				} else {

					SingleLinkedListNode<T> auxNode = previousNode.getNext();

					while (!auxNode.isNIL()) {

						if (auxNode.getData().equals(element)) {

							previousNode.setNext(auxNode.getNext());

						}

						previousNode = auxNode;
						auxNode = auxNode.getNext();

					}

				}

			}

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {

		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> auxNode = this.head;
		int cont = 0;

		while (!auxNode.isNIL()) {

			array[cont] = auxNode.getData();
			auxNode = auxNode.getNext();
			cont++;

		}

		return array;

	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}