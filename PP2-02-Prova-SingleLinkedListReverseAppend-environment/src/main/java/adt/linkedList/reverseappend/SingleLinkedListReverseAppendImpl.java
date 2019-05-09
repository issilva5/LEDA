package adt.linkedList.reverseappend;

import adt.linkedList.SingleLinkedListNode;

/**
 * 
 * @see SingleLinkedListReverseAppend
 * 
 * @author campelo
 *
 * @param <T>
 */
public class SingleLinkedListReverseAppendImpl<T> implements SingleLinkedListReverseAppend<T> {
	
	/*
	 * Nao remover esse atributo nem criar outros
	 */
	protected SingleLinkedListNode<T> head;
	
	/*
	 * Nao modifique o construtor
	 * @param head
	 */
	public SingleLinkedListReverseAppendImpl() {
		head = new SingleLinkedListNode<T>();
	}

	/* (non-Javadoc)
	 * @see adt.linkedList.reverseappend.SingleLinkedListReverseAppend#doIt(java.lang.Object)
	 * 
	 * Implemente apenas este metodo de acordo com os comentários da interface.
	 * 
	 */
	@Override
    public void doIt(T elem) {
    	
		if (elem != null) {

			if (this.head.isNIL()) {

				this.head = new SingleLinkedListNode<T>(elem, new SingleLinkedListNode<T>());

			} else {

				SingleLinkedListNode<T> toAddNode = new SingleLinkedListNode<T>(elem, new SingleLinkedListNode<T>());
				SingleLinkedListNode<T> auxNode = toAddNode;

				while (!this.head.getNext().isNIL()) {

					SingleLinkedListNode<T> previous = this.head;
					SingleLinkedListNode<T> current = this.head.getNext();

					while (!current.getNext().isNIL()) {

						current = current.getNext();
						previous = previous.getNext();

					}

					auxNode.setNext(current);
					auxNode = auxNode.getNext();
					previous.setNext(new SingleLinkedListNode<>());

				}

				auxNode.setNext(this.head);
				this.head = toAddNode;

			}

		}

    }
    
	
	
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     */
	@Override
    public String toString() {
    	String retorno = "";
    	SingleLinkedListNode<T> currentNode = this.head;
    	while (currentNode!=null) {
    		if (!retorno.equals("")) {
    			retorno += " ";
    		}
    		retorno += currentNode;
    		currentNode = currentNode.getNext();
    	}
		return retorno;
    }
    
}