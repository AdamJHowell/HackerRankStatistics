package com.adamjhowell.hackerrank.implementation;


import java.util.Scanner;


/**
 * Created by Adam Howell on 2018-06-13.
 * https://www.hackerrank.com/challenges/strange-code/problem
 *
 * Bob has a strange counter. At the first second, it displays the number 3.
 * Each second, the number displayed by the counter decrements by 1 until it reaches 1.
 *
 * The counter counts down in cycles.
 * In next second, the timer resets to (2*the initial number for the prior cycle) and continues counting down.
 * Find and print the value displayed by the counter at time t.
 *
 * Input format:
 * A single integer denoting the value of t.
 * Output format:
 * Print the value displayed at time t.
 *
 * Sample input:
 * 4
 * Expected output:
 * 6
 *
 * Sample input:
 * 1000
 * Expected output:
 * 534
 *
 * Sample input:
 * 1000000000000
 * Expected output:
 * 649267441662
 *
 * Sample input:
 * 999999997668
 * Expected output:
 * 649267443994
 *
 * 3*1 = 3
 * 3*3 = 9
 * 3*7 = 21
 * 3*15 = 45
 * 3*31 = 93
 * (time at end of each cycle) = ( 3 * ( 2 * lastReset ) ) + 1
 */
public class StrangeCounter
{
	// Complete the strangeCounter function below.
	@SuppressWarnings( "squid:S106" )
	private static long strangeCounter( long t )
	{
		long count = 3;
		if( t < 2 )
		{
			return count;
		}
		while( t > count )
		{
			t -= count;
			count *= 2;
		}
		return count - t + 1;
	}


	private static final Scanner scanner = new Scanner( System.in );


	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		long t = scanner.nextLong();
		scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

		long result = strangeCounter( t );

		System.out.println( result );
		scanner.close();
	}
}
