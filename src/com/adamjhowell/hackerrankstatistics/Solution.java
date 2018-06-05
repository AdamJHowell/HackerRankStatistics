package com.adamjhowell.hackerrankstatistics;


import java.util.*;


/**
 * https://www.hackerrank.com/domains/tutorials/10-days-of-statistics
 * https://www.hackerrank.com/challenges/s10-quartiles/problem
 * <p>
 * Sample input:
 * 9
 * 3 7 8 5 12 14 21 13 18
 * Expected output:
 * 6
 * 12
 * 16
 * <p>
 * Sample input:
 * 10
 * 3 7 8 5 12 14 21 15 18 14
 * Expected output:
 * 7
 * 13
 * 15
 */
public class Solution
{
	public static void main( String[] args )
	{
		Scanner scan = new Scanner( System.in );
		int arraySize = scan.nextInt();
		int[] intArray = new int[arraySize];
		for( int i = 0; i < arraySize; i++ )
		{
			intArray[i] = scan.nextInt();
		}
		// Calculate the weighted mean using the two arrays, and print the result with 1 decimal point.
		printQuartiles( intArray );
	}


	@SuppressWarnings( "squid:S106" )
	private static void printQuartiles( int[] numArray )
	{
		int[] quartiles = calculateQuartiles( numArray );
		for( int num : quartiles )
		{
			System.out.println( num );
		}
	}


	private static int[] calculateQuartiles( int[] numArray )
	{
		// Sort the array in non-descending order.
		// Split the array in half.
		// If the array has an odd number of elements, exclude the middle element from each half, q2 (median) is that middle element.
		// If the array has an even number of elements, split the array evenly, q2 (median) is the mean of the two middle-most elements.
		// For each half of the array, repeat the process above to get q1 and q3.
		// q1 is the median for the lower half of the array.
		// q3 is the median for the upper half of the array.
		int q1;
		int q2;
		int q3;

		List<Integer> tempList = new ArrayList<>();
		List<Integer> lowerList = new ArrayList<>();
		List<Integer> upperList = new ArrayList<>();
		for( int num : numArray )
		{
			tempList.add( num );
		}
		Collections.sort( tempList );
		int chunkSize = tempList.size() % 2 == 0 ? tempList.size() / 2 : ( tempList.size() / 2 ) + 1;

		if( tempList.size() % 2 == 1 )
		{
			q2 = calculateMedianOdd( tempList );
			lowerList = tempList.subList( 0, chunkSize );
			upperList = tempList.subList( chunkSize + 1, tempList.size() );
		}
		else
		{
			q2 = calculateMedianEven( tempList );
			lowerList = tempList.subList( 0, chunkSize );
			upperList = tempList.subList( chunkSize, tempList.size() );
		}
		for( Integer num : lowerList )
		{
			System.out.println( "Lower: " + num );
		}
		for( Integer num : upperList )
		{
			System.out.println( "Upper: " + num );
		}
		if( lowerList.size() % 2 == 0 )
			q1 = calculateMedianEven( lowerList );
		else
			q1 = calculateMedianOdd( lowerList );
		if( upperList.size() % 2 == 0 )
			q3 = calculateMedianEven( upperList );
		else
			q3 = calculateMedianOdd( upperList );
		return new int[]{ q1, q2, q3 };
	}


	/**
	 * calculateMedianEven will return the median if the input has an even number of elements.
	 *
	 * @param integerList an ArrayList of integers sorted in non-descending order.
	 * @return an integer that represents the median value.
	 */
	private static int calculateMedianEven( List<Integer> integerList )
	{
		int tempInt = integerList.get( integerList.size() / 2 - 1 );
		tempInt += integerList.get( integerList.size() / 2 );
		return tempInt / 2;
	}


	/**
	 * calculateMedianOdd will return the median if the input has an odd number of elements.
	 *
	 * @param integerList an ArrayList of integers sorted in non-descending order.
	 * @return an integer that represents the median value.
	 */
	private static int calculateMedianOdd( List<Integer> integerList )
	{
		return integerList.get( integerList.size() / 2 );
	}
}
