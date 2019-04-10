package com.shadov.codehellven.api.infrastructure.aspects

import net.logstash.logback.argument.StructuredArguments.keyValue
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.Logger
import org.springframework.util.StopWatch


@Aspect
internal class RepositoryCallLoggingAspect(private val log: Logger) {
    @Pointcut("execution(public * org.springframework.data.mongodb.repository.MongoRepository+.*(..))")
    fun anyRepositoryMethod() = {}

    @Around("anyRepositoryMethod()")
    fun publicNonVoidRepositoryMethod(jointPoint: ProceedingJoinPoint): Any {
        val watch = StopWatch()
        watch.start()

        try {
            return jointPoint.proceed()
        } finally {
            watch.stop()

            val time = watch.totalTimeMillis
            val operation = "${jointPoint.signature.declaringTypeName}.${jointPoint.signature.name}"

            log.debug("repository call",
                    keyValue("operation", operation),
                    keyValue("timeMs", time)
            )
        }
    }
}