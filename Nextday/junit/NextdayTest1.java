import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class NextdayTest1 {
		
	@Rule
	public ExpectedException thrown= ExpectedException.none();
	
	@Test(timeout=4000)
	public void test1(){
		assertEquals(1, new Year(1).getYear());
	}
	
	@Test(timeout=4000)
	public void test2(){
		Year y1 = new Year(1);
		y1.increment();
		assertEquals(new Year(2), y1);
	}
	
	@Test(timeout=4000)
	public void test3(){
		assertTrue(new Year(2000).isLeap());
	}
	
	@Test(timeout=4000)
	public void test4(){
		assertTrue(new Year(2000).isValid());
	}
	
	@Test(timeout=4000)
	public void test5(){
		assertTrue(new Year(2000).equals(new Year(2000)));
	}
	
	@Test(timeout=4000)
	public void test6(){
		Year y = new Year(2000);
		assertEquals(1, new Month(1, y).getMonth());
	}
	
	@Test(timeout=4000)
	public void test7(){
		Year y = new Year(2000);
		assertEquals(29, new Month(2, y).getMonthSize());
	}
	
	@Test(timeout=4000)
	public void test8(){
		Year y = new Year(2000);
		assertTrue(new Month(1, y).increment());
	}
	
	@Test(timeout=4000)
	public void test9(){
		Year y = new Year(2000);
		assertTrue(new Month(3, y).isValid());
	}
	
	@Test(timeout=4000)
	public void test10(){
		Year y = new Year(2000);
		Year y1 = new Year(1);
		assertTrue(new Month(1, y).equals(new Month(1, y)));
	}
	
	@Test(timeout=4000)
	public void test11(){
		Year y = new Year(2000);
		Month m = new Month(1, y);
		assertEquals(1, new Day(1, m).getDay());
	}
	
	@Test(timeout=4000)
	public void test12(){
		Year y = new Year(2000);
		Month m = new Month(1, y);
		assertTrue(new Day(1, m).increment());
	}
	
	@Test(timeout=4000)
	public void test13(){
		Year y = new Year(2000);
		Month m = new Month(1, y);
		assertTrue(new Day(1, m).isValid());
	}
	
	@Test(timeout=4000)
	public void test14(){
		Year y = new Year(2000);
		Month m = new Month(1, y);
		Month m1 = new Month(2, y);
		assertTrue(new Day(1, m).equals(new Day(1, m)));
	}
	
	@Test
	public void test15(){
		Date dd = new Date(1, 1, 2000);
		Date dd1 = new Date(1, 2, 2000);
		dd.increment();
		assertEquals(dd1.getDay(), dd.getDay());
	}
	
	@Test(timeout=4000)
	public void test16(){
		Date dd = new Date(1, 1, 2000);
		assertEquals(new Year(2000), dd.getYear());
	}
	
	@Test(timeout=4000)
	public void test17(){
		Date dd = new Date(1, 1, 2000);
		assertEquals(new Month(1,new Year(2000)), dd.getMonth());
	}
	
	@Test(timeout=4000)
	public void test18(){
		Date dd = new Date(1, 1, 2000);
		assertEquals(new Day(1,new Month(1,new Year(2000))), dd.getDay());
	}
	
	@Test
	public void test19(){
		Date dd = new Date(1, 1, 2000);
		assertEquals("1/1/2000", dd.toString());
	}
	
	@Test(timeout=4000)
	public void test20(){
		Date dd = new Date(1, 1, 2000);		
		assertTrue(dd.equals(new Date(1,1,2000)));
	}
	
	@Test(timeout=4000)
	public void test21() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Not a valid year");
		Year y = new Year(0);
	}
	
	@Test(timeout=4000)
	public void test22() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Not a valid month");
		Year y = new Year(1);
		Month m = new Month(0,y);
	}
	
	@Test(timeout=4000)
	public void test23() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Not a valid day");
		Year y = new Year(1);
		Month m = new Month(1,y);
		Day d = new Day(0,m);
	}
	
}
