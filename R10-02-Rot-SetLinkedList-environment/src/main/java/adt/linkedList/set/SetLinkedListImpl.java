package adt.linkedList.set;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

	@Override
	public void removeDuplicates() {
		
		if (!this.isEmpty()) {
			
			SingleLinkedListNode<T> first = this.head;
			
			while (!first.isNIL()) {
				
				T data = first.getData();
				
				SingleLinkedListNode<T> second = first.getNext();
				SingleLinkedListNode<T> previous = first;
				
				while (!second.isNIL()) {
					
					if (second.getData().equals(data)) {
						
						previous.setNext(second.getNext());
						
					} else {
						
						previous = second;
						
					}
					
					second = second.getNext();
					
				}
				
				first = first.getNext();
			}
			
		}
		
	}

	@Override
	public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
		
		SetLinkedListImpl<T> union = new SetLinkedListImpl<>();
		
		SingleLinkedListNode<T> aux = this.head;
		
		while (!aux.isNIL()) {
			
			union.insert(aux.getData());
			aux = aux.getNext();
			
		}
		
		aux = ((SetLinkedListImpl<T>) otherSet).getHead();
		
		while (!aux.isNIL()) {
			
			union.insert(aux.getData());
			aux = aux.getNext();
			
		}
		
		union.removeDuplicates();
		
		return union;
		
	}

	@Override
	public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
		
		SetLinkedListImpl<T> intersection = new SetLinkedListImpl<>();
		
		SingleLinkedListNode<T> aux = this.head;
		
		while (!aux.isNIL()) {
			
			if (((SetLinkedListImpl<T>) otherSet).search(aux.getData()) != null) {
				
				intersection.insert(aux.getData());
				
			}
			
			aux = aux.getNext();
			
		}
		
		intersection.removeDuplicates();
		
		return intersection;
	}

	@Override
	public void concatenate(SetLinkedList<T> otherSet) {
		
		SingleLinkedListNode<T> aux = ((SetLinkedListImpl<T>) otherSet).getHead();
		
		while (!aux.isNIL()) {
			
			this.insert(aux.getData());
			aux = aux.getNext();
			
		}
		
		this.removeDuplicates();
		
	}

}
