package com.shadov.codehellven.api.infrastructure.filters

import com.shadov.codehellven.api.infrastructure.LoggingFields
import com.shadov.codehellven.common.lazyLogger
import org.slf4j.MDC
import org.springframework.web.filter.OncePerRequestFilter
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

internal class RequestIdentifiersFilter : OncePerRequestFilter() {
    private val sleuthHeader = "X-B3-TraceId"

    private val log by lazyLogger()

    override fun doFilterInternal(req: HttpServletRequest, res: HttpServletResponse, filterChain: FilterChain) {
        val requestId = UUID.randomUUID().toString()
        val traceId = req.getHeader(sleuthHeader)

        MDC.put(LoggingFields.REQUEST_ID.nameInLog, requestId)
        MDC.put(LoggingFields.TRACE_ID.nameInLog, traceId)

        log.info("Adding to MDC requestId = $requestId and traceId = $traceId")

        filterChain.doFilter(req, res)
    }

}