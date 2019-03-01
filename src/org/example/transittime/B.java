package org.example.transittime;

public class B extends A{
	
	StringBuffer sb = new StringBuffer();
	
	StringBuilder sb1 = new StringBuilder();
	
	public static void main(String[] args) {
		
		String s = "abc";
		String s1 = "abc";
		
		String s3 = new String("abc");
		
		if(s==s1){
			System.out.println("Yes");
		} 
		if(s == s3){
			System.out.println("yes1");
		}
		
		String aa = "Hello World";
		char[] ca = aa.toCharArray();
		for(int i =0;i<ca.length;i++){
			
			if(ca[i] != ' '){
				if(i != 0){
					System.out.print(" ");
				}
				System.out.print(ca[i]);
			}
		}
		
	}

}
