package com.example.apptest.di

import com.example.participationteam.data.services.TeamService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideTeamService(): TeamService {
        return TeamService.create()
    }
}