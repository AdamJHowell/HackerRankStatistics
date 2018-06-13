package com.adamjhowell.hackerrankstatistics;


import java.util.Scanner;


/**
 * Created by Adam Howell on 2018-06-13.
 * https://www.hackerrank.com/challenges/angry-professor/problem
 *
 * A Discrete Mathematics professor has a class of students.
 * Frustrated with their lack of discipline, he decides to cancel class if fewer than some number of students are present when class starts.
 * Arrival times go from on time (arrivalTime <= 0) to arrived late (arrivalTime > 0).
 * Given the arrival time of each student, determine if the class is canceled.
 *
 * Input format:
 * The first line of input contains t, the number of test cases.
 * Each test case consists of two lines.
 * The first line has two space-separated integers, n (students in the class) and k (the cancellation threshold).
 * The second line contains n space-separated integers describing the arrival time, in minutes, for each student.
 * Output Format:
 * For each test case, print the word "YES" if the class is canceled or "NO" if it is not.
 * Note, an arrival time of 0 is considered 'on time'.
 *
 * Sample input:
 * 2
 * 4 3
 * -1 -3 4 2
 * 4 2
 * 0 -1 2 1
 * Expected output:
 * YES
 * NO
 */
public class AngryProfessor
{
	// Complete the angryProfessor function below.
	private static String angryProfessor( int k, int[] a )
	{
		int numPresent = 0;
		// k is the cancellation threshold (how many students must be present at start time to continue class).
		// a is the array of arrival times.
		for( int num : a )
		{
			if( num <= 0 )
			{
				numPresent++;
			}
		}
		if( numPresent < k )
		{
			return "YES";
		}
		else
		{
			return "NO";
		}
	}


	private static final Scanner scanner = new Scanner( System.in );


	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		int t = scanner.nextInt();
		scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

		for( int tItr = 0; tItr < t; tItr++ )
		{
			// Number of students and cancellation threshold.
			String[] nk = scanner.nextLine().split( " " );

			// Number of students.
			int n = Integer.parseInt( nk[0] );

			// Cancellation threshold.
			int k = Integer.parseInt( nk[1] );

			// Arrival times.
			int[] a = new int[n];

			// Arrival times of each student.
			String[] aItems = scanner.nextLine().split( " " );
			scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );
			for( int i = 0; i < n; i++ )
			{
				int aItem = Integer.parseInt( aItems[i] );
				a[i] = aItem;
			}

			// Pass in cancellation threshold and arrival times.
			String result = angryProfessor( k, a );

			System.out.println( result );
		}
		scanner.close();
	}
}
