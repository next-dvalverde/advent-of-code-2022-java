package utils;

public final class StringUtils {

    private StringUtils() {
        // no instance
    }

    public static Pair<String, String> split(String s,
                                             int index,
                                             int trimStart,
                                             int trimEnd,
                                             SplitCharBehavior behavior) {
        int firstEndIndex;
        int secondStartIndex;
        switch (behavior) {
            case ADD_CHAR_AT_SPLIT_INDEX_TO_FIRST -> {
                firstEndIndex = index + 1;
                secondStartIndex = index + 1;
            }
            case ADD_CHAR_AT_SPLIT_INDEX_TO_SECOND -> {
                firstEndIndex = index;
                secondStartIndex = index;
            }
            case OMIT_CHAR_AT_SPLIT_INDEX -> {
                firstEndIndex = index;
                secondStartIndex = index + 1;
            }
            default -> {
                firstEndIndex = 0;
                secondStartIndex = 0;
            }
        }
        return new Pair<>(s.substring(trimStart, firstEndIndex), s.substring(secondStartIndex, s.length() - trimEnd));
    }

    public enum SplitCharBehavior {
        ADD_CHAR_AT_SPLIT_INDEX_TO_FIRST,
        ADD_CHAR_AT_SPLIT_INDEX_TO_SECOND,
        OMIT_CHAR_AT_SPLIT_INDEX
    }

}
