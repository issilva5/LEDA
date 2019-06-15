package adt.btree;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class StudentTestBTree {

	protected BTree<Integer> tree1;

	@Before
	public void setUp() throws Exception {
		tree1 = new BTreeImpl<Integer>(4);
	}

	@Test
	public void testIsEmpty() {
		assertTrue(tree1.isEmpty());
	}

	@Test
	public void testHeight() {
		assertEquals(-1, tree1.height());
		tree1.insert(2);
		assertEquals(0, tree1.height());
	}

	@Test
	public void testDepthLeftOrder() {
		tree1.insert(2);
		tree1.insert(4);
		tree1.insert(6);
		tree1.insert(8);
		assertEquals("[[6], [2, 4], [8]]",
					Arrays.toString(tree1.depthLeftOrder()));
		
	}

	@Test
	public void testSize() {
		assertEquals(0, tree1.size());
		tree1.insert(18);
		assertEquals(1, tree1.size());
	}
	
	@Test
	public void testInsert2() {

		tree1.insert(13);
		tree1.insert(9);
		tree1.insert(5);

		assertEquals(tree1.getRoot().getElementAt(0), new Integer(5));
		assertEquals(tree1.getRoot().getElementAt(1), new Integer(9));
		assertEquals(tree1.getRoot().getElementAt(2), new Integer(13));

		assertEquals(tree1.size(), 3);
		assertEquals(tree1.height(), 0);

		tree1.insert(12);

		assertEquals(tree1.size(), 4);
		assertEquals(tree1.height(), 1);

		tree1.insert(122);
		tree1.insert(3);

		assertEquals(tree1.size(), 6);
		assertEquals(tree1.height(), 1);
		
		tree1.insert(76);

		tree1.insert(10);
		assertEquals(1, tree1.height());

		tree1.insert(7);
		assertEquals(1, tree1.height());
		tree1.insert(8);
		assertEquals(1, tree1.height());
		
		tree1.insert(6);

		tree1.insert(1000);
		assertEquals(2, tree1.height());

		for (int i = 0; i < 4332; i++) {
			tree1.insert(null);
		}

	}

	@Test
	public void testAdd() {
		BTreeImpl<Integer> tree = new BTreeImpl<>(4);
		BNodePosition<Integer> aux = null;
		assertEquals(tree.size(), 0);

		assertNull(tree.search(1).node);
		tree.insert(0);
		tree.insert(1);
		assertNotNull(tree.search(1).node);
		assertNull(tree.search(-1).node);
		tree.insert(-1);
		assertNotNull(tree.search(-1).node);
		
		aux = tree.search(1);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(1));

		aux = tree.search(0);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(0));

		aux = tree.search(-1);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(-1));
		
		assertEquals(tree.size(), 3);
		assertEquals(tree.height(), 0);

		tree.insert(2);
		assertEquals(tree.height(), 1);
		tree.insert(-2);
		assertEquals(tree.size(), 5);
		assertEquals(tree.height(), 1);
		assertNotNull(tree.search(-2).node);
		
		aux = tree.search(2);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(2));

		aux = tree.search(-2);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(-2));
		
		aux = tree.search(1);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(1));

		aux = tree.search(0);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(0));
		
		tree.insert(3);
		tree.insert(-3);
		assertEquals(tree.height(), 1);
		assertEquals(tree.size(), 7);
		
		aux = tree.search(3);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(3));

		aux = tree.search(-3);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(-3));
		
		aux = tree.search(1);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(1));

		aux = tree.search(0);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(0));

		tree.insert(4);
		assertEquals(tree.height(), 1);
		tree.insert(5);
		tree.insert(6);
		assertEquals(tree.height(), 1);
		tree.insert(7);
		assertEquals(tree.size(), 11);
		assertEquals(tree.height(), 1);
		assertEquals(tree.search(444).node, new BNodePosition<>().node);
		assertNotNull(tree.search(7).node);
		
		aux = tree.search(4);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(4));

		aux = tree.search(5);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(5));
		
		aux = tree.search(6);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(6));

		aux = tree.search(7);
		assertEquals(aux.node.getElementAt(aux.position), new Integer(7));
		
		tree.insert(8);
		assertEquals(tree.size(), 12);
		assertEquals(tree.height(), 2);
		
	}

}
