import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GraderTest {

    private Grader grader;

    @BeforeAll
    void setUp() {
        // runs only once before all tests
        grader = new Grader();
    }

    @Nested
    @DisplayName("Grade Determination Tests")
    class GradeDeterminationTests {
        @Test
        @DisplayName("Test grade A for score 75 or above")
        void determineGradeReturnsAForScore75OrAbove() {
            assertEquals('A', grader.determineGrade(75));
            assertEquals('A', grader.determineGrade(100));
        }

        @Test
        @DisplayName("Test grade B for score between 65 and 74")
        void determineGradeReturnsBForScoreBetween65And74() {
            assertEquals('B', grader.determineGrade(65));
            assertEquals('B', grader.determineGrade(74));
        }

        @Test
        @DisplayName("Test grade C for score between 55 and 64")
        void determineGradeReturnsCForScoreBetween55And64() {
            assertEquals('C', grader.determineGrade(55));
            assertEquals('C', grader.determineGrade(64));
        }

        @Test
        @DisplayName("Test grade S for score between 35 and 54")
        void determineGradeReturnsSForScoreBetween35And54() {
            assertEquals('S', grader.determineGrade(35));
            assertEquals('S', grader.determineGrade(54));
        }

        @Test
        @DisplayName("Test grade F for score below 35")
        void determineGradeReturnsFForScoreBelow35() {
            assertEquals('F', grader.determineGrade(0));
            assertEquals('F', grader.determineGrade(34));
        }
    }

    @Nested
    @DisplayName("Boundary Value Tests")
    class BoundaryValueTests {
        @Test
        @DisplayName("Test boundary value for minimum valid score")
        void determineGradeThrowsExceptionForNegativeScore() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> grader.determineGrade(-1));
            assertEquals("Score must be between 0 and 100", exception.getMessage());
        }

        @Test
        @DisplayName("Test boundary value for maximum valid score")
        void determineGradeThrowsExceptionForScoreAbove100() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> grader.determineGrade(101));
            assertEquals("Score must be between 0 and 100", exception.getMessage());
        }
    }
}
