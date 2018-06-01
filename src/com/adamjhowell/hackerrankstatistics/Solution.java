package com.adamjhowell.hackerrankstatistics;


import java.util.*;


/**
 * The HackerRank Java compiler does not seem to allow ArrayLists for some data manipulations.
 * https://www.hackerrank.com/domains/tutorials/10-days-of-statistics
 * https://www.hackerrank.com/challenges/s10-quartiles/problem
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
		int q1;
		int q2;
		int q3;

		List<Integer> tempList = new ArrayList<>();
		for( int num : numArray )
		{
			tempList.add( num );
		}
		Collections.sort( tempList );
		int chunkSize = tempList.size() % 2 == 0 ? tempList.size() / 2 : ( tempList.size() / 2 ) + 1;

		if( tempList.size() % 2 == 1 )
		{
			q2 = calculateMedianOdd( tempList );
		}
		else
		{
			q2 = calculateMedianEven( tempList );

		}
		if( tempList.size() % 4 == 0 )
		{
			// The first value of subList is inclusive, and second value is exclusive.
			q1 = calculateMedianEven( new ArrayList<>( tempList.subList( 0, chunkSize ) ) );
			q3 = calculateMedianEven( new ArrayList<>( tempList.subList( chunkSize, tempList.size() ) ) );
		}
		else
		{
			// The first value of subList is inclusive, and second value is exclusive.
			q1 = calculateMedianOdd( new ArrayList<>( tempList.subList( 0, chunkSize ) ) );
			q3 = calculateMedianOdd( new ArrayList<>( tempList.subList( chunkSize + 1, tempList.size() ) ) );
		}

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
