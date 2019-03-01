
public class MainTest {

	public static void main(String[] args) {
		Object ab = null;
		
		String abc = (String)ab;
		
		if(abc == null){
			System.out.println("is null");
		}
		System.out.println(abc);
	}
}