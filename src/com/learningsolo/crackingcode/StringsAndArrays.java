package com.learningsolo.crackingcode;

import java.util.Arrays;
/**
 * Cracking coding interviews
 * @author kumars28
 *
 */
public class StringsAndArrays {
	
	public static void main(String[] args) {
		String s = "sushil";
		
		System.out.println(isStringUnique1(s));
		System.out.println(getURL("Mr John Smith   ", 13));
		System.out.println(checkIfPermutationOfStrings("dog", "god"));
		System.out.println(isOneEditAway("pale", "ple"));
		System.out.println(stringCompression("aabcccaaa"));
	}
	/**
	 * 1.1
	 * String contains all unique characters or not
	 * @param s
	 * @return
	 */
	static boolean isStringUnique(String s){
		char[] ch = s.toCharArray();
		for(int i=0;i<ch.length;i++){
			for(int j=i+1;j<ch.length;j++){
				if(ch[i]==ch[j]){
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * 1.1
	 * All Unique char length is max 128. char is converted to ASCII value and stored as true if present else default is
	 * false. If we encounter again same ASCII value in array then return false.
	 * @param s
	 * @return
	 */
	static boolean isStringUnique1(String s){
		if(s.length()>128) return false;
		boolean[] char_val = new boolean[128];
		
		for(int i=0;i<s.length();i++){
			int val = s.charAt(i);
			if(char_val[val]){
				return false;
			}
			char_val[val] = true;
		}
		return true;
	}
	/**
	 * 1.2
	 * checks if both the string params are permutation of each other or not
	 * @param s1
	 * @param s2
	 * @return
	 */
	static boolean checkIfPermutationOfString(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		
		return sort(s1).equals(s2);
	}
	
	static String sort(String s){
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		return arr.toString();
	}
	/**
	 * 1.2
	 * @param s1
	 * @param s2
	 * @return
	 */
	static boolean checkIfPermutationOfStrings(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}
		int[] arr = new int[128];
		char[] charArr = s1.toCharArray();
		for (char c : charArr) {
			arr[c]++;
		}
		
		for(int i=0;i<s2.length();i++){
			char c = s2.charAt(i);
			arr[c]--;
			if(arr[c]<0){
				return false;
			}
		}
		return true;
	}
	/**
	 * 1.3
	 * @param url
	 * @param len
	 * @return
	 */
	static String getURL(String url, int len){
		return url.trim().replaceAll(" ", "%20");
		
	}
	
	static boolean isOneEditAway(String first, String second){
		if(first.equals(second)) return true;
		
		String s1 = first.length() < second.length()?second:first;
		String s2 = first.length() < second.length()?first:second;
		
		if(s1.length() == s2.length()){
			return oneEditReplace(s1, s2);
		}else if(s1.length() +1 == s2.length()){
			return oneEditInsert(s1, s2);
		}else if(s1.length() -1 == s2.length()){
			return oneEditInsert(s1, s2);
		}
		return false;
	}
	private static boolean oneEditInsert(String s1, String s2) {
		int index1=0;
		int index2 =0;
		while(index1 < s1.length() && index2 < s2.length()){
			if(s1.charAt(index1) != s2.charAt(index2)){
				if(index1 != index2){
					return false;
				}
				index1++;
			}else{
				index1++;
				index2++;
			}
		}
		return true;
	}
	private static boolean oneEditReplace(String s1, String s2) {
		boolean foundDiff = false;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i) != s2.charAt(i)){
				if(foundDiff){
					return false;
				}
				foundDiff = true;
			}
		}
		return true;
	}
	/**
	 * 1.6
	 * @param s
	 * @return
	 */
	static String stringCompression(String s){
		System.out.println(s);
		int[] iarr = new int[s.length()];
		char[] carr = new char[s.length()];
		char a = 0;
		int index=0;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(c != a){
				if(i!=0)
					index++;
				carr[index] = c;
				a = c;
				iarr[index]++;
				
			}else{
				iarr[index]++;
			}
		}
		for(int i=0;i<s.length();i++){
			if(carr[i] != 0){
				sb.append((char)carr[i]).append(iarr[i]);
			}
		}
		return sb.length()<s.length()?sb.toString():s;
	}
}
