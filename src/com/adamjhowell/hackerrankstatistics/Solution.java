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

		// The first line contains an integer denoting the number of elements in each array.
		int arraySize = numScanner.nextInt();
		// Create the number array, and the weight array.
		Integer[] intArray = new Integer[arraySize];
		Integer[] weightArray = new Integer[arraySize];

		// Loop arraySize times to capture all integers into the number array.
		List<Integer> integerList = new ArrayList<>();
		for( int i = 0; i < arraySize; i++ )
		{
			if( numScanner.hasNextInt() )
			{
				integerList.add( numScanner.nextInt() );
			}
		}
		// Load the ArrayList into an array, then clear out the ArrayList.
		integerList.toArray( intArray );
		integerList.clear();

		// Loop arraySize times to capture all integers into the weight array.
		for( int i = 0; i < arraySize; i++ )
		{
			if( numScanner.hasNextInt() )
			{
				integerList.add( numScanner.nextInt() );
			}
		}
		// Load the ArrayList into an array.
		integerList.toArray( weightArray );

		// Calculate the weighted mean using the two arrays, and print the result.
		System.out.println( calculateWeightedMean( intArray, weightArray ) );
	}


	private static String calculateWeightedMean( Integer[] numArray, Integer[] weightArray )
	{
		return "1";
	}
}
