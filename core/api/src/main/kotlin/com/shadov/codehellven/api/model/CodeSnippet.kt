package com.shadov.codehellven.api.model

import com.shadov.codehellven.common.model.Languages


internal data class CodeSnippet(
        val code: String,
        val language: Languages
)