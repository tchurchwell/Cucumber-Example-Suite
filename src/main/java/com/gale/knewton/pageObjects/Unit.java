package com.gale.knewton.pageObjects;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Unit {
	
	public static void main (String args[]) throws ParseException{
		DateFormat formatter = new SimpleDateFormat("MM/DD/YYYY");
		//SimpleDateFormat monthParse = new SimpleDateFormat("DD");
		String  s = "03/01/2012";
		//s= formatter.parse(s);
		System.out.println(formatter.parse(s));
		
	}
	

}
