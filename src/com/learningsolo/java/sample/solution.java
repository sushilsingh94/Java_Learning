package com.learningsolo.java.sample;

import java.util.*;

/*Scheduling Classes
Scheduling Classes
Andy studies at the University of California is very studious. He wants to take as many subjects as possible without any class overlap. 
The University doesn’t impose any restriction of the number of classes taken during the semester.

He really doesn’t care about what subject he takes; he likes them all! However, he wants to maximize the number of subjects he can take.

Input Format

The first line of input consists of an integer t. This is the number of days. 
For each day, the first line contains an integer n which gives the number of subjects offered on that day. 
Then next n lines follow containing the subject name (which is a string) followed by start and end time for that subject in 24 hour format: hh:mm

Maths 10:00 11:00

Note: The timings are given in 24-hour format and the subject names do not have spaces between them.

Output Format

The output should contain t lines and each line has a number representing the maximum number of classes Andy can chose.

Constraints

1 <= t <= 5000
2 <= n <= 100
start time of a class < end time of class

Sample Input
2
4
Maths 16:00 18:00
ComputerScience 12:00 13:00
Physics 12:30 14:00
Chemistry 14:00 16:30
5
Geography 14:00 16:00
History 12:00 14:30
Arts 14:00 16:30
Literature 12:30 13:30
German 13:30 15:00

Sample Output

2
2
*/
class solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int n = 0; n < t; n++) {
			List<String> list = new ArrayList<>(); 
			int subject = sc.nextInt();
			sc.nextLine();
			for (int i = 0; i < subject; i++) {
				String line = sc.nextLine();
				String[] subArr = line.split(" ");
				list.add(subArr[1]+" "+subArr[2]);
			}
			Collections.sort(list);
			System.out.println(list);
			getMaxCount(list);
		}
	}
	
	static void getMaxCount(List<String> list){
		int s = list.size();
		System.out.println(countRec(list, s, 0, 0));
	}
	
	static int countRec(List<String> list, int size, int k, int sum){
		int tempsum = 0;
		if(k==size-1){
			return sum;
		}
		String prev="";
		for(int i=k;i<size;i++){
			String[] temp = list.get(i).split(" ");
			if(temp[0].compareTo(prev)>=0){
				prev = temp[1];
				tempsum++;
				if(tempsum>sum){
					sum = tempsum;
				}
			}
		}
		return countRec(list, size, k+1, sum);
	}
}
