package com.epam.vyacheslav_utenkov.java.lesson4.task1;

public class Course {
	private String name;
	private int courseDuration;

	public Course(String name, int courseDuration) {
		this.name = name;
		this.courseDuration = courseDuration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
}
