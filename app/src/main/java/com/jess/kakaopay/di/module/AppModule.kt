package com.jess.kakaopay.di.module

import com.jess.kakaopay.di.provider.DispatcherProvider
import com.jess.kakaopay.di.provider.DispatcherProviderImpl
import dagger.Binds
import dagger.Module

/**
 * @author jess
 * @since 2020.06.15
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun bindDispatchers(dispatcher: DispatcherProviderImpl): DispatcherProvider

}

