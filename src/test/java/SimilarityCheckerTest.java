import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SimilarityCheckerTest {
    private SimilarityChecker similarityChecker;
    private int score;

    @BeforeEach
    void setUp() {
        similarityChecker = new SimilarityChecker();
    }

    @Test
    void testInvalidStrings() {
        assertNullOrEmpty(null, null);
        assertNullOrEmpty(null, "a");
        assertNullOrEmpty("a", null);
        assertNullOrEmpty("", "");
        assertNullOrEmpty("", "a");
        assertNullOrEmpty("a", "");
    }

    @Test
    void testWhenAlphabetsAreSame() {
        score = similarityChecker.getScoreForAlpha("ASD", "DSA");
        assertThat(score).isEqualTo(40);

        score = similarityChecker.getScoreForAlpha("AAABB", "BAA");
        assertThat(score).isEqualTo(40);

        score = similarityChecker.getScoreForAlpha("AAAA", "A");
        assertThat(score).isEqualTo(40);
    }

    @Test
    void testWhenNothingMatched() {
        score = similarityChecker.getScoreForAlpha("A", "BB");
        assertThat(score).isZero();

        score = similarityChecker.getScoreForAlpha("ABC", "XYZ");
        assertThat(score).isZero();
    }

    @Test
    void testWhenPartialMatched() {
        score = similarityChecker.getScoreForAlpha("AA", "AAE");
        assertThat(score).isEqualTo(20);

        score = similarityChecker.getScoreForAlpha("AB", "BCCCD");
        assertThat(score).isEqualTo(10);

        score = similarityChecker.getScoreForAlpha("ABCD", "DEFGH");
        assertThat(score).isEqualTo(5);
    }

    private void assertNullOrEmpty(String s1, String s2) {
        assertThrows(IllegalArgumentException.class,
                () -> similarityChecker.getScoreForAlpha(s1, s2));
    }
}