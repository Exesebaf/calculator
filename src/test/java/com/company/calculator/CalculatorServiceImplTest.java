package com.company.calculator;

import com.company.calculator.exception.DivideByZeroException;
import com.company.calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorServiceImplTest {

    private final CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl();


    @Test
    public void plusTest() {
        Number actual = calculatorServiceImpl.plus(2, 3);
        assertThat(actual).isEqualTo(5);

        actual = calculatorServiceImpl.plus(-3, 1);
        assertThat(actual).isEqualTo(-2);
    }
    @Test
    public void minusTest() {
        Number actual = calculatorServiceImpl.minus(3, 2);
        assertThat(actual).isEqualTo(1);

        actual = calculatorServiceImpl.minus(-3, 2);
        assertThat(actual).isEqualTo(-5);
    }

    @Test
    public void multiplyTest() {
        Number actual = calculatorServiceImpl.multiply(1, 2);
        assertThat(actual).isEqualTo(2);

        actual = calculatorServiceImpl.multiply(-3, 1);
        assertThat(actual).isEqualTo(-3);
    }
    @Test
    public void dividePositiveTest() {
        Number actual = calculatorServiceImpl.divide(1, 2);
        assertThat(actual).isEqualTo(0.5);

        actual = calculatorServiceImpl.divide(-3, 1);
        assertThat(actual).isEqualTo(-3D);
    }
    @Test
    public void divideNegativeTest() {
        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(()->calculatorServiceImpl.divide(1,0))
                        .withMessage("num2 не может равняться 0");

        assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(()->calculatorServiceImpl.divide(-5,0))
                .withMessage("num2 не может равняться 0");
    }


}
