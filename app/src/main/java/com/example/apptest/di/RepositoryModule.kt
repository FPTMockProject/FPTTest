package com.example.apptest.di

import com.example.participationteam.data.repositories.TeamRepositoryImpl
import com.example.participationteam.domain.repositories.TeamRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    internal abstract fun bindTeamRepository(repository: TeamRepositoryImpl): TeamRepository
}