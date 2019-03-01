package com.learningsolo.crackingcode.stack;


/**
 * Implement Stack using array
 * @author kumars28
 *
 */
public class MyStackArray<T> {
	
	private int top;
	private final int MAX = 1000;
	Object[] arr = new Object[MAX];
	
	public boolean isEmpty(){
		return top <=0;
	}
	public boolean push(T data){
		if(top > MAX-1){
			System.out.println("Stack Overflow..!");
			return false;
		}
		arr[top++] = data; 
		return true;
	}
	
	public T peek() throws Exception{
		if(top<=0){
			throw new Exception();
		}
		return (T) arr[top-1];
	}
	public T pop() throws Exception{
		if(top<=0){
			throw new Exception();
		}
		T item = (T) arr[--top];
		return item;
	}
	
	public static void main(String[] args) throws Exception {
		MyStackArray<Integer> stack = new MyStackArray<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}

}
