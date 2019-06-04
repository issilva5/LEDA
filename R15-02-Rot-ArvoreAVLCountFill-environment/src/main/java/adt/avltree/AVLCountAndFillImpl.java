package adt.avltree;

import adt.bst.BSTNode;
import java.util.Arrays;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}
	
	@Override
	protected void rebalance(BSTNode<T> node) {
		
		int balance = this.calculateBalance(node);
		
		if (balance < -1) {
			
			int balanceLeft = this.calculateBalance((BSTNode<T>) node.getLeft());
			
			if (balanceLeft > 0) {
				
				this.leftRotation((BSTNode<T>) node.getLeft());
				this.rightRotation(node);
				this.LRcounter++;
				
			} else {
			
				this.rightRotation(node);
				this.RRcounter++;
				
			}
			
		} else if (balance > 1) {
			
			int balanceRight = this.calculateBalance((BSTNode<T>) node.getRight());
			
			if (balanceRight < 0) {
				
				this.rightRotation((BSTNode<T>) node.getRight());
				this.leftRotation(node);
				this.RLcounter++;
				
			} else {
			
				this.leftRotation(node);
				this.LLcounter++;
				
			}
			
		}
		
	}
	
	@Override
	public void fillWithoutRebalance(T[] array) {
		
		Arrays.sort(array);
		
		int maxPot = (int) Math.floor(Math.log10(array.length)/Math.log10(2));
		
		int[] visited = new int[array.length];
		
		for (int i = 1; i <= maxPot; i++) {
			
			double pot2 = Math.pow(2, i);
			int cont = 1, pos = 0;
			
			do {
				
				pos = (int) Math.floor(cont * array.length / pot2); 
				cont++;
				
				if (visited[pos] == 0) {
					this.insert(array[pos]);
					visited[pos] = 1;
				}
				
			} while (pos < array.length);
			
		}
		
		for (int i = 0; i < array.length; i++) {
			
			if (visited[pos] == 0) {
				this.insert(array[pos]);
				visited[pos] = 1;
			}
			
		}
	
	}

}
