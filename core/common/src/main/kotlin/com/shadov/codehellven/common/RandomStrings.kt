package com.shadov.codehellven.common

import org.apache.commons.text.CharacterPredicate
import org.apache.commons.text.RandomStringGenerator

object RandomStrings {

    private val letterGenerator = RandomStringGenerator.Builder().filteredBy(CustomPredicates.ASCII_LETTERS).build()

    enum class CustomPredicates : CharacterPredicate {
        ARABIC_NUMERALS {
            override fun test(codePoint: Int): Boolean {
                return codePoint >= '0'.toInt() && codePoint <= '9'.toInt()
            }
        },
        ASCII_LOWERCASE_LETTERS {
            override fun test(codePoint: Int): Boolean {
                return codePoint >= 'a'.toInt() && codePoint <= 'z'.toInt()
            }
        },
        ASCII_UPPERCASE_LETTERS {
            override fun test(codePoint: Int): Boolean {
                return codePoint >= 'A'.toInt() && codePoint <= 'Z'.toInt()
            }
        },
        ASCII_LETTERS {
            override fun test(codePoint: Int): Boolean {
                return ASCII_LOWERCASE_LETTERS.test(codePoint) || ASCII_UPPERCASE_LETTERS.test(codePoint)
            }
        },
        ASCII_ALPHA_NUMERALS {
            override fun test(codePoint: Int): Boolean {
                return (ASCII_LOWERCASE_LETTERS.test(codePoint) || ASCII_UPPERCASE_LETTERS.test(codePoint)
                        || ARABIC_NUMERALS.test(codePoint))
            }
        }
    }

    fun letterString(length: Int): String {
        return letterGenerator.generate(length)
    }
}
