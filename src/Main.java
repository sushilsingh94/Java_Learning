import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.example.transittime.MyClass;

public class Main extends MyClass{
	
	static final int NO_OF_CHARS = 256;
    static char count[] = new char[NO_OF_CHARS];
    
    TreeSet<String> treeSet;
    HashMap<String, String> map;
     
    /* calculate count of characters 
       in the passed string */
     static void getCharCountArray(String str) 
     {
         for (int i = 0; i < str.length();  i++){
              count[str.charAt(i)]++;
         }
     }
      
    /* The method returns index of first non-repeating
       character in a string. If all characters are repeating 
       then returns -1 */
    static int firstNonRepeating(String str)
    {
        getCharCountArray(str);
        int index = -1, i;
      
        for (i = 0; i < str.length();  i++)
        {
            if (count[str.charAt(i)] == 1)
            {
                index = i;
                break;
            }   
        }  
       
      return index;
    }
	
    /**
     * Find and print the relationship between units and values
     * 1 row contains all units separated by comma
     * next rows will be the  size of first row -1, 
     * 
     * output should one line relation between units and and its values in descending order
     * 
     *  eg a = bc
     *  a = unit, b = value , c = unit of b
     * 
     * Input : hour,day,second,minute,milisecond
	 *			day = 24 hour
	 *			hour = 60 minute
	 *			minute = 60 second
	 *			second = 60 milisecond
     *
     * Output : 1day = 24hour = 1440minute = 86400second = 5184000milisecond
     */
    public static void main11(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        List<String> units = Arrays.asList(name.split(","));
        List<String> rel = new ArrayList<>();
        String start = "";
        List<String> templ = new ArrayList<>();
        for(int i=0;i<units.size() - 1; i++){
            String temp = s.nextLine();
            rel.add(temp);
            String[] arr = temp.split(" ");
            templ.add(arr[3]);
        }
        
        for(int i=0;i<units.size();i++){
        	String t = units.get(i);
        	if(!templ.contains(t)){
        		start = t;
        	}
        }
        
        String key = start;
        int val = 1;
        System.out.print(val+key);
        for(int i=0; i<rel.size();i++){
        	
        	String[] arr = rel.get(i).split(" ");
        	if(arr[0].equals(key)){
        		val = Integer.parseInt(arr[2])*val;
        		key = arr[3];
        		System.out.print(" = "+val+""+arr[3]);
        	}
        	
        }
        
    }
    
    public static void main(String[] args) {


    	Map<String, String> eligibleOrdersSerialMap= new HashMap<>();
    	eligibleOrdersSerialMap.put("1234:mfr1", "mfr1");
    	eligibleOrdersSerialMap.put("1235:mfr2", "mfr2");
    	eligibleOrdersSerialMap.put("1236:mfr3", "mfr3");
    	eligibleOrdersSerialMap.put("1237:mfr4", "mfr4");
    	
    	List<Map<String, Object>> validSerialWithClaimsList = new ArrayList<>();
    	Map<String, Object> map1 = new HashMap<>();
    	map1.put("mfr__c", "mfr2");
    	map1.put("ord__c", "asda");
    	map1.put("sswew__c", "332r2");
    	validSerialWithClaimsList.add(map1);
    	Map<String, Object> map2 = new HashMap<>();
    	map2.put("mfr__c", "mfr1");
    	map2.put("ord__c", "asda");
    	map2.put("sswew__c", "332r2");
    	validSerialWithClaimsList.add(map2);
    	
    	Map<String, Object> map3 = new HashMap<>();
    	map3.put("mfr__c", "mfr4");
    	map3.put("ord__c", "asda");
    	map3.put("sswew__c", "332r2");
    	validSerialWithClaimsList.add(map3);
		addP(validSerialWithClaimsList);
		
		System.out.println(validSerialWithClaimsList);
	}
    
    private static void addP(List<Map<String, Object>> ll){
    	Map<String, Object> map1 = new HashMap<>();
    	map1.put("mfr__c", "mfr2");
    	map1.put("ord__c", "asda");
    	map1.put("sswew__c", "332r2");
    	ll.add(map1);
    }
    
    public static void main_tem(String[] args) {
		String s = "aabbccddeefghi";
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++){
			Integer val = map.containsKey(s.charAt(i))?map.get(s.charAt(i)):0;
			map.put(s.charAt(i), val+1);
		}
		
