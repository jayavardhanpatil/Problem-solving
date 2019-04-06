package org.problems.ds.arrays;

/*
 @Author : Jayavardhan Patil
 @Date : 06/04/19
 @Time : 2:07 PM
*/

//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
public class Search_an_element_in_a_sorted_and_rotated_array {

	/*Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8*/

	public static void main(String[] args) {

		int[] a = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int key = 3;

		System.out.println(pivotedBinarySearch(a, key));

		//System.out.println(binarySearch(a, key, 0, a.length-1));

	}

	public static int binarySearch(int[] a, int key, int startindex, int endIndex){

		if(endIndex < startindex){
			return -1;
		}

		int mid = (startindex + endIndex) / 2;
		if(key == a[mid])
			return mid;

		if(key > a[mid]){
			return binarySearch(a, key, mid+1, endIndex);
		}else{
			return binarySearch(a, key, startindex, mid-1);
		}

	}

	public static int findPivot(int[] a, int start, int end){

		if(start > end){
			return -1;
		}
		if(start == end){
			return start;
		}

		int mid = (start + end) / 2;
		if(mid < end && a[mid] > a[mid+1]){
			return mid;
		}
		if(mid > start && a[mid] < a[mid-1]){
			return mid-1;
		}
		if(a[start] >= a[mid]){
			return findPivot(a, start, mid-1);
		}else {
			return findPivot(a, mid+1, end);
		}

	}

	static int pivotedBinarySearch(int[] a, int key){

		int pivote = findPivot(a, 0, a.length-1);

		if(pivote == -1){
			binarySearch(a, key, 0, a.length-1);
		}

		if(a[pivote] == key){
			return pivote;
		}

		if(a[0] <= key){
			return binarySearch(a, key, 0,pivote-1 );
		}else {
			return binarySearch(a, key, pivote+1,a.length-1);
		}
	}

}
