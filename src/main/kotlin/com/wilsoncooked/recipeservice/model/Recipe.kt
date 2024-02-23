package com.wilsoncooked.recipeservice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

//@Entity
data class Recipe (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,
    val createdAt: LocalDate,
    val title: String,
    val description: String
    )