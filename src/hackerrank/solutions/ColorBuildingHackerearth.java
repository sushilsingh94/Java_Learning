package hackerrank.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ColorBuildingHackerearth {
	
	
	static int count =0;
	public static void main(String[] args) throws NumberFormatException, IOException 
	{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  
        
        while(n>0){
        	String[] row = br.readLine().split(" ");
        	int building = Integer.parseInt(row[0]);
        	int colors = Integer.parseInt(row[1]);
        	char[] arr = new char[colors];
        	for(int i=0;i<colors;i++){
        		arr[i]=(char)i;
        	}
        	count=0;
        	printAllKLength(arr, building);
        	n--;
        }
        /*
	    System.out.println("First Test"); 
	    char[] set1 = {'a', 'b', 'c', 'd','e','f'}; 
	    int k = 4; 
	    printAllKLength(set1, k); 
	      */
	    /*System.out.println("\nSecond Test"); 
	    char[] set2 =  {'a', 'b', 'c', 'd','e','f'}; 
	    int k1 = 40; 
	    printAllKLength(set2, k1); */
	}
	
	


	static void printAllKLength(char[] set, int k) 
	{
	    int n = set.length;  
	    printAllKLengthRec(set, "", n, k); 
	    System.out.println("count:"+count);
	} 

	static void printAllKLengthRec(char[] set, String prefix, int n, int k) 
	{
	    if (k == 0)  
	    {
	    	int j;
	        for(j=1;j<prefix.length();j++)
	        {
	        	if(prefix.charAt(j) == prefix.charAt(j-1))
	        	{
	        		return;
	        	}
	        }
	        count++;
	        //System.out.println(prefix); 
	        return; 
	    } 

	    for (int i = 0; i < n; ++i) 
	    { 
	        String newPrefix = prefix + set[i];  
	        printAllKLengthRec(set, newPrefix,  
	                                n, k - 1);  
	    } 
	} 


}
