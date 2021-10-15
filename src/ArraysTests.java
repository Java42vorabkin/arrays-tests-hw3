import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArraysTests {

	@Test
	void simpleArrayTests() {
		int ar[] = new int[10];
		ar[9] = 2;
		assertEquals(2, ar[9]);
		int ar1[] = ar;
		ar1[9] = 20;
		assertEquals(20, ar1[9]);
		assertEquals(20, ar[9]);
		
	}
	@Test
	void swapTests () {
		int ar[] = {-10, 20, 12, 40};
		assertEquals(40, ar[3]);
		assertEquals(12, ar[2]);
		//swap
		int tmp = ar[3];
		ar[3] = ar[2];
		ar[2] = tmp;
		assertEquals(12, ar[3]);
		assertEquals(40, ar[2]);
	}
	@Test
	void twoDimensional1() {
		int ar[][] = {{1, 2, 3}, {10, 20 , 30}, {100, 200, 300}};
		assertEquals(20, ar[1][1]);
	}
	@Test
	void twoDimensional2() {
		int ar1[] = {10, -3, 8};
		int ar2[] = {-7, 11};
		int ar3[] = {1, 2, 3 ,4};
		int ar[][] = {ar1, ar2, ar3};
		ar[1][1] = 10;
		assertEquals(10, ar2[1]);
	}
	/*
	 * Description
	 * The java.lang.System.arraycopy() method copies an array from the specified source array,
	 *  beginning at the specified position, to the specified position of the destination array.
	 *  This method does not return any value
	 */
	@Test
	void systemArrayCopy1() {
		int ar[] = new int[5];
		int ar1[] = {1, 2, 3};
		int ar2[] = {4, 5};
		int expected[] = {1, 2, 3, 4, 5};
		System.arraycopy(ar1, 0, ar, 0, ar1.length);
		System.arraycopy(ar2, 0, ar, 3, ar2.length);
		assertArrayEquals(expected, ar);
		
	}
	@Test
	void systemArrayShift() {
		int ar[] = {1, 2, 3, 4, 5};
		System.arraycopy(ar, 1, ar, 0, ar.length - 1); //{2, 3, 4, 5, 5};
		ar[ar.length - 1] = 0;
		int expected[] = {2, 3, 4, 5, 0};
		assertArrayEquals(expected, ar);
	}
	@Test
	void systemArrayDelete() {
		int ar[]= {1, 2, 3, 4, 5};
		int actual[] = new int[4];
		System.arraycopy(ar, 0, actual, 0, 2);
		System.arraycopy(ar, 3, actual, 2, 2);
		int expected[] = {1, 2, 4, 5};
		//TODO make sure the following assert will pass using System.arraycopy
		// Done!!!
		assertArrayEquals(expected, actual);
	}
	@Test
	void systemArrayInsert() {
		//TODO make sure the following assert will pass using System.arraycopy
		int ar[]= {1, 2, 3, 4, 5};
		int actual[] = new int[6];
		System.arraycopy(ar, 0, actual, 0, 3);
		actual[3] = -10;
		System.arraycopy(ar, 3, actual, 4, 2);
		int expected[] = {1, 2, 3,-10, 4, 5};
		assertArrayEquals(expected, actual);
		// Done!!!
	}
/*
 * Description
 * The Arrays.copyOf(int[] original,int newLength) method copies the specified array,
 * truncating or padding with zeros (if necessary) so the copy has the specified length.
 * For all indices that are valid in both the original array and the copy, the two arrays will
 * contain identical values. For any indices that are valid in the copy but not the original,
 * the copy will contain 0.Such indices will exist if and only if the specified length is
 *  greater than that of the original array.
 * Return Value
 * 
 * This method returns a copy of the original array, truncated or padded with zeros to obtain
 *  the specified length.
 */
	@Test
	void arraysCopyOf() {
		//TODO write tests for Arrays.copyOf functionality according to the doc
		int ar[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int actual1[] = Arrays.copyOf(ar, 5);
		int expected1[] = {1, 2, 3, 4, 5};
		assertArrayEquals(expected1, actual1);
		int actual2[] = Arrays.copyOf(ar, 15);
		int expected2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0, 0, 0};
		assertArrayEquals(expected2, actual2);
		// Done!!!!
	}

/*
 * Description
 * The Arrays.copyOfRange(short[] original, int from, int to) method copies the specified range
 * of the specified array into a new array.The final index of the range (to), which must be
 * greater than or equal to from, may be greater than original.length, in which case
 * (short)0 is placed in all elements of the copy whose index is greater than or equal
 * to original.length - from. The length of the returned array will be to - from.
 * 
 * Return Value
 * This method returns a new array containing the specified range from the original array,
 * truncated or padded with zeros to obtain the required length.
 */
	@Test
	void arraysCopyOfRange() {
		//TODO write tests for Arrays.copyOfRange functionality according to the doc
		int ar[] = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		int actual1[] = Arrays.copyOfRange(ar, 5, 10);
		int expected1[] = {16, 17, 18, 19, 20};
		assertArrayEquals(expected1, actual1);
		int actual2[] = Arrays.copyOfRange(ar, 5, 15);
		int expected2[] = {16, 17, 18, 19, 20, 0, 0, 0, 0, 0};
		assertArrayEquals(expected2, actual2);
		// Done!!!!
	}
	
/*
 * Description
 * The java.Arrays.binarySearch(int[] a, int key) method searches the specified
 *  array of ints for the specified value using the binary search algorithm.The array
 *  must be sorted before making this call.If it is not sorted, the results are undefined.
 *  
 * Return Value
 * This method returns index of the search key, if it is contained in the array,
 * else it returns (-(insertion point) - 1). The insertion point is the point at which 
 * the key would be inserted into the array: the index of the first element greater than
 *  the key, or a.length if all elements in the array are less than the specified key.
 */
	@Test
	void arraysBinarySearchSorted() {
		//TODO write tests for Arrays.binarySearch functionality according to the doc
		int ar[] = {-20, -20, -20, -2, 0, 3, 8, 11, 99, 999};
		int index1 = Arrays.binarySearch(ar, 0);
		assertEquals(4, index1);
		int index2 = Arrays.binarySearch(ar, -20);
		assertEquals(1, index2);
		int index3 = Arrays.binarySearch(ar, 99);
		assertEquals(8, index3);
		int index4 = Arrays.binarySearch(ar, 5);
		assertEquals(-7, index4);
		// Done!!!!
	}

	@Test
	void arraysBinarySearchUnsorted() {
		//TODO write tests for Arrays.binarySearch functionality according to the doc
		int ar[] = {11, -2, 3, 0, 999, -20, 8, -20, 99, -20};
		Arrays.sort(ar);
		int index1 = Arrays.binarySearch(ar, 0);
		assertEquals(4, index1);
		int index2 = Arrays.binarySearch(ar, -20);
		assertEquals(1, index2);
		int index3 = Arrays.binarySearch(ar, 99);
		assertEquals(8, index3);
		int index4 = Arrays.binarySearch(ar, 5);
		assertEquals(-7, index4);
		// Done!!!!
	}
	@Test
	void externalClass() {
		A a = new A(3);
		int actualPlus = a.getPlus();
		int expectedPlus = 4;
		assertEquals(expectedPlus, actualPlus);
		int actualMinus = a.getMinus();
		int expectedMinus = 2;
		assertEquals(expectedMinus, actualMinus);
	}

}
