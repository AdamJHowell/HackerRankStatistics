package com.adamjhowell.hackerrank;


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
	private static final Scanner scanner = new Scanner( System.in );


	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		String[] nkq = scanner.nextLine().split( " " );

		// # of elements in the array.
		int n = Integer.parseInt( nkq[0] );
		// Rotation count.
		int k = Integer.parseInt( nkq[1] );
		// # of queries.
		int q = Integer.parseInt( nkq[2] );

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split( " " );
		scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

		for( int i = 0; i < n; i++ )
		{
			int aItem = Integer.parseInt( aItems[i] );
			a[i] = aItem;
		}

		int mod = k % n;

		for( int i = 0; i < q; i++ )
		{
			int queriesItem = scanner.nextInt();
			scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );
			if( queriesItem - mod >= 0 )
			{
				System.out.println( a[queriesItem - mod] );
			}
			else
			{
				System.out.println( a[queriesItem - mod + a.length] );
			}
		}
		scanner.close();
	}
}
