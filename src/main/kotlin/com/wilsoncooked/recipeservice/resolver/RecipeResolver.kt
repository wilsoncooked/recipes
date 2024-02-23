package com.wilsoncooked.recipeservice.resolver

import com.wilsoncooked.recipeservice.dto.RecipeDTO
import com.wilsoncooked.recipeservice.service.RecipeService
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated

@Component
@Validated
class RecipeResolver(val recipeService: RecipeService): GraphQLQueryResolver {

    fun recipes(): List<RecipeDTO> {
        return recipeService.getAllRecipes()
    }

}