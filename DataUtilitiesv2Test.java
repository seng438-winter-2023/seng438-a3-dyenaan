package org.jfree.data;

import static org.junit.Assert.*;
import java.security.*;
import org.jfree.data.DataUtilities;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class DataUtilitiesv2Test {

	Mockery mockingContext = new Mockery();
	Mockery mockingContext1 = new Mockery();
	Mockery mockingContext2 = new Mockery();
	Mockery mockingContext3 = new Mockery();
	
	final Values2D kVal = mockingContext.mock(Values2D.class);
	final Values2D kVal1 = mockingContext1.mock(Values2D.class);
	final Values2D kVal2 = mockingContext2.mock(Values2D.class);	
	final Values2D kVal3 = mockingContext3.mock(Values2D.class);
	
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception {
    }
	
	@Before
	public void setUp() throws Exception {
		mockingContext.checking(new Expectations() {
			{
				one(kVal).getRowCount();
				will(returnValue(1));
				one(kVal).getValue(0, 0);
				will(returnValue(5));
			}
		});
		
		mockingContext1.checking(new Expectations() {
			{
				one(kVal1).getRowCount();
				will(returnValue(2));
				one(kVal1).getValue(0, 0);
				will(returnValue(2.5));
				one(kVal1).getValue(0, 1);
				will(returnValue(2.5));
			}
		});
		
		mockingContext2.checking(new Expectations() {
			{
				one(kVal2).getColumnCount();
				will(returnValue(2));
				one(kVal2).getValue(0, 0);
				will(returnValue(7.5));
				one(kVal2).getValue(0, 1);
				will(returnValue(2.5));
			}
		});
		
		mockingContext3.checking(new Expectations() {
			{
				one(kVal3).getRowCount();
				will(returnValue(2));
				one(kVal3).getColumnCount();
				will(returnValue(2));
				one(kVal2).getValue(0, 0);
				will(returnValue(7.5));
				one(kVal2).getValue(0, 1);
				will(returnValue(2.5));
				one(kVal2).getValue(1, 0);
				will(returnValue(2.5));
				one(kVal2).getValue(1, 1);
				will(returnValue(7.5));
			}
		});
	}
	
//////////TESTS FOR calculateColumnTotal(Values2D, int): double
	
	@Test(expected = IllegalArgumentException.class)
	public void nullDataTest() {
		double actual = DataUtilities.calculateColumnTotal(null, 0);
		assertSame("This method should throw an Illegal Argument Exception", 0.0, actual);
	}
	
	
	@Test
	public void calcColumnTotalWithOneColumn() {
		try {
			double kValResult = DataUtilities.calculateColumnTotal(kVal, 0);
			assertEquals(5.0, kValResult, .000000001d);
		}catch(Exception e) {
			System.out.println("calcTotal2 with one row and one column");
		}
	}
	
//	@Test
//	public void calcColumnTotalWithOutOfBoundsColumn() {
//			double kValResult = DataUtilities.calculateColumnTotal(kVal, -1);
//			assertEquals(0.0, kValResult, .000000001d);
//	}
	
//////////TESTS FOR calculateColumnTotal(Values2D, int, int[]): double
	
	@Test
	public void calcColumnTotalForRowWithTwoValues() {
			int[] row = new int[]{1};
			double kValResult = DataUtilities.calculateColumnTotal(kVal1, 0, row);
			assertEquals(2.5, kValResult, .000000001d);
	}
	
//////////TESTS FOR calculateRowTotal(Values2D, int): double
	
	@Test
	public void calcRowTotalWithTwoValues() {
			double kValResult = DataUtilities.calculateRowTotal(kVal2, 0);
			assertEquals(10.0, kValResult, .000000001d);
	}
	
//////////TESTS FOR calculateRowTotal(Values2D, int, int[]): double
	
	@Test
	public void calcRowTotalWithOneColumn() {
			int[] column = new int[]{1};
			double kValResult = DataUtilities.calculateRowTotal(kVal2, 0, column);
			assertEquals(2.5, kValResult, .000000001d);
	}
	
//////////TESTS FOR clone(double[][]): double[][]
	
	@Test
	public void cloneTest() {
			double[][] test = new double[][] {
				{1.2, 2.3},
				{3.3, 4.4}
			};
			double[][] actual = DataUtilities.clone(test);
			assertArrayEquals(test, actual);
	}
	
	@After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}