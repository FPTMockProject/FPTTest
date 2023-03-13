package com.example.apptest.di

import com.example.apptest.CalculateLocationUseCase
import com.example.apptest.CalculateLocationUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    internal abstract fun getCalculateLocationUseCase(useCase: CalculateLocationUseCaseImpl): CalculateLocationUseCase
}