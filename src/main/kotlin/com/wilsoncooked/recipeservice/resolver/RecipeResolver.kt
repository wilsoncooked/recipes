package com.wilsoncooked.recipeservice.resolver

import com.wilsoncooked.recipeservice.dto.RecipeDTO
import com.wilsoncooked.recipeservice.model.Recipe
import com.wilsoncooked.recipeservice.service.RecipeService
import graphql.kickstart.tools.GraphQLQueryResolver
import mu.KLogging
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated

@Component
@Validated
class RecipeResolver(val recipeService: RecipeService): GraphQLQueryResolver {

    companion object : KLogging()

    fun recipes(): List<RecipeDTO> {
        logger.info { "Fetching recipes from GraphQL query" }
        return recipeService.getAllRecipes()
    }

}