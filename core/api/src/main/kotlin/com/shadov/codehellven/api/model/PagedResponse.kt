package com.shadov.codehellven.api.model

import io.vavr.kotlin.toVavrList
import org.springframework.data.domain.Page
import io.vavr.collection.List as VavrList

internal data class PagedResponse<T>(
        val page: PageOutput,
        val content: VavrList<T> = VavrList.empty()
)

internal fun <T> Page<T>.asPagedResponse(): PagedResponse<T> {
    return PagedResponse(
            content = this.content.toVavrList(),
            page = PageOutput(
                    totalElements = this.numberOfElements,
                    totalPages = this.totalPages,
                    number = this.number,
                    size = this.size,
                    hasNext = this.hasNext(),
                    hasPrevious = this.hasPrevious()
            )
    )
}