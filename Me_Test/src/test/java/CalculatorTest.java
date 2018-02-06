

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.Assert;

/**
 * Created by sqsgalaxys (AT) gmail (DOT) com
 * on 07/02/2018.
 */
class CalculatorTest {
    private Calculator caculateService = new Calculator();

    @Test
    void testDivide() {
        // Assert.assertEquals(caculateService.divide(2, 1), 2.0);
        // Assert.assertSame(caculateService.divide(2, 1), 2.0);
        assertEquals(caculateService.divide(2, 1), 2.0);

    }
}