package com.shadov.codehellven.common

import org.apache.commons.lang3.StringUtils

import java.util.Arrays
import java.util.Objects
import java.util.function.Predicate

object Check {
    fun noBlanks(vararg args: String): Boolean {
        return Arrays.stream(args).noneMatch { StringUtils.isBlank(it) }
    }

    fun anyBlank(vararg args: String): Boolean {
        return Arrays.stream(args).anyMatch { StringUtils.isBlank(it) }
    }

    fun isNull(`object`: Any): Boolean {
        return Objects.isNull(`object`)
    }

    fun notNull(`object`: Any): Boolean {
        return !Objects.isNull(`object`)
    }
}
