package com.adamjhowell.hackerrank.statistics;


import com.adamjhowell.hackerrank.UsefulMethods;


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
	public static void main( String[] args )
	{
		double probMale = 1.09;
		double probFemale = 1;
		printBinomialDistribution( probMale, probFemale );
	}


	@SuppressWarnings( "squid:S106" )
	private static void printBinomialDistribution( double male, double female )
	{
		System.out.printf( "%.3f", calculateBinomialDistribution( male, female ) );
	}


	private static double calculateBinomialDistribution( double male, double female )
	{
		double p = male / ( male + female );
		double q = 1 - p;
		double prob = 0.0;
		for( int i = 6; i >= 3; i-- )
		{
			prob += UsefulMethods.combination( 6, i ) * Math.pow( p, i ) * Math.pow( q, 6 - ( double )i );
		}
		return prob;
	}
}
