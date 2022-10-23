package com.company.calculator;

import com.company.calculator.exception.DivideByZeroException;
import com.company.calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ParameterizedCalculatorServiceImplTest {
    private final CalculatorServiceImpl calculatorServiceimpl = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("paramsForPlus")
    public void plusTest(Integer a,
                         Integer b,
                         Integer expected) {
        assertThat(calculatorServiceimpl.plus(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForMinus")
    public void minusTest(Integer a,
                          Integer b,
                          Integer expected) {
        assertThat(calculatorServiceimpl.minus(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForMultiply")
    public void multiplyTest(Integer a,
                             Integer b,
                             Integer expected) {
        assertThat(calculatorServiceimpl.multiply(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("paramsForDivide")
    public void divideTest(Integer a,
                           Integer b,
                           Double expected) {
        if (b == 0){
            assertThatExceptionOfType(DivideByZeroException.class)
                    .isThrownBy(() -> calculatorServiceimpl.divide(a, b))
                    .withMessage("num2 не может равняться 0");
        }else {
            assertThat(calculatorServiceimpl.divide(a, b)).isEqualTo(expected);
        }
    }


    public static Stream<Arguments> paramsForPlus() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(-1, 2, 1),
                Arguments.of(-10, -6, -16),
                Arguments.of(1, -5, -4),
                Arguments.of(0, 0, 0)
        );
    }

    public static Stream<Arguments> paramsForMinus() {
        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(-1, 2, -3),
                Arguments.of(-10, -6, -10),
                Arguments.of(6, -5, 11),
                Arguments.of(0, 0, 0)
        );
    }

    public static Stream<Arguments> paramsForMultiply() {
        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(-1, 2, -2),
                Arguments.of(-10, -6, 60),
                Arguments.of(1, -5, -5),
                Arguments.of(0, 0, 0)
        );
    }

    public static Stream<Arguments> paramsForDivide() {
        return Stream.of(
                Arguments.of(1, 2, 0.5),
                Arguments.of(-1, 2, -0.5),
                Arguments.of(-10, -6, 5D / 3),
                Arguments.of(1, -5, -0.2),
                Arguments.of(1, 0, null),
                Arguments.of(-1, 0, null)
        );
    }


}
