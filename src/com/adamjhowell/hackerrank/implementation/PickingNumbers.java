package com.adamjhowell.hackerrank.implementation;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Created by Adam Howell on 2018-06-13.
 * https://www.hackerrank.com/challenges/picking-numbers/problem
 *
 * Given an array of integers, find and print the maximum number of integers you can select from the array
 * such that the absolute difference between any two of the chosen integers is less than or equal to 1.
 *
 * Sample input:
 * 6
 * 4 6 5 3 3 1
 * Expected output:
 * 3
 *
 * Sample input:
 * 6
 * 1 2 2 3 1 2
 * Expected output:
 * 5
 *
 * Sample input:
 * 100
 * 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66
 * Expected output:
 * 100
 */
public class PickingNumbers
{
	// Complete the pickingNumbers function below.
	private static int pickingNumbers( int[] a )
	{
		// Sort the array for later use.
		Arrays.sort( a );
		int maxCount = 0;
		Map<Integer, Integer> numMap = new HashMap<>();
		// Build a Map of numbers and their counts.
		for( int num : a )
		{
			if( numMap.containsKey( num ) )
			{
				numMap.put( num, numMap.get( num ) + 1 );
			}
			else
			{
				numMap.put( num, 1 );
			}
		}
		// Set maxCount to the largest value in numMap.
		for( Map.Entry<Integer, Integer> entry : numMap.entrySet() )
		{
			if( entry.getValue() > maxCount )
			{
				maxCount = entry.getValue();
			}
		}
		for( int num : a )
		{
			if( numMap.containsKey( num + 1 ) )
			{
				if( numMap.get( num ) + numMap.get( num + 1 ) > maxCount )
				{
					maxCount = numMap.get( num ) + numMap.get( num + 1 );
				}
			}
		}
		return maxCount;
	}


	private static final Scanner scanner = new Scanner( System.in );


	public static void main( String[] args ) throws IOException
	{
		try( BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( System.getenv( "OUTPUT_PATH" ) ) ) )
		{

			int n = scanner.nextInt();
			scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

			int[] a = new int[n];

			String[] aItems = scanner.nextLine().split( " " );
			scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

			for( int i = 0; i < n; i++ )
			{
				int aItem = Integer.parseInt( aItems[i] );
				a[i] = aItem;
			}

			int result = pickingNumbers( a );

			bufferedWriter.write( String.valueOf( result ) );
			bufferedWriter.newLine();
		}
		scanner.close();
	}
}
