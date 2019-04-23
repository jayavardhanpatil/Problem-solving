package org.problems.leetcode.String;

/*
 @Author : Jayavardhan Patil
 @Date : 12/04/19
 @Time : 10:30 PM
*/


public class ZigZagConversion {

	public static void main(String[] args) {

		String s = "PAYPALISHIRING";
		int rowNum = 4;

		if (rowNum == 1) {
			System.out.println(s);
		} else {

			StringBuilder builder = new StringBuilder();
			int length = s.length();
			int itrRow = 0;
			int cycleLen = 2 * rowNum - 2;
			for (int i = 0; i < rowNum; i++) {

				for (int j = 0; j + i < length; j += cycleLen) {
					builder.append(s.charAt(j + i));

					if (i != 0 && i != rowNum - 1 && j + cycleLen - i < length)
						builder.append(s.charAt(j + cycleLen - i));
				}
			}
			System.out.println(builder.toString());
		}

	}
}
