package aoc2022;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class Day03 {
	private static final AtomicInteger accumulator = new AtomicInteger();
	private static final AtomicInteger count = new AtomicInteger();
	private static final char firstLetterMinus = 'a';
	private static final char firstLetterMays = 'A';
	private static final int totalLetters = 26;
	private static String firstBag = "";
	private static String secondBag = "";
	private static String thirdBag = "";

	public static int part1(List<String> input) {
		initValues();
		input.forEach(
			s -> {
				char[] firstBag = s.substring(0, s.length() / 2).toCharArray();
				String secondBag = s.substring(s.length() / 2);
				int maxPriority = 0;
				for (char s1 : firstBag) {
					if (secondBag.indexOf(s1) != -1) {
						int priority = giveScore(s1);
						if (maxPriority < priority) {
							maxPriority = priority;
						}
					}
				}
				accumulator.addAndGet(maxPriority);
			}
		);
		return accumulator.get();
	}

	public static int part2(List<String> input) {
		initValues();

		input.forEach(
			s -> {
				count.addAndGet(1);
				if (count.get() % 3 == 1) {
					firstBag = s;
				}
				if (count.get() % 3 == 2) {
					secondBag = s;
				}
				if (count.get() % 3 == 0) {
					thirdBag = s;
					char[] list = firstBag.toCharArray();
					for (char c : list) {
						if (secondBag.indexOf(c) != -1 && thirdBag.indexOf(c) != -1) {
							accumulator.addAndGet(giveScore(c));
							break;
						}
					}
				}
			}
		);
		return accumulator.get();
	}

	private static void initValues() {
		accumulator.set(0);
		count.set(0);
	}

	public static int giveScore(char letter) {
		if (!Character.isUpperCase(letter)) {
			return letter - firstLetterMinus + 1;
		}
		return letter - firstLetterMays + 1 + totalLetters;
	}
}
