package ru.maxim.spring.spring.fraction;

public class Main {
    public static void main (String[] args) {
        Fraction fractionTest = new Fraction(3, 5);
        System.out.println(fractionTest);
        System.out.println(fractionTest.isProper());

        Fraction fraction2 = new Fraction(7, 5);
        System.out.println(fraction2.isProper());
    }
}
