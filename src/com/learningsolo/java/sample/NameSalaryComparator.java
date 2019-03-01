package com.learningsolo.java.sample;

import java.util.Comparator;

/**
 * first compare based on salary and if salary is same then compare based on name
 * @author kumars28
 *
 */
public class NameSalaryComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		
		int sal = Integer.compare(o1.getSalary(), o2.getSalary());
		if(sal == 0){
			return o1.getName().compareTo(o2.getName());
		}
		return sal;
	}

}
