package org.jfree.data;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
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
	
	private double [] data = {1.1, 2.2};
	
	@Test
	// test that right array is returned
	public void testCreateNumberArray1() {
		Number [] expected = {1.1, 2.2};
		Number [] actual = DataUtilities.createNumberArray(data);
		boolean res = actual.equals(expected);
		assertEquals(true, res);
	}
	
	@Test
	// test that the array is right length
	public void testCreateNumberArray2() {
		int expectedlength = 2;
		assertEquals(expectedlength, DataUtilities.createNumberArray(data).length);
	}
	
	@Test
	// test that the right values are returned
	public void testCreateNumberArray3() {
		double expectedvalue = 1.1;
		assertEquals(expectedvalue, DataUtilities.createNumberArray(data)[0]);
	}
	
	@Test
	// test that the right values are returned
	public void testCreateNumberArray4() {
		double expectedvalue = 2.2;
		assertEquals(expectedvalue, DataUtilities.createNumberArray(data)[1]);
	}
	
	private double [][] po_data = {{1.1, 2.2}, {3.3, 4.4}};
	private double [][] ne_data = {{-1.1, -2.2}, {-3.3, -4.4}};
	
	
	@Test
	// test that right array is returned
	public void testCreateNumberArray2D1() {
		Number [][] expected = {{1.1, 2.2}, {3.3, 4.4}};
		Number [][] actual = DataUtilities.createNumberArray2D(po_data);
		boolean res = actual.equals(expected);
		assertEquals(true, res);
	}
	
	@Test
	// test that right array of array is returned
	public void testCreateNumberArray2D2() {
		Number [] expected = {1.1, 2.2};
		Number [] actual = DataUtilities.createNumberArray2D(po_data)[0];
		boolean res = actual.equals(expected);
		assertEquals(true, res);
	}

	@Test
	// test that right array of array is returned
	public void testCreateNumberArray2D3() {
		Number [] expected = {3.3, 4.4};
		Number [] actual = DataUtilities.createNumberArray2D(po_data)[1];
		boolean res = actual.equals(expected);
		assertEquals(true, res);
	}
	
	@Test
	// test that the array is right length
	public void testCreateNumberArray2D4() {
		int expectedlength = 2;
		Number [][] actual = DataUtilities.createNumberArray2D(po_data);
		assertEquals(expectedlength, actual.length);
	}
	
	@Test
	// test that the array of array is right length
	public void testCreateNumberArray2D5() {
		int expectedlength = 2;
		Number [][] actual = DataUtilities.createNumberArray2D(po_data);
		assertEquals(expectedlength, actual[0].length);
	}
	
	@Test
	// test that the array of array is right length
	public void testCreateNumberArray2D6() {
		int expectedlength = 2;
		Number [][] actual = DataUtilities.createNumberArray2D(po_data);
		assertEquals(expectedlength, actual[1].length);
	}
	
	@Test
	// test that the right values are returned
	public void testCreateNumberArray2D7() {
		double expectedvalue = 1.1;
		Number [][] actual = DataUtilities.createNumberArray2D(po_data);
		assertEquals(expectedvalue, actual[0][0]);
	}
	
	@Test
	// test that the right values are returned
	public void testCreateNumberArray2D8() {
		double expectedvalue = 2.2;
		Number [][] actual = DataUtilities.createNumberArray2D(po_data);
		assertEquals(expectedvalue, actual[0][1]);
	}
	
	@Test
	// test that the right values are returned
	public void testCreateNumberArray2D9() {
		double expectedvalue = 3.3;
		Number [][] actual = DataUtilities.createNumberArray2D(po_data);
		assertEquals(expectedvalue, actual[1][0]);
	}
	
	@Test
	// test that the right values are returned
	public void testCreateNumberArray2D10() {
		double expectedvalue = 4.4;
		Number [][] actual = DataUtilities.createNumberArray2D(po_data);
		assertEquals(expectedvalue, actual[1][1]);
	}
	
	// *****ALL SAME TESTS AS ABOVE BUT WITH NEGATIVE DOUBLES*****
	
	@Test
	// test that right array is returned
	public void testCreateNumberArray2D11() {
		Number [][] expected = {{-1.1, -2.2}, {-3.3, -4.4}};
		Number [][] actual = DataUtilities.createNumberArray2D(ne_data);
		boolean res = actual.equals(expected);
		assertEquals(true, res);
	}
	
	@Test
	// test that right array of array is returned
	public void testCreateNumberArray2D12() {
		Number [] expected = {-1.1, -2.2};
		Number [] actual = DataUtilities.createNumberArray2D(ne_data)[0];
		boolean res = actual.equals(expected);
		assertEquals(true, res);
	}
	
	@Test
	// test that right array of array is returned
	public void testCreateNumberArray2D13() {
		Number [] expected = {-3.3, -4.4};
		Number [] actual = DataUtilities.createNumberArray2D(ne_data)[1];
		boolean res = actual.equals(expected);
		assertEquals(true, res);
	}
	
	@Test
	// test that the array is right length
	public void testCreateNumberArray2D14() {
		int expectedlength = 2;
		Number [][] actual = DataUtilities.createNumberArray2D(ne_data);
		assertEquals(expectedlength, actual.length);
	}
	
	@Test
	// test that the array of array is right length
	public void testCreateNumberArray2D15() {
		int expectedlength = 2;
		Number [][] actual = DataUtilities.createNumberArray2D(ne_data);
		assertEquals(expectedlength, actual[0].length);
	}
	
	@Test
	// test that the array of array is right length
	public void testCreateNumberArray2D16() {
		int expectedlength = 2;
		Number [][] actual = DataUtilities.createNumberArray2D(ne_data);
		assertEquals(expectedlength, actual[1].length);
	}
	
	@Test
	// test that the right values are returned
	public void testCreateNumberArray2D17() {
		double expectedvalue = -1.1;
		Number [][] actual = DataUtilities.createNumberArray2D(ne_data);
		assertEquals(expectedvalue, actual[0][0]);
	}
	
	@Test
	// test that the right values are returned
	public void testCreateNumberArray2D18() {
		double expectedvalue = -2.2;
		Number [][] actual = DataUtilities.createNumberArray2D(ne_data);
		assertEquals(expectedvalue, actual[0][1]);
	}
	
	@Test
	// test that the right values are returned
	public void testCreateNumberArray2D19() {
		double expectedvalue = -3.3;
		Number [][] actual = DataUtilities.createNumberArray2D(ne_data);
		assertEquals(expectedvalue, actual[1][0]);
	}
	
	@Test
	// test that the right values are returned
	public void testCreateNumberArray2D20() {
		double expectedvalue = -4.4;
		Number [][] actual = DataUtilities.createNumberArray2D(ne_data);
		assertEquals(expectedvalue, actual[1][1]);
	}
	
	@Test
	// tests that two arrays are same with null values
	public void testEqual1() {
		double [][] a = null;
		double [][] b = null;
		boolean res = DataUtilities.equal(a, b);
		assertEquals(true, res);
	}
	
	@Test
	// tests that two arrays are same with random values
	public void testEqual2() {
		double [][] a = {{1.1, 2.2}, {3.3, 4.4}};
		double [][] b = {{1.1, 2.2}, {3.3, 4.4}};
		boolean res = DataUtilities.equal(a, b);
		assertEquals(true, res);
	}
	
	@Test
	// tests that two arrays are same length
	public void testEqual3() {
		double [][] a = {{1.1, 2.2}, {3.3, 4.4}};
		double [][] b = {{1.1, 2.2}, {3.3, 4.4}};
		boolean res = (a.length == b.length);
		assertEquals(true, res);
	}
	
	@Test
	// tests that two arrays are same length
	public void testEqual4() {
		double [][] a = {{1.1, 2.2}, {3.3, 4.4}};
		double [][] b = {{1.1, 2.2}, {3.3, 4.4}};
		boolean res = (a[0].length == b[0].length);
		assertEquals(true, res);
	}
	
	@Test
	// tests that two arrays are same length
	public void testEqual5() {
		double [][] a = {{1.1, 2.2}, {3.3, 4.4}};
		double [][] b = {{1.1, 2.2}, {3.3, 4.4}};
		boolean res = (a[1].length == b[1].length);
		assertEquals(true, res);
	}
	
	@Test
	// tests that two arrays have same  values
	public void testEqual6() {
		double [][] a = {{1.1, 2.2}, {3.3, 4.4}};
		double [][] b = {{1.1, 2.2}, {3.3, 4.4}};
		boolean res = (a[0][0] == b[0][0]);
		assertEquals(true, res);
	}
	
	@Test
	// tests that two arrays have same  values
	public void testEqual7() {
		double [][] a = {{1.1, 2.2}, {3.3, 4.4}};
		double [][] b = {{1.1, 2.2}, {3.3, 4.4}};
		boolean res = (a[0][1] == b[0][1]);
		assertEquals(true, res);
	}
	
	@Test
	// tests that two arrays have same  values
	public void testEqual8() {
		double [][] a = {{1.1, 2.2}, {3.3, 4.4}};
		double [][] b = {{1.1, 2.2}, {3.3, 4.4}};
		boolean res = (a[1][0] == b[1][0]);
		assertEquals(true, res);
	}
	
	@Test
	// tests that two arrays have same  values
	public void testEqual9() {
		double [][] a = {{1.1, 2.2}, {3.3, 4.4}};
		double [][] b = {{1.1, 2.2}, {3.3, 4.4}};
		boolean res = (a[1][1] == b[1][1]);
		assertEquals(true, res);
	}
	
	@Test
	// test for when there's just one row of data
	public void testGetCumulativePercentages1(){
		Mockery mockingContext = new Mockery();
		final KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(data).getItemCount();
				will(returnValue(1));
				allowing(data).getValue(0);
				will(returnValue(1));
				allowing(data).getKey(0);
				will(returnValue(0));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		assertEquals(1.0, result.getValue(0));
	}
	
	@Test
	// test for when there are four rows of data
	public void testGetCumulativePercentages2(){
		Mockery mockingContext = new Mockery();
		final KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(data).getItemCount();
				will(returnValue(4));
				
				allowing(data).getValue(0);
				will(returnValue(2));
				allowing(data).getValue(1);
				will(returnValue(2));
				allowing(data).getValue(2);
				will(returnValue(2));
				allowing(data).getValue(3);
				will(returnValue(2));
				
				allowing(data).getKey(0);
				will(returnValue(0));
				allowing(data).getKey(1);
				will(returnValue(1));
				allowing(data).getKey(2);
				will(returnValue(2));
				allowing(data).getKey(3);
				will(returnValue(3));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		assertEquals(0.25, result.getValue(0));
		assertEquals(0.5, result.getValue(1));
		assertEquals(0.75, result.getValue(2));
		assertEquals(1.0, result.getValue(3));
	}
	
	@Test
	// test for when all rows are zero
	public void testGetCumulativePercentages3(){
		Mockery mockingContext = new Mockery();
		final KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(data).getItemCount();
				will(returnValue(4));
				
				allowing(data).getValue(0);
				will(returnValue(0));
				allowing(data).getValue(1);
				will(returnValue(0));
				allowing(data).getValue(2);
				will(returnValue(0));
				allowing(data).getValue(3);
				will(returnValue(0));
				
				allowing(data).getKey(0);
				will(returnValue(0));
				allowing(data).getKey(1);
				will(returnValue(1));
				allowing(data).getKey(2);
				will(returnValue(2));
				allowing(data).getKey(3);
				will(returnValue(3));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		assertEquals(0.0 / 0.0, result.getValue(0));
		assertEquals(0.0 / 0.0, result.getValue(1));
		assertEquals(0.0 / 0.0, result.getValue(2));
		assertEquals(0.0 / 0.0, result.getValue(3));
	}
	
	@After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
