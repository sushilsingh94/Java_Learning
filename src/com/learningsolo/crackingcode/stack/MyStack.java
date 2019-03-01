package com.learningsolo.crackingcode.stack;
/**
 * Implement Stack Using linked list
 * @author kumars28
 *
 */
public class MyStack<T> {
	
	private class NodeStack<T>{
		private T data;
		private NodeStack<T> next;
		
		NodeStack(T data){
			this.data = data;
		}
	}
	
	private NodeStack<T> top;
	
	public void push(T data){
		NodeStack<T> t = new NodeStack<>(data);
		t.next = top;
		top = t;
	}
	
	public T peek() throws Exception{
		if(top ==null) {
			throw new Exception();
		}
		return top.data;
	}
	
	public T pop() throws Exception{
		if(top ==null) {
			throw new Exception();
		}
		T item = top.data;
		top = top.next;
		return item;
	}
	
	public boolean isEmpty(){
		return top==null;
	}
	
	public static void main(String[] args) throws Exception {
		MyStack<Integer> stack = new MyStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}

}
