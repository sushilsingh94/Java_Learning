
import java.util.*;
/**
 * Find tallest boy from list where 
 * Tallest is who can see largest count of boys behind him.
 * If two are having same count then one with biggest index will be tallest.
 * Return index of tallest boy, index starts from 1 
 * Input int arr[] = {5, 4, 3, 1, 2};
    	int arr[] = {5, 2, 1, 5, 4, 1, 2};
    	
    Output:
    	1
    	4
 * @author kumars28
 *
 */
class Solution {

    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            int a = sc.nextInt();
            int count=0;
            int[] arr = new int[a];
            while(count<=a-1){
            	int b = sc.nextInt();
            	arr[count++] = b;
            }
            showTallestBoy(arr, a);
        }
    	/*//int arr[] = {5, 4, 3, 1, 2};
    	int arr[] = {5, 2, 1, 5, 4, 1, 2};
    	showTallestBoy(arr, 7);*/
    }
    
    static void showTallestBoy(int[] arr, int n){
        int tall=0;
        int tall2 = 0;
        int count =0;
        int count2 =0;
        int tallest = 0;
    	for(int i=0;i<n;i++){
    		count++;
    		
        	if(arr[i] >= arr[tall2] && count>=count2){
        		count2=count;
        		count = 0;
        		tall2 = tall;
        		tall = i;
        	}
        	if(i==n-1){
        		if(count > count2){
            		tallest = tall;
            	}else if(count < count2){
            		tallest = tall2;
            	}else{
            		if(tall > tall2){
            			tallest = tall;
            		}else{
            			tallest = tall2;
            		}
            	}
        	}
        }
    	System.out.println(tallest+1);
    }
}
