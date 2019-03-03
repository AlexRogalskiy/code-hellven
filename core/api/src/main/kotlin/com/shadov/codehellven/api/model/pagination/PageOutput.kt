package com.shadov.codehellven.api.model.pagination

internal data class PageOutput(
        val size: Int,
        val number: Int,
        val totalPages: Int,
        val totalElements: Int,
        val hasNext: Boolean,
        val hasPrevious: Boolean
)