package com.adamjhowell.hackerrankstatistics;


import java.util.*;


/**
 * https://www.hackerrank.com/challenges/java-loops/problem
 */
public class Day0
{
	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		Scanner numScanner = new Scanner( System.in ).useDelimiter( "\\s" );

		// The first line contains an integer denoting the number of elements in the array.
		int arraySize = numScanner.nextInt();
		Integer[] intArray = new Integer[arraySize];

		// Loop arraySize times to capture all integers into the array.
		List<Integer> integerList = new ArrayList<>();
		for( int i = 0; i < arraySize; i++ )
		{
			if( numScanner.hasNextInt() )
				integerList.add( numScanner.nextInt() );
		}
		integerList.toArray( intArray );

		System.out.println( calculateMean( intArray ) );
		System.out.println( calculateMedian( intArray ) );
		System.out.println( calculateMode( intArray ) );
	}


	private static double calculateMean( Integer[] inputArray )
	{
		double workingValue = 0.0;
		for( int num : inputArray )
		{
			workingValue += num;
		}
		return workingValue / ( double ) inputArray.length;
	}


	private static double calculateMedian( Integer[] inputArray )
	{
		List<Integer> tempList = Arrays.asList( inputArray );
		Collections.sort( tempList );
		if( tempList.size() % 2 == 1 )
		{
			return ( double ) ( tempList.get( tempList.size() / 2 ) );
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
		// Add the entrySet() from modeMap to list.
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>( modeMap.entrySet() );

		// Sort list by values.
		list.sort( Map.Entry.comparingByValue() );

		// Determine the maximum value (count).
		Integer maxVal = list.get( list.size() - 1 ).getValue();

		// modeList will hold all keys whose value matches maxVal.
		List<Integer> modeList = new ArrayList<>();
		for( Map.Entry pair : list )
		{
			if( pair.getValue() == maxVal )
			{
				modeList.add( ( Integer ) pair.getKey() );
			}
		}
		Collections.sort( modeList );
		return modeList.get( 0 );
	}
}
