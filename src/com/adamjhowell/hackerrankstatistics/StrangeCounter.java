package com.adamjhowell.hackerrankstatistics;


import java.util.Scanner;


/**
 * Created by Adam Howell on 2018-06-13.
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
 * 3*1 = 3
 * 3*3 = 9
 * 3*7 = 21
 * 3*15 = 45
 * 3*31 = 93
 */
public class StrangeCounter
{
	// Complete the strangeCounter function below.
	@SuppressWarnings( "squid:S106" )
	private static long strangeCounter( long t )
	{
		if( t < 1 )
		{
			return 3;
		}
		// Counter always begins at 3.
		long lastReset = 3;
		long value = lastReset;
		long time = 1;
		while( time < t )
		{
			value--;
			time++;
			if( value < 1 )
			{
				lastReset *= 2;
				value = lastReset;
			}
		}
		return value;
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
