package ru.maxim.spring.spring.recipes;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Recipe {

    private Long id;
    private String name;
    private String description;
    private List<String> ingredients;
    private String instructions;
    private String videoUrl;
}