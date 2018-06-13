package com.adamjhowell.hackerrankstatistics;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * Created by Adam Howell on 2018-06-13.
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 *
 * Sample input:
 * 4
 * 3 2 1 3
 * Expected output:
 * 2
 */
public class BirthdayCakeCandles
{

	// Complete the birthdayCakeCandles function below.
	private static int birthdayCakeCandles( int[] ar )
	{
		int max = -2147483648;
		Map<Integer, Integer> numMap = new HashMap<>();
		// Build a Map of numbers and their counts, and find the largest value.
		for( int num : ar )
		{
			if( numMap.containsKey( num ) )
			{
				numMap.put( num, numMap.get( num ) + 1 );
			}
			else
			{
				numMap.put( num, 1 );
			}
			if( num > max )
			{
				max = num;
			}
		}
		// Count the frequency of that value.
		return numMap.get( max );
	}


	private static final Scanner scanner = new Scanner( System.in );


	public static void main( String[] args ) throws IOException
	{
		try( BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( System.getenv( "OUTPUT_PATH" ) ) ) )
		{
			int arCount = scanner.nextInt();
			scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

			int[] ar = new int[arCount];

			String[] arItems = scanner.nextLine().split( " " );
			scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

			for( int i = 0; i < arCount; i++ )
			{
				int arItem = Integer.parseInt( arItems[i] );
				ar[i] = arItem;
			}

			int result = birthdayCakeCandles( ar );

			bufferedWriter.write( String.valueOf( result ) );
			bufferedWriter.newLine();
		}
		scanner.close();
	}
}
