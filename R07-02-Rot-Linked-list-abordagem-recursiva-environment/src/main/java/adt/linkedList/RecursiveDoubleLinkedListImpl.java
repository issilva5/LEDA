package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data) {
		super(data);
	}

	@Override
	public void insert(T element) {
		
		if (element != null) {
			
			if (this.isEmpty()) {
				
				this.data = element;
				
			} else if (this.next == null) {
				
				RecursiveDoubleLinkedListImpl<T> auxNode = new RecursiveDoubleLinkedListImpl<>(element);
				this.next = auxNode;
				auxNode.previous = this;
				
			} else {
				
				this.next.insert(element);
				
			}
			
		}
		
	}
	
	@Override
	public void remove(T element) {
		
		if (element != null) {
			
			if (!this.isEmpty()) {
				
				if (this.data.equals(element)) {
					
					if (this.next == null) {
						
						if (this.previous == null) {
							
							this.data = null;
							
						} else {
							
							this.previous.next = this.next;
							
						}
						
					} else {
						
						if (this.previous == null) {
							
							((RecursiveDoubleLinkedListImpl<T>) this.next).previous = null;
							
							if (this.next.next != null) {
								
								((RecursiveDoubleLinkedListImpl<T>) this.next.next).previous = this;
								
							}
							
							this.data = this.next.data;
							this.next = this.next.next;
							
						} else {
							
							this.previous.next = this.next;
							((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this.previous;
							
						}
						
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
	public void insertFirst(T element) {
		
		if (element != null) {
			
			if (this.isEmpty()) {
				
				this.data = element;
				
			} else {
				
				RecursiveDoubleLinkedListImpl<T> auxNode = new RecursiveDoubleLinkedListImpl<>(this.data);
				auxNode.next = this.next;
				auxNode.previous = this;
				
				if (this.next != null) {
					
					((RecursiveDoubleLinkedListImpl<T>) this.next).previous = auxNode;
					
				}
				
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
				
				if (this.next.next != null) {
					
					((RecursiveDoubleLinkedListImpl<T>) this.next.next).previous = this;
					
				}
				
				this.data = this.next.data;
				this.next = this.next.next;
				
			}
			
		}
		
	}

	@Override
	public void removeLast() {
		
		if (!this.isEmpty()) {
			
			if (this.next == null) {
				
				if (this.previous == null) {
					
					this.data = null;
					
				} else {
					
					this.previous.next = null;
					
				}
				
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
