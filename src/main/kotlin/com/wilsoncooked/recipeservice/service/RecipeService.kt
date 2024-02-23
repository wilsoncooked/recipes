package com.wilsoncooked.recipeservice.service

import com.wilsoncooked.recipeservice.dto.RecipeDTO
import com.wilsoncooked.recipeservice.model.Recipe
import com.wilsoncooked.recipeservice.repository.RecipeRepository
import mu.KLogging
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.Date

@Service
class RecipeService(private val recipeRepository: RecipeRepository) {

    companion object : KLogging()

    fun getAllRecipes(): List<RecipeDTO> {
        val recipes: List<Recipe> = recipeRepository.findAll()
        logger.info { "Retrieved ${recipes.size} recipes from the database" }
        return recipes.map { mapRecipeToDTO(it) }
    }

    private fun mapRecipeToDTO(recipe: Recipe): RecipeDTO {
        return RecipeDTO(
            id = recipe.id,
            createdAt = recipe.createdAt,
            title = recipe.title,
            description = recipe.description ?: "" // Ensure nullable fields are handled
        )
    }
}