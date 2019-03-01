package org.example.transittime;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	static String gender;
	private int height;

	Person() {
	};

	Person(String name, int age, String gender, int height) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Name:" + name + "\nAge: " + age + "\nGender: " + gender;
	}
}