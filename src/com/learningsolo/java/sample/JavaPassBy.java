package com.learningsolo.java.sample;

import java.util.ArrayList;
import java.util.List;

public class JavaPassBy {
	
	public static void main(String[] args) {
		Employee e = new Employee("Sushil", 213232);
		
		System.out.println("Name:"+e.getName() +" - Sal:"+e.getSalary());
		JavaPassBy j = new JavaPassBy();
		j.modify(e);
		System.out.println("After Modify() Name:"+e.getName() +" - Sal:"+e.getSalary());
		
		List<String> list = new ArrayList<>();
		list.add("sushil");
		System.out.println("Before list:"+list);
		j.modify(list);
		System.out.println("After list:"+list);
		
		StringBuilder text = new StringBuilder("new");
		System.out.println(text);
		j.modify(text);
		System.out.println(text);
	}
	
	private void modify(Employee e1){
		e1.setName("rajesh");
		e1.setSalary(10000);
	}
	
	private void modify(List<String> list){
		list.add("new 1");
		list.add("new 2");
	}
	
	private void modify(StringBuilder abc){
		abc.append("sshil");
	}

}
