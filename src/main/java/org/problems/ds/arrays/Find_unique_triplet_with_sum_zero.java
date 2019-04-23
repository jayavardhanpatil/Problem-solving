package org.problems.ds.arrays;

/*
 @Author : Jayavardhan Patil
 @Date : 11/04/19
 @Time : 10:24 PM
*/


import java.util.*;

public class Find_unique_triplet_with_sum_zero {

	public static void main(String[] args) {

		int[] a = {1, -1, -1 ,0, -2, 2};
		System.out.println(findNumbers(a));
	}

	public static List<List<Integer>> findNumbers(int[] nums){

		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i + 2 < nums.length; i++) {
			// if(i == 0 && nums[i] > 0){
			//     break;
			// }

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int j = i + 1, k = nums.length - 1;
			int target = -nums[i];
			while (j < k) {
				if (nums[j] + nums[k] == target) {
					res.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1]) j++;
					while (j < k && nums[k] == nums[k + 1]) k--;
				} else if (nums[j] + nums[k] > target) {
					k--;
				} else {
					j++;
				}
			}
		}
		return res;
	}

}
