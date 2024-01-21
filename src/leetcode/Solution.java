package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution{
	static String trythat;
	public static void main(String[] args) {
		List<Integer> lens = Arrays.asList(200,200,200,200,200,200,200,200,200,200,400);
		maxProfit(1000, 1, lens);
	}
	public static void change(StringBuilder sb) {
		sb.append("life");
	}

	public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
		Collections.sort(lengths);
		int maxProf = 0;
		int minLen = 1;
		while (minLen <= lengths.get(lengths.size() - 1)) {
			int pieces = 0;
			int cut = 0;
			for (int len : lengths) {
				if (len < minLen) {
					continue;
				}
				pieces += len / minLen;
				int unitWaste = len % minLen;
				cut += ((len / minLen) - (unitWaste > 0 ? 0 : 1));
			}
			System.out.println("minLen: " + minLen + "; pieces: " + pieces + "; + cut: " + cut);
			int prof = (salePrice * pieces * minLen) - (costPerCut * cut);
			System.out.println("prof: " + prof);
			maxProf = Math.max(maxProf, prof);
			System.out.println("maxProf: " + maxProf);
			minLen ++;
		}
		return maxProf;
	}
}
