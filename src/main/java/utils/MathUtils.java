package utils;

public final class MathUtils {

	private MathUtils() {
		// no instance
	}

	/**
	 * Math util to calculate partial sum.
	 * The partial sum is the sum of all numbers from 1 to <endValue> (=> 1+2+3+4+5+...+<endValue>)
	 */
	public static int partialSum(int endValue) {
		final int absoluteValue = Math.abs(endValue);
		int partialSum = (absoluteValue * (absoluteValue + 1)) / 2;
		if (endValue < 0) return -partialSum; else return partialSum;
	}
}
