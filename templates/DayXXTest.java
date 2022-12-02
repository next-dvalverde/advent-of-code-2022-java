package aoc2022;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import utils.InputReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(
        MethodOrderer.MethodName.class
)
public class DayXXTest {

    private final List<String> testInput = InputReader.readInputAsStrings("Day01_test");
    private final List<String> input = InputReader.readInputAsStrings("Day01");

    public DayXXTest() throws IOException {
        // default constructor
    }

    @Test
    public void testPart1() {
        // when
        final var result = DayXX.part1(testInput);

        // then
        assertEquals(0, result);

        // get solution
        System.out.println("Result of aoc2022.Day XX - Part 1: " + DayXX.part1(input));
    }

    @Test
    public void testPart2() {
        // when
        final var result = DayXX.part2(testInput);

        // then
        assertEquals(0, result);

        // get solution
        System.out.println("Result of aoc2022.Day 01 - Part 2: " + DayXX.part2(input));
    }
}