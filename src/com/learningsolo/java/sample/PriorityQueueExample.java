package com.learningsolo.java.sample;

import java.util.PriorityQueue; 
import java.util.Queue; 

public class PriorityQueueExample { 
	
	public static void main(String[] args) { 
		Queue<Integer> pQueue = new PriorityQueue<>(); 
		pQueue.add(900); 
		pQueue.add(100); 
		pQueue.add(700); 
		pQueue.add(200); 
		// Remove items from the PriorityQueue 
		while (!pQueue.isEmpty()) {
			System.out.println(pQueue.remove()); 
		} 
	} 
}

