package adt.linkedList.set;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetTest {
	
	private SetLinkedList<Integer> set;
	private SetLinkedList<Integer> set2;
	private SetLinkedList<Integer> set3;
	private SetLinkedList<Integer> setE;
	
	@Before
	public void setUp() {
		
		this.set = new SetLinkedListImpl<>();
		this.set.insert(5);
		this.set.insert(12);
		this.set.insert(11);
		this.set.insert(29);
		this.set.insert(42);
		this.set.insert(5);
		this.set.insert(42);
		this.set.insert(5);
		this.set.insert(29);
		this.set.insert(11);
		this.set.insert(29);
		this.set.insert(42);
		this.set.insert(11);
		this.set.insert(29);
		this.set.insert(42);
		this.set.insert(11);
		this.set.insert(29);
		this.set.insert(42);
		this.set.insert(11);
		this.set.insert(29);
		this.set.insert(42);
		this.set.insert(874);
		
		this.set2 = new SetLinkedListImpl<>();
		this.set2.insert(6);
		this.set2.insert(13);
		this.set2.insert(14);
		this.set2.insert(30);
		this.set2.insert(43);
		
		this.set3 = new SetLinkedListImpl<>();
		this.set3.insert(5);
		this.set3.insert(12);
		this.set3.insert(13);
		this.set3.insert(29);
		this.set3.insert(30);
		this.set3.insert(101);
		
		this.setE = new SetLinkedListImpl<>();
		
	}
	
	@Test
	public void testRemoveDuplicates() {
		
		this.set.removeDuplicates();
		
		assertArrayEquals(new Integer[] {5, 12, 11, 29, 42, 874}, this.set.toArray());
		
		this.set.removeDuplicates();
		
		assertArrayEquals(new Integer[] {5, 12, 11, 29, 42, 874}, this.set.toArray());
		
		this.setE.removeDuplicates();
		
		assertArrayEquals(new Integer[] {}, this.setE.toArray());
		
	}
	
	@Test
	public void testUnion() {
		
		SetLinkedList<Integer> setAux = null;
		
		setAux = this.set.union(this.set2);
		assertArrayEquals(new Integer[] {5, 12, 11, 29, 42, 874, 6, 13, 14, 30, 43}, setAux.toArray());
		
		setAux = this.set2.union(this.set);
		assertArrayEquals(new Integer[] {6, 13, 14, 30, 43, 5, 12, 11, 29, 42, 874}, setAux.toArray());
		
		setAux = this.set.union(this.set3);
		assertArrayEquals(new Integer[] {5, 12, 11, 29, 42, 874, 13, 30, 101}, setAux.toArray());
		
		setAux = this.set.union(this.setE);
		assertArrayEquals(new Integer[] {5, 12, 11, 29, 42, 874}, setAux.toArray());
		
		setAux = this.setE.union(this.set);
		assertArrayEquals(new Integer[] {5, 12, 11, 29, 42, 874}, setAux.toArray());
		
		setAux = this.set2.union(this.set3);
		assertArrayEquals(new Integer[] {6, 13, 14, 30, 43, 5, 12, 29, 101}, setAux.toArray());
		
		setAux = setAux.union(this.set);
		assertArrayEquals(new Integer[] {6, 13, 14, 30, 43, 5, 12, 29, 101, 11, 42, 874}, setAux.toArray());
		
	}
	
	@Test
	public void testIntersection() {
		
		SetLinkedList<Integer> setAux = null;
		
		setAux = this.set.intersection(this.set2);
		assertArrayEquals(new Integer[] {}, setAux.toArray());
		
		setAux = this.set2.intersection(this.set);
		assertArrayEquals(new Integer[] {}, setAux.toArray());
		
		setAux = this.set.intersection(this.set3);
		assertArrayEquals(new Integer[] {5, 12, 29}, setAux.toArray());
		
		setAux = this.set.intersection(this.setE);
		assertArrayEquals(new Integer[] {}, setAux.toArray());
		
		setAux = this.setE.intersection(this.set);
		assertArrayEquals(new Integer[] {}, setAux.toArray());
		
		setAux = this.set2.intersection(this.set3);
		assertArrayEquals(new Integer[] {13, 30}, setAux.toArray());
		
		setAux = setAux.intersection(this.set);
		assertArrayEquals(new Integer[] {}, setAux.toArray());
		
	}
	
	@Test
	public void testConcatenate() {
		
		this.set.concatenate(this.set2);
		assertArrayEquals(new Integer[] {5, 12, 11, 29, 42, 874, 6, 13, 14, 30, 43}, this.set.toArray());
		this.set.concatenate(this.set3);
		assertArrayEquals(new Integer[] {5, 12, 11, 29, 42, 874, 6, 13, 14, 30, 43, 101}, this.set.toArray());
		this.set.concatenate(this.set3);
		assertArrayEquals(new Integer[] {5, 12, 11, 29, 42, 874, 6, 13, 14, 30, 43, 101}, this.set.toArray());
		
		this.set2.concatenate(this.set3);
		assertArrayEquals(new Integer[] {6, 13, 14, 30, 43, 5, 12, 29, 101}, this.set2.toArray());
		this.set2.concatenate(this.setE);
		assertArrayEquals(new Integer[] {6, 13, 14, 30, 43, 5, 12, 29, 101}, this.set2.toArray());
		this.set2.concatenate(this.set);
		assertArrayEquals(new Integer[] {6, 13, 14, 30, 43, 5, 12, 29, 101, 11, 42, 874}, this.set2.toArray());
		
		this.setE.concatenate(this.set3);
		assertArrayEquals(new Integer[] {5, 12, 13, 29, 30, 101}, this.setE.toArray());
		this.setE.concatenate(this.set);
		assertArrayEquals(new Integer[] {5, 12, 13, 29, 30, 101, 11, 42, 874, 6, 14, 43}, this.setE.toArray());
		
	}
	
}
