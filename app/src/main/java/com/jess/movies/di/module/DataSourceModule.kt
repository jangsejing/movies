package com.jess.movies.di.module

import com.jess.movies.domain.datasource.LiveDataSource
import com.jess.movies.domain.datasource.LiveDataSourceImpl
import com.jess.movies.domain.datasource.MainDataSource
import com.jess.movies.domain.datasource.MainDataSourceImpl
import dagger.Binds
import dagger.Module

/**
 * @author jess
 * @since 2020.06.13
 */
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindMainDataSource(dataSource: MainDataSourceImpl): MainDataSource

    @Binds
    abstract fun bindLiveDataSource(dataSource: LiveDataSourceImpl): LiveDataSource

}

