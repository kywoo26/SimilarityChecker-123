public class SimilarityChecker {
    public int getScoreForLength(String s1, String s2) {
        if (isNullOrEmpty(s1) || isNullOrEmpty(s2)) {
            throw new IllegalArgumentException();
        }

        if (s1.length() == s2.length()) {
            return 60;
        } else {
            if (s1.length() >= s2.length() * 2 ||
                    s1.length() * 2 <= s2.length()) {
                return 0;
            }
        }

        return -1;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
