package com.adamjhowell.hackerrank.implementation;


import java.util.Scanner;


/**
 * Created by Adam Howell on 2018-06-13.
 * https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 *
 * The first line contains 26 space-separated integers, describing the respective heights of each lowercase English letter, ascii[a-z].
 * The second line contains a single word, consisting of lowercase English alphabetic letters.
 * ASCII 'a' has a value of 97.
 *
 * Sample input:
 * 1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5
 * abc
 * Expected output:
 * 9
 *
 * Sample input:
 * 1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 7
 * zaba
 * Expected output:
 * 28
 */
public class DesignerPDFViewer
{
	// Complete the designerPdfViewer function below.
	private static int designerPdfViewer( int[] h, String word )
	{
		int maxHeight = 0;
		// Find the maximum value in array 'h' that appears in 'word'.
		for( int i = 0; i < word.length(); i++ )
		{
			int height = h[word.codePointAt( i ) - 97];
			if( height > maxHeight )
			{
				maxHeight = height;
			}
		}
		// Return that maximum value multiplied by the length of 'word'.
		return maxHeight * word.length();
	}


	private static final Scanner scanner = new Scanner( System.in );


	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		int[] h = new int[26];

		String[] hItems = scanner.nextLine().split( " " );
		scanner.skip( "(\r\n|[\n\r\u2028\u2029\u0085])?" );

		for( int i = 0; i < 26; i++ )
		{
			int hItem = Integer.parseInt( hItems[i] );
			h[i] = hItem;
		}

		String word = scanner.nextLine();

		int result = designerPdfViewer( h, word );

		System.out.println( result );

		scanner.close();
	}
}
