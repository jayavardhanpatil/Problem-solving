package org.problems.ds.arrays;

/*
 @Author : Jayavardhan Patil
 @Date : 07/04/19
 @Time : 12:10 AM
*/


import java.util.Arrays;

public class Rearrange_an_array {

	public static void main(String[] args) {

		int[] a = {0,6,-1,4,3,2,-1,5};
		System.out.println(Arrays.toString(rearrance(a)));
	}


	public static int[] rearrance(int[] a){

		for(int i=0;i<a.length;i++){

			if(a[i] != -1 && a[i] != i){

				int x = a[i];

				while (a[x] != -1 && a[x] !=x){

					int y = a[x];
					a[x] = x;
					x=y;
				}

				a[x] = x;

				if(a[i] != i){
					a[i] = -1;
				}

			}
		}
		return a;

	}

}
