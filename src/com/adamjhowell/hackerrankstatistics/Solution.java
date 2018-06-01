package com.adamjhowell.hackerrankstatistics;


import java.util.*;


/**
 * https://www.hackerrank.com/challenges/s10-weighted-mean/problem
 */
public class Solution
{
	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		Scanner numScanner = new Scanner( System.in ).useDelimiter( "\\s" );

		// The first line contains an integer denoting the number of elements in the array.
		int arraySize = numScanner.nextInt();
		Integer[] intArray = new Integer[arraySize];
		Integer[] weightArray = new Integer[arraySize];

		// Loop arraySize times to capture all integers into the array.
		List<Integer> integerList = new ArrayList<>();
		for( int i = 0; i < arraySize; i++ )
		{
			if( numScanner.hasNextInt() )
				integerList.add( numScanner.nextInt() );
		}
		integerList.toArray( intArray );

	}
}
