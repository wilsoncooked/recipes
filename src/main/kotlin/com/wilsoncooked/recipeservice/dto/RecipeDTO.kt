package com.wilsoncooked.recipeservice.dto

import java.time.LocalDate

data class RecipeDTO(
    val id: Int,
    val createdAt: LocalDate,
    val title: String,
    val description: String
)
