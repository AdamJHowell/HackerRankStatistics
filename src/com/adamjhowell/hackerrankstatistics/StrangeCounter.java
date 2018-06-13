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
 */
public class StrangeCounter
{
	// Complete the strangeCounter function below.
	@SuppressWarnings( "squid:S106" )
	private static long strangeCounter( long t )
	{
		if( t < 1 )
		{
			return t;
		}
		// Counter always begins at 3.
		int startNum = 3;
		int curVal = startNum;
		int timeSince = 0;
		while( timeSince < t )
		{
			curVal--;
			timeSince++;
			if( curVal == 1 )
			{
				startNum *= 2;
				curVal = startNum;
			}
			System.out.println( timeSince + " seconds have elapsed, and curVal is now " + curVal );
		}
		return curVal;
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
