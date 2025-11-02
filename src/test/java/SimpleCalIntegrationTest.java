import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SimpleCalIntegrationTest {

    private SimpleCal calculator;

    @BeforeAll
    void init() {
        // runs only once before all tests
        calculator = new SimpleCal();
    }

    @Test
    @DisplayName("Integration Test: Perform a sequence of operations together")
    void testOperationsSequence() {
        int sum = calculator.addition(10, 5);      // 15
        int diff = calculator.subtraction(sum, 3); // 12
        int product = calculator.multiplication(diff, 2); // 24
        double result = calculator.division(product, 6);  // 4.0

        assertEquals(4.0, result, 0.001);
    }

    @Test
    @DisplayName("Integration Test: Chain different inputs")
    void testAnotherFlow() {
        int sum = calculator.addition(20, 10);     // 30
        int diff = calculator.subtraction(sum, 5); // 25
        int product = calculator.multiplication(diff, 4); // 100
        double result = calculator.division(product, 20); // 5.0

        assertEquals(5.0, result, 0.001);
    }
}
