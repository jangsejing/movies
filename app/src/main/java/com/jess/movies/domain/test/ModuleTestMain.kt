package com.jess.movies.domain.test

import dagger.Module

/**
 * @author jess
 * @since 2020.06.12
 */
@Module(includes = [
    ModuleSingleton::class,
    ModuleTest1::class,
    ModuleTest2::class
])
abstract class ModuleTestMain