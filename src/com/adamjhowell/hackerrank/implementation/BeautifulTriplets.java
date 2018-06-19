package com.adamjhowell.hackerrank.implementation;


import java.util.Scanner;


/**
 * https://www.hackerrank.com/challenges/beautiful-triplets/problem
 *
 * Erica wrote an increasing sequence of n numbers (a[0], a[1],...a[n-1]) in her notebook.
 * She considers a triplet (a[i],a[j],a[k]) to be beautiful if:
 * i < j < k
 * a[j] - a[i] = a[k] - a[j] = d
 *
 * Given the sequence and the value of d, can you help Erica count the number of beautiful triplets in the sequence?
 *
 * Input Format:
 * The first line contains 2 space-separated integers n and d, the length of the sequence and the beautiful difference.
 * The second line contains n space-separated integers a[i].
 *
 * Output Format:
 * Print a single line denoting the number of beautiful triplets in the sequence.
 *
 * Sample Input:
 * 7 3
 * 1 2 4 5 7 8 10
 * Expected Output:
 * 3
 */

public class BeautifulTriplets
{
	// Complete the beautifulTriplets function below.
	private static int beautifulTriplets( int d, int[] arr )
	{
		int count = 0;
		for( int i = 0; i < arr.length - 4; i++ )
		{
			if( arr[i + 2] - arr[i + 1] == d && arr[i + 1] - arr[i] == d )
			{
				count++;
			}
		}
		return count;
	}


	private static final Scanner scanner = new Scanner( System.in );


	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		String[] nd = scanner.nextLine().split( " " );
		int n = Integer.parseInt( nd[0] );
		int d = Integer.parseInt( nd[1] );
		int[] arr = new int[n];
		String[] arrItems = scanner.nextLine().split( " " );
		scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

		for( int i = 0; i < n; i++ )
		{
			int arrItem = Integer.parseInt( arrItems[i] );
			arr[i] = arrItem;
		}

		System.out.println( beautifulTriplets( d, arr ) );
		scanner.close();
	}
}
