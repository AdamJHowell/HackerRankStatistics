package com.adamjhowell.hackerrank.statistics;


/**
 * Created by Adam Howell on 2018-06-15.
 * https://www.hackerrank.com/challenges/s10-binomial-distribution-2/problem
 *
 * Objective
 * In this challenge, we go further with binomial distributions.
 * We recommend reviewing the previous challenge's Tutorial before attempting this problem.
 *
 * Task
 * A manufacturer of metal pistons finds that, on average, 12% of the pistons they manufacture are rejected because they are incorrectly sized.
 * What is the probability that a batch of 10 pistons will contain:
 * No more than 2 rejects?
 * At least 2 rejects?
 *
 * Input Format
 * A single line containing the following values (denoting the respective percentage of defective pistons and the size of the current batch of pistons):
 * 12 10
 * If you do not wish to read this information from stdin, you can hard-code it into your program.
 *
 * Output Format
 * Print the answer to each question on its own line:
 * 1. The first line should contain the probability that a batch of 10 pistons will contain no more than 2 rejects.
 * 2. The second line should contain the probability that a batch of 10 pistons will contain at least 2 rejects.
 * Round both of your answers to a scale of 3 decimal places (i.e., 1.234 format).
 *
 * Sample input:
 * 12 10
 * Expected output:
 * 0.891
 * 0.342
 */
public class Day4Part2
{
	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		double p = .12;
		double q = 1 - p;
		int batch = 10;
		int rejects = 2;
		double atMost = 0.0;
		double atLeast = 0.0;
		for( int i = 0; i <= rejects; i++ )
		{
			atMost += combination( batch, i ) * Math.pow( p, i ) * Math.pow( q, ( double )batch - i );
		}
		for( int i = 0; i < rejects; i++ )
		{
			atLeast += combination( batch, i ) * Math.pow( p, i ) * Math.pow( q, ( double )batch - i );
		}
		// No more than 2:
		System.out.format( "%.3f%n", atMost );
		// At least 2:
		System.out.format( "%.3f%n", 1 - atLeast );
	}


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
		if( n < r || n < 0 )
		{
			return 0;
		}
		return ( factorial( n ) / ( factorial( r ) * factorial( n - r ) ) );
	}
}
