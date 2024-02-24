package com.wilsoncooked.recipeservice.api.dto

import java.time.LocalDate

data class RecipeDTO(
    val id: Int? = null,
    val createdAt: LocalDate,
    val title: String,
    val description: String
)
