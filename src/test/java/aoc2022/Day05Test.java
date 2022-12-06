package aoc2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import utils.InputReader;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Day05Test {
	private final List<String> testInput = InputReader.readInputAsStrings("aoc2022/Day05_test");
	private final List<String> input = InputReader.readInputAsStrings("aoc2022/Day05");

	public Day05Test() throws IOException {
		// default constructor
	}

	@Test
	public void testPart1() {
		// when
		final var result = Day05.part1(testInput);

		// then
		assertEquals("CMZ", result);

		// get solution
		long init = System.currentTimeMillis();
		final var solution = Day05.part1(input);
		long end = System.currentTimeMillis() - init;
		System.out.printf("Part 1 took %d ms%n", end);
		System.out.println("Result of aoc2022.Day05 - Part 1: " + solution);
	}

	@Test
	public void testPart2() {
		// when
		final var result = Day05.part2(testInput);

		// then
		assertEquals("MCD", result);

		// get solution
		long init = System.currentTimeMillis();
		final var solution = Day05.part2(input);
		long end = System.currentTimeMillis() - init;
		System.out.printf("Part 2 took %d ms%n", end);
		System.out.println("Result of aoc2022.Day05 - Part 2: " + solution);
	}
}
