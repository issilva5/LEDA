package list;

@SuppressWarnings("unchecked")
public class SingleLinkedListRecursive<T> implements List<T> {
	
	protected T data;
	
	protected SingleLinkedListRecursive<T> next;
	
	public SingleLinkedListRecursive() {
		
	}
	
	public SingleLinkedListRecursive(T data, SingleLinkedListRecursive<T> next) {
		this.data = data;
		this.next = next;
	}
	
	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		
		int size = 0;
		
		if (this.next == null) {
			
			if (this.data != null) {
				
				size = 1;
				
			}
			
		} else {
			
			size = 1 + this.next.size();
			
		}
		
		return size;
	}

	@Override
	public T search(T element) {
		
		T returnValue = null;
		
		if (element != null) {
			
			if (this.data.equals(element)) {
				
				returnValue = element;
				
			} else if (this.next != null) {
				
				returnValue = this.next.search(element);
				
			}
			
		}
		
		return returnValue;
	}

	@Override
	public void insert(T element) {
		
		if (element != null) {
			
			if (this.next == null) {
				
				if (this.data == null) {
					
					this.data = element;
					
				} else {
				
					this.next = new SingleLinkedListRecursive<T>();
					this.next.data = element;
					
				}
				
			} else {
				
				this.next.insert(element);
				
			}
			
		}
		
		
	}

	@Override
	public void remove(T element) {

		if (element != null) {
			
			if (!this.isEmpty()) {
				
				if (this.next != null) {
				
					if (this.data.equals(element)) {
						
						this.data = this.next.data;
						this.next = this.next.next;
						
					} else {
						
						this.next.remove(element);
						
					}
					
				} else {
					
					if (this.data.equals(element)) {
						
						this.data = null;
						
					}
					
				}
				
			}
			
		}
		
	}

	@Override
	public T[] toArray() {
		
		T[] array = (T[]) new Object[this.size()];
		
		this.toArray(array, 0);
		
		return array;
	}

	private void toArray(T[] array, int i) {
		
		array[i] = this.data;
			
		if (this.next != null) {
			this.next.toArray(array, i+1);
		}
		
	}

}
