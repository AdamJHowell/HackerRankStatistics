package com.adamjhowell.hackerrankstatistics;


import java.util.Scanner;


/**
 * Created by Adam Howell on 2018-06-13.
 * https://www.hackerrank.com/challenges/circular-array-rotation/problem
 *
 * John Watson knows of an operation called a right circular rotation on an array of integers.
 * One rotation operation moves the last array element to the first position and shifts all remaining elements right one.
 * To test Sherlock's abilities, Watson provides Sherlock with an array of integers.
 * Sherlock is to perform the rotation operation a number of times then determine the value of the element at a given position.
 *
 * For each array, perform a number of right circular rotations and return the value of the element at a given index.
 *
 * For example, array a = [3, 4, 5], k = 2 and m = [1,2].
 * First we perform the two rotations:
 * [3, 4, 5] -> [5, 3, 4] -> [4, 5, 3]
 * Now return the values from indexes 1 and 2 as indicated in the m array.
 * a[1] = 5
 * a[2] = 3
 *
 * Input Format:
 * The first line contains 3 space-separated integers, n, k, and q, the number of elements in the integer array, the rotation count, and the number of queries.
 * The second line contains n space-separated integers, where each integer i describes array element a[i] (where 0 <= i < n).
 * Each of the q subsequent lines contains a single integer denoting m, the index of the element to return from a.
 *
 * Output Format:
 * For each query, print the value of the element at index m of the rotated array on a new line.
 *
 * Sample Input:
 * 3 2 3
 * 1 2 3
 * 0
 * 1
 * 2
 * Expected output:
 * 2
 * 3
 * 1
 */

public class CircularArrayRotation
{
	// Complete the circularArrayRotation function below.
	private static int[] circularArrayRotation( int[] a, int k, int[] queries )
	{
		int[] result = new int[queries.length];
		for( int i = 0; i < k; i++ )
		{
			a = rightCircularRotation( a );
		}
		for( int i = 0; i < queries.length; i++ )
		{
			result[i] = a[queries[i]];
		}
		return result;
	}


	private static int[] rightCircularRotation( int[] inArray )
	{
		int count = inArray.length;
		int[] outArray = new int[count];
		outArray[0] = inArray[count - 1];

		while( count > 1 )
		{
			outArray[count - 1] = inArray[count - 2];
			count--;
		}
		return outArray;
	}


	private static final Scanner scanner = new Scanner( System.in );


	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		String[] nkq = scanner.nextLine().split( " " );

		int n = Integer.parseInt( nkq[0] );

		int k = Integer.parseInt( nkq[1] );

		int q = Integer.parseInt( nkq[2] );

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split( " " );
		scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

		for( int i = 0; i < n; i++ )
		{
			int aItem = Integer.parseInt( aItems[i] );
			a[i] = aItem;
		}

		int[] queries = new int[q];

		for( int i = 0; i < q; i++ )
		{
			int queriesItem = scanner.nextInt();
			scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );
			queries[i] = queriesItem;
		}

		int[] result = circularArrayRotation( a, k, queries );

		for( int i = 0; i < result.length; i++ )
		{
			System.out.print( result[i] );

			if( i != result.length - 1 )
			{
				System.out.println();
			}
		}
		System.out.println();

		scanner.close();
	}
}
