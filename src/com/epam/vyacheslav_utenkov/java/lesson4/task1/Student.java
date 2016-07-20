package com.epam.vyacheslav_utenkov.java.lesson4.task1;

import java.text.SimpleDateFormat;
import java.util.List;

public class Student {

	private Programm programm;
	private String name;
	private String[] parametrs;
	private static SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");

	public Student(String name, Programm programm) {
		this.name = name;
		this.programm = programm;
	}

	public Student(String name, String programmName) {
		this.name = name;
		this.programm = new Programm(programmName);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Programm getProgramm() {
		return programm;
	}

	public List<Course> getCourses() {
		return getProgramm().getCourses();
	}

	public void setProgramm(Programm programm) {
		this.programm = programm;
	}

	public String[] getParametrs() {
		parametrs = new String[] { format.format(getProgramm().getCurrentDate()),
				format.format(getProgramm().getStartDate()), format.format(getProgramm().getFinishDate()),
				getProgramm().getWorkingTime(), getName(), getProgramm().getProgrammName() };
		return parametrs;
	}

}
