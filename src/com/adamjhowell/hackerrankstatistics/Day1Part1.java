package com.adamjhowell.hackerrankstatistics;


import java.util.Scanner;

import static java.lang.StrictMath.sqrt;


/**
 * Created by Adam Howell on 2018-06-01.
 * https://www.hackerrank.com/domains/tutorials/10-days-of-statistics
 * https://www.hackerrank.com/challenges/s10-standard-deviation/problem
 */
public class Day1Part1
{
	@SuppressWarnings( "squid:S106" )
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
		System.out.printf( "%.1f%n", calculateStdev( intArray ) );
	}


	private static double calculateStdev( int[] intArray )
	{
		double mean = calculateMean( intArray );
		double diff = 0.0;
		for( int num : intArray )
		{
			diff += ( num - mean ) * ( num - mean );
		}
		return sqrt( diff / intArray.length );
	}


	private static double calculateMean( int[] inputArray )
	{
		double workingValue = 0.0;
		for( int num : inputArray )
		{
			workingValue += num;
		}
		return workingValue / inputArray.length;
	}
}
