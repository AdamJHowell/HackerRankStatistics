package com.adamjhowell.hackerrank.implementation;


import java.util.*;
import java.util.stream.Collectors;


/**
 * https://www.hackerrank.com/challenges/happy-ladybugs/problem
 *
 * Sample input:
 * 4
 * 7
 * RBY_YBR
 * 6
 * X_Y__X
 * 2
 * __
 * 6
 * B_RRBR
 *
 * Expected output:
 * YES
 * NO
 * YES
 * YES
 *
 *
 *
 * Sample input:
 * 5
 * 1
 * _
 * 4
 * RBRB
 * 4
 * RRRR
 * 3
 * BBB
 * 4
 * BBB_
 *
 * Expected output:
 * YES
 * NO
 * YES
 * YES
 * YES
 */

public class HappyLadyBugs
{
	@SuppressWarnings( "squid:S106" )
	// Complete the happyLadybugs function below.
	private static String happyLadybugs( String b )
	{
		boolean happy = true;
		char[] charArray = b.toCharArray();
		int arrayLength = charArray.length;
		char[] sortedArray = new char[arrayLength];
		Map<Character, Integer> countMap = new HashMap<>();
		// Get a count of the quantity of unique chars.
		for( Character item : charArray )
		{
			if( countMap.containsKey( item ) )
			{
				countMap.put( item, countMap.get( item ) + 1 );
			}
			else
			{
				countMap.put( item, 1 );
			}
		}
		boolean hasSpace = countMap.containsKey( '_' );
		if( hasSpace )
		{
			sortedArray = sortArray( charArray );
		}
		for( Map.Entry<Character, Integer> entry : countMap.entrySet() )
		{
			// If any char (aside from underscore) has fewer than 2 entries, the string fails.
			if( entry.getKey() != '_' && entry.getValue() < 2 )
			{
				happy = false;
			}
		}
		for( int i = 0; i < arrayLength; i++ )
		{
			// Edge cases for i=0 and for i=charArray.length.
			if( ( ( i == 0 && sortedArray[i] != sortedArray[i + 1] ) || ( i == arrayLength - 1 ) ) && ( sortedArray[i] != '_' && sortedArray[i] != sortedArray[i - 1] ) )
			{
				happy = false;
			}
			// Case for all other i values.
			if( i > 0 && i < arrayLength - 1 && sortedArray[i] != sortedArray[i - 1] && sortedArray[i] != sortedArray[i + 1] && hasSpace )
			{
				happy = false;
			}
		}


		if( happy )
		{
			return "YES";
		}
		else
		{
			return "NO";
		}
	}


	private static char[] sortArray( char[] inArray )
	{
		List<Character> inList = new ArrayList<>();
		for( char ch : inArray )
		{
			inList.add( ch );
		}
		Collections.sort( inList );

		String result = inList.stream()
		                      .map( String::valueOf )
		                      .collect( Collectors.joining() );
		return result.toCharArray();
	}


	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		String result = happyLadybugs( "RBY_YBR" );
		System.out.println( "RBY_YBR - YES: " + result );
		result = happyLadybugs( "X_Y__X" );
		System.out.println( "X_Y__X - NO: " + result );
		result = happyLadybugs( "__" );
		System.out.println( "__ - YES: " + result );
		result = happyLadybugs( "B_RRBR" );
		System.out.println( "B_RRBR - YES: " + result );
		result = happyLadybugs( "RBRB" );
		System.out.println( "RBRB - NO: " + result );
	}
}
