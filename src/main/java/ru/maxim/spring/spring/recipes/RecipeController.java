package ru.maxim.spring.spring.recipes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    private final RecipeRepository repository;

    public RecipeController(RecipeRepository repository) {
        this.repository = repository;
    }

    // 1. Краткая информация о конкретном рецепте
    @GetMapping("/{id}")
    public ResponseEntity<?> getBrief(@PathVariable long id) {
        Recipe recipe = repository.getById(id);

        if (recipe == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Рецепт не найден");
        }

        return ResponseEntity.ok(
                Map.of(
                        "id", recipe.getId(),
                        "name", recipe.getName(),
                        "description", recipe.getDescription()
                )
        );
    }

    // 2. Полный текст рецепта и ссылка на видео
    @GetMapping("/{id}/full")
    public ResponseEntity<?> getFull(@PathVariable long id) {
        Recipe recipe = repository.getById(id);

        if (recipe == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Рецепт не найден");
        }

        return ResponseEntity.ok(
                Map.of(
                        "instructions", recipe.getInstructions(),
                        "videoUrl", recipe.getVideoUrl()
                )
        );
    }

    // 3. Поиск рецептов по ингредиенту
    @GetMapping(params = "ingredient")
    public List<Recipe> findByIngredient(
            @RequestParam String ingredient) {
        return repository.findByIngredient(ingredient);
    }

    // 4. Получение случайного рецепта
    @GetMapping("/random")
    public ResponseEntity<?> getRandom() {
        Recipe recipe = repository.getRandom();

        if (recipe == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Рецептов пока нет");
        }

        return ResponseEntity.ok(recipe);
    }
}