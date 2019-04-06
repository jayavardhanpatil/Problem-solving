package org.problems.ds.arrays;

/*
 @Author : Jayavardhan Patil
 @Date : 07/03/19
 @Time : 7:41 AM
*/


import java.util.Date;

public class Array_Rotation {

	public static void main(String[] args) {
		int[] a = new int[100];
		for(int i=0;i<100;i++){
			a[i] = i;
		}

		System.out.println("start time : "+new Date().getTime());
		long startTime = new Date().getTime();
		leftRotate(a, 80);
		System.out.println("endTime : "+new Date().getTime());
		long endTime = new Date().getTime();
		//printArray(a);
		System.out.println("Time taken : "+(endTime - startTime));

		//
		System.out.println("start time : "+new Date().getTime());
		startTime = new Date().getTime();
		rotate_Left_Array(a, 20);
		//test(a, 30);
		System.out.println("endTime : "+new Date().getTime());
		endTime = new Date().getTime();
		//printArray(a);
		System.out.println("Time taken : "+(endTime - startTime));


		//Reverse the array
/*
	* Let the array be arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7
	A = [1, 2] and B = [3, 4, 5, 6, 7]

	Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
	Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
	Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]
	* */
		startTime = new Date().getTime();
		reverseArray(a, 0, 50);
		reverseArray(a, 51, a.length-1);
		reverseArray(a, 0 , a.length-1);
		endTime = new Date().getTime();
		printArray(a);
		System.out.println("Time taken : "+(endTime - startTime));
	}


	//Normal method with
	/*Time complexity : O(n * d)
	Auxiliary Space : O(1)*/
	private static void leftRotate(int[] arr, int noOfPositions){

		for(int i=0;i<noOfPositions;i++){
			rotate_one_element_left(arr);
		}
	}

	private static void rotate_one_element_left(int[] arr){
		int arraySize = arr.length;
		int temp = arr[0];
		for(int i=0;i<arraySize-1;i++){
			arr[i] = arr[i+1];
		}
		arr[arraySize-1] = temp;
	}

	/*
	A Juggling Algorithm

	Let arr[] be {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
	a) Elements are first moved in first set –

	ArrayRotation
			  arr[] after this step --> {4 2 3 7 5 6 10 8 9 1 11 12}
	b)    Then in second set.
			  arr[] after this step --> {4 5 3 7 8 6 10 11 9 1 2 12}
	c)    Finally in third set.
          arr[] after this step --> {4 5 6 7 8 9 10 11 12 1 2 3}*/

	private static void rotate_Left_Array(int[] arr, int noOfPositions){

		//i = first element to point
		int i, j, k, temp;
		//GCD will return how many sets to be made in the array.
		for(i=0;i<gcd(noOfPositions, arr.length);i++){
			//store first element in the temp array
			temp = arr[i];
			//assign the same position to the j variable
			j = i;

			//loop untill you moved all the positions in all sets
			while (true){
				k = j + noOfPositions;
				if(k >= arr.length){
					k = k - arr.length;
				}
				if(k == i){
					break;
				}
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}

	}

	//to identify the GCD for array length and the no of positions to be shifted to make sets.
	private static int gcd(int a, int b){
		if(b==0){
			return a;
		}else
			return gcd(b, a%b);
	}

	private static void printArray(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

	private static void test(int[]a, int no_of_position){


		for(int i=0;i<gcd(no_of_position, a.length);i++){
			int j = i;
			int temp = a[i];

			while (true){
				int k = j + no_of_position;
				if(k >= a.length){
					k = k-a.length;
				}
				if(k==i){
					break;
				}
				a[j]=a[k];
				j = k;
			}

			a[j] = temp;
		}

	}

	private static void reverseArray(int[] a, int start, int end){
		int temp;
		while (start < end){
			temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}
}
