package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		
		if (element != null) {
			
			boolean full = true;
			int iterator = 0;
			
			while (iterator < this.table.length) {
				
				int hash = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, iterator);
				
				if (this.table[hash] == null || this.table[hash].equals(this.deletedElement)) {
					this.table[hash] = element;
					full = false;
					break;
				}
				
				iterator++;
				
			}
			
			if (full) {
				
				throw new HashtableOverflowException();
				
			} else {
			
				this.COLLISIONS += iterator;
				this.elements++;
				
			}
			
		}
		
	}

	@Override
	public void remove(T element) {
		
		if (element != null) {
			
			int iterator = 0;
			
			while (iterator < this.table.length) {
				
				int hash = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, iterator);
				
				if (this.table[hash] == null) {
					break;
				} else if (this.table[hash].equals(element)) {
					this.table[hash] = this.deletedElement;
					this.elements--;
					break;
				}
				
				iterator++;
				
			}
			
		}
		
	}

	@Override
	public T search(T element) {
		
		T returnValue = null;
		
		if (element != null) {
			
			int iterator = 0;
			
			while (iterator < this.table.length) {
				
				int hash = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, iterator);
				
				if (this.table[hash] == null) {
					break;
				} else if (this.table[hash].equals(element)) {
					returnValue = element;
					break;
				}
				
				iterator++;
				
			}
			
		}
		
		return returnValue;
		
	}

	@Override
	public int indexOf(T element) {
		
		int index = -1;
		
		if (element != null) {
			
			int iterator = 0;
			
			while (iterator < this.table.length) {
				
				int hash = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, iterator);
				
				if (this.table[hash] == null) {
					break;
				} else if (this.table[hash].equals(element)) {
					index = hash;
					break;
				}
				
				iterator++;
				
			}
			
		}
		
		return index;
		
	}
}
