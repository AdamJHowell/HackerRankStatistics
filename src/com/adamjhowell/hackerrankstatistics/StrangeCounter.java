package com.adamjhowell.hackerrankstatistics;


import java.util.LinkedHashMap;
import java.util.Map;
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

		if( t > 1533 )
		{
			Map<Long, Long> endOfCycle = counterShortcut( t );
			for( Map.Entry<Long, Long> entry : endOfCycle.entrySet() )
			{
				if( entry.getKey() < t && entry.getKey() > time )
				{
					time = entry.getKey();
					value = entry.getValue();
				}
			}
		}

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


	private static Map<Long, Long> counterShortcut( long startTime )
	{
		Map<Long, Long> endOfCycle = new LinkedHashMap<>();
		// Start the cycle at time = 1533 and lastReset = 255.
//		long time = 1533;
//		long lastReset = 255;
		long time = 1;
		long lastReset = 3;
		endOfCycle.put( time, lastReset );
		while( time < startTime )
		{
			time = 3 * ( 2 * lastReset + 1 );
			lastReset *= 2;
			endOfCycle.put( time, lastReset );
			System.out.println( "\tput time: " + time + ", lastRest: " + lastReset );
		}
		return endOfCycle;
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
