package aoc2022;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class Day04 {
	private static final AtomicInteger accumulator = new AtomicInteger();

	public static int part1(List<String> input) {
		initValues();
		input
			.stream()
			.map(s -> s.split(","))
			.forEach(
				elfList -> {
					List<Integer> turnsFirstElf = Arrays
						.stream(elfList[0].split("-"))
						.map(Integer::parseInt)
						.toList();
					List<Integer> turnsSecondElf = Arrays
						.stream(elfList[1].split("-"))
						.map(Integer::parseInt)
						.toList();
					if (
						(
							turnsFirstElf.get(0) <= turnsSecondElf.get(0) &&
							turnsFirstElf.get(1) >= turnsSecondElf.get(1)
						) ||
						(
							turnsFirstElf.get(0) >= turnsSecondElf.get(0) &&
							turnsFirstElf.get(1) <= turnsSecondElf.get(1)
						)
					) {
						accumulator.addAndGet(1);
					}
				}
			);
		return accumulator.get();
	}

	public static int part2(List<String> input) {
		initValues();
		input
			.stream()
			.map(s -> s.split(","))
			.forEach(
				elfList -> {
					List<Integer> turnsFirstElf = Arrays
						.stream(elfList[0].split("-"))
						.map(Integer::parseInt)
						.toList();
					List<Integer> turnsSecondElf = Arrays
						.stream(elfList[1].split("-"))
						.map(Integer::parseInt)
						.toList();
					if (
						(
							rangeContainNumber(
								turnsFirstElf.get(0),
								turnsFirstElf.get(1),
								turnsSecondElf.get(0)
							) ||
							rangeContainNumber(turnsFirstElf.get(0), turnsFirstElf.get(1), turnsSecondElf.get(1))
						) ||
						(
							rangeContainNumber(
								turnsSecondElf.get(0),
								turnsSecondElf.get(1),
								turnsFirstElf.get(0)
							) ||
							rangeContainNumber(turnsSecondElf.get(0), turnsSecondElf.get(1), turnsFirstElf.get(1))
						)
					) {
						accumulator.addAndGet(1);
					}
				}
			);
		return accumulator.get();
	}

	private static void initValues() {
		accumulator.set(0);
	}

	private static boolean rangeContainNumber(Integer rangeInit, Integer rangeEnd, Integer number) {
		return rangeInit <= number && rangeEnd >= number;
	}
}
