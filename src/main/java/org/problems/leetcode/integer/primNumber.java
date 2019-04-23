package org.problems.leetcode.integer;

/*
 @Author : Jayavardhan Patil
 @Date : 12/04/19
 @Time : 11:51 PM
*/


public class primNumber {
	public static void main(String[] args) {

		int num = 12321;
		int reverse = 0;
		int temp = num;
		while (num != 0) {
			int digit = num % 10;
			num = num / 10;
			reverse = reverse * 10 + digit;
		}

		if(reverse == temp){
			System.out.println(true);
		}
		else {
			System.out.println(false);
		}
	}


}
