package com.wilsoncooked.recipeservice.service

import com.wilsoncooked.recipeservice.dto.RecipeDTO
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.Date

@Service
class RecipeService {
    public val recipes: List<RecipeDTO> = listOf(
        RecipeDTO(1, LocalDate.now(), "Spaghetti Carbonara", "A delicious pasta dish"),
        RecipeDTO(2, LocalDate.now(), "Chicken Stir Fry", "A delicious chicken dish"),
    )

    fun getAllRecipes(): List<RecipeDTO> {
        return recipes
    }
}