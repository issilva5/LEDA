package adt.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;

	@Before
	public void setUp() {

		getImplementations();

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		stack1 = new StackDoubleLinkedListImpl<>(5);
	}
	
	// MÉTODOS DE TESTE
	@Test
	public void testTop() throws StackOverflowException {
		stack1.push(15);
		stack1.push(3);
		assertEquals(new Integer(3), stack1.top());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(stack1.isEmpty());
	}

	@Test
	public void testIsFull() throws StackOverflowException {
		assertFalse(stack1.isFull());
		assertTrue(stack1.isEmpty());
		
		stack1.push(15);
		stack1.push(3);
		stack1.push(12);
		stack1.push(25);
		stack1.push(12);
		
		assertTrue(stack1.isFull());
		assertFalse(stack1.isEmpty());
	}

	@Test
	public void testPush() {
		try {
			
			stack1.push(15);
			assertEquals(new Integer(15), stack1.top());
			stack1.push(3);
			assertEquals(new Integer(3), stack1.top());
			stack1.push(12);
			assertEquals(new Integer(12), stack1.top());
			stack1.push(25);
			assertEquals(new Integer(25), stack1.top());
			stack1.push(null);
			assertEquals(new Integer(25), stack1.top());
			stack1.push(12);
			assertEquals(new Integer(12), stack1.top());
			
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack1.push(15);
		stack1.push(3);
		stack1.push(12);
		stack1.push(25);
		stack1.push(27);
		stack1.push(12);
	}

	@Test
	public void testPop() throws StackOverflowException {
		try {
			
			stack1.push(15);
			assertEquals(new Integer(15), stack1.pop());
			stack1.push(3);
			assertEquals(new Integer(3), stack1.pop());
			stack1.push(12);
			assertEquals(new Integer(12), stack1.pop());
			stack1.push(25);
			assertEquals(new Integer(25), stack1.pop());
			stack1.push(12);
			assertEquals(new Integer(12), stack1.pop());
			
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		assertEquals(new Integer(3), stack1.pop()); // levanta excecao apenas se
													// stack1 for vazia
	}
	
	@Test
	public void testTopEmpty() throws StackUnderflowException {
		assertEquals(null, stack1.top()); // levanta excecao apenas se
													// stack1 for vazia
	}
}