package com.adamjhowell.hackerrank.warmup;


import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by Adam Howell on 2018-06-13.
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 *
 * Sample input:
 * 1 2 3 4 5
 * Expected output:
 * 10 14
 */
public class MinMaxSum
{
	// Complete the miniMaxSum function below.
	@SuppressWarnings( "squid:S106" )
	private static void miniMaxSum( int[] arr )
	{
		long minSum = 0;
		long maxSum = 0;
		Arrays.sort( arr );
		for( int i = 0; i < 5; i++ )
		{
			if( i < 4 )
			{
				minSum += arr[i];
			}
			if( i > 0 )
			{
				maxSum += arr[i];
			}
		}
		System.out.println( minSum + " " + maxSum );
	}


	private static final Scanner scanner = new Scanner( System.in );


	public static void main( String[] args )
	{
		int[] arr = new int[5];

		String[] arrItems = scanner.nextLine().split( " " );
		scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

		for( int i = 0; i < 5; i++ )
		{
			int arrItem = Integer.parseInt( arrItems[i] );
			arr[i] = arrItem;
		}

		miniMaxSum( arr );

		scanner.close();
	}
}