		Iterator iterator = map.entrySet().iterator();
		int uindex = 0;
		int prev = 0;
		while(iterator.hasNext()){
			Entry<Character, Integer> e = (Entry<Character, Integer>)iterator.next();
			int val = e.getValue();
			
			if(val != prev && prev!=0 && val-1==prev){
				uindex++;
			}
			prev = val;
		}
		if(uindex<=1){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
    
    
	public static void main112(String[] args) {
		count[0] = 2;
		count[0]++;
		System.out.println((int)count[0]);
		System.out.println(count["abcd".charAt(2)]++);
		System.out.println(count["abcd".charAt(2)]++);
		System.out.println((int)count['c']);
		//System.out.println(firstNonRepeating("church"));
		
		TreeMap<Character, Integer> mapA = new TreeMap<>();
        TreeMap<Character, Integer> mapB = new TreeMap<>();
        String a = "abaca";
        String b = "abac";
        char[] achar = a.toCharArray();
        for(int i=0;i<achar.length;i++){
            Character ach = achar[i];
            Integer val = mapA.containsKey(ach)?mapA.get(ach):0;
            mapA.put(ach, val +1);
        }
        
        char[] bchar = b.toCharArray();
        for(int i=0;i<bchar.length;i++){
            Character bch = bchar[i];
            Integer val = mapB.containsKey(bch)?mapB.get(bch):0;
            mapB.put(bch, val +1);
        }
        int count = 0;
		Iterator itr = mapA.entrySet().iterator();
		while(itr.hasNext()){
			Entry<Character, Integer> ent =  (Entry<Character, Integer>) itr.next();
			char key = ent.getKey();
			int val = ent.getValue();
			if(mapB.containsKey(key)){
				int bVal = mapB.get(key);
				if(val == bVal){
					int s = val + bVal;
					count += s;
				}else{
					int dif = Math.abs(val - bVal);
					int s = val + bVal - dif;
					count += s;
				}
			}
		}
		int size = a.length() + b.length();
		System.out.println(size - count);
	}
	
	public static int getFirstNonRepeatingChar(String val){
		char[] chars = new char[256];
		
		for(int i=0;i<val.length();i++){
			chars[val.charAt(i)]++;
		}
		for(int i=0;i<val.length();i++){
			if(chars[val.charAt(i)] == 1){
				return val.charAt(i);
			}
		}
		return -1;
	}
	
	static boolean isVowel(char c){
		return c == 'a' || c == 'e' || c=='i' || c == 'o' || c=='u';
	}
	
	static int countVowels(String val){
		val = val.toLowerCase();
		int count = 0;
		for(char c : val.toCharArray()){
			if(isVowel(c)){
				count++;
			}
		}
		return count;
	}
	
	static void printPairWithSum50(int[] arr){
		for(int i=0;i<arr.length;i++){
			
		}
	}
	
	 public static void main232(String args[]) throws IllegalArgumentException, IllegalAccessException {
		 System.out.println("Vowels count:"+countVowels("churich"));
		 //System.out.println(firstNonRepeating("chch"));

		 System.out.println("First Non Repeating character:"+(char)getFirstNonRepeatingChar("church"));
		 
		 try {
			 Field privateField = Class.forName("org.example.transittime.MyClass").getDeclaredField("privateString");

			 privateField.setAccessible(true);
			 MyClass objTest = new MyClass();
			 System.out.println(privateField.get(objTest)); // prints "private string"
			 privateField.set(objTest, "private string updated");
			 System.out.println(privateField.get(objTest)); //prints "private string updated"
			 
			 

		 } catch (NoSuchFieldException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	  }
	
	public static void main1(String[] args) throws ParseException {
		
		String lastDate = "2017-12-11 09:47:11";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(lastDate);
		Date newdate = new Date(date.getHours() + 4);

		String abc = "lineItemConsistMasterStep:Thread01";
		
		if(abc.contains("lineItemConsistMasterStep")){
			System.out.println(new java.util.Date());
		}
		
		ArrayList<String> phoneNumbers = new ArrayList();
		phoneNumbers.add("+1 1234567890123");
		phoneNumbers.add("+12 123456789");
		phoneNumbers.add("+123 123456");
		phoneNumbers.add("+91 9620112360");
		phoneNumbers.add("+919620112360");
		 
		String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
		 
		Pattern pattern = Pattern.compile(regex);
		 
		for(String email : phoneNumbers)
		{
		    Matcher matcher = pattern.matcher(email);
		    System.out.println(email +" : "+ matcher.matches());
		}
	}
	

}
