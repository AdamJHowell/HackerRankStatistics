package com.adamjhowell.hackerrankstatistics;


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
		return male / female * 6;
	}
}
