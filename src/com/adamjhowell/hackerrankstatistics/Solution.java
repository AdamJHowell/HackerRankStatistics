package com.adamjhowell.hackerrankstatistics;


import java.util.Scanner;


/**
 * The HackerRank Java compiler does not seem to allow ArrayLists for some data manipulations.
 * https://www.hackerrank.com/domains/tutorials/10-days-of-statistics
 * https://www.hackerrank.com/challenges/s10-quartiles/problem
 * Sample input:
 * 9
 * 3 7 8 5 12 14 21 13 18
 * Sample output:
 * 6
 * 12
 * 16
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
		int q1 = 0;
		int q2 = 0;
		int q3 = 0;

		return new int[]{ q1, q2, q3 };
	}
}
