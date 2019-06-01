package adt.avltree;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import adt.bst.BSTNode;

public class StudentAVLTest {

	private AVLTree<Integer> avl;
	private BSTNode<Integer> NIL = new BSTNode<Integer>();

	@Before
	public void setUp() {
		avl = new AVLTreeImpl<>();
	}

	@Test
	public void testInit() {
		assertTrue(avl.isEmpty());
		assertEquals(0, avl.size());
		assertEquals(-1, avl.height());
		assertEquals(NIL, avl.getRoot());
	}

	@Test
	public void testInsert() {
		avl.insert(-10);
		assertEquals(1, avl.size());
		assertEquals(0, avl.height());
		assertArrayEquals(new Integer[] { -10 }, avl.preOrder());

		assertFalse(avl.isEmpty());
		assertEquals(new Integer(-10), avl.getRoot().getData());

		avl.insert(-15);
		assertEquals(2, avl.size());
		assertEquals(1, avl.height());
		assertArrayEquals(new Integer[] { -10, -15 }, avl.preOrder());

		avl.insert(20);
		assertEquals(3, avl.size());
		assertEquals(1, avl.height());
		assertArrayEquals(new Integer[] { -10, -15, 20 }, avl.preOrder());
	}

	@Test
	public void testRemove() {
		avl.insert(55);
		avl.insert(9);
		avl.insert(91);
		avl.insert(12);

		avl.remove(-1);
		assertEquals(4, avl.size());
		avl.remove(91);
		assertEquals(3, avl.size());
		assertArrayEquals(new Integer[] { 12, 9, 55 }, avl.preOrder());

		avl.remove(12);
		assertEquals(2, avl.size());
		assertArrayEquals(new Integer[] { 55, 9 }, avl.preOrder());

		avl.remove(9);
		avl.remove(55);
		assertEquals(NIL, avl.getRoot());
		assertTrue(avl.isEmpty());
	}
	
	@Test
	public void testRemove2() {
		avl.insert(1);
		avl.insert(77);
		avl.insert(34);
		avl.insert(65);
		avl.insert(12);
		avl.insert(14);
		avl.insert(67);
		avl.insert(11);
		avl.insert(38);
		assertArrayEquals(new Integer[] { 34, 12, 1, 11, 14, 67, 65, 38, 77 }, avl.preOrder());
		
		avl.remove(-1);
		assertEquals(9, avl.size());
		
		avl.remove(12);
		assertEquals(8, avl.size());
		assertArrayEquals(new Integer[] { 34, 11, 1, 14, 67, 65, 38, 77 }, avl.preOrder());
		
		avl.remove(34);
		assertEquals(7, avl.size());
		assertArrayEquals(new Integer[] { 38, 11, 1, 14, 67, 65, 77 }, avl.preOrder());
		
		avl.remove(67);
		assertEquals(6, avl.size());
		assertArrayEquals(new Integer[] { 38, 11, 1, 14, 77, 65 }, avl.preOrder());
		
		avl.remove(77);
		assertEquals(5, avl.size());
		assertArrayEquals(new Integer[] { 38, 11, 1, 14, 65 }, avl.preOrder());
		
		avl.remove(65);
		assertEquals(4, avl.size());
		assertArrayEquals(new Integer[] { 11, 1, 38, 14 }, avl.preOrder());
		
		avl.remove(1);
		assertEquals(3, avl.size());
		assertArrayEquals(new Integer[] { 14, 11, 38 }, avl.preOrder());
		
		avl.remove(14);
		assertEquals(2, avl.size());
		assertArrayEquals(new Integer[] { 38, 11 }, avl.preOrder());
		
		avl.remove(38);
		assertEquals(1, avl.size());
		assertArrayEquals(new Integer[] { 11 }, avl.preOrder());
		
		avl.remove(11);
		assertEquals(0, avl.size());
		assertArrayEquals(new Integer[] {  }, avl.preOrder());
				
	}
}
