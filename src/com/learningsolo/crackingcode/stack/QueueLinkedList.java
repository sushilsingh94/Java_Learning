package com.learningsolo.crackingcode.stack;

/**
 * Queue implementation using linked list
 * @author kumars28
 *
 * @param <T>
 */
public class QueueLinkedList<T> {
	
	class QueueNode<T>{
		private T data;
		private QueueNode<T> next;
		
		QueueNode(T data){
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public boolean isEmpty(){
		return first==null;
	}
	
	public void add(T data){
		QueueNode<T> t = new QueueNode<>(data);
		if(last != null){
			last.next = t;
		}
		last = t;
		if(first==null){
			first = last;
		}
	}
	
	public T peek() throws Exception{
		if(first == null){
			throw new Exception();
		}
		return first.data;
	}
	
	public T remove() throws Exception{
		if(first == null){
			throw new Exception();
		}
		T data = first.data;
		first = first.next;
		if(first == null){
			last = null;
		}
		return data;
	}
	
	public static void main(String[] args) throws Exception {
		QueueLinkedList<Integer> que = new QueueLinkedList<>();
		que.add(1);
		que.add(2);
		que.add(3);
		que.add(4);
		que.add(5);
		
		System.out.println(que.peek());
		System.out.println(que.remove());
		System.out.println(que.peek());
		int[] in=new int[4];
		in[0] &= ~(1 << 5);
		System.out.println(in[0]);
	}

}
