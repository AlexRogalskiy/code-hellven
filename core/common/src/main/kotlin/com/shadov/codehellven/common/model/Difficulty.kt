package com.shadov.codehellven.common.model

import com.fasterxml.jackson.annotation.JsonCreator

enum class Difficulty constructor(private val reputation: Int) {
    STARTING(1), EASY(3), MEDIUM(5), HARD(10), GOD(50);

    fun reputation(): Int {
        return reputation
    }

    companion object {
        @JsonCreator
        fun fromString(key: String): Difficulty {
            for (type in Difficulty.values()) {
                if (type.name.equals(key, ignoreCase = true))
                    return type
            }
            throw IllegalArgumentException("Difficulty with key $key does not exist")
        }
    }
}
