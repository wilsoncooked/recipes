package com.wilsoncooked.recipeservice.repository

import com.wilsoncooked.recipeservice.domain.model.Recipe
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeRepository: JpaRepository<Recipe, Int> {

    override fun findAll(): List<Recipe>
    fun findByTitle(title: String): Recipe?
}