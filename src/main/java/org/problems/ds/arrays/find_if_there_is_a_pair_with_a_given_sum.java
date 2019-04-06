package org.problems.ds.arrays;

/*
 @Author : Jayavardhan Patil
 @Date : 06/04/19
 @Time : 2:44 PM
*/


import static java.lang.System.exit;

public class find_if_there_is_a_pair_with_a_given_sum {

	public static void main(String[] args) {

		int[] a = {10,12,14,15,19,2,6,7,8};
		int sum = 20;

		int pivotr = findPivote(a, 0, a.length-1 );
		findsumPair(a, pivotr, pivotr+1, sum);

	}


	public static void findsumPair(int[] a, int left, int right, int sum){

		if((a[left] + a[right]) == sum){
			System.out.println("("+ a[left] + " + " +a[right]+") = "+ sum);
			if(left == 0 || right == a.length-1) {
				exit(0);
			}
			findsumPair(a, left-1, right+1, sum);
		}
		if((a[left] + a[right]) < sum){
			findsumPair(a, left, right+1, sum);
		}else{
			findsumPair(a, left-1, right, sum);
		}

	}

	public static int findPivote(int[] a, int low, int high){

		if(low > high){
			return -1;
		}

		if(low == high){
			return low;
		}

		int mid = (low+high) / 2;

		if(mid < high && a[mid] > a[mid+1]){
			return mid;
		}
		if(mid > low && a[mid] < a[mid-1]){
			return mid-1;
		}

		if(a[low] >= a[mid]){
			return findPivote(a, 0 ,mid-1);
		}
		return findPivote(a, mid+1, high);



	}

}

