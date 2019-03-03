package com.shadov.codehellven.api.model

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort

internal data class PageInput(
        val size: Int,
        val number: Int
)

internal fun PageInput.asRequest(): PageRequest {
    return PageRequest(number, size)
}

internal fun PageInput.asRequest(sort: Sort): PageRequest {
    return PageRequest(number, size, sort)
}