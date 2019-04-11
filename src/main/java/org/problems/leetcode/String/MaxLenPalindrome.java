package org.problems.leetcode.String;

/*
 @Author : Jayavardhan Patil
 @Date : 12/04/19
 @Time : 12:17 AM
*/


public class MaxLenPalindrome {



	public static void main(String[] args) {
		String s = "abcdcbaoijcoiwjcoiww";


		int start = 0, end = 0;
		for(int i =0;i<s.length();i++){

			int len1 = expandAroundCenters(s, i, i);
			int len2 = expandAroundCenters(s, i, i+1);
			int len = Math.max(len1, len2);

			if(len > end - start){
				start = i -(len - 1) / 2;
				end = i + len / 2;
			}
		}
		System.out.println(s.substring(start, end+1));
	}


	public static int expandAroundCenters(String s, int left, int right){

		int l = left, r = right;
		while (l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
			l--;
			r++;
		}
		return r-l-1;
	}

}
