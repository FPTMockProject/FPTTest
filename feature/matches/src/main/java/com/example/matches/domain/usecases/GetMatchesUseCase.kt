package com.example.matches.domain.usecases

import com.example.common.IoDispatcher
import com.example.domain.FlowUseCase
import com.example.matches.domain.models.Matches
import com.example.matches.domain.repositories.MatchesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

abstract class GetMatchesUseCase(ioDispatcher: CoroutineDispatcher) :
    FlowUseCase<Unit, Matches>(ioDispatcher)

class GetMatchesUseCaseImpl @Inject constructor(
    @IoDispatcher ioDispatcher: CoroutineDispatcher,
    repository: MatchesRepository
) : GetMatchesUseCase(ioDispatcher) {
    private val lastUpdate = flow {
        val matches = repository.getMatches()
        emit(matches)
        delay(10000L)
    }

    override fun execute(params: Unit): Flow<Matches> {
        return lastUpdate
    }
}