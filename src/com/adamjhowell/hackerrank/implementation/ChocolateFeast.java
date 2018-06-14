package com.adamjhowell.hackerrank.implementation;


import java.util.Scanner;


/**
 * Created by Adam Howell on 2018-06-14.
 * https://www.hackerrank.com/challenges/chocolate-feast/problem
 *
 * Little Bobby loves chocolate. He frequently goes to his favorite 5&10 store, Penny Auntie, to buy them.
 * They are having a promotion at Penny Auntie.
 * If Bobby saves enough wrappers, he can turn them in for a free chocolate.
 *
 * Complete the chocolateFeast function in the code stub below to return the number of chocolates
 * Bobby can eat with a given amount of money after taking full advantage of the promotion.
 *
 * Note: Little Bobby will always turn in his wrappers if he has enough to get a free chocolate.
 *
 * Input Format:
 * The first line contains an integer, t, denoting the number of scenarios to analyze.
 * Each of the next t lines contains three space-separated integers: n, c, and m.
 * They represent money to spend, cost of a chocolate, and the number of wrappers he can turn in for a free chocolate.
 *
 * Output Format:
 * For each trip to Penny Auntie, print the total number of chocolates Bobby eats on a new line.
 *
 * Sample input:
 * 3
 * 10 2 5
 * 12 4 4
 * 6 2 2
 * Expected output:
 * 6
 * 3
 * 5
 */
public class ChocolateFeast
{
	// Complete the chocolateFeast function below.
	private static int chocolateFeast( int n, int c, int m )
	{
		return n + c + m;
	}


	private static final Scanner scanner = new Scanner( System.in );


	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		int t = scanner.nextInt();
		scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

		for( int tItr = 0; tItr < t; tItr++ )
		{
			String[] ncm = scanner.nextLine().split( " " );

			int n = Integer.parseInt( ncm[0] );

			int c = Integer.parseInt( ncm[1] );

			int m = Integer.parseInt( ncm[2] );

			int result = chocolateFeast( n, c, m );

			System.out.println( result );
		}
		scanner.close();
	}
}
