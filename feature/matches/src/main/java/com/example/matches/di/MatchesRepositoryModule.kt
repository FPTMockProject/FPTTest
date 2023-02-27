package com.example.matches.di

import com.example.matches.data.repositories.MatchesRepositoryImpl
import com.example.matches.domain.repositories.MatchesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MatchesRepositoryModule {
    @Binds
    @Singleton
    internal abstract fun bindMatchesRepository(repository: MatchesRepositoryImpl): MatchesRepository
}