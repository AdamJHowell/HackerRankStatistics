package com.adamjhowell.hackerrankstatistics;


import java.util.Scanner;


public class Main
{
	public static void main( String[] args )
	{
		Scanner sizeScanner = new Scanner( System.in ).useDelimiter( "\\n" );
		Scanner numScanner = new Scanner( System.in ).useDelimiter( "\\s" );
		int arraySize = sizeScanner.nextInt();
		Integer[] list2 = new Integer[arraySize];
		for( int i = 0; i < arraySize; i++ )
		{
			list2[i] = numScanner.nextInt();
		}

		Day0 day0 = new Day0( new Integer[]{ 64630, 11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060, 14470, 67060, 14470, 67060 } );
		day0.printAnswer();
		System.out.println( "\n" );

		day0 = new Day0( list2 );
		day0.printAnswer();
	}
}
