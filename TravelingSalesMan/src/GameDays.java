import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

public class GameDays {
	private ArrayList<String> teams;
	private ArrayList<String> fullteams;
	private ArrayList<String> cities;
	private String[][] chart;
	private String[][] nfc;
	private String[][] afc;

	public GameDays() {
		chart = new String[32][17];
		teams = new ArrayList<String>();
		cities = new ArrayList<String>();
		fullteams = new ArrayList<String>();
		nfc = new String[16][18];
		afc = new String[16][18];

	}

	public void fillSchedule() throws FileNotFoundException {

		Scanner scan = new Scanner(new File("NFLScheduleList.txt"));
		Scanner scans = new Scanner(new File("teams.txt"));
		Scanner scams = new Scanner(new File("CTP2.txt"));
		Scanner scanms = new Scanner(new File("fullteams.txt"));
		Scanner scanNFC = new Scanner(new File("NFLScheduleListNFC.txt"));
		Scanner scanAFC = new Scanner(new File("NFLScheduleListAFC.txt"));

		for (int c = 0; c < chart[0].length; c++) {
			for (int r = 0; r < chart.length; r++) {
				chart[r][c] = scan.nextLine();
			}
		}// whole schedule

		for (int c = 0; c < 18; c++) {
			for (int r = 0; r < 16; r++) {
				afc[r][c] = scanAFC.nextLine();
			}
		}// afc schedule
		
		for (int c = 0; c < 18; c++) {
			for (int r = 0; r < 16; r++) {
				nfc[r][c] = scanNFC.nextLine();
			}
		}// nfc schedule

		while (scans.hasNextLine()) {
			teams.add(scans.nextLine());
		}

		while (scams.hasNextLine()) {
			cities.add(scams.nextLine());
		}
		while (scanms.hasNextLine()) {
			fullteams.add(scanms.nextLine());
		}

	}
	//in string form
	
	public String getDestCity(String top, int row) {
		

		if (top.indexOf('@') == 0) {
			top = top.substring(1);
			int scplace = teams.indexOf(top);
			
			return cities.get(scplace);
			
		} else if (top.indexOf('*') == 0) {
			top = top.substring(1);
			int scplace = teams.indexOf(top);
			
			return cities.get(32);
			
		} else if (top.equals("BYE")) {

			return "BYE";
		} else {
			int scplace = teams.indexOf(top);
			return cities.get(teams.indexOf(top));
		}
	}
	
	public String getFromCity(String city, int row) {
		int fcplace = teams.indexOf(city); //gets the place for the first city 

		String top = chart[fcplace][row - 1];

		if (top.indexOf('@') == 0) {
			top = top.substring(1);
			int scplace = teams.indexOf(top);
			
			return cities.get(scplace);
			
		} else if (top.indexOf('*') == 0) {
			top = top.substring(1);
			int scplace = teams.indexOf(top);
			
			return cities.get(32);
			
		} else if (top.equals("BYE")) {

			return "BYE";
		} else {
			int scplace = teams.indexOf(top);
			return cities.get(fcplace);
		}
	}
	
	public String getSchedule(String city, int row) {
		int fcplace = teams.indexOf(city); //gets the place for the first city 

		String top = chart[fcplace][row - 1];

		if (top.indexOf('@') == 0) {
			top = top.substring(1);
			int scplace = teams.indexOf(top);
			
			return "The " + fullteams.get(fcplace) + " is playing against the "
					+ fullteams.get(scplace) + " at " + cities.get(scplace)
					+ " in Week " + row + ".";
		} else if (top.indexOf('*') == 0) {
			top = top.substring(1);
			int scplace = teams.indexOf(top);
			return "The " + fullteams.get(fcplace) + " is playing against the "
					+ fullteams.get(scplace) + " at " + cities.get(32) + " in Week " + row
					+ ".";
		} else if (top.equals("BYE")) {

			return "The " + fullteams.get(fcplace) + " is not playing in Week "
					+ row + ".";
		} else {
			int scplace = teams.indexOf(top);
			return "The " + fullteams.get(fcplace) + " is playing against the "
					+ fullteams.get(scplace) + " at " + cities.get(fcplace)
					+ " in Week " + row + ".";
		}
	}
	/*
	public String getTeam(String city, int row) {
		int fcplace = teams.indexOf(city); //gets the place for the first city 

		String top = chart[fcplace][row - 1];

		if (top.indexOf('@') == 0) {
			top = top.substring(1);
			int scplace = teams.indexOf(top);
			
			return
			
			return "The " + fullteams.get(fcplace) + " is playing against the "
					+ fullteams.get(scplace) + " at " + cities.get(scplace)
					+ " in Week " + row + ".";
		} else if (top.indexOf('*') == 0) {
			top = top.substring(1);
			int scplace = teams.indexOf(top);
			return "The " + fullteams.get(fcplace) + " is playing against the "
					+ fullteams.get(scplace) + " at " + cities.get(32) + " in Week " + row
					+ ".";
		} else if (top.equals("BYE")) {

			return "The " + fullteams.get(fcplace) + " is not playing in Week "
					+ row + ".";
		} else {
			int scplace = teams.indexOf(top);
			return "The " + fullteams.get(fcplace) + " is playing against the "
					+ fullteams.get(scplace) + " at " + cities.get(fcplace)
					+ " in Week " + row + ".";
		}
	}

	
	
	*/
	public String[][] getmatrix()
	{
		return chart;
	}
	public String[][] getAFC() {
		return afc;
	}
	
	public String[][] getNFC()
	{
		return nfc;
	}

	public String getKey() {
		for (int i = 0; i < teams.size(); i++) {
			System.out.println(teams.get(i) + " = " + fullteams.get(i) + " = "
					+ cities.get(i));
		}
		return "";
	}

	public String toString() {
		for (int i = 0; i < chart.length; i++) {
			for (int j = 0; j < chart[i].length; j++) {
				System.out.print(chart[i][j] + " \t");
			}
			System.out.println();
		}

		return "";
	}

}


