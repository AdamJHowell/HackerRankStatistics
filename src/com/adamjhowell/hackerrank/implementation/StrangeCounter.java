package com.adamjhowell.hackerrank.implementation;


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
		if( t < 2 )
		{
			return 3;
		}
		// (time at end of each cycle) = 3 * ( ( 2 * lastReset ) + 1 )  // The counter value at this point will always be 1.
		// 1533 = 3 * ( 2 * 255 + 1 )
		// t = 1533
		// lastReset = 255
		// count = 1

		// Create a LinkedHashMap<Integer, Integer> of times and counts.  LinkedHashMap<time at end of cycle, lastCycleStartCount>
		// Update lastCycleStartCount as that map is built.
		// If the new time is greater than 't', do not store that new time, but instead start the counter from the most recent lastCycleStartCount.
		// Counter initializes to 3.
		long lastCycleStartCount = 3;
		long value = lastCycleStartCount;
		long time = 1;

		// "Fast forward" to the block before 't'.
		while( time + lastCycleStartCount * 2 < t - lastCycleStartCount )
		{
			// Get to the end of this block.
			time = time + value - 1;

			// Get to the start of the next block.
			time++;
			value = lastCycleStartCount * 2;
			lastCycleStartCount = value;
		}

		/*
		To get the last time of the current block:
	(end time of the current block) = time + value - 1
	// The last value will always be 1.

Get the next value after the end of the block:
	time++;
	value = lastReset * 2;
	lastReset = value;



// "Fast forward" to the block before 't'.
while( time + lastReset * 2 < t - lastReset )
{
	// Get to the end of this block.
	time = time + value - 1;
	value = 1;

	// Get to the start of the next block.
	time++;
	value = lastReset * 2;
	lastReset = value;
}
		 */
		while( time < t )
		{
			value--;
			time++;
			if( value < 1 )
			{
				lastCycleStartCount *= 2;
				value = lastCycleStartCount;
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
