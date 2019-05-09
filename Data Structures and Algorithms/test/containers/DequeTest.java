package containers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DequeTest {
	
	private DoubleEndedQueueArray<Integer> deque;
	private DoubleEndedQueueArray<Integer> standard;
	
	@BeforeEach
	public void setUp() {
		
		this.deque = new DoubleEndedQueueArray<>(6);
		this.standard = new DoubleEndedQueueArray<>();
		
	}
	
	
	@Test
	public void testSizeEmpty() {
		
		assertTrue(this.deque.isEmpty());
		assertEquals(0, this.deque.size());
		
		assertTrue(this.standard.isEmpty());
		assertEquals(0, this.standard.size());
		assertEquals(100, this.standard.getCapacity());
		
	}
	
	@Test
	public void testSizeNotEmpty() {
		
		this.deque.pushFront(16);
		assertEquals(1, this.deque.size());
		
		this.deque.pushBack(12);
		assertEquals(2, this.deque.size());
		
		this.deque.popBack();
		assertEquals(1, this.deque.size());
		
		this.deque.popFront();
		assertEquals(0, this.deque.size());
		

	}
	
	@Test
	public void testPush() {
		
		this.deque.pushFront(16);
		assertEquals(16, (int) this.deque.front());
		
		this.deque.pushBack(12);
		assertEquals(12, (int) this.deque.back());
		
		this.deque.pushBack(16);
		assertEquals(16, (int) this.deque.back());
		
		this.deque.pushFront(10);
		assertEquals(10, (int) this.deque.front());
		
		this.deque.pushFront(16);
		assertEquals(16, (int) this.deque.front());
		
		this.deque.pushBack(12);
		assertEquals(12, (int) this.deque.back());
		
	}
	
	@Test
	public void testPopFront() {
		
		this.deque.pushFront(16);
		
		this.deque.pushBack(12);
		
		this.deque.pushBack(16);
		
		this.deque.pushFront(10);
		
		this.deque.pushFront(16);
		
		this.deque.pushBack(12);
		
		assertEquals(16, (int) this.deque.popFront());
		assertEquals(10, (int) this.deque.popFront());
		assertEquals(16, (int) this.deque.popFront());
		assertEquals(12, (int) this.deque.popFront());
		assertEquals(16, (int) this.deque.popFront());
		assertEquals(12, (int) this.deque.popFront());
		assertEquals(0, this.deque.size());
		assertEquals(-1, this.deque.getTail());
		assertEquals(this.deque.getCapacity(), this.deque.getHead());
		
	}
	
	@Test
	public void testPopBack() {
		
		this.deque.pushFront(16);
		
		this.deque.pushBack(12);
		
		this.deque.pushBack(16);
		
		this.deque.pushFront(10);
		
		this.deque.pushFront(16);
		
		this.deque.pushBack(12);
		
		assertEquals(12, (int) this.deque.popBack());
		assertEquals(16, (int) this.deque.popBack());
		assertEquals(12, (int) this.deque.popBack());
		assertEquals(16, (int) this.deque.popBack());
		assertEquals(10, (int) this.deque.popBack());
		assertEquals(16, (int) this.deque.popBack());
		assertEquals(0, this.deque.size());
		assertEquals(-1, this.deque.getTail());
		assertEquals(this.deque.getCapacity(), this.deque.getHead());
		
	}
	
	@Test
	public void testPopRandom() {
		
		this.deque.pushFront(16);
		
		this.deque.pushBack(12);
		
		this.deque.pushBack(16);
		
		this.deque.pushFront(10);
		
		this.deque.pushFront(16);
		
		this.deque.pushBack(12);
		
		assertEquals(12, (int) this.deque.popBack());
		assertEquals(16, (int) this.deque.popFront());
		assertEquals(10, (int) this.deque.popFront());
		assertEquals(16, (int) this.deque.popBack());
		assertEquals(16, (int) this.deque.popFront());
		assertEquals(12, (int) this.deque.popBack());
		assertEquals(0, this.deque.size());
		assertEquals(-1, this.deque.getTail());
		assertEquals(this.deque.getCapacity(), this.deque.getHead());
		
	}
	
	@Test
	public void testClear() {
		
		assertTrue(this.deque.isEmpty());
		assertEquals(0, this.deque.size());
		assertEquals(-1, this.deque.getTail());
		assertEquals(this.deque.getCapacity(), this.deque.getHead());
		
		this.deque.pushFront(16);
		
		this.deque.pushBack(12);
		
		this.deque.pushBack(16);
		
		this.deque.pushFront(10);
		
		this.deque.pushFront(16);
		
		this.deque.pushBack(12);
		
		assertFalse(this.deque.isEmpty());
		assertEquals(6, this.deque.size());
		
		this.deque.clear();
		
		assertTrue(this.deque.isEmpty());
		assertEquals(0, this.deque.size());
		assertEquals(-1, this.deque.getTail());
		assertEquals(this.deque.getCapacity(), this.deque.getHead());
		
	}
	
	@Test
	public void testSize() {
		
		assertEquals(0, this.deque.size());
		
		this.deque.pushFront(16);
		assertEquals(1, this.deque.size());
		
		this.deque.pushBack(12);
		assertEquals(2, this.deque.size());
		
		this.deque.pushBack(16);
		assertEquals(3, this.deque.size());
		
		this.deque.pushFront(10);
		assertEquals(4, this.deque.size());
		
		this.deque.pushFront(16);
		assertEquals(5, this.deque.size());
		
		this.deque.pushBack(12);
		assertEquals(6, this.deque.size());
		
		this.deque.pushBack(15);
		assertEquals(7, this.deque.size());
		assertEquals(12, this.deque.getCapacity());
		
		this.deque.popBack();
		assertEquals(6, this.deque.size());
		assertEquals(12, this.deque.getCapacity());
		
		this.deque.pushBack(15);
		assertEquals(7, this.deque.size());
		assertEquals(12, this.deque.getCapacity());
		
		this.deque.pushBack(18);
		assertEquals(8, this.deque.size());
		assertEquals(12, this.deque.getCapacity());
		
		this.deque.clear();
		assertEquals(0, this.deque.size());
		assertEquals(12, this.deque.getCapacity());
		
	}
	
	@Test
	public void testExceptions() {
		
		try {
			this.deque.popBack();
			fail("");
		} catch (Exception e) {
			
		}
		
		try {
			this.deque.popFront();
			fail("");
		} catch (Exception e) {
			
		}
		
		try {
			this.deque.front();
			fail("");
		} catch (Exception e) {
			
		}
		
		try {
			this.deque.back();
			fail("");
		} catch (Exception e) {
			
		}
		
	}
	
	@Test
	public void testToString() {
		
		assertEquals("Deque []", this.deque.toString());
		
		this.deque.pushFront(16);
		assertEquals("Deque [16]", this.deque.toString());
		
		this.deque.pushBack(12);
		assertEquals("Deque [16, 12]", this.deque.toString());
		
		this.deque.pushBack(16);
		assertEquals("Deque [16, 12, 16]", this.deque.toString());
		
		this.deque.pushFront(10);
		assertEquals("Deque [10, 16, 12, 16]", this.deque.toString());
		
		this.deque.pushFront(16);
		assertEquals("Deque [16, 10, 16, 12, 16]", this.deque.toString());
		
		this.deque.pushBack(12);
		assertEquals("Deque [16, 10, 16, 12, 16, 12]", this.deque.toString());
		
		this.deque.pushBack(15);
		assertEquals("Deque [16, 10, 16, 12, 16, 12, 15]", this.deque.toString());
		
		this.deque.popBack();
		assertEquals("Deque [16, 10, 16, 12, 16, 12]", this.deque.toString());
	
		this.deque.pushBack(15);
		assertEquals("Deque [16, 10, 16, 12, 16, 12, 15]", this.deque.toString());
		
		this.deque.pushBack(18);
		assertEquals("Deque [16, 10, 16, 12, 16, 12, 15, 18]", this.deque.toString());
		
		this.deque.pushFront(18);
		assertEquals("Deque [18, 16, 10, 16, 12, 16, 12, 15, 18]", this.deque.toString());
		
		this.deque.popFront();
		assertEquals("Deque [16, 10, 16, 12, 16, 12, 15, 18]", this.deque.toString());
		
		this.deque.popBack();
		assertEquals("Deque [16, 10, 16, 12, 16, 12, 15]", this.deque.toString());
		
		this.deque.popFront();
		assertEquals("Deque [10, 16, 12, 16, 12, 15]", this.deque.toString());
		
		this.deque.clear();
		assertEquals("Deque []", this.deque.toString());

	}

}
