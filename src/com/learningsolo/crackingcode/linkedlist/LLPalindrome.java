package com.learningsolo.crackingcode.linkedlist;
/**
 * Check if a linked list of strings forms a palindrome
 * @author kumars28
 *
 */

public class LLPalindrome {
	Node root;
	
	static class Node{
		String data;
		Node next;
		
		Node(String data){
			this.data = data;
			this.next = null;
		}
	}
	
	public boolean isPalindrome(String str){
		int len = str.length();
		
		for(int i=0;i<len/2;i++){
			if(str.charAt(i) != str.charAt(len-1 -i)){
				return false;
			}
		}
		return true;
	}
	
	public boolean checkPalindrome(){
		Node temp = root;
		
		StringBuilder sb = new StringBuilder();
		while(temp != null){
			sb.append(temp.data);
			temp = temp.next;
		}
		return isPalindrome(sb.toString());
	}
	
	public static void main(String[] args) {
		LLPalindrome ll = new LLPalindrome();
		ll.root = new Node("a");
		ll.root.next = new Node("b");
		ll.root.next.next = new Node("c");
		ll.root.next.next.next = new Node("b");
		ll.root.next.next.next.next = new Node("a");
		
		System.out.println(ll.checkPalindrome());
	}

}
