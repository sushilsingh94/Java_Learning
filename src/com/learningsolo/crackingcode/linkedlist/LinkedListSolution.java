package com.learningsolo.crackingcode.linkedlist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListSolution {
	
	public static void main(String[] args) {
		LinkedList<Integer> llist = new LinkedList<>();
		llist.add(1);
		llist.add(2);
		llist.add(7);
		llist.add(1);
		llist.add(7);
		
		removeDuplicate(llist);
	}
	
	static void removeDuplicate(LinkedList<Integer> llist){
		System.out.println(llist);
		HashSet<Integer> set = new HashSet<>();
		
		Iterator<Integer> itr = llist.iterator();
		while(itr.hasNext()){
			Integer a = itr.next();
			if(set.contains(a)){
				itr.remove();
			}else{
				set.add(a);
			}
			
		}
		System.out.println(llist);
	}
	
	static void removeMidElementLinkedList(LinkedLists llist){
		
	}

}
