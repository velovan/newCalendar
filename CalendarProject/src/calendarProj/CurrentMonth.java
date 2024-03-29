package calendarProj;

import java.time.LocalDate;

public class CurrentMonth {

	public final static String[] monthcalender = { "January", "February", "March", "April",
		"May", "June", "July", "August", "September", "October", "November", "December" };

	public final static int daysinmonths[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_RESET = "\u001B[0m  ";

	public static void displayMonth(int month, int year) {

		// The number of days to leave blank at
		// the start of this month.
		// LocalDate cldr = LocalDate();//.ofYearDay(year, month);
		LocalDate cldr = LocalDate.now();
		int blankdays = 0;
		System.out.println("\n       " + monthcalender[month] + ": " + year);
		System.out.println("___________________________\n ");
		System.out.println("Mon Tue Wed Thu Fri Sat Sun ");

		// Compute how much to leave before before the first day of the month.
		// getDay() returns 0 for Sunday.

		blankdays = cldr.getMonth().ordinal() - 9;
		int daysInMonth = daysinmonths[month];

		// Blank out the labels before 1st day of the
		// month
		for (int i = 0; i < blankdays; i++) {
			System.out.print("    ");
		}

		for (int i = 1; i <= daysInMonth; i++) {
			
			if (i == cldr.getDayOfMonth()) {
//				System.out.print("[" + i + "] ");
				 System.out.print(ANSI_RED + i + ANSI_RESET);
				i++;
			}
			if (i <= 9) {
				System.out.print(" ");
			}
		 
			if ((blankdays + i) % 7 == 6) {
				System.out.print(ANSI_RED + i + ANSI_RESET);
//				System.out.print("[" + i + "] "); 
				i++; 
			}
			if ((blankdays + i) % 7 == 0 ) {
				System.out.print(ANSI_RED + i + ANSI_RESET);
//				System.out.print("[" + i + "] ");
				System.out.println();
//				i++; 
			} else {
				System.out.print(i);
				System.out.print("  ");
			}
		}
	}

}
