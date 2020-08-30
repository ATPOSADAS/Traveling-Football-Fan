import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

import static java.lang.System.*;


public class Chart // extend HashTableClass
{
	private ArrayList<String> ab; 
	private ArrayList<String> cities;
	private int[][] chart;
	private ArrayList<String> mileage;
	
	public Chart() 
	{
		chart = new int[32][32];
		ab = new ArrayList<String>();
		cities = new ArrayList<String>();
		mileage = new ArrayList<String>();
		
	}//end of constructor 

	public void fillHash() throws FileNotFoundException
	{	
		Scanner scan = new Scanner(new File("NFLMileList.txt"));
		Scanner scans = new Scanner(new File("teams.txt"));
		Scanner scams = new Scanner(new File("NFLCitiesList.txt"));
		
		while(scan.hasNextLine())
		{
			mileage.add(scan.nextLine());
		
		}
		
		int place = 0;
		
		for(int r = 0; r < chart[0].length; r++)
		{
			for(int c = 0; c < chart.length; c++)
			{
				if(r == c)
				{
					chart[r][c] = 0;
					continue;
				}
				chart[r][c] = Integer.parseInt(mileage.get(place));
				
				place++;
			}
			
		}
		
		while(scans.hasNextLine())
		{
			ab.add(scans.nextLine());
		}
		
		while(scams.hasNextLine())
		{
			cities.add(scams.nextLine());
		}
	}									

	public int getMileage(String from_city, String to_city)
	{
		int fcplace = cities.indexOf(from_city);
	
		int scplace = cities.indexOf(to_city);
	
		int value = chart[fcplace][scplace];
		
		return value;
	}
	
	public String getKey()
	{
		for(int i = 0; i < ab.size(); i++)
		{
			System.out.println(ab.get(i) + " = " + cities.get(i) );
		}
		return "";
	}
	
	public String toString()
	{
		for (int i = 0; i < chart.length; i++) {
		    for (int j = 0; j < chart[i].length; j++) {
		        System.out.print(chart[i][j] + " \t");
		    }
		    System.out.println();
		}
		
		return "";
	}
	
	public int[][] matrix()
	{
		return chart;
	}
	
	public ArrayList<String> getCityList()
	{
		return cities; 
	}


}



