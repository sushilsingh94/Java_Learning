

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;



public class MainJava8 {
	static List<Map<String, String>> list = new ArrayList<>();
	/**
	 * Left rotate array input {1,2,3,4,5} Output-{5,1,2,3,4}
	 * [2, 3, 4, 5, 1], [3, 4, 5, 1, 2] , [4, 5, 1, 2, 3], [5, 1, 2, 3, 4]
	 * Final-[5, 1, 2, 3, 4]
	 * @param a
	 * @param d
	 * @return
	 */
	static int[] rotLeft_Recursion(int[] a, int d) {
		int[] arr = new int[a.length];
        int s = a[0];
        if(d<=0){
            return a;
        }
        for(int i=0;i<a.length-1;i++){
        	arr[i] = a[i+1];
        }
        arr[a.length-1] = s;
        return rotLeft(arr, d-1);

    }
	
	static int[] rotLeft(int[] a, int d) {

        for(int j=0;j<d;j++){
        	int[] arr = new int[a.length];
            int s = a[0];
	        System.arraycopy(a, 1, arr, 0, a.length-1);
	        arr[a.length-1] = s;
	        a = arr;
        }
        return a;
    }
	
public static void main(String[] args) {
	int[] a= {1,2,3,4,5};
	System.out.println("Final-"+Arrays.toString(rotLeft(a, 4)));
	
	int k = 20;
	char[] arr = new char[k];
	for(int i=0;i<k;i++){
		arr[i]=(char)i;
	}
	System.out.println(Arrays.toString(arr));
		
		/*int arr[][]  = {{-9,-9,-9, 1,1,1},{0,-9, 0, 4,3,2},{-9,-9,-9, 1,2,3},{0, 0, 8, 6,6,0},{0, 0, 0,-2,0,0},{ 0, 0, 1, 2,4,0}};
		int j =3;
		int ar[] = new int[3];
		ar = Arrays.copyOfRange(arr[0], j, j+3);
		System.out.println(Arrays.toString(ar));
		*/
	/*char[] chars = new char[] {'\u0097'}; 
	System.out.println(Arrays.toString(chars));
	String str = new String(chars);
	System.out.println(str);
	byte[] bytes = str.getBytes();
	System.out.println(Arrays.toString(bytes));
	
	try {
		FileOutputStream fs = new FileOutputStream("");
	} catch (IOException e) {
		
	}*/

	
}
	public static void main1(String[] args) {
		
		int arr[][]  = {{-9,-9,-9, 1,1,1},{0,-9, 0, 4,3,2},{-9,-9,-9, 1,2,3},{0, 0, 8, 6,6,0},{0, 0, 0,-2,0,0},{ 0, 0, 1, 2,4,0}};
		int j =0;
		System.out.println(Arrays.copyOfRange(arr[0], j, j+3));
		
		
		Map<String, String> ordersMap = new HashMap<>();
		ordersMap.put("1", "one");
		ordersMap.put("2", "two");
		ordersMap.put("3", "three");
		List<String> validClaimsSerialList = new ArrayList<>();
		validClaimsSerialList.add("1");
		validClaimsSerialList.add("3");
		/*ordersMap.entrySet().forEach(entry -> {
			if(!validClaimsSerialList.isEmpty() && validClaimsSerialList.contains(entry.getValue())){
				Map<String, Object> map = new HashMap<>();
				map.put("1", entry.getValue());
				map.put("2", entry.getKey());
				map.put("3", entry.getKey()+entry.getValue()); 
				list.add(map);
			}});*/
		
		ordersMap.entrySet().stream()
							.filter(entry -> validClaimsSerialList.contains(entry.getKey()))
							.forEach(MainJava8::getSFMapParams);
		System.out.println(list);
		list.clear();
		System.out.println(list.size());
		list.addAll(ordersMap.entrySet().stream()
                .filter(entry -> validClaimsSerialList.contains(entry.getKey()))
                .map(MainJava8::getSFMapParams1).collect(Collectors.toList()));
		
		System.out.println(list);
		
	}
	
	private static void getSFMapParams(Entry<String, String> entry){
		Map<String, String> map = new HashMap<>();
		map.put("ord", entry.getValue());
		map.put("part", entry.getKey());
		map.put("seq", entry.getKey()+entry.getValue());
		list.add(map);

	}
	
	private static Map<String, String> getSFMapParams1(Entry<String, String> entry){
		Map<String, String> map = new HashMap<>();
		map.put("ord", entry.getValue());
		map.put("part", entry.getKey());
		map.put("seq", entry.getKey()+entry.getValue());
		return map;
	}

}
