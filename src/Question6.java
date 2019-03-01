
public class Question6 {
	
	private String str="this is my best";
	 
	 public void reverse(){
		 String name = null;
		 for(int i=str.length()-1;i>=0;i--){
			  name = name+str.charAt(i);
			 
		 }
		 System.out.println("reverse name is "+name);
	 }
	 
	 public static void main(String[] args) {
		 Question6 q8=new Question6();
		 q8.reverse();
	}
}
