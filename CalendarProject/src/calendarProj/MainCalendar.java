package calendarProj;

import java.time.LocalDate;

public class MainCalendar {

	public static void main(String[] args) {

		CurrentMonth moncldr = new CurrentMonth();

		LocalDate todaycldr = LocalDate.now();
		moncldr.displayMonth(todaycldr.getMonth().ordinal(), todaycldr.getYear());
		SelectedMonth sel = new SelectedMonth();
		sel.testDate();
	}
}
