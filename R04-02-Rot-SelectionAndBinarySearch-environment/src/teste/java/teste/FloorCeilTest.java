package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import problems.FloorCeil;
import problems.FloorCeilBinarySearch;

public class FloorCeilTest {

	private FloorCeil bsearch;
	private Integer[] array;
	
	@Before
	public void setUp() {
		this.bsearch = new FloorCeilBinarySearch();
		this.array = new Integer[]{-3, -2, 0, 0, 1, 5, 5, 9, 11, 11, 17};
	}
	
	@Test
	public void test1() {
		
		assertEquals(5, (int) bsearch.floor(array, 6));
		assertEquals(9, (int) bsearch.ceil(array, 6));
		
	}
	
	@Test
	public void test2() {
		
		assertEquals(0, (int) bsearch.floor(array, 0));
		assertEquals(0, (int) bsearch.ceil(array, 0));
		
	}
	
	@Test
	public void test3() {
		
		assertEquals(11, (int) bsearch.floor(array, 15));
		assertEquals(17, (int) bsearch.ceil(array, 15));
		
	}
	
	//@Test
	public void test4() {
		
		assertEquals(-3, (int) bsearch.floor(array, -3));
		assertEquals(-3, (int) bsearch.ceil(array, -3));
		
	}
	
	@Test
	public void test5() {
		
		assertEquals(null, bsearch.floor(array, -4));
		assertEquals(-3, (int) bsearch.ceil(array, -4));
		
	}
	
	@Test
	public void test6() {
		
		assertEquals(17, (int) bsearch.floor(array, 17));
		assertEquals(17, (int) bsearch.ceil(array, 17));
		
	}
	
	@Test
	public void test7() {
		
		assertEquals(17, (int) bsearch.floor(array, 19));
		assertEquals(null, bsearch.ceil(array, 19));
		
	}
	
	@Test
	public void test8() {
		
		assertEquals(1, (int) bsearch.floor(array, 4));
		assertEquals(5, (int) bsearch.ceil(array, 4));
		
	}
	
	@Test
	public void test9() {
		
		assertEquals(-2, (int) bsearch.floor(array, -1));
		assertEquals(0, (int) bsearch.ceil(array, -1));
		
	}
	
	@Test
	public void test10() {
		
		assertEquals(11, (int) bsearch.floor(array, 16));
		assertEquals(17, (int) bsearch.ceil(array, 16));
		
	}
	
	@Test
	public void test11() {
		
		assertEquals(5, (int) bsearch.floor(array, 7));
		assertEquals(9, (int) bsearch.ceil(array, 7));
		
	}
	
	@Test
	public void test12() {
		
		assertEquals(null, bsearch.floor(new Integer[] {}, 7));
		assertEquals(null, bsearch.ceil(new Integer[] {}, 7));
		
	}
	
	@Test
	public void test13() {
		
		assertEquals(9, (int) bsearch.floor(array, 10));
		assertEquals(11, (int) bsearch.ceil(array, 10));
		
	}
	
	@Test
	public void test14() {
		
		assertEquals(11, (int) bsearch.floor(array, 12));
		assertEquals(17, (int) bsearch.ceil(array, 12));
		
	}


}
