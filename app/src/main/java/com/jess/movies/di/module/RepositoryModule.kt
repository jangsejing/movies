package com.jess.movies.di.module

import com.jess.movies.repository.NaverRepository
import com.jess.movies.repository.NaverRepositoryImpl
import com.jess.movies.repository.service.NaverService
import dagger.Module
import dagger.Provides

/**
 * @author jess
 * @since 2020.06.12
 */
@Module(includes = [NetworkModule::class])
class RepositoryModule {

    @Provides
    fun provideNaverRepository(
        service: NaverService
    ): NaverRepository {
        return NaverRepositoryImpl(service)
    }
}