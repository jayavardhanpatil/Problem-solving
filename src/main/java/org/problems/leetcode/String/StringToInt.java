package org.problems.leetcode.String;

/*
 @Author : Jayavardhan Patil
 @Date : 12/04/19
 @Time : 11:16 PM
*/


import java.util.regex.Pattern;

public class StringToInt {

	public static void main(String[] args) {


		String str = "      -423";

		int index = 0, sign = 1, total = 0;
		//1. Empty string
		if(str.length() == 0) System.out.println(0);

		//2. Remove Spaces
		//  str = str.trim();
		while(str.charAt(index) == ' ' && index < str.length()-1)
			index ++;


		//3. Handle signs
		if(str.charAt(index) == '+' || str.charAt(index) == '-'){
			sign = str.charAt(index) == '+' ? 1 : -1;
			index ++;
		}

		//4. Convert number and avoid overflow
		while(index < str.length()){
			int digit = str.charAt(index) - '0';
			if(digit < 0 || digit > 9) break;

			//check if total will be overflow after 10 times and add digit
			if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
				System.out.println(sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);

			total = 10 * total + digit;
			index ++;
		}
		System.out.println(total * sign);
	}
}
