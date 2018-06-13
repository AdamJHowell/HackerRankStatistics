package com.adamjhowell.hackerrankstatistics;


import java.util.Scanner;


/**
 * Created by Adam Howell on 2018-06-13.
 * https://www.hackerrank.com/challenges/utopian-tree/problem
 *
 * The Utopian Tree goes through 2 cycles of growth every year. Each spring, it doubles in height. Each summer, its height increases by 1 meter.
 * Laura plants a Utopian Tree sapling with a height of 1 meter at the onset of spring. How tall will her tree be after n growth cycles?
 *
 * Input Format
 * The first line contains an integer, t, the number of test cases.
 * t subsequent lines each contain an integer, n, denoting the number of cycles for that test case.
 *
 * Output Format
 * For each test case, print the height of the Utopian Tree after n cycles. Each height must be printed on a new line.
 *
 * Sample input:
 * 3
 * 0
 * 1
 * 4
 * Expected output:
 * 1
 * 2
 * 7
 */
public class UtopianTree
{
	// Complete the utopianTree function below.
	private static int utopianTree( int n )
	{
		int height = 1;
		while( n > 0 )
		{
			if( n > 0 )
			{
				height *= 2;
				n--;
			}
			if( n > 0 )
			{
				height++;
				n--;
			}
		}
		return height;
	}


	private static final Scanner scanner = new Scanner( System.in );


	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		int t = scanner.nextInt();
		scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

		for( int tItr = 0; tItr < t; tItr++ )
		{
			int n = scanner.nextInt();
			scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

			int result = utopianTree( n );

			System.out.println( result );
		}
	}
}
