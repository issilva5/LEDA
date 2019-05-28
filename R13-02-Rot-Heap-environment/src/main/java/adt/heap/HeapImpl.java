package adt.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import util.Util;

/**
 * O comportamento de qualquer heap é definido pelo heapify. Neste caso o
 * heapify dessa heap deve comparar os elementos e colocar o maior sempre no
 * topo. Ou seja, admitindo um comparador normal (responde corretamente 3 > 2),
 * essa heap deixa os elementos maiores no topo. Essa comparação não é feita
 * diretamente com os elementos armazenados, mas sim usando um comparator. Dessa
 * forma, dependendo do comparator, a heap pode funcionar como uma max-heap ou
 * min-heap.
 */
public class HeapImpl<T extends Comparable<T>> implements Heap<T> {

	protected T[] heap;
	protected int index = -1;
	/**
	 * O comparador é utilizado para fazer as comparações da heap. O ideal é mudar
	 * apenas o comparator e mandar reordenar a heap usando esse comparator. Assim
	 * os metodos da heap não precisam saber se vai funcionar como max-heap ou
	 * min-heap.
	 */
	protected Comparator<T> comparator;

	private static final int INITIAL_SIZE = 20;
	private static final int INCREASING_FACTOR = 10;

	/**
	 * Construtor da classe. Note que de inicio a heap funciona como uma min-heap.
	 */
	@SuppressWarnings("unchecked")
	public HeapImpl(Comparator<T> comparator) {
		this.heap = (T[]) (new Comparable[INITIAL_SIZE]);
		this.comparator = comparator;
	}

	// /////////////////// METODOS IMPLEMENTADOS
	private int parent(int i) {
		return (i - 1) / 2;
	}

	/**
	 * Deve retornar o indice que representa o filho a esquerda do elemento indexado
	 * pela posicao i no vetor
	 */
	private int left(int i) {
		return (i * 2 + 1);
	}

	/**
	 * Deve retornar o indice que representa o filho a direita do elemento indexado
	 * pela posicao i no vetor
	 */
	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	@Override
	public boolean isEmpty() {
		return (index == -1);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> resp = new ArrayList<T>();
		for (int i = 0; i <= this.index; i++) {
			resp.add(this.heap[i]);
		}
		return (T[]) resp.toArray(new Comparable[0]);
	}

	// ///////////// METODOS A IMPLEMENTAR
	/**
	 * Valida o invariante de uma heap a partir de determinada posicao, que pode ser
	 * a raiz da heap ou de uma sub-heap. O heapify deve colocar os maiores
	 * (comparados usando o comparator) elementos na parte de cima da heap.
	 */
	private void heapify(int position) {
		
		T bigger = this.getMax(position);
		int left = this.left(position);
		int right = this.right(position);
		
		if (this.comparator.compare(bigger, this.heap[position]) != 0) {
			
			if (this.comparator.compare(bigger, this.heap[left]) == 0) {
				
				Util.swap(this.heap, position, left);
				this.heapify(left);
				
			} else {
				
				Util.swap(this.heap, position, right);
				this.heapify(right);
				
			}
			
		}
		
	}

	private T getMax(int position) {
		
		int left = this.left(position);
		int right = this.right(position);
		T bigger = this.heap[position];
		
		if (left <= this.index && this.comparator.compare(this.heap[left], this.heap[position]) > 0) {
			
			if (right > this.index || this.comparator.compare(this.heap[left], this.heap[right]) > 0) {
				
				bigger = this.heap[left];
				
			} else if (right <= this.index) {
				
				bigger = this.heap[right];
				
			}
			
		} else if (right <= this.index && this.comparator.compare(this.heap[right], this.heap[position]) > 0) {
			
			if (left > this.index || this.comparator.compare(this.heap[right], this.heap[left]) > 0) {
				
				bigger = this.heap[right];
				
			} else if (left <= this.index) {
				
				bigger = this.heap[left];
				
			}
			
		}
		
		return bigger;
	}

	@Override
	public void insert(T element) {
		// ESSE CODIGO E PARA A HEAP CRESCER SE FOR PRECISO. NAO MODIFIQUE
		if (index == heap.length - 1) {
			heap = Arrays.copyOf(heap, heap.length + INCREASING_FACTOR);
		}
		
		this.heap[++this.index] = element;
		this.heapifyUp();
		
	}

	private void heapifyUp() {
		
		int aux = this.index;
		while (aux > 0 && this.comparator.compare(this.heap[aux], this.heap[this.parent(aux)]) > 0) {
			
			Util.swap(this.heap, aux, this.parent(aux));
			aux = this.parent(aux);
			
		}
		
	}

	@Override
	public void buildHeap(T[] array) {
		
		this.clear();
		for (int i = 0; i < array.length; i++) {
			
			this.insert(array[i]);
			
		}
		
	}

	private void clear() {
		
		while (!this.isEmpty()) {
			this.extractRootElement();
		}
		
	}

	@Override
	public T extractRootElement() {
		
		T root = this.rootElement();
		
		if (root != null) {
			
			this.heap[0] = this.heap[this.index--];
			this.heapify(0);
			
		}
		
		return root;
		
	}

	@Override
	public T rootElement() {
	
		T root = null;
		
		if (!this.isEmpty()) {
			
			root = this.heap[0];
			
		}
		
		return root;
	
	}

	@Override
	public T[] heapsort(T[] array) {
		
		this.clear();
		
		this.sortInsert(array);
		
		for (int i = 0; i < array.length; i++) {
			
			array[i] = this.rootElement();
			this.heap[0] = this.heap[this.index--];
			this.sortHeapify(0);
			
			
		}
		
		this.clear();
		
		return array;
		
	
	}

	private void sortHeapify(int position) {
		
		T smallest = this.getMin(position);
		int left = this.left(position);
		int right = this.right(position);
		
		if (smallest.compareTo(this.heap[position]) != 0) {
			
			if (smallest.compareTo(this.heap[left]) == 0) {
				
				Util.swap(this.heap, position, left);
				this.sortHeapify(left);
				
			} else {
				
				Util.swap(this.heap, position, right);
				this.sortHeapify(right);
				
			}
		}
		
	}

	private T getMin(int position) {
		
		int left = this.left(position);
		int right = this.right(position);
		T smallest = this.heap[position];
		
		if (left <= this.index && this.heap[left].compareTo(smallest) < 0) {
			
			if (right > this.index || this.heap[left].compareTo(this.heap[right]) < 0) {
				
				smallest = this.heap[left];
				
			} else if (right <= this.index) {
				
				smallest = this.heap[right];
				
			}
			
		} else if (right <= this.index && this.heap[right].compareTo(smallest) < 0) {
			
			if (left > this.index || this.heap[right].compareTo(this.heap[left]) < 0) {
				
				smallest = this.heap[right];
				
			} else if (left <= this.index) {
				
				smallest = this.heap[left];
				
			}
			
		}
		
		return smallest;
	}

	private void sortInsert(T[] array) {
		for (int i = 0; i < array.length; i++) {
			
			this.heap[++this.index] = array[i];
			
			int aux = this.index;
			while (aux > 0 && this.heap[aux].compareTo(this.heap[this.parent(aux)]) < 0) {
				
				Util.swap(this.heap, aux, this.parent(aux));
				aux = this.parent(aux);
				
			}
			
		}
	}

	@Override
	public int size() {
		
		return this.index + 1;
		
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] getHeap() {
		return heap;
	}

}
