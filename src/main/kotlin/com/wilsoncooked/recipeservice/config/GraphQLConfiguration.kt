package com.wilsoncooked.recipeservice.config

import graphql.scalars.ExtendedScalars
import graphql.schema.GraphQLScalarType
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GraphQLConfiguration {
    @Bean
    fun dateScalar(): GraphQLScalarType =
        ExtendedScalars.Date

    @Bean
    fun urlScalar(): GraphQLScalarType = ExtendedScalars.Url
}
