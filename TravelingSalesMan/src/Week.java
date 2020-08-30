import java.io.FileNotFoundException;
import static java.lang.System.*;
import java.util.ArrayList;
public class Week 
{
	private ArrayList<Integer> AFCmiles;
	private ArrayList<Integer> NFCmiles;
	private ArrayList<String> AFCteams;
	private ArrayList<String> NFCteams;
	private Chart chart;
	private GameDays sched;
	private int whichweek;
	
	//Starting Point 
	private String sp = "GB";
	
	public Week() throws FileNotFoundException
	{
		AFCmiles = new ArrayList<Integer>();
		NFCmiles = new ArrayList<Integer>();
		AFCteams = new ArrayList<String>();
		NFCteams = new ArrayList<String>();
		chart = new Chart();
		sched = new GameDays();
		
		chart.fillHash();
		sched.fillSchedule();
		whichweek = 1;
	}
	
	public Week(int a) throws FileNotFoundException
	{
		AFCmiles = new ArrayList<Integer>();
		NFCmiles = new ArrayList<Integer>();
		AFCteams = new ArrayList<String>();
		NFCteams = new ArrayList<String>();
		chart = new Chart();
		sched = new GameDays();
		
		chart.fillHash();
		sched.fillSchedule();
		whichweek = a;
		
	}
	
	public void setWeek(int a)
	{
		whichweek = a;
	}
	
	public int getWeek()
	{
		return whichweek;
	}
	
	public void fillWeekAFC()
	{
		//Make the Schedule ArrayList first
		
		int[][] mmatrix = chart.matrix(); //mileages for each city	
		String[][] gmatrix = sched.getAFC(); //schedule for AFC
		 
		//for games DON'T WORRY ABOUT STARTING POINT HERE
		for(int i = 0; i < gmatrix.length; i++)
		{
			AFCteams.add(gmatrix[i][whichweek]);
		}	
	}
	
	public void fillWeekNFC()
	{
		
	}
	
	public ArrayList<String> getAFCteams()
	{
		return AFCteams;
	}
	
	public ArrayList<String> getNFCteams()
	{
		return NFCteams;
	}
	
	public ArrayList<Integer> getAFCmiles()
	{
		return AFCmiles;
	}
	
	public ArrayList<Integer> getNFCmiles()
	{
		return NFCmiles;
	}
	
	public String toString()
	{
		return "works";
	}
}
