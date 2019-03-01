package hackerrank.solutions;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftArrayRotation {
	
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
	
	static int[] rotLeft1(int[] a, int d) {

        for(int j=0;j<d;j++){
        	int[] arr = new int[a.length];
            int s = a[0];
	        System.arraycopy(a, 1, arr, 0, a.length-1);
	        arr[a.length-1] = s;
	        a = arr;
        }
        return a;
    }
	
	// Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] arr = new int[a.length];
        arr = a;
        while(d>0){
            arr = rotate(arr);
            d--;
        }
        return arr;
    }
    
    static int[] rotate(int[] a){
        int[] arr = Arrays.copyOfRange(a, 1, a.length);
        int[] tempa = Arrays.copyOf(arr, a.length);
        tempa[a.length-1] = a[0];
        return tempa;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/Users/kumars28/Desktop/Ocean Jars/Ocean jars/out.txt"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }*/
    	int d = 60581;
        int[] result = rotLeft(a, d);

        System.out.println(Arrays.toString(result));
        /*for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}