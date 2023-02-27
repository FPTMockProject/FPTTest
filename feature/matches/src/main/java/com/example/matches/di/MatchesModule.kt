package com.example.matches.di

import com.example.matches.data.services.MatchService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MatchesModule {
    @Singleton
    @Provides
    fun provideMatchService() = MatchService.create()
}