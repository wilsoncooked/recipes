package com.wilsoncooked.recipeservice.api.resolver

import com.wilsoncooked.recipeservice.api.dto.RecipeDTO
import com.wilsoncooked.recipeservice.domain.model.Recipe
import com.wilsoncooked.recipeservice.domain.service.RecipeService
import graphql.kickstart.tools.GraphQLMutationResolver
import mu.KLogging
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class RecipeMutationResolver(private val recipeService: RecipeService) : GraphQLMutationResolver {

    companion object : KLogging()

    fun addRecipe(title: String, description: String): RecipeDTO {
        logger.info { "Adding new recipe from graphQL mutation" }
        return recipeService.addRecipe(LocalDate.now().toString(), title, description)
    }
}