package cccquestions;

import java.io.*;
import java.util.*;

public class S42018 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static HashMap<Integer, Long> weights = new HashMap<Integer, Long>();

	public static void main(String[] args) throws IOException {
		
		long weight = Long.parseLong(br.readLine());
		weights.put(1, (long) 1);
		weights.put(2, (long) 1);
		System.out.println(function(weight));
	}
	public static long function(long x) {
		if (weights.containsKey((int) x)) {
			return weights.get((int) x);
		}
		long numOfSubtrees = 0;
		for (int i = 2; i <= x;) {
			int maxNext = (int) x/((int) x/i)+1;
			numOfSubtrees += (maxNext-i) * function((int) x/i);
			i = maxNext;
		}
		weights.put((int) x, numOfSubtrees);
		return numOfSubtrees;
	}
}
