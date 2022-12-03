package aoc2022;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class Day02 {
	private static final AtomicInteger myScore = new AtomicInteger();
	private static final String opponentRock = "A";
	private static final String opponentPaper = "B";
	private static final String opponentScissors = "C";
	private static final String myRock = "X";
	private static final String myPaper = "Y";
	private static final String myScissors = "Z";
	private static final String lose = "X";
	private static final String draw = "Y";
	private static final String win = "Z";

	public static int part1(List<String> input) {
		initValues();
		input.forEach(
			s -> {
				List<String> stringList = Arrays.stream(s.split(" ")).toList();

				String opponent = stringList.get(0);
				String me = stringList.get(1);

				myScore.addAndGet(giveScore(me));
				winDrawOrLose(opponent, me);
			}
		);
		return myScore.get();
	}

	public static int part2(List<String> input) {
		initValues();
		input.forEach(
			s -> {
				List<String> stringList = Arrays.stream(s.split(" ")).toList();

				String opponent = stringList.get(0);
				String result = stringList.get(1);
				winDrawLose2(result);
				guessPlay(opponent, result);
			}
		);
		return myScore.get();
	}

	private static void initValues() {
		myScore.set(0);
	}

	private static int giveScore(String play) {
		int result;
		switch (play) {
			case myRock:
				result = 1;
				break;
			case myPaper:
				result = 2;
				break;
			case myScissors:
				result = 3;
				break;
			default:
				result = 0;
		}
		return result;
	}

	private static void winDrawOrLose(String opponentPlay, String myPlay) {
		if (
			(opponentRock.equals(opponentPlay) && myRock.equals(myPlay)) ||
			(opponentPaper.equals(opponentPlay) && myPaper.equals(myPlay)) ||
			(opponentScissors.equals(opponentPlay) && myScissors.equals(myPlay))
		) {
			myScore.addAndGet(3);
			return;
		}
		if (
			(opponentRock.equals(opponentPlay) && myPaper.equals(myPlay)) ||
			(opponentPaper.equals(opponentPlay) && myScissors.equals(myPlay)) ||
			(opponentScissors.equals(opponentPlay) && myRock.equals(myPlay))
		) {
			myScore.addAndGet(6);
		}
	}

	private static void winDrawLose2(String result) {
		switch (result) {
			case draw:
				myScore.addAndGet(3);
				break;
			case win:
				myScore.addAndGet(6);
				break;
			default:
				myScore.addAndGet(0);
				break;
		}
	}

	private static void guessPlay(String opponentPlay, String result) {
		if (
			(opponentRock.equals(opponentPlay) && draw.equals(result)) ||
			(opponentPaper.equals(opponentPlay) && lose.equals(result)) ||
			(opponentScissors.equals(opponentPlay) && win.equals(result))
		) {
			myScore.addAndGet(giveScore(myRock));
		}
		if (
			(opponentRock.equals(opponentPlay) && win.equals(result)) ||
			(opponentPaper.equals(opponentPlay) && draw.equals(result)) ||
			(opponentScissors.equals(opponentPlay) && lose.equals(result))
		) {
			myScore.addAndGet(giveScore(myPaper));
		}
		if (
			(opponentRock.equals(opponentPlay) && lose.equals(result)) ||
			(opponentPaper.equals(opponentPlay) && win.equals(result)) ||
			(opponentScissors.equals(opponentPlay) && draw.equals(result))
		) {
			myScore.addAndGet(giveScore(myScissors));
		}
	}
}
