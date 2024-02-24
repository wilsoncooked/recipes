package com.wilsoncooked.recipeservice.api.resolver

import com.wilsoncooked.recipeservice.api.dto.RecipeDTO
import com.wilsoncooked.recipeservice.domain.service.RecipeService
import graphql.kickstart.tools.GraphQLQueryResolver
import mu.KLogging
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated

@Component
@Validated
class RecipeQueryResolver(val recipeService: RecipeService): GraphQLQueryResolver {

    companion object : KLogging()

    fun recipes(): List<RecipeDTO> {
        logger.info { "Fetching recipes from GraphQL query" }
        return recipeService.getAllRecipes()
    }

}