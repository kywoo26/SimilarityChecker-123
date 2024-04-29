import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SimilarityCheckerTest {
    private SimilarityChecker similarityChecker;

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
        int score = similarityChecker.getScoreForLength("ASD", "DSA");
        assertThat(score).isEqualTo(60);

        similarityChecker.getScoreForLength("aaaa", "bbbb");
        assertThat(score).isEqualTo(60);
    }

    @Test
    void testWhenLengthIsGreaterThanOrEqualToDouble() {
        int score = similarityChecker.getScoreForLength("A", "BB");
        assertThat(score).isZero();

        score = similarityChecker.getScoreForLength("BBB", "A");
        assertThat(score).isZero();
    }

    private void assertNullOrEmpty(String s1, String s2) {
        assertThrows(IllegalArgumentException.class,
                () -> similarityChecker.getScoreForLength(s1, s2));
    }
}