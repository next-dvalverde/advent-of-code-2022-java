package aoc2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import utils.InputReader;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Day02Test {
	private final List<String> testInput = InputReader.readInputAsStrings("aoc2022/Day02_test");
	private final List<String> input = InputReader.readInputAsStrings("aoc2022/Day02");

	public Day02Test() throws IOException {
		// default constructor
	}

	@Test
	public void testPart1() {
		// when
		final var result = Day02.part1(testInput);

		// then
		assertEquals(15, result);

		// get solution
		long init = System.currentTimeMillis();
		final var solution = Day02.part1(input);
		long end = System.currentTimeMillis() - init;
		System.out.printf("Part 1 took %d ms%n", end);
		System.out.println("Result of aoc2022.Day02 - Part 1: " + solution);
	}

	@Test
	public void testPart2() {
		// when
		final var result = Day02.part2(testInput);

		// then
		assertEquals(12, result);

		// get solution
		long init = System.currentTimeMillis();
		final var solution = Day02.part2(input);
		long end = System.currentTimeMillis() - init;
		System.out.printf("Part 2 took %d ms%n", end);
		System.out.println("Result of aoc2022.Day02 - Part 2: " + solution);
	}
}
