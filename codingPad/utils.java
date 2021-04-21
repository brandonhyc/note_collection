package codingPad;

import java.util.Arrays;

public class utils {

	public static String print(int[][] m) {
		StringBuilder sb = new StringBuilder();
		for (int[] row : m) {
			sb.append(Arrays.toString(row));
			sb.append("\n");
		}
		return sb.toString();
	}

	static String reverseString(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	static String toHexString(long num, int bits) {
		StringBuilder sb = new StringBuilder();
		char[] arr = "0123456789ABCDEF".toCharArray();
		boolean isLeading = true;
		sb.append("0x");
		for (int i = bits - 4; i >= 0; i -= 4) {
			char ch = arr[(int) ((num >> i) & 0xF)];
			if (ch == '0' && isLeading) {
				continue;
			}
			isLeading = false;
			sb.append(ch);
		}

		return sb.toString();
	}

	static String toBinaryStringView(long num) {
		return toBinaryStringView(num, 64);
	}

	static String toBinaryStringView(long num, int bits) {
		StringBuilder numSb = new StringBuilder();
		StringBuilder indexSb = new StringBuilder();

		for (int i = bits - 1; i >= 0; i--) {

			numSb.append((num >> i) & 1);
			numSb.append(" ");

			indexSb.append(i % 10);
			indexSb.append(i % 10 == 0 || i % 4 == 0 ? "|" : " ");
		}

		return indexSb.append("\n\n").append(numSb).toString();
	}

	static String toBinaryStringView(int num) {
		return toBinaryStringView(num, 32);
	}

	static String toBinaryString(int num) {
		return toBinaryString(Long.valueOf(num), 32);

	}

	static String toBinaryString(long num) {
		return toBinaryString(Long.valueOf(num), 64);
	}

	static String toBinaryString(Long num, int... len) {
		int i = 31;
		if (len.length != 0) {
			i = len[0] - 1;
		}
		StringBuilder sb = new StringBuilder();
		while (i >= 0) {
			sb.append((num >> i) & 1);
			i--;
		}

		return sb.toString();

	}


	public static class Test {
		static public int[][] generateMatrix() {
			return new int[][] { 
				{ 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 0 }, 
				{ 0, 0, 0, 1, 1 } };
		}

//		int[][] m = new int[][] { 
//				{ 1, 0, 0, 0, 1 }, 
//				{ 0, 1, 0, 1, 0 }, 
//				{ 0, 0, 1, 0, 0 },
//				{ 0, 1, 0, 1, 0 },
//				{ 1, 0, 0, 0, 1 } };
//		}

//		int[][] m = 

//		int[][] m = new int[][] { 
//			{ 1, 2, 3, 4 }, 
//			{ 5, 6, 7, 8 }, 
//			{ 9, 10, 11, 12 }, 
//			{ 13, 14, 15, 16 } };
//		int[][] {
//			{3,1,1,3,0,1,1,0},
//			{2,0,0,2,0,0,0,0},
//			{3,1,3,0,0,0,0,0},
//			{2,0,2,0,0,0,0,0},
//			{1,1,0,0,0,0,0,0}}

//		System.out.println(sol.largest(new int[][]
//		//    0	 1  2  3  4  5  6  7  8
//		{ 	{ 1, 0, 0, 0, 0, 0, 0, 0, 1 },        // 0
//			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 		  // 1
//			{ 0, 0, 1, 0, 0, 0, 1, 0, 0 },        // 2
//			{ 0, 0, 0, 1, 0, 1, 0, 0, 0 },        // 3
//			{ 0, 0, 0, 0, 1, 0, 0, 0, 0 },        // 4
//			{ 0, 0, 0, 1, 0, 1, 0, 0, 0 },        // 5
//			{ 0, 0, 1, 0, 0, 0, 1, 0, 0 },        // 6
//			{ 0, 1, 0, 0, 0, 0, 0, 1, 0 },        // 7
//			{ 1, 0, 0, 0, 0, 0, 0, 0, 1 } }));    // 8
	}

}
