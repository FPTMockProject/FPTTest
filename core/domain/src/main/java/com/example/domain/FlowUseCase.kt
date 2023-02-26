package com.example.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<in P, out R>(private val coroutineDispatcher: CoroutineDispatcher) {
    operator fun invoke(params: P): Flow<R> = execute(params)
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(params: P): Flow<R>
}
