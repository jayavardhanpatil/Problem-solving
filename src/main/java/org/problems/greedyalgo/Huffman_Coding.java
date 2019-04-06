package org.problems.greedyalgo;

/*
 @Author : Jayavardhan Patil
 @Date : 05/04/19
 @Time : 9:54 PM
*/

//https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman_Coding {
	static StringBuilder encoded = new StringBuilder();
	static HashMap<Character, String> charCodes = new HashMap<>();

	public static void main(String[] args) {

		String str = "oshg gfhweiuf jayavardhan".replace(" ","");

		char[] charArray = str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c: charArray){
			map.merge(c, 1, Integer :: sum);
		}

		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(map.size(), new Compare());

		for(Map.Entry<Character, Integer> d : map.entrySet()){
			HuffmanNode node = new HuffmanNode();
			node.c = d.getKey();
			node.data = d.getValue();

			node.left = null;
			node.right = null;

			q.add(node);
		}

		HuffmanNode root = null;

		while (q.size() > 1){

			HuffmanNode x = q.peek();
			q.poll();

			HuffmanNode y = q.peek();
			q.poll();

			HuffmanNode f = new HuffmanNode();

			f.data = x.data + y.data;
			f.c = '-';

			f.left = x;
			f.right = y;

			root = f;

			q.add(f);

		}
		printCode(root, " ");

		for (char c : charArray) {
			encoded.append(charCodes.get(c));
		}

		decode(q.peek(), encoded.toString().replace(" ",""));

	}

	public static void printCode(HuffmanNode root, String s){
		if(root.left == null && root.right == null && Character.isLetter(root.c)){
			System.out.println(root.c +" : "+ s);
			charCodes.put(root.c, s);
			return;
		}
		printCode(root.left, s + "0");
		printCode(root.right, s + "1");
	}


	public static class HuffmanNode{
		int data;
		char c;

		HuffmanNode left;
		HuffmanNode right;

	}

	public static class Compare implements Comparator<HuffmanNode> {
		@Override
		public int compare(HuffmanNode o1, HuffmanNode o2) {
			return o1.data - o2.data;
		}
	}

	public static void decode(HuffmanNode node, String encodedString){

		HuffmanNode curr = node;
		char[] c = encodedString.toCharArray();
		StringBuilder decodedString = new StringBuilder();
		for(int j=0;j<c.length; j++){
			if(c[j] == '0'){
				curr = curr.left;
			}else{
				curr = curr.right;
			}

			if(curr.left == null && curr.right == null){
				decodedString.append(curr.c);
				curr = node;
			}
		}
		System.out.println(decodedString.toString());

	}
}
