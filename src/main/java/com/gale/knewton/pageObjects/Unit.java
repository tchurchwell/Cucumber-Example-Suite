package com.gale.knewton.pageObjects;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Unit {
	
	public static void main (String args[]){
		DateFormat formatter = new SimpleDateFormat("MM");
		SimpleDateFormat monthParse = new SimpleDateFormat("MM");
		DateFormat dformatter = new SimpleDateFormat("DD");
		SimpleDateFormat dateParse = new SimpleDateFormat("DD");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH,1); //set calendar to next month
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE)); //set last day of next month
		String month = Integer.toString(cal.get(Calendar.MONTH)+1);
		String date = Integer.toString(cal.get(Calendar.DATE));
		try {
			month = formatter.format(monthParse.parse(month));
			date = dformatter.format(dateParse.parse(date));
		} catch (ParseException e) {
		}
		String year = Integer.toString(cal.get(Calendar.YEAR));
		String calDate = month + "/" + date + "/" + year;
		System.out.println(calDate);
	}
	

}
