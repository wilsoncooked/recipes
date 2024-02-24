package com.wilsoncooked.recipeservice.domain.service

import com.wilsoncooked.recipeservice.api.dto.RecipeDTO
import com.wilsoncooked.recipeservice.domain.model.Recipe
import com.wilsoncooked.recipeservice.repository.RecipeRepository
import mu.KLogging
import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.random.Random

@Service
class RecipeService(private val recipeRepository: RecipeRepository) {

    companion object : KLogging()

    fun getAllRecipes(): List<RecipeDTO> {
        val recipes: List<Recipe> = recipeRepository.findAll()
        logger.info { "Retrieved ${recipes.size} recipes from the database" }
        return recipes.map { mapRecipeToDTO(it) }
    }

    fun addRecipe(createdAt: String ,title: String, description: String): RecipeDTO {
        val newRecipe = recipeRepository.save(
            Recipe(
                id = Random.nextInt(1000),
                createdAt = LocalDate.parse(createdAt),
                title = title,
                description = description
            )
        )
        logger.info { "Saved new recipe to the database" }
        return mapRecipeToDTO(newRecipe)
    }

    private fun mapRecipeToDTO(recipe: Recipe): RecipeDTO {
        return RecipeDTO(
            id = recipe.id,
            createdAt = recipe.createdAt,
            title = recipe.title,
            description = recipe.description?: ""
        )
    }
}