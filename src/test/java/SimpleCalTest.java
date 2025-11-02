import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalTest {

    private SimpleCal calculator;

    @BeforeEach
    void setUp() {
        // runs only once before all tests
        calculator = new SimpleCal();
    }

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {
        @Test
        @DisplayName("Test addition of the two positive numbers")
        void testAdditionOfTwoPositiveNumbers() {
            var result = calculator.addition(2, 3);
            assertEquals(5, result);
        }

        @Test
        @DisplayName("Test addition of the two negative numbers")
        void testAdditionOfTwoNegativeNumbers() {
            assertEquals(-4, calculator.addition(-2, -2));
        }
    }

    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {
        @Test
        @DisplayName("Test subtraction of the two positive numbers")
        void testSubtractionOfTwoPositiveNumbers() {
            assertEquals(1, calculator.subtraction(3, 2));
        }

        @Test
        @DisplayName("Test subtraction of the two negative numbers")
        void testSubtractionOfTwoNegativeNumbers() {
            assertEquals(0, calculator.subtraction(-1, -1));
        }
    }

    @Nested
    @DisplayName("Multiplication Tests")
    class MultiplicationTests {
        @Test
        @DisplayName("Test multiplication of the two positive numbers")
        void testMultiplicationOfTwoPositiveNumbers() {
            assertEquals(6, calculator.multiplication(2, 3));
        }

        @Test
        @DisplayName("Test multiplication of the two negative numbers")
        void testMultiplicationOfTwoNegativeNumbers() {
            assertEquals(4, calculator.multiplication(-2, -2));
        }
    }

    @Nested
    @DisplayName("Division Tests")
    class DivisionTests {
        @Test
        @DisplayName("Test Division of the two positive numbers")
        void testDivisionOfTwoPositiveNumbers() {
            assertEquals(2.0, calculator.division(6, 3), 0.001);
            assertEquals(2.5, calculator.division(5, 2), 0.001);
        }

        @Test
        @DisplayName("Division by zero raises ArithmeticException")
        void divisionByZeroRaisesArithmeticException() {
            Exception exception = assertThrows(ArithmeticException.class, () -> {
                calculator.division(5, 0);
            });
            assertEquals("Division can't be done by zero", exception.getMessage());
        }
    }
}
