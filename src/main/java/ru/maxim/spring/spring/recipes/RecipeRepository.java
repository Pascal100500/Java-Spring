package ru.maxim.spring.spring.recipes;

import org.springframework.stereotype.Repository;
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
        return null;
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

    public Recipe getRandom() {
        if (recipes.isEmpty()) {
            return null;
        }

        int index = (int) (Math.random() * recipes.size());

        return recipes.get(index);
    }

    public RecipeRepository() {
        Recipe pasta = new Recipe();
        pasta.setName("Паста Карбонара");
        pasta.setDescription("Итальянская паста с сыром и беконом");
        pasta.setIngredients(
                List.of("макароны", "яйца", "сыр", "бекон")
        );
        pasta.setInstructions(
                "Отвари макароны. Смешай яйца с сыром. Добавь бекон и соедини всё с пастой."
        );
        pasta.setVideoUrl("https://example.com/carbonara");

        add(pasta);

        Recipe salad = new Recipe();
        salad.setName("Овощной салат");
        salad.setDescription("Лёгкий салат из свежих овощей");
        salad.setIngredients(
                List.of("помидоры", "огурцы", "сыр", "оливковое масло")
        );
        salad.setInstructions(
                "Нарежь овощи, добавь сыр и заправь оливковым маслом."
        );
        salad.setVideoUrl("https://example.com/salad");

        add(salad);

        Recipe soup = new Recipe();
        soup.setName("Картофельный суп");
        soup.setDescription("Простой домашний суп");
        soup.setIngredients(
                List.of("картофель", "морковь", "лук", "вода")
        );
        soup.setInstructions(
                "Нарежь овощи и вари их в воде до готовности."
        );
        soup.setVideoUrl("https://example.com/soup");

        add(soup);
    }

}
