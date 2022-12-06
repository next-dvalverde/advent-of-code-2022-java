package aoc2022;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public final class Day05 {
	private static final String separator = "";
	private static String result = "";

	private static final AtomicBoolean startMovements = new AtomicBoolean(false);
	private static Map<Integer, ArrayList<Character>> boxes = new HashMap<>();

	public static String part1(List<String> input) {
		initValues();

		input.forEach(
			s -> {
				if (separator.equals(s)) {
					startMovements.set(true);
				}
				if (startMovements.get() && !s.isBlank()) {
					makeMovement(s, false);
					return;
				}
				packaging(s);
			}
		);
		boxes.values().forEach(c -> result += c.get(0));
		return result;
	}

	public static String part2(List<String> input) {
		initValues();

		input.forEach(
			s -> {
				if (separator.equals(s)) {
					startMovements.set(true);
				}
				if (startMovements.get() && !s.isBlank()) {
					makeMovement(s, true);
					return;
				}
				packaging(s);
			}
		);
		boxes.values().forEach(c -> result += c.get(0));
		return result;
	}

	private static void makeMovement(String s, boolean allInOne) {
		List<Integer> movements = Arrays
			.stream(s.replaceAll("[a-z]*", "").split(" "))
			.filter(s1 -> !" ".equals(s1) && !"".equals(s1))
			.map(Integer::parseInt)
			.toList();

		int quantity = movements.get(0);
		int from = movements.get(1);
		int to = movements.get(2);

		ArrayList<Character> fromBox = boxes.get(from);
		ArrayList<Character> toBox = boxes.get(to);

		for (int i = 0; i < quantity; i++) {
			if (allInOne) {
				toBox.add(0, fromBox.get(quantity - i - 1));
			} else {
				toBox.add(0, fromBox.get(i));
			}
		}
		// Not found
		// fromBox.removeRange
		if (quantity > 0) {
			fromBox.subList(0, quantity).clear();
		}
	}

	private static void packaging(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				int blanks = i / 4;
				int boxNumber = (int) Math.ceil(((i - blanks) / 3)) + 1;
				ArrayList<Character> list = new ArrayList<>();
				if (boxes.containsKey(boxNumber)) {
					list = boxes.get(boxNumber);
				} else {
					boxes.put(boxNumber, list);
				}
				list.add(c);
			}
		}
	}

	private static void initValues() {
		result = "";
		startMovements.set(false);
		boxes = new HashMap<>();
	}
}
