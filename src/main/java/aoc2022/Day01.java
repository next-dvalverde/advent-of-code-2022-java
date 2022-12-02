package aoc2022;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class Day01 {
	private static final String separator = "";
	private static final AtomicInteger count = new AtomicInteger();
	private static final AtomicInteger accumulator = new AtomicInteger();
	private static final AtomicInteger biggestOne = new AtomicInteger();
	private static final AtomicInteger biggestTwo = new AtomicInteger();
	private static final AtomicInteger biggestThree = new AtomicInteger();

	public static int part1(List<String> input) {
		initValues();
		input.forEach(
			s -> {
				count.addAndGet(1);
				if (!separator.equals(s)) {
					int val = Integer.parseInt(s);
					accumulator.addAndGet(val);
				}

				if (separator.equals(s) || count.get() == input.size()) {
					if (accumulator.get() > biggestOne.get()) {
						biggestOne.set(accumulator.get());
					}
					accumulator.set(0);
				}
			}
		);
		return biggestOne.get();
	}

	public static int part2(List<String> input) {
		initValues();
		input.forEach(
			s -> {
				count.addAndGet(1);
				if (!separator.equals(s)) {
					int val = Integer.parseInt(s);
					accumulator.addAndGet(val);
				}

				if (separator.equals(s) || count.get() == input.size()) {
					if (accumulator.get() > biggestOne.get()) {
						distributeBiggest(biggestOne);
						biggestOne.set(accumulator.get());
					} else {
						distributeBiggest(accumulator);
					}
					accumulator.set(0);
				}
			}
		);
		return biggestOne.addAndGet(biggestTwo.addAndGet(biggestThree.get()));
	}

	private static void initValues() {
		count.set(0);
		accumulator.set(0);
		biggestOne.set(0);
		biggestTwo.set(0);
		biggestThree.set(0);
	}

	private static void distributeBiggest(AtomicInteger biggest) {
		if (biggest.get() > Day01.biggestTwo.get()) {
			if (Day01.biggestTwo.get() > Day01.biggestThree.get()) {
				Day01.biggestThree.set(Day01.biggestTwo.get());
			}
			Day01.biggestTwo.set(biggest.get());
		} else if (biggest.get() > Day01.biggestThree.get()) {
			Day01.biggestThree.set(biggest.get());
		}
	}
}
