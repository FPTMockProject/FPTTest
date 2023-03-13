package com.example.apptest

import com.example.common.IoDispatcher
import com.example.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import java.lang.Integer.max
import java.lang.Integer.min
import javax.inject.Inject

data class CalculateLocationInput(
    val location: String,
    val instruction: String,
)

abstract class CalculateLocationUseCase(
    coroutineDispatcher: CoroutineDispatcher,
) : UseCase<CalculateLocationInput, String>(coroutineDispatcher)

class CalculateLocationUseCaseImpl @Inject constructor(
    @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
) : CalculateLocationUseCase(coroutineDispatcher) {

    override suspend fun execute(params: CalculateLocationInput): String {
        val location = params.location
        var x = Integer.parseInt(location[0].toString())
        var y = Integer.parseInt(location[1].toString())
        var head = location[2].toString()
        val instruction = params.instruction
        instruction.forEachIndexed { step, command ->
            when (command) {
                'L', 'R' -> {
                    head = getDirection(command, head)
                }
                'M' -> {
                    val result = calculateCoordinate(x to y, head)
                    x = result.first
                    y = result.second
                }
            }
        }
        return "$x$y$head"
    }

    private fun calculateCoordinate(point: Pair<Int, Int>, head: String): Pair<Int, Int> =
        when (head) {
            "N" -> point.first to min(point.second + 1, 5)
            "S" -> point.first to max(point.second - 1, 0)
            "E" -> min(point.first + 1, 5) to point.second
            "W" -> max(point.first - 1, 0) to point.second
            else -> throw IllegalArgumentException("Unknown head direction")
        }

    private fun getDirection(direction: Char, head: String): String = when (direction) {
        'L' -> getRotationLeft(head)
        'R' -> getRotationRight(head)
        else -> throw IllegalArgumentException("Unknown direction")
    }

    private fun getRotationLeft(head: String): String = when (head) {
        "N" -> "W"
        "S" -> "E"
        "E" -> "N"
        "W" -> "S"
        else -> throw IllegalArgumentException("Unknown head direction")
    }

    private fun getRotationRight(head: String): String = when (head) {
        "N" -> "E"
        "S" -> "W"
        "E" -> "S"
        "W" -> "N"
        else -> throw IllegalArgumentException("Unknown head direction")
    }
}