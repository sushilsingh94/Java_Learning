package com.learningsolo.crackingcode.linkedlist;
/**
 * Check if a linked list is Circular Linked List
 * 
 * While traversing If we reach NULL, linked list is not circular. If reach head again, linked list is circular.
 * @author kumars28
 *
 */

public class LLCircular {
	
	Node head;
	static class Node{
		String data;
		Node next;
		
		Node(String data){
			this.data = data;
			this.next = null;
		}
	}
	public boolean isListCircular(){
		Node temp = head;
		
		while(temp != null){
			temp = temp.next;
			if(temp == head){
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		LLCircular ll = new LLCircular();
	    ll.head = new Node("a"); 
	    ll.head.next = new Node("b");
	    ll.head.next.next = new Node("c");
	    ll.head.next.next.next = new Node("d");
	  
	    System.out.println(ll.isListCircular());
	  
	    ll.head.next.next.next.next = ll.head; 
	  
	    System.out.println(ll.isListCircular());
	}
}
