public class SimilarityChecker {
    public int getScoreForLength(String s1, String s2) {
        if (isNullOrEmpty(s1) || isNullOrEmpty(s2)) {
            throw new IllegalArgumentException();
        }

        return 0;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
