package com.adamjhowell.hackerrank;


/**
 * Created by Adam Howell on 2018-06-15.
 */
public class UsefulMethods
{
	private UsefulMethods()
	{
	}


	static long factorial( int number )
	{
		long result = 1;

		for( int factor = 2; factor <= number; factor++ )
		{
			result *= factor;
		}

		return result;
	}


	static double doubleFactorial( double number )
	{
		long result = 1;

		for( double factor = 2; factor <= number; factor++ )
		{
			result *= factor;
		}

		return result;
	}


	public static long combination( int n, int x )
	{
		return factorial( n ) / factorial( x ) * factorial( n - x );
	}


	public static double doubleCombination( double n, double x )
	{
		return doubleFactorial( n ) / doubleFactorial( x ) * doubleFactorial( n - x );
	}
}
