package com.jess.movies.di.annotaion

import dagger.MapKey
import kotlin.reflect.KClass

/**
 * @author jess
 * @since 2020.06.12
 */
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class UseCaseKey(val value: String)
