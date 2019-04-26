package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentLinkedListTest {

	protected LinkedList<Integer> lista1;
	protected LinkedList<Integer> lista2;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new RecursiveSingleLinkedListImpl<>();
		lista2 = new RecursiveSingleLinkedListImpl<>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(lista1.isEmpty());
		Assert.assertTrue(lista2.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, lista1.size());
		lista1.insert(null);
		Assert.assertEquals(3, lista1.size());
		Assert.assertEquals(0, lista2.size());
	}

	@Test
	public void testSearch() {
		Assert.assertTrue(2 == lista1.search(2));
		Assert.assertNull(lista1.search(4));
		Assert.assertNull(lista2.search(4));
		Assert.assertNull(lista1.search(null));
		Assert.assertFalse(3 == lista1.search(2));
	}

	@Test
	public void testInsert() {
		Assert.assertEquals(3, lista1.size());
		lista1.insert(5);
		lista1.insert(7);
		Assert.assertEquals(5, lista1.size());

		Assert.assertEquals(0, lista2.size());
		lista2.insert(4);
		lista2.insert(7);
		Assert.assertEquals(2, lista2.size());
	}

	@Test
	public void testRemove() {
		
		lista1.insert(-3);
		lista1.insert(-2);
		lista1.insert(22);
		lista1.insert(15);
		
		Assert.assertEquals(7, lista1.size());
		lista1.remove(2);
		Assert.assertArrayEquals(new Integer[] { 3, 1, -3, -2, 22, 15 }, lista1.toArray());
		lista1.remove(1);
		Assert.assertArrayEquals(new Integer[] { 3, -3, -2, 22, 15 }, lista1.toArray());
		Assert.assertEquals(5, lista1.size());
		lista1.remove(null);
		Assert.assertEquals(5, lista1.size());
		lista1.remove(5);
		Assert.assertEquals(5, lista1.size());
		lista1.remove(3);
		Assert.assertArrayEquals(new Integer[] { -3, -2, 22, 15 }, lista1.toArray());
		Assert.assertEquals(4, lista1.size());
		lista2.remove(16);
		lista1.remove(-3);
		Assert.assertArrayEquals(new Integer[] { -2, 22, 15 }, lista1.toArray());
		Assert.assertEquals(3, lista1.size());
		lista1.insert(5);
		lista1.remove(5);
		Assert.assertArrayEquals(new Integer[] { -2, 22, 15 }, lista1.toArray());
		Assert.assertEquals(3, lista1.size());
		lista1.insert(12);
		Assert.assertArrayEquals(new Integer[] { -2, 22, 15, 12 }, lista1.toArray());
		Assert.assertEquals(4, lista1.size());
		lista1.remove(12);
		Assert.assertArrayEquals(new Integer[] { -2, 22, 15 }, lista1.toArray());
		Assert.assertEquals(3, lista1.size());
		lista1.remove(15);
		Assert.assertArrayEquals(new Integer[] { -2, 22 }, lista1.toArray());
		Assert.assertEquals(2, lista1.size());
		lista1.remove(-2);
		Assert.assertArrayEquals(new Integer[] { 22 }, lista1.toArray());
		Assert.assertEquals(1, lista1.size());
		lista1.remove(22);
		Assert.assertArrayEquals(new Integer[] { }, lista1.toArray());
		Assert.assertEquals(0, lista1.size());
		
	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
	}
}