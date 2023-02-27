package com.example.participationteam.domain.usecases

import com.example.common.IoDispatcher
import com.example.domain.FlowUseCase
import com.example.participationteam.domain.models.Team
import com.example.participationteam.domain.repositories.TeamRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

abstract class GetTeamsUseCase(ioDispatcher: CoroutineDispatcher) :
    FlowUseCase<Unit, List<Team>>(ioDispatcher)

class GetTeamsUseCaseImpl @Inject constructor(
    private val teamRepository: TeamRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : GetTeamsUseCase(ioDispatcher) {
    private val lastedTeams: Flow<List<Team>> = flow {
        while (true) {
            val teams = teamRepository.getTeams()
            emit(teams)
            delay(10000L)
        }
    }

    override fun execute(params: Unit): Flow<List<Team>> {
        return lastedTeams
    }
}