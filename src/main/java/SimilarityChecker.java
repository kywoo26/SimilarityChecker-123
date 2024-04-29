public class SimilarityChecker {
    public int getScoreForAlpha(String s1, String s2) {
        if (isNullOrEmpty(s1) || isNullOrEmpty(s2)) {
            throw new IllegalArgumentException();
        }

        return calcScoreForAlpha(s1, s2);
    }

    private int calcScoreForAlpha(String s1, String s2) {
        int totalCount = 0;
        int sameCount = 0;

        for (char c = 'A'; c <= 'Z'; c++) {
            if (existsEvenOne(s1, s2, c)) {
                if (existsBoth(s1, s2, c)) {
                    sameCount++;
                }

                totalCount++;
            }
        }

        return (int) ((sameCount / (double) totalCount) * 40);
    }

    private boolean existsBoth(String s1, String s2, char target) {
        return s1.indexOf(target) > -1 && s2.indexOf(target) > -1;
    }

    private boolean existsEvenOne(String s1, String s2, char target) {
        return s1.indexOf(target) != -1 || s2.indexOf(target) != -1;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}