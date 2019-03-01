package com.learningsolo.java.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SampleMain {
	
	public static void main(String[] args) {
		
		Employee e1 = new Employee("Sushil", 1321);
		Employee e2 = new Employee("Swati", 1321);
		Employee e3 = new Employee("Sanjay", 1435);
		Employee e4 = new Employee("Suresh", 313);
		
		List<Employee> list = new ArrayList<>();
		
		list.add(e2);
		list.add(e1);
		list.add(e3);
		list.add(e4);
		
		printList(list);
		Collections.sort(list, new NameSalaryComparator());
		System.out.println("--------");
		printList(list);
	}

	static void printList(List<Employee> list){
		for (Employee e : list) {
			System.out.println(e.getName()+" - "+e.getSalary());
		}
	}
}
