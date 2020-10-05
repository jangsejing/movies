package com.jess.movies.di

import com.jess.movies.JessApplication
import com.jess.movies.di.module.*
import com.jess.movies.domain.test.ModuleTest1
import com.jess.movies.domain.test.ModuleTestMain
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author jess
 * @since 2020.06.12
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        DataSourceModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
        ModuleTestMain::class
    ]
)

interface AppComponent : AndroidInjector<JessApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: JessApplication): AppComponent
    }
}