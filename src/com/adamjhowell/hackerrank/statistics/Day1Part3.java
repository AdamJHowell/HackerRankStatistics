package com.adamjhowell.hackerrank.statistics;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * Created by Adam Howell on 2018-06-05.
 */
public class Day1Part3
{
	public static void main( String[] args )
	{
		Scanner scan = new Scanner( System.in );
		int arraySize = scan.nextInt();
		int[] quantityArray = new int[arraySize];
		int[] numArray = new int[arraySize];
		List<Integer> completeList = new ArrayList<>();
		// Scan in the quantities.
		for( int i = 0; i < arraySize; i++ )
		{
			numArray[i] = scan.nextInt();
		}
		// Scan in the integers.
		for( int i = 0; i < arraySize; i++ )
		{
			quantityArray[i] = scan.nextInt();
		}
		scan.close();
		// Extrapolate the numbers to a complete array.
		// Each numArray[x] needs to have quantityArray[x] entries.
		for( int i = 0; i < arraySize; i++ )
		{
			for( int j = 0; j < quantityArray[i]; j++ )
			{
				completeList.add( numArray[i] );
			}
		}
		// Calculate and print the inter-quartile range.
		printIQR( completeList );
	}


	@SuppressWarnings( "squid:S106" )
	private static void printIQR( List<Integer> numList )
	{
		double[] quartiles = calculateIQR( numList );
		System.out.println( quartiles[1] - quartiles[0] );
	}


	private static double[] calculateIQR( List<Integer> numList )
	{
		// Sort the array in non-descending order.
		// Split the array in half.
		// If the array has an odd number of elements, exclude the middle element from each half, q2 (median) is that middle element.
		// If the array has an even number of elements, split the array evenly, q2 (median) is the mean of the two middle-most elements.
		// For each half of the array, repeat the process above to get q1 and q3.
		// q1 is the median for the lower half of the array.
		// q3 is the median for the upper half of the array.
		double q1;
		double q3;

		List<Integer> lowerList;
		List<Integer> upperList;
		Collections.sort( numList );
		int chunkSize = numList.size() % 2 == 0 ? numList.size() / 2 : ( numList.size() / 2 ) + 1;

		if( numList.size() % 2 == 1 )
		{
			lowerList = numList.subList( 0, chunkSize - 1 );
			upperList = numList.subList( chunkSize, numList.size() );
		}
		else
		{
			lowerList = numList.subList( 0, chunkSize );
			upperList = numList.subList( chunkSize, numList.size() );
		}
		// The lower and upper lists must be the same size.  If not, the sublist logic (above) is faulty.
		if( lowerList.size() % 2 == 0 )
		{
			// Calculate q1 and q3 for an even list size.
			q1 = calculateMedianEven( lowerList );
			q3 = calculateMedianEven( upperList );
		}
		else
		{
			q1 = calculateMedianOdd( lowerList );
			q3 = calculateMedianOdd( upperList );
		}
		return new double[]{ q1, q3 };
	}


	/**
	 * calculateMedianEven will return the median if the input has an even number of elements.
	 *
	 * @param integerList an ArrayList of integers sorted in non-descending order.
	 * @return an integer that represents the median value.
	 */
	private static double calculateMedianEven( List<Integer> integerList )
	{
		Integer tempInt = integerList.get( integerList.size() / 2 - 1 );
		tempInt += integerList.get( integerList.size() / 2 );
		return tempInt / 2.0;
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
