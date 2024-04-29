public class SimilarityChecker {
    public int getScoreForLength(String s1, String s2) {
        if (isNullOrEmpty(s1) || isNullOrEmpty(s2)) {
            throw new IllegalArgumentException();
        }

        if (isSameLength(s1, s2)) {
            return 60;
        } else {
            if (isGreaterThanEqualToDoubleLength(s1, s2)) {
                return 0;
            } else {
                return getPartialScore(s1, s2);
            }
        }
    }

    private int getPartialScore(String s1, String s2) {
        int longLength;
        int shortLength;

        if (s1.length() > s2.length()) {
            longLength = s1.length();
            shortLength = s2.length();
        } else {
            longLength = s2.length();
            shortLength = s1.length();
        }

        return (int) ((1 - (longLength - shortLength) / (double) shortLength) * 60);
    }

    private boolean isGreaterThanEqualToDoubleLength(String s1, String s2) {
        return s1.length() >= s2.length() * 2 ||
                s1.length() * 2 <= s2.length();
    }

    private boolean isSameLength(String s1, String s2) {
        return s1.length() == s2.length();
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
