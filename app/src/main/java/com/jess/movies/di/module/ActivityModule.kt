package com.jess.movies.di.module

import com.jess.movies.di.annotaion.ActivityScoped
import com.jess.movies.presentation.detail.DetailActivity
import com.jess.movies.presentation.live.LiveActivity
import com.jess.movies.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author jess
 * @since 2020.06.12
 */
@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindDetailActivity(): DetailActivity

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun bindLiveActivity(): LiveActivity

}