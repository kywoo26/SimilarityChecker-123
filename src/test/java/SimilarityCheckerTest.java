import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
    void testWhenLengthsAreSame() {
        score = similarityChecker.getScoreForLength("ASD", "DSA");
        assertThat(score).isEqualTo(60);

        score = similarityChecker.getScoreForLength("aaaa", "bbbb");
        assertThat(score).isEqualTo(60);
    }

    @Test
    void testWhenLengthIsGreaterThanOrEqualToDouble() {
        score = similarityChecker.getScoreForLength("A", "BB");
        assertThat(score).isZero();

        score = similarityChecker.getScoreForLength("BBB", "A");
        assertThat(score).isZero();
    }

    @Test
    void testWhenLengthIsLessThanDouble() {
        score = similarityChecker.getScoreForLength("AAABB", "BAA");
        assertThat(score).isEqualTo(20);

        score = similarityChecker.getScoreForLength("AA", "AAE");
        assertThat(score).isEqualTo(30);
    }

    private void assertNullOrEmpty(String s1, String s2) {
        assertThrows(IllegalArgumentException.class,
                () -> similarityChecker.getScoreForLength(s1, s2));
    }
}