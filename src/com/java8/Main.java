package com.java8;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) {
		SquareRoot root = n -> Math.sqrt(n);
		
		System.out.println(root.findSquareRoot(2));
		
		printDuplicateChar("sushil");
		
		ArrayList<String> list = new ArrayList<>();
		list.add(1, "asa");
		list.add(10,"2342");
	}
	
	public static void printDuplicateChar(String val){
		HashSet<Character> set = new HashSet<>();
		
		for(int i=0;i<val.length();i++){
			char ch = val.charAt(i);
			if(!set.add(ch)){
				System.out.println(ch);
			}
			
			
		}
	}

}
