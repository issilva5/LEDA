package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.OrderStatistics;
import orderStatistic.OrderStatisticsSelectionImpl;

public class OrderStatisticsTest {

	private OrderStatistics<Integer> order;
	private Integer[] array;
	
	@Before
	public void setUp() {
		this.order = new OrderStatisticsSelectionImpl<>();
		this.array = new Integer[]{9, 5, -1, 14, 3, -2, 0, 67, 4, 100};
	}
	
	@Test
	public void test1() {
		
		Integer a = -2;
		
		assertEquals(a, order.getOrderStatistics(array, 1));
		
	}
	
	@Test
	public void test2() {
		
		Integer a = -1;
		
		assertEquals(a, order.getOrderStatistics(array, 2));
		
	}
	
	@Test
	public void test3() {
		
		assertEquals((Integer) 0, order.getOrderStatistics(array, 3));
		
	}
	
	@Test
	public void test4() {
		
		assertEquals((Integer) 3, order.getOrderStatistics(array, 4));
		
	}
	
	@Test
	public void test5() {
		
		assertEquals((Integer) 4, order.getOrderStatistics(array, 5));
		
	}
	
	@Test
	public void test6() {
		
		assertEquals((Integer) 5, order.getOrderStatistics(array, 6));
		
	}
	
	@Test
	public void test7() {
		
		assertEquals((Integer) 9, order.getOrderStatistics(array, 7));
		
	}
	
	@Test
	public void test8() {
		
		assertEquals((Integer) 14, order.getOrderStatistics(array, 8));
		
	}
	
	@Test
	public void test9() {
		
		assertEquals((Integer) 67, order.getOrderStatistics(array, 9));
		
	}
	
	@Test
	public void test10() {
		
		assertEquals((Integer) 100, order.getOrderStatistics(array, 10));
		
	}

}
