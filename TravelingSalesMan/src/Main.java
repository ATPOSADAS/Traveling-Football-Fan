import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {
	public static void main(String args[]) throws FileNotFoundException {

		Chart chart = new Chart();
		chart.fillHash();
		GameDays sched = new GameDays();
		sched.fillSchedule();
		ArrayList<Week> weeks = new ArrayList<Week>();
		ArrayList<ArrayList> cfull = new ArrayList<ArrayList>();

		int yes = 17;

		for (int i = 0; i < 17; i++) {
			Week wk = new Week(i);
			wk.fillWeekAFC();
			// out.println(wk.getAFCteams());

			weeks.add(wk);
		}

		// translate the object Week into ArrayLists with its city equivalent
		for (int j = 0; j < 17; j++) {
			Week temp = weeks.get(j);
			ArrayList<String> wk = temp.getAFCteams();
			ArrayList<String> output = new ArrayList<String>();

			for (int i = 0; i < wk.size(); i++) {
				output.add(sched.getDestCity(wk.get(i), i));
			} // end of for loop

			cfull.add(output);
		} // end of for loop
		/*
		 * //print out the weeks in city lists for(int i = 0; i < 17; i++) {
		 * out.print("WEEK " + (i + 1) + " "); out.println(cfull.get(i) + "\n");
		 * 
		 * }// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
		 */

		String sp = "Green Bay, WI";
		ArrayList<String> AFCcities = new ArrayList<String>(); // this is the priority list
		ArrayList<String> removed = new ArrayList<String>();
		ArrayList<String> log = new ArrayList<String>();
		String[][] afc = sched.getAFC();
		String pv = "";
		int total = 0;
		int place = 0;

		Scanner scan = new Scanner(new File("AFCcities.txt"));
		while (scan.hasNextLine()) {
			AFCcities.add(scan.nextLine());
		}

		do {
			ArrayList<String> cweek = cfull.get(place);
			int cmile = Integer.MAX_VALUE;

			int index = 0;
			if (place == 8) {
				cmile = chart.getMileage(sp, "London, U.K.");
				total += cmile;

				pv = "London, U.K.";

				AFCcities.remove(pv);
				removed.add(pv);
				String yup = "Traveled from " + sp + " to " + pv + " in Week " + (place + 1) + ".";
				log.add(yup);
				sp = pv;
				place++;

				continue;
			}
			while (index < cweek.size()) {

				String tempc = cweek.get(index);
				if (tempc.equals("BYE")) {
					index++;
					continue;
				}

				if (chart.getMileage(sp, tempc) < cmile && AFCcities.contains(tempc)) {
					cmile = chart.getMileage(sp, tempc);
					total += cmile;
					pv = tempc;
				}

				index++;
			}
			AFCcities.remove(pv);
			removed.add(pv);

			String yup = "Traveled from " + sp + " to " + pv + " in Week " + (place + 1) + ".";
			log.add(yup);

			sp = pv;
			place++;

		} while (place < 17);

		for (int i = 0; i < log.size(); i++) {
			out.println(log.get(i));
		}
		out.println("Total Mileage: " + total);

	}// end of main
}// end of class
