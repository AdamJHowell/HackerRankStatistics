package com.adamjhowell.hackerrankstatistics;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * https://www.hackerrank.com/challenges/java-regex/problem
 */
public class Solution
{
	public static void main( String[] args )
	{
		Scanner in = new Scanner( System.in );
		while( in.hasNext() )
		{
			String IP = in.next();
			System.out.println( IP.matches( new MyRegex().pattern ) );
		}

	}
}


class MyRegex
{
	MyRegex( String ipAddr )
	{
		String pattern = "\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";
		Pattern validIP = Pattern.compile( pattern );
		Matcher matcher = validIP.matcher( ipAddr );
		if( matcher.matches() )
		{
			System.out.println( "true" );
		}
		else
		{
			System.out.println( "false" );
		}
	}
}
