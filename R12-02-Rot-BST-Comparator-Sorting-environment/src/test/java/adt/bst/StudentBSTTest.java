package adt.bst;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import adt.bst.BSTImpl;
import adt.bst.extended.SortComparatorBSTImpl;
import adt.bt.BTNode;

public class StudentBSTTest {

	private SortComparatorBSTImpl<Integer> tree;
	private BTNode<Integer> NIL = new BTNode<Integer>();

	private void fillTree() {
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			tree.insert(i);
		}
	}

	@Before
	public void setUp() {
		tree = new SortComparatorBSTImpl<>((o1, o2) -> o1 - o2);
	}

	@Test
	public void testInit() {
		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertEquals(-1, tree.height());

		assertEquals(NIL, tree.getRoot());

		assertArrayEquals(new Integer[] {}, tree.order());
		assertArrayEquals(new Integer[] {}, tree.preOrder());
		assertArrayEquals(new Integer[] {}, tree.postOrder());

		assertEquals(NIL, tree.search(12));
		assertEquals(NIL, tree.search(-23));
		assertEquals(NIL, tree.search(0));

		assertEquals(null, tree.minimum());
		assertEquals(null, tree.maximum());

		assertEquals(null, tree.sucessor(12));
		assertEquals(null, tree.sucessor(-23));
		assertEquals(null, tree.sucessor(0));

		assertEquals(null, tree.predecessor(12));
		assertEquals(null, tree.predecessor(-23));
		assertEquals(null, tree.predecessor(0));
	}

	@Test
	public void testMinMax() {
		tree.insert(6);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(6), tree.maximum().getData());

		tree.insert(23);
		assertEquals(new Integer(6), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(-34);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(5);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());

		tree.insert(9);
		assertEquals(new Integer(-34), tree.minimum().getData());
		assertEquals(new Integer(23), tree.maximum().getData());
	}

	@Test
	public void testSucessorPredecessor() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232
		
		assertEquals(null, tree.predecessor(-40));
		assertEquals(new Integer(-34), tree.sucessor(-40).getData());

		assertEquals(new Integer(-40), tree.predecessor(-34).getData());
		assertEquals(new Integer(0), tree.sucessor(-34).getData());

		assertEquals(new Integer(-34), tree.predecessor(0).getData());
		assertEquals(new Integer(2), tree.sucessor(0).getData());

		assertEquals(new Integer(0), tree.predecessor(2).getData());
		assertEquals(new Integer(5), tree.sucessor(2).getData());
		
		tree.insert(-38);
		assertEquals(new Integer(-40), tree.predecessor(-38).getData());
		assertEquals(new Integer(-34), tree.sucessor(-38).getData());
	}

	@Test
	public void testSize() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		int size = 12;
		assertEquals(size, tree.size());

		while (!tree.isEmpty()) {
			tree.remove(tree.getRoot().getData());
			assertEquals(--size, tree.size());
		}
	}

	@Test
	public void testHeight() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		Integer[] preOrder = new Integer[] { 6, -34, -40, 5, 2, 0, 23, 9, 12,
				76, 67, 232 };
		assertArrayEquals(preOrder, tree.preOrder());
		assertEquals(4, tree.height());

		tree.remove(0);
		assertEquals(3, tree.height());

		tree.remove(2);
		assertEquals(3, tree.height());
	}

	@Test
	public void testRemove() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232
		
		Integer[] order = { -40, -34, 0, 2, 5, 6, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());
		
		Integer[] postOrder = { -40, 0, 2, 5, -34, 12, 9, 67, 232, 76, 23, 6 };
		assertArrayEquals(postOrder, tree.postOrder());

		tree.remove(6);
		order = new Integer[] { -40, -34, 0, 2, 5, 9, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		tree.remove(9);
		order = new Integer[] { -40, -34, 0, 2, 5, 12, 23, 67, 76, 232 };
		assertArrayEquals(order, tree.order());

		assertEquals(NIL, tree.search(6));
		assertEquals(NIL, tree.search(9));

	}

	@Test
	public void testSearch() {

		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		assertEquals(new Integer(-40), tree.search(-40).getData());
		assertEquals(new Integer(-34), tree.search(-34).getData());
		assertEquals(NIL, tree.search(2534));
	}
	
	@Test
	public void testRemove2() {
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		int size = 12;
		assertEquals(size, tree.size());
		Comparable[] order = tree.order();
		int pos = 0;
		
		while (!tree.isEmpty()) {
			tree.remove((Integer) order[pos++]);
			assertEquals(--size, tree.size());
		}
		
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		size = 12;
		assertEquals(size, tree.size());
		Comparable[] preOrder = tree.preOrder();
		pos = 0;
		
		while (!tree.isEmpty()) {
			tree.remove((Integer) preOrder[pos++]);
			assertEquals(--size, tree.size());
		}
		
		fillTree(); // -40 -34 0 2 5 6 9 12 23 67 76 232

		size = 12;
		assertEquals(size, tree.size());
		Comparable[] postOrder = tree.postOrder();
		pos = 0;
		
		while (!tree.isEmpty()) {
			tree.remove((Integer) postOrder[pos++]);
			assertEquals(--size, tree.size());
		}
		
		fillTree();
		tree.insert(-50);
		tree.remove(-40);
	}
	
	@Test
	public void testSort() {
		fillTree();
		Integer[] order = new Integer[] { -40, -34, 0, 2, 5, 12, 23, 67, 76, 232 };
		Integer[] unorder = new Integer[] { 12, 0, 5, 232, 67, -40, 76, -34, 2, 23 };
		assertArrayEquals(order, tree.sort(unorder));
	}
	
	@Test
	public void testReverse() {
		fillTree();
		Integer[] order = new Integer[] { 232, 76, 67, 23, 12, 9, 6, 5, 2, 0, -34, -40};
		assertArrayEquals(order, tree.reverseOrder());
	}
}
