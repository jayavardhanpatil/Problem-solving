package org.problems.ds.arrays;

/*
 @Author : Jayavardhan Patil
 @Date : 06/04/19
 @Time : 1:52 PM
*/


import java.util.Arrays;

public class Reversal_algorithm_for_array_rotation {

	public static void main(String[] args) {

		int[] a = {1,2,3,4,5,6,7}; //op = 3,4,5,6,7,1,2;
		int d = 2;

		//reverse the arrays

		reverseArray(a, 0, d);
		reverseArray(a, d+1, a.length-1);
		reverseArray(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));

	}

	public static void reverseArray(int[] a, int start, int end){

		int temp;
		while (start<end){
			temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}

}
