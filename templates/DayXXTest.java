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

    private final List<String> testInput = InputReader.readInputAsStrings("aoc2022/DayXX_test");
    private final List<String> input = InputReader.readInputAsStrings("aoc2022/DayXX");

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
        long init = System.currentTimeMillis();
        final var solution = Day01.part1(input);
        long end = System.currentTimeMillis() - init;
        System.out.printf("Part 1 took %d ms%n", end);
        System.out.println("Result of aoc2022.DayXX - Part 1: " + solution);
    }

    @Test
    public void testPart2() {
        // when
        final var result = DayXX.part2(testInput);

        // then
        assertEquals(0, result);

        // get solution
        long init = System.currentTimeMillis();
        final var solution = Day01.part2(input);
        long end = System.currentTimeMillis() - init;
        System.out.printf("Part 2 took %d ms%n", end);
        System.out.println("Result of aoc2022.DayXX - Part 2: " + solution);
    }
}