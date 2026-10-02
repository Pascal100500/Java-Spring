package ru.maxim.spring.spring.fraction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FractionController {

    @GetMapping("/fraction")
    public boolean fraction(
            @RequestParam int numerator,
            @RequestParam int denominator) {

        Fraction fraction = new Fraction(numerator, denominator);

        return fraction.isProper();
    }
}