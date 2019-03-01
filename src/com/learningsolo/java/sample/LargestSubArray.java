package com.learningsolo.java.sample;
/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
/**
 * Largest sub array 
 * @author kumars28
 *
 */
public class LargestSubArray {
	public static void main(String args[] ) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());                // Reading input from STDIN
		String val = br.readLine();

		int len = findLongestSub(val,n);

		System.out.println(len);

	}

	static int findLongestSub(String val, int n){
		Map<Integer, Integer> map = new HashMap<>();

		int maxLen = 0;
		int curLen;
		int sum =0;

		for (int i = 0; i < n; i++) {

			if(val.charAt(i) == '0'){
				sum++;
			}else{
				sum--;
			}

			if(sum>0){
				maxLen = i +1;
			}else if(sum <=0){
				if(map.get(sum-1) != map.get(n-1)){
					curLen = i -map.get(sum -1);
					maxLen = maxLen>curLen?maxLen:curLen;
				}
			}
			if(map.get(sum) == map.get(n-1)){
				map.put(sum, i);

			}
		}

		return maxLen;
	}
}
