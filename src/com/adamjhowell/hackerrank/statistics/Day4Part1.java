package com.adamjhowell.hackerrank.statistics;


import java.util.Scanner;


/**
 * https://www.hackerrank.com/domains/tutorials/10-days-of-statistics
 * https://www.hackerrank.com/challenges/s10-binomial-distribution-1/problem
 *
 * The ratio of boys to girls for babies born in Russia is 1.09 : 1.
 * If there is 1 child born per birth, what proportion of Russian families with exactly 6 children will have at least 3 boys?
 * Write a program to compute the answer using the above parameters.
 *
 * Sample Format:
 * 1.09 1
 * Expected Output:
 * 0.696
 */
public class Day4Part1
{
	private static long factorial( long n )
	{
		if( n == 0 )
		{
			return 1;
		}
		return n * factorial( n - 1 );
	}


	private static double combination( long n, long r )
	{
		return ( factorial( n ) / ( factorial( r ) * factorial( n - r ) ) );
	}


	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		Scanner scan = new Scanner( System.in );
		double maleValue = scan.nextDouble();
		double femaleValue = scan.nextDouble();
		double p = ( maleValue ) / ( maleValue + femaleValue );
		double q = 1 - p;

		double prob = 0.0;
		for( int i = 6; i >= 3; i-- )
		{
			prob += combination( 6, i ) * Math.pow( p, i ) * Math.pow( q, 6 - ( double )i );
		}
		System.out.printf( "%.3f", prob );
	}
}
