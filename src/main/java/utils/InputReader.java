package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class InputReader {

	private InputReader() {
		// no instance
	}

	/**
	 * Reads lines from the given input txt file as stream.
	 */
	public static Stream<String> readInputAsStringStream(String name) throws IOException {
		return Files.lines(Paths.get("src/main/resources", name + ".txt"));
	}

	/**
	 * Reads lines from the given input txt file as stream.
	 */
	public static List<String> readInputAsStrings(String name) throws IOException {
		return readInputAsStringStream(name).toList();
	}

	/**
	 * Reads lines from the given input txt file as int stream.
	 */
	public static Stream<Integer> readInputAsIntStream(String name) throws IOException {
		return readInputAsStringStream(name).map(Integer::parseInt);
	}

	/**
	 * Reads lines from the given input txt file as integers.
	 */
	public static List<Integer> readInputAsInts(String name) throws IOException {
		return readInputAsIntStream(name).toList();
	}

	public static List<List<Integer>> readInputAs2dIntArray(String name) throws IOException {
		return readInputAs2dIntArray(name, "");
	}

	public static List<List<Integer>> readInputAs2dIntArray(String name, String delimiter) throws IOException {
		return readInputAsStringStream(name)
			.map(row -> Arrays.stream(row.split(delimiter)).map(Integer::parseInt).toList())
			.toList();
	}

	/**
	 * Reads one line as String.
	 */
	public static String readOneLineInputAsString(String name) throws IOException {
		return readInputAsStrings(name).get(0);
	}

	/**
	 * Reads one line and map to Ints.
	 */
	public static Stream<Integer> readOneLineInputAsIntStream(String name) throws IOException {
		return readOneLineInputAsIntStream(name, ",");
	}

	public static Stream<Integer> readOneLineInputAsIntStream(String name, String delimiter) throws IOException {
		return Arrays.stream(readOneLineInputAsString(name).split(delimiter)).map(Integer::parseInt);
	}

	public static List<Integer> readOneLineInputAsInts(String name) throws IOException {
		return readOneLineInputAsInts(name, ",");
	}

	public static List<Integer> readOneLineInputAsInts(String name, String delimiter) throws IOException {
		return readOneLineInputAsIntStream(name, delimiter).toList();
	}
}
