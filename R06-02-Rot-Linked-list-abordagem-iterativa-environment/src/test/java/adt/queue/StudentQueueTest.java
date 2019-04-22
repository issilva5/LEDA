package adt.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

	}

	private void getImplementations() {
		
		queue1 = new QueueDoubleLinkedListImpl<>(5);

	}

	// MÉTODOS DE TESTE
	
	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue1.dequeue());
	}
	
	@Test
	public void testHeadEmpty() throws QueueUnderflowException {
		assertEquals(null, queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue1.isEmpty());
		assertFalse(queue1.isFull());
	}

	@Test
	public void testIsFull() throws QueueOverflowException {
		
		queue1.enqueue(15);
		queue1.enqueue(10);
		queue1.enqueue(16);
		queue1.enqueue(18);
		
		queue1.enqueue(null);
		assertFalse(queue1.isEmpty());
		assertFalse(queue1.isFull());
		
		queue1.enqueue(20);
		
		assertFalse(queue1.isEmpty());
		assertTrue(queue1.isFull());
		
	}
	
	@Test
	public void testHead() throws QueueOverflowException {
		
		queue1.enqueue(15);
		
		assertEquals(new Integer(15), queue1.head());
		
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(15);
			assertEquals(new Integer(15), queue1.head());
			
			queue1.enqueue(10);
			assertEquals(new Integer(15), queue1.head());
			
			queue1.enqueue(16);
			assertEquals(new Integer(15), queue1.head());
			
			queue1.enqueue(18);
			assertEquals(new Integer(15), queue1.head());
			
			queue1.enqueue(20);
			assertEquals(new Integer(15), queue1.head());
			
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		
		queue1.enqueue(15);
		queue1.enqueue(10);
		queue1.enqueue(16);
		queue1.enqueue(18);
		queue1.enqueue(20);
		
		queue1.enqueue(new Integer(5));
	}

	@Test
	public void testDequeue() throws QueueOverflowException {
		try {
			
			queue1.enqueue(15);
			queue1.enqueue(10);
			queue1.enqueue(16);
			queue1.enqueue(18);
			queue1.enqueue(20);
			
			assertEquals(new Integer(15), queue1.dequeue());
			assertEquals(new Integer(10), queue1.dequeue());
			assertEquals(new Integer(16), queue1.dequeue());
			assertEquals(new Integer(18), queue1.dequeue());
			assertEquals(new Integer(20), queue1.dequeue());
			
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}