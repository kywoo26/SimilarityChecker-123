import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void testGetScoreWhenLengthsAreSame() {
        int score = similarityChecker.getScoreForLength("ASD", "DSA");
        assertThat(score).isEqualTo(60);
    }

    private void assertNullOrEmpty(String s1, String s2) {
        assertThrows(IllegalArgumentException.class,
                () -> similarityChecker.getScoreForLength(s1, s2));
    }
}