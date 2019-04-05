package org.problems.greedyalgo;

/*
 @Author : Jayavardhan Patil
 @Date : 03/04/19
 @Time : 10:52 PM
*/

//https://www.geeksforgeeks.org/fractional-knapsack-problem/
//Problem
/*Given weights and values of n items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.

In the 0-1 Knapsack problem, we are not allowed to break items. We either take the whole item or don’t take it.*/

/*Input:
  Items as (value, weight) pairs
  arr[] = {{60, 10}, {100, 20}, {120, 30}}
  Knapsack Capacity, W = 50;
Output:
  Maximum possible value = 220
  by taking items of weight 20 and 30 kg
*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Fractional_Knapsack_Problem {

	public static void main(String[] args) {

		int[] wt = {40, 20, 30};
		int[] val = {40, 100, 120};
		int capacity = 50;

		double max_value = getMaxValue(wt, val, capacity);
		System.out.println(max_value);
	}

	private static double getMaxValue(int[] wt, int[] val, int capacity) {
		ArrayList<ItemValue> itemValueList = new ArrayList<ItemValue>();

		for(int i = 0; i < wt.length; i++){
			ItemValue itemValue = new ItemValue(wt[i], val[i], i);
			itemValueList.add(itemValue);
		}

		itemValueList.sort(new Comparator<ItemValue>() {
			public int compare(ItemValue o1, ItemValue o2) {
				return o2.cost.compareTo(o1.cost);
			}
		});

		double totalValue = 0d;

		for(ItemValue i:itemValueList){

			int current_wt = i.wt;
			int current_val = i.val;

			if(capacity - current_wt >= 0){
				capacity = capacity - current_wt;
				totalValue += current_val;
			}else {
				double fraction = ((double) capacity / (double) current_wt);
				totalValue += (current_val * fraction);
				capacity = (int) (capacity - (current_wt * fraction));
				break;
			}

		}
		return totalValue;
	}

	static class ItemValue {

		Double cost;
		int wt, val ,index;
		 ItemValue(){};
		 ItemValue(int wt, int val, int index){
		 	this.wt = wt;
		 	this.val = val;
		 	this.index = index;
			cost = new Double(val/wt);
		 }

	}

}
