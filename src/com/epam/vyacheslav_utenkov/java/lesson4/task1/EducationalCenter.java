package com.epam.vyacheslav_utenkov.java.lesson4.task1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EducationalCenter {
	List<Student> students = new ArrayList<Student>();

	public EducationalCenter() {
		
	}
	
	public void createDefultStudent(){
		Programm programmFull = new Programm("Java full");
		programmFull.setStartDate(new Date());
		programmFull.addCourse(new Course("Basic", 20));
		programmFull.addCourse(new Course("JDBC", 40));
		programmFull.addCourse(new Course("Servlet", 60));
		Student studentAlina = new Student("ALina Rusakova", programmFull);
		addStudent(studentAlina);

		Programm programmTesting = new Programm("Java Testing");
		programmTesting.setStartDate(new Date());
		programmTesting.addCourse(new Course("Basic", 20));
		Student studentSergey = new Student("Sergey Smirnov", programmTesting);
		addStudent(studentSergey);
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public List<Student> getStudents() {
		return students;
	}
}
