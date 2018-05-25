package com.adamjhowell.hackerrankstatistics;


import java.util.*;


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
				modeList.add( ( Integer )pair.getKey() );
			}
		}
		Collections.sort( modeList );
		return modeList.get( 0 );
	}


	@SuppressWarnings( "squid:S106" )
	void printAnswer()
	{
		System.out.printf( "%.1f%n", mean );
		System.out.printf( "%.1f%n", median );
		System.out.printf( "%d", mode );
	}
}
