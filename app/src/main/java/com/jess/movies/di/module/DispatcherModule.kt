package com.jess.movies.di.module

import com.jess.movies.di.DispatcherProvider
import com.jess.movies.di.DispatcherProviderImpl
import dagger.Binds
import dagger.Module

/**
 * @author jess
 * @since 2020.06.13
 */
@Module
abstract class DispatcherModule {

    @Binds
    abstract fun bindDispatchers(dispatcher: DispatcherProviderImpl): DispatcherProvider

}

