package aoc2022;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class Day06 {

	public static int part1(List<String> input) {
		AtomicInteger result = new AtomicInteger();
		input.forEach(s -> result.set(giveResult(s, 4)));
		return result.get();
	}

	public static int part2(List<String> input) {
		AtomicInteger result = new AtomicInteger();
		input.forEach(s -> result.set(giveResult(s, 14)));
		return result.get();
	}

	private static int giveResult(String s, int lengthMessage) {
		for (int i = 0; i < s.length() - (lengthMessage - 1); i++) {
			String substring = s.substring(i, i + lengthMessage);
			String[] arrayStrings = substring.split("");
			Set<String> uniqueValues = new HashSet<>(List.of(arrayStrings));
			if (uniqueValues.size() == lengthMessage) {
				return i + lengthMessage;
			}
		}
		return 0;
	}
}
