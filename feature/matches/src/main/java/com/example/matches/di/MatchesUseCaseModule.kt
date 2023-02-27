package com.example.matches.di

import com.example.matches.domain.usecases.GetMatchesUseCase
import com.example.matches.domain.usecases.GetMatchesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MatchesUseCaseModule {
    @Binds
    @Singleton
    internal abstract fun bindGetMatchesUseCase(useCase: GetMatchesUseCaseImpl): GetMatchesUseCase
}