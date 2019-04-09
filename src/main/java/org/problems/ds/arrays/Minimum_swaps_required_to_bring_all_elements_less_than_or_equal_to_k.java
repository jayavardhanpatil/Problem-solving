package org.problems.ds.arrays;

/*
 @Author : Jayavardhan Patil
 @Date : 09/04/19
 @Time : 9:23 PM
*/


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Random;

//https://www.geeksforgeeks.org/minimum-swaps-required-bring-elements-less-equal-k-together/
public class Minimum_swaps_required_to_bring_all_elements_less_than_or_equal_to_k {

	public static void main(String[] args) {

		/*int[] a = new int[100000000];
		Random random = new Random();
		for(int i=0;i<100000000;i++){
			a[i] = random.nextInt(100);
		}*/

		int[] a = {2, 7, 9, 5, 8, 7, 4, 3};
		int k = 5;
		int count = 0;

		/*LocalDateTime start = LocalDateTime.now();
		int swapcount = 0;
		for(int i=0;i<a.length;i++) {
			if (a[i] <= k) {
				count++;
				continue;
			}else {
				break;
			}
		}

		int l=count;
		while (l<a.length){
			if(a[l] <= k){
				swapcount++;
			}
			l++;
		}
		System.out.println(swapcount);
		LocalDateTime end = LocalDateTime.now();
		long difference = end.getNano() - start.getNano();
		System.out.println(difference);*/


		//Different method
		LocalDateTime start_ = LocalDateTime.now();
		for (int i = 0; i < a.length; ++i)
			if (a[i] <= k)
				++count;

		int bad = 0;
		for(int j=0;j<count;j++){
			if(a[j] > k){
				bad++;
			}
		}

		int ans = bad;
		for(int i=0, j=count; j<a.length ;i++, j++){
			if(a[i] > k){
				--bad;
			}
			if(a[j] > k){
				bad++;
			}
		}

		ans = Math.min(ans, bad);
		System.out.println(ans);
		System.out.println((LocalDateTime.now().getNano() - start_.getNano()));

	}


}
