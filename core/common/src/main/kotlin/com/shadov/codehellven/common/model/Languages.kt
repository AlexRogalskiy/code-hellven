package com.shadov.codehellven.common.model

import com.fasterxml.jackson.annotation.JsonCreator

enum class Languages {
    JAVA, SCALA;

    companion object {
        @JsonCreator
        fun fromString(key: String): Languages {
            for (type in Languages.values()) {
                if (type.name.equals(key, ignoreCase = true))
                    return type
            }
            throw IllegalArgumentException("Language with key $key does not exist")
        }
    }
}
