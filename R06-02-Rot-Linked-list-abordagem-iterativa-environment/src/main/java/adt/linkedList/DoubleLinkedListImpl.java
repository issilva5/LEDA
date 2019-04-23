package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	@Override
	public void insert(T element) {
		
		if (element != null) {
			
			if (this.isEmpty()) {
				
				DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
				this.last = auxNode;
				this.setHead(auxNode);
				
			} else {
				
				DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>();
				
				if (this.getHead() instanceof DoubleLinkedListNode<?>) {
					
					auxNode = (DoubleLinkedListNode<T>) this.getHead();
					
				}
				
				while (!auxNode.getNext().isNIL()) {
					
					if (auxNode.getNext() instanceof DoubleLinkedListNode<?>) {
						
						auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();
						
					}
					
				}
				
				auxNode.setNext(new DoubleLinkedListNode<>(element, new DoubleLinkedListNode<>(), auxNode));
				
				if (auxNode.getNext() instanceof DoubleLinkedListNode<?>) {
					
					this.last = (DoubleLinkedListNode<T>) auxNode.getNext();
					
				}
				
			}
			
		}
		
	}
	
	@Override
	public void remove(T element) {
		
		if (element != null) {
			
			if (!this.isEmpty()) {
				
				if (this.size() == 1) {
					
					this.last = new DoubleLinkedListNode<T>();
					this.setHead(this.last);
					
				} else {
					
					if (this.getHead().getData().equals(element)) {
						
						this.setHead(this.getHead().getNext());
						
					} else {
						
						DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>();
						
						if (this.getHead() instanceof DoubleLinkedListNode<?>) {
							
							auxNode = (DoubleLinkedListNode<T>) this.getHead();
							
						}
						
						while(!auxNode.isNIL()) {
							
							if (auxNode.getData().equals(element)) {
								
								auxNode.getPrevious().setNext(auxNode.getNext());
								( (DoubleLinkedListNode<T>) auxNode.getNext()).setPrevious(auxNode.getPrevious());
								
							}
							
							if (auxNode.getNext() instanceof DoubleLinkedListNode<?>) {
								
								auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();
								
							}
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
	@Override
	public void insertFirst(T element) {

		if (element != null) {

			if (this.isEmpty()) {
				
				this.last = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(), new DoubleLinkedListNode<T>());
				this.setHead(this.last);

			} else {
				
				DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>();
				auxNode.setData(this.getHead().getData());
				auxNode.setNext(this.getHead().getNext());
				
				this.setHead(new DoubleLinkedListNode<T>(element, auxNode, new DoubleLinkedListNode<T>()));
				
				if (this.getHead() instanceof DoubleLinkedListNode<?>) {
				
					auxNode.setPrevious((DoubleLinkedListNode<T>) this.getHead());
					
				}
			}

		}

	}

	@Override
	public void removeFirst() {

		if (!this.isEmpty()) {

			if (this.size() == 1) {

				this.setHead(this.getHead().getNext());
				
				if (this.getHead() instanceof DoubleLinkedListNode<?>) {
				
					this.last = (DoubleLinkedListNode<T>) this.getHead();
					
				}

			} else {

				this.setHead(this.getHead().getNext());

			}

		}

	}

	@Override
	public void removeLast() {

		if (!this.isEmpty()) {

			if (this.size() == 1) {

				this.last = new DoubleLinkedListNode<T>();
				this.setHead(this.last);

			} else {
				
				this.last.getPrevious().setNext(new DoubleLinkedListNode<T>());
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
