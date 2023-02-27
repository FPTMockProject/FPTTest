package com.example.teamservice

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TeamServiceModule {
    @Provides
    @Singleton
    fun provideTeamService(): TeamService = TeamService.create()
}