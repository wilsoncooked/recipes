package com.wilsoncooked.recipeservice.domain.service

import com.wilsoncooked.recipeservice.api.dto.RecipeDTO
import com.wilsoncooked.recipeservice.domain.model.Recipe
import com.wilsoncooked.recipeservice.repository.RecipeRepository
import io.mockk.junit5.MockKExtension
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.LocalDate
import org.junit.jupiter.api.Assertions.assertEquals

@ExtendWith(MockKExtension::class)
internal class RecipeServiceUnitTest {

    private val recipeRepository: RecipeRepository = mockk()

    private val recipeService: RecipeService = RecipeService(recipeRepository)

    @Test
    fun `should add recipe`() {
        // Given
        val createdAt = "2024-02-24"
        val title = "New Recipe"
        val description = "Test Description"
        val newRecipe = Recipe(
            id = 1,
            createdAt = LocalDate.parse(createdAt),
            title = title,
            description = description
        )
        val expectedRecipeDTO = RecipeDTO(
            id = newRecipe.id,
            createdAt = newRecipe.createdAt,
            title = newRecipe.title,
            description = newRecipe.description ?: ""
        )
        every { recipeRepository.save(any()) } returns newRecipe

        // When
        val result = recipeService.addRecipe(createdAt, title, description)

        // Then
        assertEquals(expectedRecipeDTO, result)
    }
}