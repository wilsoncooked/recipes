package com.wilsoncooked.recipeservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
class RecipeServiceApplication

fun main(args: Array<String>) {
	runApplication<RecipeServiceApplication>(*args)
}
