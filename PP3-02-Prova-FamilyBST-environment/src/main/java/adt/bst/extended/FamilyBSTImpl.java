package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class FamilyBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements FamilyBST<T>{	
	

	@Override
	public boolean primosPrimeiroGrau(T elem1, T elem2) {

		boolean areCousin = false;

		BSTNode<T> nodeOne = this.search(elem1);

		if (!nodeOne.isEmpty()) {

			BSTNode<T> grandParentOne = this.getGrandParent(nodeOne);

			if (grandParentOne != null) {

				BSTNode<T> cousinNode = null;

				if (elem1.compareTo(grandParentOne.getData()) < 0) {

					cousinNode = this.search((BSTNode<T>) grandParentOne.getRight(), elem2);

				} else if (elem1.compareTo(grandParentOne.getData()) > 0) {

					cousinNode = this.search((BSTNode<T>) grandParentOne.getLeft(), elem2);

				}

				if (cousinNode != null && !cousinNode.isEmpty()) {

					BSTNode<T> grandParentTwo = this.getGrandParent(cousinNode);

					if (grandParentOne.equals(grandParentTwo)) {

						areCousin = true;

					}

				}

			}

		}

		return areCousin;

	}

	private BSTNode<T> getGrandParent(BSTNode<T> node) {

		BSTNode<T> grandParent = null;

		if (node.getParent() != null) {

			node = (BSTNode<T>) node.getParent();

			if (node.getParent() != null) {

				grandParent = (BSTNode<T>) node.getParent();

			}

		}

		return grandParent;

	}


	@Override
	public boolean primosSegundoGrau(T elem1, T elem2) {
		//primos em primeiro grau de nossos pais sao nossos primos em segundo grau.

		boolean areCousin = false;

		BSTNode<T> node = this.search(elem1);
		BSTNode<T> parent = null;

		if (!node.isEmpty()) {

			parent = (BSTNode<T>) node.getParent();

			if (parent != null) {

				areCousin = areCousin || this.primosPrimeiroGrau(parent.getData(), elem2);

			}

		}

		node = this.search(elem2);
		parent = null;

		if (!node.isEmpty()) {

			parent = (BSTNode<T>) node.getParent();

			if (parent != null) {

				areCousin = areCousin || this.primosPrimeiroGrau(parent.getData(), elem1);

			}

		}

		return areCousin;

	}
	
	
	/**
	 * NAO ALTERAR OS METODOS ABAIXO PORQUE SERAO UTULIZADOS PELOS TESTES
	 */
	@Override
	public void insert(T element) {
		insert(root, element);
	}

	protected void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
		} else {
			if (element.compareTo(node.getData()) < 0) {
				insert((BSTNode<T>)node.getLeft(), element);
			} else if (element.compareTo(node.getData()) > 0) {
				insert((BSTNode<T>)node.getRight(), element);
			}
		}
	}
	
	@Override
	public BSTNode<T> search(T element) {
		return search(root, element);
	}

	protected BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> result = node;
		if (element != null) {
			if (!node.isEmpty()) {
				if (element.compareTo(node.getData()) == 0) {
					result = node;
				} else if (element.compareTo(node.getData()) < 0) {
					result = search((BSTNode<T>)node.getLeft(), element);
				} else {
					result = search((BSTNode<T>)node.getRight(), element);
				}
			}
		}

		return result;
	}
}
