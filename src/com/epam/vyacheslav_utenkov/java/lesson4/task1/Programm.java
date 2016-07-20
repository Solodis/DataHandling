package com.epam.vyacheslav_utenkov.java.lesson4.task1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Programm {
	private String programmName;
	private int programmDuration = 0;
	private final int START_WORKING_TIME = 10;
	private final int END_WORKING_TIME = 18;
	private final int WORKING_HOURS = 8;
	private Date startDate;
	private GregorianCalendar calendar;
	private int hoursBeforeTheEnd = 0;
	private int daysBeforeTheEnd = 0;
	private boolean isComplete = false;
	private String status;
	private List<Course> courses = new ArrayList<Course>();

	public String getWorkingTime() {
		return String.valueOf(START_WORKING_TIME) + " - " + String.valueOf(END_WORKING_TIME);
	}

	public Programm(String programmName) {
		this.programmName = programmName;
	}

	public String getProgrammName() {
		return programmName;
	}

	public void setProgrammName(String programmName) {
		this.programmName = programmName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setProgramm(List<Course> courses) {
		this.courses = courses;
	}

	public int getProgrammDuration() {
		programmDuration = 0;
		for (Course course : courses) {
			programmDuration += course.getCourseDuration();
		}

		return programmDuration;
	}

	public void setStartDate(Date date) {
		this.startDate = date;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getFinishDate() {
		this.calendar = new GregorianCalendar();
		calendar.setTime(startDate);

		for (int i = 0; i < getProgrammDuration(); i++) {
			skipWeekend();
			skipOffHours();
			calendar.add(Calendar.HOUR, 1);
		}

		return calendar.getTime();
	}

	public Date getCurrentDate() {
		return new Date();
	}

	public String getProgrammStatus() {

		this.calendar = new GregorianCalendar();
		int duration = 0;
		isComplete = getFinishDate().getTime() - getCurrentDate().getTime() <= 0;

		if (!isComplete) {

			calendar.setTime(getCurrentDate());
			for (int i = 0; i < getProgrammDuration(); i++) {
				skipWeekend();
				skipOffHours();
				duration++;
			}
			status = "Not complete";
		} else {
			calendar.setTime(getFinishDate());
			while (calendar.getTime().getTime() < getCurrentDate().getTime()) {
				if (calendar.get(Calendar.HOUR_OF_DAY) <= END_WORKING_TIME
						&& calendar.get(Calendar.HOUR_OF_DAY) > START_WORKING_TIME) {
					calendar.add(Calendar.HOUR_OF_DAY, 1);
					duration++;
				} else {
					calendar.add(Calendar.HOUR_OF_DAY, 1);
				}
			}
			status = "Completed";
		}

		for (int i = 0; i < duration; i++) {
			if (hoursBeforeTheEnd < WORKING_HOURS) {
				hoursBeforeTheEnd++;
			} else {
				hoursBeforeTheEnd = 0;
				daysBeforeTheEnd++;
			}
		}
		return status + " Days: " + daysBeforeTheEnd + " Hours: " + hoursBeforeTheEnd;

	}

	public void addCourse(Course course) {

		courses.add(course);

	}

	private void skipWeekend() {
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			calendar.add(Calendar.DATE, 1);
		}
	}

	private void skipOffHours() {
		while (calendar.get(Calendar.HOUR_OF_DAY) >= END_WORKING_TIME
				|| calendar.get(Calendar.HOUR_OF_DAY) < START_WORKING_TIME) {

			calendar.clear(Calendar.MINUTE);
			calendar.clear(Calendar.SECOND);
			calendar.clear(Calendar.MILLISECOND);
			calendar.add(Calendar.HOUR, 1);
		}
	}
}
