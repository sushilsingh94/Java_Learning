package com.learningsolo.crackingcode.linkedlist;


/**
 * Cracking coding interview
 * @author kumars28
 *
 */
public class LinkedLists {

	Node head;

	static class Node{
		int data;
		Node next;

		Node(int data){
			this.data = data;
			this.next = null;
		}
	}

	public void push(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	public void print(){
		Node n = head;
		while(n != null){
			System.out.print("-> "+n.data);
			n = n.next;
		}
		System.out.println("");
	}
	/**
	 * find middle without using size
	 * use fast and slow poniter to find middle element
	 * 
	 */
	public void printMiddle(){
		Node fast = head;
		Node slow = head;

		while(fast!=null && fast.next !=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("Middle Element ->"+slow.data);
		System.out.println("Length of linked List:");
	}
	/**
	 * this removes any particular given node
	 * @param node
	 */
	public static void removeNode(Node node){
		if(node == null || node.next == null){
			System.out.println("Null");
		}
		Node temp = node.next;
		node.next = temp.next;
		node.data = temp.data;
	}
	public static void main(String[] args) {
		LinkedLists llist = new LinkedLists(); 
		for (int i=5; i>0; --i){ 
			llist.push(i); 
			llist.print();
		} 
		llist.printMiddle();

		LinkedLists list = new LinkedLists();
		list.head = new Node(1); 
		Node nn = new Node(12);
		list.head.next = nn; 
		list.head.next.next = new Node(1); 
		list.head.next.next.next = new Node(4); 
		list.head.next.next.next.next = new Node(1);

		list.print(); 
		list.removeNode(nn);
		list.print(); 
	}
}
