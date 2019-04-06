package org.problems.ds.arrays;

/*
 @Author : Jayavardhan Patil
 @Date : 06/04/19
 @Time : 3:29 PM
*/


public class Find_maximum_value_of_Sum_with_only_rotations_on_given_array_allowed {

	public static void main(String[] args) {

		int[] a = {1, 20, 2, 10};

		System.out.println(rotateAndfindMaxSum(a));
	}

	public static int rotateAndfindMaxSum(int[] a){
		int arraySum = 0;
		int currentSum = 0;

		for(int i=0;i<a.length;i++){
			arraySum = arraySum+a[i];
			currentSum = currentSum + (i* a[i]);
		}

		int maxVal = currentSum;

		for(int j=1;j<a.length;j++){

			currentSum = currentSum + arraySum - a.length*a[a.length-j];
			if(currentSum > maxVal){
				maxVal = currentSum;
			}
		}
		return maxVal;

	}

}
