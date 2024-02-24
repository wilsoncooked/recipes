package com.wilsoncooked.recipeservice.api.resolver

import com.wilsoncooked.recipeservice.api.dto.RecipeDTO
import com.wilsoncooked.recipeservice.repository.RecipeRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecipeMutationResolverIntgTest {
    @Autowired
    private lateinit var recipeRepository: RecipeRepository

    @Autowired
    private lateinit var recipeMutationResolver: RecipeMutationResolver

    @Test
    fun `should add a new recipe`() {
        // Given
        val title = "New Recipe"
        val description = "This is a new recipe"

        // When
        val addedRecipe: RecipeDTO = recipeMutationResolver.addRecipe(title, description)

        // Then
        assertThat(addedRecipe).isNotNull
        assertThat(addedRecipe.title).isEqualTo(title)
        assertThat(addedRecipe.description).isEqualTo(description)

        // Additional assertions if needed
        val savedRecipe = recipeRepository.findById(addedRecipe.id!!)
        assertThat(savedRecipe.isPresent).isTrue
        assertThat(savedRecipe.get().title).isEqualTo(title)
        assertThat(savedRecipe.get().description).isEqualTo(description)
    }
}