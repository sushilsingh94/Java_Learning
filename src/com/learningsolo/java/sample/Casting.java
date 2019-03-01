package com.learningsolo.java.sample;

/**
 * child/subclass object can be assigned to Parent class object but 
 * Parent class object cannot be assigned to Child class object. It fails as run time
 * @author kumars28
 *
 */
public class Casting {
	
	public static void main(String[] args) {
		B b1 = new B();
		b1.display();
		C c = (C) b1;
		c.display();
		/*B b = c;
		
		A a = b;
		A a1 = c;
		
		C c1 = (C) a;*/
	}
}

class A{
	
	public void display(){
		System.out.println("A");
	}
	
}
class B extends A{
	public void display(){
		System.out.println("B");
	}
}
class C extends B{
	public void display(){
		System.out.println("C");
	}
}
