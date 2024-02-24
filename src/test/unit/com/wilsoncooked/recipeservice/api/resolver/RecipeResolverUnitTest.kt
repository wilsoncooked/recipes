package com.wilsoncooked.recipeservice.api.resolver.com.wilsoncooked.recipeservice.api.resolver


import com.wilsoncooked.recipeservice.api.dto.RecipeDTO
import com.wilsoncooked.recipeservice.api.resolver.RecipeQueryResolver
import com.wilsoncooked.recipeservice.domain.service.RecipeService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.time.LocalDate

class RecipeResolverTest {

    @Test
    fun `should return all recipes`() {
        // Given
        val recipeService = mock(RecipeService::class.java)
        val recipeResolver = RecipeQueryResolver(recipeService)
        val recipes = listOf(
            RecipeDTO(id = 1, title = "Recipe 1", description = "Description 1", createdAt = LocalDate.now()),
            RecipeDTO(id = 2, title = "Recipe 2", description = "Description 2", createdAt = LocalDate.now())
        )
        `when`(recipeService.getAllRecipes()).thenReturn(recipes)

        // When
        val result: List<RecipeDTO> = recipeResolver.recipes()

        // Then
        assert(result.size == 2)
        assert(result[0].title == "Recipe 1")
        assert(result[1].description == "Description 2")
    }

    @Test
    fun `should return empty list`() {
        // Given
        val recipeService = mock(RecipeService::class.java)
        val recipeResolver = RecipeQueryResolver(recipeService)
        `when`(recipeService.getAllRecipes()).thenReturn(emptyList())

        // When
        val result: List<RecipeDTO> = recipeResolver.recipes()

        // Then
        assert(result.isEmpty())
    }

    @Test
    fun `should handle null recipe list`() {
        // Given
        val recipeService = mock(RecipeService::class.java)
        val recipeResolver = RecipeQueryResolver(recipeService)
        `when`(recipeService.getAllRecipes()).thenReturn(null)

        // When
        val result: List<RecipeDTO> = recipeResolver.recipes()

        // Then
        assert(result == null)
    }
}