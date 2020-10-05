package com.jess.movies.domain.test

import dagger.Module
import dagger.Provides

/**
 * @author jess
 * @since 2020.06.12
 */
@Module
class LibModule {

    @Provides
    fun provideTest1(): Test1 {
        return Test1()
    }

    @Provides
    fun provideTest2(): Test2 {
        return Test2()
    }

    @Provides
    fun provideTest3(): Test3 {
        return Test3()
    }

    @Provides
    fun provideTestRepository(
        test1: Test1,
        test2: Test2,
        test3: Test3
    ): TestRepository {
        return TestRepository(
            test1,
            test2,
            test3
        )
    }

    @Provides
    fun provideTestUseCase(
        testRepository: TestRepository
    ): TestUseCase {
        return TestUseCase(testRepository)
    }
}