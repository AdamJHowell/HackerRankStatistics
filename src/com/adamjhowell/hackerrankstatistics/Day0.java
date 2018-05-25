package com.adamjhowell.hackerrankstatistics;


import java.util.*;


/**
 * Created by Adam Howell on 2018-05-24.
 * Objective
 * In this challenge, we practice calculating the mean, median, and mode. Check out the Tutorial tab for learning materials and an instructional video!
 * <p>
 * Task
 * Given an array, inputArray, of N integers, calculate and print the respective mean, median, and mode on separate lines.
 * If your array contains more than one modal value, choose the numerically smallest one.
 * <p>
 * Note: Other than the modal value (which will always be an integer), your answers should be in decimal form, rounded to a scale of 1 decimal place.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, N, denoting the number of elements in the array.
 * The second line contains N space-separated integers describing the array's elements.
 * <p>
 * Constraints
 * 10 < N < 2500
 * 0 < xᵢ <= 10⁵, where xᵢ is the iᵀᴴ element of the array.
 * Output Format
 * <p>
 * Print 3 lines of output in the following order:
 * <p>
 * Print the mean on a new line, to a scale of 1 decimal place.
 * Print the median on a new line, to a scale of 1 decimal place.
 * Print the mode on a new line; if more than one such value exists, print the numerically smallest one.
 */
class Day0
{
	private double mean;
	private double median;
	private int mode;


	Day0( Integer[] inputArray )
	{
		mean = calculateMean( inputArray );
		median = calculateMedian( inputArray );
		mode = calculateMode( inputArray );
	}


	private static double calculateMean( Integer[] inputArray )
	{
		double workingValue = 0.0;
		for( int num : inputArray )
		{
			workingValue += num;
		}
		return workingValue / ( double )inputArray.length;
	}


	private static double calculateMedian( Integer[] inputArray )
	{
		List<Integer> tempList = Arrays.asList( inputArray );
		Collections.sort( tempList );
		if( tempList.size() % 2 == 1 )
		{
			return ( double )( tempList.get( tempList.size() / 2 ) );
		}
		else
		{
			double returnVal = tempList.get( tempList.size() / 2 - 1 );
			returnVal += tempList.get( tempList.size() / 2 );
			return returnVal / 2;
		}
	}


	// If more there is more than one mode, return the smallest.
	private static int calculateMode( Integer[] inputArray )
	{
		Map<Integer, Integer> modeMap = new HashMap<>();
		// Build a Map of numbers and their counts.
		for( int num : inputArray )
		{
			if( modeMap.containsKey( num ) )
			{
				modeMap.put( num, modeMap.get( num ) + 1 );
			}
			else
			{
				modeMap.put( num, 1 );
			}
		}
		// ToDo: Find the key(s) with the largest value.
		return 1;
	}


	@Override public String toString()
	{
		return mean + "\n" + median + "\n" + mode;
	}


	@SuppressWarnings( "squid:S106" )
	void printAnswer()
	{
		System.out.printf( "%.1f%n", mean );
		System.out.printf( "%.1f%n", median );
		System.out.printf( "%d", mode );
	}
}
