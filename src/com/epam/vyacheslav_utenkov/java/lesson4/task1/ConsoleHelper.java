package com.epam.vyacheslav_utenkov.java.lesson4.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleHelper {

	private static EducationalCenter educationalCenter = new EducationalCenter();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static final String MENU = "0 - Light edition; 1 - Full edition; 3 - EXIT";
	private static final String FULL = "1";
	private static final String LIGHT = "0";
	private static final String EXIT = "3";
	private static final String ERROR = "Wrong command! please try again";
	private static String[] keys = { "current_date", "start_date", "finish_date", "working_time", "student",
			"curriculum"};
	private static final String LIGHT_EDITION = "%s (%s) %s";
	private static String[] date;
	public static final String DELIMITER = ",";
	public static final String SPACE = " ";

	public static void writeMessage(String message) {
		System.out.println(message);
	}
	
	public static void setDate(String[] date) {
		ConsoleHelper.date = date;
	}

	public static String readString() {

		String line = "";
		try {
			line = reader.readLine().replaceAll("\\s", "");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}

	public static void workWithUser(String locale) {
		writeMessage(MENU);
		educationalCenter.createDefultStudent();
        FileHandler.setLocale(locale);
        ConsoleHelper.setDate(FileHandler.getDate());
		String edition = "";
		if(educationalCenter.getStudents().isEmpty()){
			educationalCenter.createDefultStudent();
		}
		while (!edition.equals(EXIT)) {
			edition = readString();
			if (edition.equals(LIGHT)) {
				ConsoleHelper.printLightDataFormat();
			} else if (edition.equals(FULL)) {
				ConsoleHelper.printFullDataFormat();
			} else if (edition.equals(EXIT)) {
				break;
			} else {
				try {
					throw new IllegalAccessException();
				} catch (IllegalAccessException e) {
					ConsoleHelper.writeMessage(ERROR);
				}
			}
		}
	}

	public static void printFullDataFormat() {

		for (Student student : educationalCenter.getStudents()) {
			printLine(getMostLargeLength(student));
			for (int i = 0; i < date.length; i++) {
				for (int j = 0; j < getLongValue(date); j++) {
					if (date[i].length() < getLongValue(date)) {
						date[i] += " ";
					} else {
						break;
					}
				}
				System.out.println(date[i] + " " + student.getParametrs()[i] + "\n");
			}

			printLine(getMostLargeLength(student));
			printCourses(student);
			printLine(getMostLargeLength(student));
			printTotalDuration(student);
		}

	}

	public static void printLightDataFormat() {
		for (Student student : educationalCenter.getStudents()) {
			ConsoleHelper.writeMessage(String.format(LIGHT_EDITION, student.getName(),
					student.getProgramm().getProgrammName(), student.getProgramm().getProgrammStatus()));
		}
	}

	private static void printLine(int lenght) {
		for (int i = 0; i < lenght; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private static int getMostLargeLength(Student student) {
		int largeParametrs = getLongValue(student.getParametrs());
		int largeData = getLongValue(date);
		return largeData + largeParametrs;
	}

	private static int getLongValue(String[] array) {
		int longValue = 0;
		for (String str : array) {
			if (str.length() > longValue) {
				longValue = str.length();
			}
		}
		return longValue;
	}

	private static int getLongValue(List<Course> list) {
		int longValue = 0;
		for (Course course : list) {
			if (course.getName().length() > longValue) {
				longValue = course.getName().length();
			}
		}
		return longValue;
	}

	private static void printCourses(Student student) {
		String fixCourseLenght = "";
		for (int i = 0; i < student.getProgramm().getCourses().size(); i++) {
			fixCourseLenght = student.getCourses().get(i).getName();
			for (int j = 0; j < getLongValue(student.getCourses()); j++) {
				if (student.getCourses().get(j).getName().length() < getLongValue(student.getCourses())) {
					fixCourseLenght += SPACE;
				} else {
					break;
				}
			}
			System.out.println(i + ". " + fixCourseLenght + SPACE + student.getCourses().get(i).getCourseDuration());
			fixCourseLenght = "";
		}

	}

	private static void printTotalDuration(Student student) {
		ConsoleHelper.writeMessage("Total:" + SPACE + student.getProgramm().getProgrammDuration() + SPACE + "hrs\n" + student.getProgramm().getProgrammStatus());
	}
	
	public static String[] getKeys(){
		return keys;
	}
	

}
