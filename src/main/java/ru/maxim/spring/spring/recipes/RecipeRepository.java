package ru.maxim.spring.spring.recipes;

import org.springframework.stereotype.Repository;
import ru.maxim.spring.spring.shopmvc.Shop;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {

    private final List<Recipe> recipes = new ArrayList<>();

    private long nextId = 1;

    public void add(Recipe recipe) {
        recipe.setId(nextId);
        nextId++;
        recipes.add(recipe);
    }

    public Recipe getById(long id) {
        for (Recipe recipe : recipes) {
            if (recipe.getId() == id) {
                return recipe;
            }
        }

        System.out.println("такого рецепта нет");return null;
    }

    public List<Recipe> getAll() {
        return recipes;
    }

    public List<Recipe> findByIngredient(String ingredient) {

        List<Recipe> result = new ArrayList<>();

        for (Recipe recipe : recipes) {
            if (recipe.getIngredients().contains(ingredient)) {
                result.add(recipe);
            }
        }

        return result;
    }

}
