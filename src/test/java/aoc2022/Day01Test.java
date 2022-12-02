package aoc2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import utils.InputReader;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class Day01Test {
	private final List<String> testInput = InputReader.readInputAsStrings("aoc2022/Day01_test");
	private final List<String> input = InputReader.readInputAsStrings("aoc2022/Day01");

	public Day01Test() throws IOException {
		// default constructor
	}

	@Test
	public void testPart1() {
		// when
		final var result = Day01.part1(testInput);

		// then
		assertEquals(24000, result);

		// get solution
		System.out.println("Result of aoc2022.Day 01 - Part 1: " + Day01.part1(input));
	}

	@Test
	public void testPart2() {
		// when
		final var result = Day01.part2(testInput);

		// then
		assertEquals(45000, result);

		// get solution
		System.out.println("Result of aoc2022.Day 01 - Part 2: " + Day01.part2(input));
	}
}
