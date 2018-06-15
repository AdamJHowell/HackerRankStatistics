package com.adamjhowell.hackerrank.strings;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * Created by Adam Howell on 2018-06-14.
 * https://www.hackerrank.com/challenges/how-many-substrings/problem
 */
public class HowManySubstrings
{
	/*
	 * Complete the countSubstrings function below.
	 */
	private static int[] countSubstrings( String s, int[][] queries )
	{
		/*
		 * Write your code here.
		 */
		int count = queries.length;
		int[] outArray = new int[count];
		for( int i = 0; i < queries.length; i++ )
		{
			outArray[i] = countSets( s.substring( queries[i][0], queries[i][1] ) );
		}
		return outArray;
	}


	private static int countSets( String subString )
	{
		Set<String> subSet = new HashSet<>();
		for( int i = 0; i < subString.length(); i++ )
		{
			for( int j = i; j < subString.length(); j++ )
			{
				if( i + j < subString.length() )
				{
					subSet.add( subString.substring( i, i + j ) );
				}
			}
		}
		return 1;
	}


	private static final Scanner scanner = new Scanner( System.in );


	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		String[] nq = scanner.nextLine().split( " " );

		int q = Integer.parseInt( nq[1].trim() );

		String s = scanner.nextLine();

		int[][] queries = new int[q][2];

		for( int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++ )
		{
			String[] queriesRowItems = scanner.nextLine().split( " " );

			for( int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++ )
			{
				int queriesItem = Integer.parseInt( queriesRowItems[queriesColumnItr].trim() );
				queries[queriesRowItr][queriesColumnItr] = queriesItem;
			}
		}

		int[] result = countSubstrings( s, queries );

		for( int resultItr = 0; resultItr < result.length; resultItr++ )
		{
			System.out.print( result[resultItr] );

			if( resultItr != result.length - 1 )
			{
				System.out.println();
			}
		}
		System.out.println();
	}
}
