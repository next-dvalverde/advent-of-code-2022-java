package aoc2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import utils.InputReader;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Day03Test {
	private final List<String> testInput = InputReader.readInputAsStrings("aoc2022/Day03_test");
	private final List<String> input = InputReader.readInputAsStrings("aoc2022/Day03");

	public Day03Test() throws IOException {
		// default constructor
	}

	@Test
	public void testPart1() {
		// when
		final var result = Day03.part1(testInput);

		// then
		assertEquals(157, result);

		// get solution
		long init = System.currentTimeMillis();
		final var solution = Day03.part1(input);
		long end = System.currentTimeMillis() - init;
		System.out.printf("Part 1 took %d ms%n", end);
		System.out.println("Result of aoc2022.Day03 - Part 1: " + solution);
	}

	@Test
	public void testPart2() {
		// when
		final var result = Day03.part2(testInput);

		// then
		assertEquals(70, result);

		// get solution
		long init = System.currentTimeMillis();
		final var solution = Day03.part2(input);
		long end = System.currentTimeMillis() - init;
		System.out.printf("Part 2 took %d ms%n", end);
		System.out.println("Result of aoc2022.Day03 - Part 2: " + solution);
	}

	@Test
	public void testCore() {
		// when
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String result = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			result = result.concat(Day03.giveScore(ch) + " ");
		}

		// then
		assertEquals(
			"1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 ",
			result
		);
	}
}
