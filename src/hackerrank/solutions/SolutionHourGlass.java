package hackerrank.solutions;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * 
 * @author kumars28
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 
 * Question: 2D array - Hourglass problem
 * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
public class SolutionHourGlass {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
		int sum = -99999;
    	for(int i=0;i<arr.length;i++){
    		for(int j=0; j<arr[i].length; j++){
    			if((arr.length -i >=3) && arr[i].length -j >= 3){
    				int[][] a = new int[3][3];
    				int index =0, len=0;
    				
    			    for (int ii = i, jj = j; len < 3; ii++, jj++) {
    			    	a[index] = Arrays.copyOfRange(arr[ii], j, j+3);
    			    	index++;
    			    	len++;
    			    }
    			    int singleSum = hourGlassSumSingle(a);
    			    System.out.println(singleSum);
    			    if(singleSum > sum){
    			    	sum = singleSum;
    			    }
    			    //System.out.println(Arrays.deepToString(a));
    				//System.out.println("true-"+i+" : "+j);
    			}else{
    				System.out.println("false-"+i+" : "+j);
    			}
    		}
    	}
    	
    	return sum;
    }
    
    static int hourGlassSumSingle(int[][] arr){
    	int sum =0;
    	for(int i=0;i<arr.length;i++){
    		for(int j=0; j<arr[i].length; j++){
    			if(i==1 && (j==0 || j==2)){
    				
    			}else{
    				sum = sum + arr[i][j];
    			}
    		}
    	}
    	return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }*/
    	//int[][] arr = {{-9,-9,-9, 1,1,1},{0,-9, 0, 4,3,2},{-9,-9,-9, 1,2,3},{0, 0, 8, 6,6,0},{0, 0, 0,-2,0,0},{ 0, 0, 1, 2,4,0}}; //{{1,1,1,0,0,0},{0,1,0,0,0,0},{1,1,1,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0},{0,0,0,0,0,0}};
    	int[][] arr = {{-1,-1,0,-9,-2,-2},{-2,-1,-6,-8,-2,-5},{-1,-1,-1,-2,-3,-4},{-1,-9,-2,-4,-4,-5},{-7,-3,-3,-2,-9,-9},{-1,-3,-1,-2,-4,-5}};
        int result = hourglassSum(arr);
        System.out.println("result:"+result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}
