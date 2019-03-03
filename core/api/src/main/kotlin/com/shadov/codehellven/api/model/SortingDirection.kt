package com.shadov.codehellven.api.model

import org.springframework.data.domain.Sort

enum class SortingDirection {
    ASC, DESC;

    fun asDirection(): Sort.Direction {
        return when (this) {
            ASC -> Sort.Direction.ASC
            DESC -> Sort.Direction.DESC
        }
    }
}