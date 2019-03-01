package com.learningsolo.crackingcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyBinaryTree<T> {
	
	class Node<T>{
		private T data;
		private Node<T> left;
		private Node<T> right;
		
		Node(T data){
			this.data = data;
		}
	}
	
	Node<T> root;
	
	public void inOrderTraversal(Node<T> temp){
		
		if(temp == null){
			return;
		}
		
		inOrderTraversal(temp.left);
		System.out.print(temp.data+" -> ");
		inOrderTraversal(temp.right);
	}
	
	public void preOrderWithouRecursion(){
		Stack<Node> nodes = new Stack<>();
		nodes.push(root);
		
		while(!nodes.isEmpty()){
			Node current = nodes.pop();
			System.out.printf("%s,", current.data);
			
			if(current.right != null){
				nodes.push(current.right);
			}
			if(current.left != null){
				nodes.push(current.left);
			}
			
		}
	}
	
	public void insert(T data){
		Node<T> temp = root;
		Queue<Node<T>> q = new LinkedList<>();
		q.add(temp);
		
		if(root == null){
			root = new Node<>(data);
		}else{
			while(!q.isEmpty()){
				temp = q.peek();
				q.remove();
				if(temp.left == null){
					temp.left = new Node<>(data);
					break;
				}else{
					q.add(temp.left);
				}
				
				if(temp.right == null){
					temp.right = new Node<>(data);
					break;
				}else{
					q.add(temp.right);
				}
			
			}
		}
	}
	
	public static void main(String[] args) {
		
		MyBinaryTree<Integer> b = new MyBinaryTree<>();
		
		b.insert(10);
		b.insert(6);
		b.insert(7);
		b.insert(5);
		b.insert(3);
		b.insert(8);
		b.insert(9);
		
		b.inOrderTraversal(b.root);
		b.preOrderWithouRecursion();
	}

}
