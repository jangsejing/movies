package com.jess.movies.di.module

import com.jess.movies.domain.repository.NaverRepository
import com.jess.movies.domain.repository.NaverRepositoryImpl
import com.jess.movies.domain.repository.NaverRepositoryImplV2
import com.jess.movies.domain.repository.NaverRepositoryV2
import dagger.Binds
import dagger.Module

/**
 * @author jess
 * @since 2020.06.12
 */
@Module(includes = [NetworkModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun bindNaverRepository(impl: NaverRepositoryImpl): NaverRepository

    @Binds
    abstract fun bindNaverRepositoryV2(impl: NaverRepositoryImplV2): NaverRepositoryV2

}