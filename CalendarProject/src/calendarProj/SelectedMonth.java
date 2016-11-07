package calendarProj;

import java.util.Scanner;

public class SelectedMonth {

	private static int numDays = 0;
	private static int h = 0;

	public static boolean leap(int year) {
		if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	} 

	public static void firstDayOfMonth(int month, int year) {
		if (month == 1 || month == 2) {
			month += 12;
			year--;
		}
		h = (1 + (int) (((month + 1) * 26) / 10.0) + year + (int) (year / 4.0) + 6 * (int) (year / 100.0) + (int) (year / 400.0)) % 7;
		String dayName = "";
		switch (h) {
		case 0:
			dayName = "Monday";
			break;
		case 1:
			dayName = "Tuesday";
			break;
		case 2:
			dayName = "Wednesday";
			break;
		case 3:
			dayName = "Thursday";
			break;
		case 4:
			dayName = "Friday";
			break;
		case 5:
			dayName = "Saturday";
			break;
		default:
			dayName = "Sunday";
			break;
		}
	}

	public static void numDaysInMonth(int month, int year) {
		int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (month == 2 && leap(year))
			days[month] = 29;
		numDays = days[month]; 
	}

	public static void printCal(int month, int year) {
		String[] monthNames = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };

		System.out.println("      " + monthNames[month] + ": " + year);
		System.out.println("___________________________\n ");
 
		System.out.println("Mon Tue Wed Thu Fri Sat Sun ");
		for (int i = 0; i < h - 1; i++)
			System.out.print("    ");
		for (int i = 1; i <= numDays; i++) {
			System.out.printf("%2d  ", i);
			if (((i + h - 1) % 7 == 0) || (i == numDays))
				System.out.println();
		}
	}

	private static boolean checkMonth(String number) {
		if (number.replaceAll("[0-9]", "").length() != 0) {
			return false;
		}
		int tmp = Integer.parseInt(number);
		if (tmp < 1 || tmp > 12) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean checkYear(String number) {
		if (number.replaceAll("[0-9]", "").length() != 0) {
			return false;
		}
		int tmp = Integer.parseInt(number);
		if (tmp < 1753 || tmp > 2100) {
			return false;
		} else {
			return true;
		}
	}

	public static void testDate() {
		// Cheking input month
		System.out.println("\n");
		Scanner scan1 = new Scanner(System.in);
		int[] data1 = new int[1];
		int result1 = 0;
		int count1 = 0;
		String month = null;
		String year = null;
		do {
			System.out.println("Enter month: ");
			month = scan1.next();
			if (checkMonth(month)) {
				data1[count1] = Integer.parseInt(month);
				count1++;
			} else {
				System.out.println("Wrong input ! ");
				continue;
			}
		} while (count1 != data1.length);

		for (int i = 0; i < data1.length; i++) {
			result1 += data1[i];
		}

		// Cheking input year
		Scanner scan2 = new Scanner(System.in);
		int[] data2 = new int[1];
		int result2 = 0;
		int count2 = 0;

		do {
			System.out.println("Enter year: ");
			year = scan2.next();
			if (checkYear(year)) {
				data2[count2] = Integer.parseInt(year);
				count2++;
			} else {
				System.out.println("Wrong input ! ");
				continue;
			}
		} while (count2 != data2.length);

		for (int i = 0; i < data2.length; i++) {
			result2 += data2[i];
		}

		int month1 = Integer.parseInt(month);
		int year1 = Integer.parseInt(year);
 
		firstDayOfMonth(month1, year1);
		numDaysInMonth(month1, year1);
		printCal(month1, year1);
	}
}
