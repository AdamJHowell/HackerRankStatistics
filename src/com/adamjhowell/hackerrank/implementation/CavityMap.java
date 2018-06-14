package com.adamjhowell.hackerrank.implementation;


/**
 * Created by Adam Howell on 2018-06-08.
 */
public class CavityMap
{
	// Complete the cavityMap function below.
	private static String[] cavityMap( String[] grid )
	{
		int minimumSize = 3;
		int depth = grid.length;
		int breadth = grid[0].length();

		// The array need to be 3x3 or larger, since border cells are not checked.
		if( depth < minimumSize || breadth < minimumSize )
		{
			return grid;
		}
		else
		{
			// Process the elements that are not on the edges.
			for( int i = 1; i < depth - 1; i++ )
			{
				for( int j = 1; j < breadth - 1; j++ )
				{
					// Check the cell above and below.
					if( grid[i].toCharArray()[j] > grid[i - 1].toCharArray()[j] && grid[i].toCharArray()[j] > grid[i + 1].toCharArray()[j] )
					{
						// Check the cell to the left and the right.
						if( grid[i].toCharArray()[j] > grid[i].toCharArray()[j - 1] && grid[i].toCharArray()[j] > grid[i].toCharArray()[j + 1] )
						{
							char[] tempString = grid[i].toCharArray();
							tempString[j] = 'X';
							grid[i] = String.copyValueOf( tempString );
						}
					}
				}
			}
			return grid;
		}
	}


	@SuppressWarnings( "squid:S106" )
	public static void main( String[] args )
	{
		String[] grid = new String[4];
		grid[0] = "1112";
		grid[1] = "1912";
		grid[2] = "1892";
		grid[3] = "1234";
		String[] grid2 = cavityMap( grid );
		for( String row : grid2 )
		{
			System.out.println( row );
		}
	}

}
