package ru.maxim.spring.spring.fraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction (int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не должен быть равен 0");
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public boolean isProper() {
        return Math.abs(numerator) < Math.abs(denominator);
    }

}
