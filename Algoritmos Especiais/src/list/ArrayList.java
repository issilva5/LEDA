package list;
@SuppressWarnings("unchecked")
public class ArrayList<T> implements List<T> {
	
	private T[] array;
	private int pos;
	
	public ArrayList() {
		this.array = (T[]) new Object[1000];
		this.pos = -1;
	}
	
	@Override
	public boolean isEmpty() {
		return this.pos == -1;
	}

	@Override
	public int size() {
		return pos + 1;
	}

	@Override
	public T search(T element) {
		T returnValue = null;
		
		int iterator = 0;
		
		while (iterator <= this.pos) {
			
			if (this.array[iterator].equals(element)) {
				
				returnValue = this.array[iterator];
				break;
				
			}
			
			iterator++;
			
		}
		
		return returnValue;
	}

	@Override
	public void insert(T element) {
		
		if (element != null) {
			
			this.pos++;
			
			if(this.pos == this.array.length) {
				
				this.extend();
				
			}
			
			this.array[this.pos] = element;
			
		}
		
		
	}

	private void extend() {
		
		T[] arrayAux = (T[]) new Object[2 * this.array.length];
		
		for (int i = 0; i < this.array.length; i++) {
			
			arrayAux[i] = this.array[i];
			
		}
		
		this.array = arrayAux;
		
	}

	@Override
	public void remove(T element) {
		
		int iterator = 0;
		
		while (iterator <= this.pos) {
			
			if (this.array[iterator].equals(element)) {
				
				this.shiftLeft(iterator);
				this.pos--;
				break;
				
			}
			
			iterator++;
			
		}
		
	}

	private void shiftLeft(int iterator) {
		
		for (int i = iterator; i < this.pos; i++) {
			
			this.array[i] = this.array[i+1];
			
		}
		
	}

	@Override
	public T[] toArray() {
		
		T[] arrayAux = (T[]) new Object[this.pos + 1];
		
		for (int i = 0; i <= this.pos; i++) {
			
			arrayAux[i] = this.array[i];
			
		}
		
		return arrayAux;
	}

}
