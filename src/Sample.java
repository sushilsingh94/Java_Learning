import java.util.ArrayList;
import java.util.List;

public class Sample {
	
	public static void main1(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		System.out.println(l);
		addToList(l);
		System.out.println(l);
		String s = "Swati";
		addToString(s);
		System.out.println(s);
	}
	
	static void addToString(String s){
		s = s + "hi";
	}
	
	static void addToList(List l){
		l.add("hi");
		l.add("hello");
	}
	
	public static void main(String[] args) {
		String name = "Sushil";
		String str = "X";
		str = str.replaceAll("X", "XXXXXXXXXX");
		str = str.replaceAll("X", "XXXXXXXXXX");
		str = str.replaceAll("X", "XXXXXXXXXX");
		str = str.replaceAll("X", name + "\n");
		System.out.println(str);
	}

}
