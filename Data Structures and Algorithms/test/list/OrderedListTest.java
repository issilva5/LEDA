package list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderedListTest {

	private List<Integer> list;
	
	@BeforeEach
	public void setUp() {
		
		this.list = new OrderedLinkedList<>();
		
	}
	
	@Test
	public void testIsEmpty() {
		assertTrue(this.list.isEmpty());
		assertEquals(0, this.list.size());
	}
	
	@Test
	public void testInsert() {
		
		this.list.insert(5);
		assertArrayEquals(new Integer[] {5}, this.list.toArray());
		this.list.insert(12);
		assertArrayEquals(new Integer[] {5, 12}, this.list.toArray());
		this.list.insert(4);
		assertArrayEquals(new Integer[] {4, 5, 12}, this.list.toArray());
		assertFalse(this.list.isEmpty());
		assertEquals(3, this.list.size());
		this.list.insert(null);
		assertFalse(this.list.isEmpty());
		assertEquals(3, this.list.size());
		this.list.insert(9);
		assertArrayEquals(new Integer[] {4, 5, 9, 12}, this.list.toArray());
		assertFalse(this.list.isEmpty());
		assertEquals(4, this.list.size());
		this.list.insert(21);
		assertArrayEquals(new Integer[] {4, 5, 9, 12, 21}, this.list.toArray());
		assertFalse(this.list.isEmpty());
		assertEquals(5, this.list.size());
		
	}
	
	@Test
	public void testSearch() {
		
		this.list.insert(5);
		this.list.insert(12);
		this.list.insert(21);
		assertEquals(new Integer(5), this.list.search(5));
		assertEquals(new Integer(12), this.list.search(12));
		assertEquals(null, this.list.search(7));
		assertEquals(new Integer(21), this.list.search(21));
		
	}
	
	@Test
	public void testRemove() {
		this.list.remove(15);
		this.list.insert(5);
		this.list.insert(12);
		this.list.insert(21);
		
		assertFalse(this.list.isEmpty());
		assertEquals(3, this.list.size());
		
		this.list.insert(null);
		assertFalse(this.list.isEmpty());
		assertEquals(3, this.list.size());
		
		this.list.remove(5);
		assertFalse(this.list.isEmpty());
		assertEquals(2, this.list.size());
		
		this.list.remove(11);
		assertFalse(this.list.isEmpty());
		assertEquals(2, this.list.size());
		
		this.list.remove(21);
		assertFalse(this.list.isEmpty());
		assertEquals(1, this.list.size());
		
		this.list.remove(12);
		assertTrue(this.list.isEmpty());
		assertEquals(0, this.list.size());
		
		this.list.insert(5);
		this.list.insert(12);
		this.list.insert(21);
		assertFalse(this.list.isEmpty());
		assertEquals(3, this.list.size());
		
	}
	
	@Test
	public void testToArray() {
		
		this.list.insert(5);
		this.list.insert(12);
		this.list.insert(21);
		assertArrayEquals(new Integer[] {5, 12, 21}, this.list.toArray());
		
	}

}
