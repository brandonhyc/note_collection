//package codingPad;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class SolutionstrStr {
//
//	public int strstr(String large, String small) {
//		return strstr_navie(large, small);
//	}
//
//	public int strstr_navie(String large, String small) {
//		for (int i = 0; i < large.length() - small.length() + 1; i++) {
//			if (equal(large, i, small)) {
//				return i;
//			}
//		}
//		return -1;
//	}
//
//	private boolean equal(String large, int index, String small) {
//		// check if the substring of large (starts from specific index) equal to small
//
//		for (int i = 0; i < small.length(); i++) {
//			if (large.charAt(i + index) != small.charAt(i)) {
//				return false;
//			}
//		}
//
//		return true;
//	}
//
//	public int strstr_kp(String large, String small) {
//		if (small == null || small.length() == 0) {
//			return 0;
//		}
//		int n = small.length();
//		int codeSmall = getHash(small);
//		int codeLarge = 0;
//		char[] array = large.toCharArray();
//
//		// [0, i - 1] are processed. i is being processed. [i - n + 1, i] can be the
//		// substring
//		for (int i = 0; i < large.length(); i++) {
//			if (i - n >= 0) {
//				codeLarge = pollChar(codeLarge, array[i - n], n);
//			}
//
//			codeLarge = appendChar(codeLarge, array[i]);
//
//			if (i >= n - 1) {
//				if (codeSmall == codeLarge && small.equals(large.substring(i - n + 1, i - n + 1 + small.length()))) {
//					return i - n + 1;
//				}
//			}
//		}
//
//		return -1;
//	}
//
//	private int pollChar(int codeLarge, char ch, int len) { // word length
//		return (int) (codeLarge - (ch - 'a')  Math.pow(26, len - 1));
//	}
//
//	private int appendChar(int codeLarge, char ch) { // word length
//		codeLarge = 26;
//		codeLarge += ch - 'a';
//		return codeLarge;
//	}
//
//	public int getHash(String str) {
//		int res = 0;
//		for (int i = 0; i < str.length(); i++) {
//			res = 26;
//			res += str.charAt(i) - 'a';
//		}
//
//		Map<String> hashMap = new HashMap<>();
//		String str1 = "";
//		str1.hashCode();
//		return res;
//	}
//
//	static void runTest() {
//		SolutionstrStr sol = new SolutionstrStr();
////		System.out.println(sol.strstr("abc", "b"));
//		System.out.println(sol.strstr("abc", "bc"));
//		System.out.println(sol.strstr("bcabc", "ab"));
//		System.out.println(sol.strstr("bcabc", "bcd"));
//		System.out.println(sol.strstr("abc", ""));
//		System.out.println(sol.strstr("abbaabbab", "bbab"));
//		System.out.println(sol.strstr("aabbaabbaabbccaabbaabbaabbaabbcc", "aabbaabbaabbaabbcc"));
//	}
//}
