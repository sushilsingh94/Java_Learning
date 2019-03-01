package com.learningsolo.java.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class Lambda {
	
	public static void main(String[] args) {
		Employee e1 = new Employee("S1", 120);
		Employee e2 = new Employee("S2", 222);
		Employee e3 = new Employee("S3", 50);
		Employee e4 = new Employee("S4", 422);
		Employee e5 = new Employee("S5", 12);
		
		List<Employee> list = Arrays.asList(e1,e2,e3,e4,e5);
		//list.forEach((s)-> System.out.println(s.getName()));
		int t = list.stream().filter((s)-> s.getSalary()>50).collect(Collectors.summingInt(Employee::getSalary));
		System.out.println(t);
	}
}
