package com.epam.vyacheslav_utenkov.java.lesson4.task1;

import java.util.Locale;
import java.util.ResourceBundle;

public class FileHandler {
	private static ResourceBundle resourceBundle;
	private static Locale current = Locale.US;
	private static final String PROPERTIES_PATH = "com.epam.vyacheslav_utenkov.java.lesson4.task1.text";

	public static void setLocale(String arg) {
		if(arg.equals("0")){
			current = Locale.US;
			resourceBundle = ResourceBundle
					.getBundle(PROPERTIES_PATH, current);
		} else if(arg.equals("1")){
			current = new Locale("ru", "RU");
			resourceBundle = ResourceBundle
					.getBundle(PROPERTIES_PATH, current);
		}else {
			current = Locale.US;
			resourceBundle = ResourceBundle
					.getBundle(PROPERTIES_PATH, current);
		}
	}
	
	
	public static String[] getDate(){
		String values = "";
		for(String key: ConsoleHelper.getKeys()){
			values += resourceBundle.getString(key) + ConsoleHelper.DELIMITER;
		}
		return values.split(ConsoleHelper.DELIMITER);
	}
}
