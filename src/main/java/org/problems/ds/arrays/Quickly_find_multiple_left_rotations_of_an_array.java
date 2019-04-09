package org.problems.ds.arrays;

/*
 @Author : Jayavardhan Patil
 @Date : 06/04/19
 @Time : 5:22 PM
*/


public class Quickly_find_multiple_left_rotations_of_an_array {

	public static void main(String[] args) {

		int[] a = {8, 9 ,10, 12, 6, 7};
		int rotate = 3;

		leftRotate(a, a.length, rotate);

	}

	public static void leftRotate(int[] a, int n, int k){

		for(int i=k;i< k+n;i++){
			System.out.print(a[i % n] + " ");
		}

	}

}
