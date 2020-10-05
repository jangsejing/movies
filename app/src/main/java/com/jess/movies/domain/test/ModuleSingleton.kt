package com.jess.movies.domain.test

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author jess
 * @since 2020.06.12
 */
@Module
class ModuleSingleton {

    @Provides
    @Singleton
    fun provideSingleton(): TestSingleton {
        return TestSingleton()
    }

}