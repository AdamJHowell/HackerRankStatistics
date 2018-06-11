package com.adamjhowell.hackerrankstatistics;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by Adam Howell on 2018-06-01.
 * https://www.hackerrank.com/domains/tutorials/10-days-of-statistics
 * https://www.hackerrank.com/challenges/s10-weighted-mean/problem
 */
public class Day0Part2
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
		numScanner.close();
		// Load the ArrayList into an array.
		integerList.toArray( weightArray );

		// Calculate the weighted mean using the two arrays, and print the result.
		System.out.printf( "%.1f%n", calculateWeightedMean( intArray, weightArray ) );
	}


	private static double calculateWeightedMean( Integer[] numArray, Integer[] weightArray )
	{
		double numerator = 0;
		double denominator = 0;
		for( int i = 0; i < numArray.length; i++ )
		{
			numerator += numArray[i] * weightArray[i];
		}
		for( Integer weight : weightArray )
		{
			denominator += weight;
		}
		if( denominator != 0 )
		{
			return numerator / denominator;
		}
		return -1;
	}
}
