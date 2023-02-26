package com.example.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

public abstract class UseCase<in P, out R>(private val dispatcher: CoroutineDispatcher) {

    public suspend operator fun invoke(params: P): R = withContext(dispatcher) {
        execute(params)
    }

    internal abstract suspend fun execute(params: P): R
}
