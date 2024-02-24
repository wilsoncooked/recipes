package com.wilsoncooked.recipeservice.api.resolver

import com.wilsoncooked.recipeservice.api.dto.RecipeDTO
import com.wilsoncooked.recipeservice.domain.model.Recipe
import com.wilsoncooked.recipeservice.repository.RecipeRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource
import java.time.LocalDate


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
class RecipeQueryResolverIntgTest {

//    @Autowired
//    private lateinit var recipeRepository: RecipeRepository

    @Autowired
    private lateinit var recipeQueryResolver: RecipeQueryResolver

//    @BeforeEach
//    fun setUp() {
//        val recipe = Recipe(
//            title = "title",
//            description = "description",
//            createdAt = LocalDate.now()
//        )
//        recipeRepository.save(recipe)
//    }

    @Test
    fun `should return all recipes`() {
        val recipes: List<RecipeDTO> = recipeQueryResolver.recipes()

        assertThat(recipes).hasSize(13)
        assertThat(recipes[0].title).isEqualTo("Cake")
        assertThat(recipes[0].description).isEqualTo("Delicious")
    }

}