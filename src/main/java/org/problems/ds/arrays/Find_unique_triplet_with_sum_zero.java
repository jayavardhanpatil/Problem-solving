package org.problems.ds.arrays;

/*
 @Author : Jayavardhan Patil
 @Date : 11/04/19
 @Time : 10:24 PM
*/


import java.util.*;

public class Find_unique_triplet_with_sum_zero {

	public static void main(String[] args) {

		int[] a = {1, -1, -1 ,0};
		findNumbers(a);
	}

	public static List<List<Integer>> findNumbers(int[] nums){

		List<List<Integer>> res = new ArrayList<>();

		Arrays.sort(nums);
		for(int i =0;i<nums.length-2;i++){

			if(i > 0 && (nums[i] == nums[i-1])){
				continue;
			}

			int j=i+1;
			int k = nums.length-1;

			while (j < k){

				if(nums[i] + nums[j] + nums[k] == 0){
					res.add(Arrays.asList(nums[i],nums[j],nums[k]));
				}
				//k--;
				j++;
			}
		}
		return res;
	}

}
