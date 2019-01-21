package com.shadov.codehellven.common

import com.github.javaparser.JavaParser
import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.body.CallableDeclaration
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.type.Type
import org.apache.commons.lang3.StringUtils

import javax.lang.model.SourceVersion
import java.util.Optional
import java.util.function.Supplier
import java.util.regex.Matcher
import java.util.regex.Pattern

object CodeUtils {
    private val SPACES_REGEX = "\\s{2,}"
    private val COMMENTS_REGEX = "(//.*?$)|(/\\*.*?\\*/)"
    private val METHOD_SIGNATURE_REGEX = "(public|protected|private)? (static|synchronized)? [\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])"
    private val PUBLIC_CLASS_REGEX = "public\\s+class\\s+(\\w+)"

    fun createInitialScalaCode(className: String, methodSignature: String): String {
        val initialJavaCode = createInitialJavaCode(className, methodSignature)

        val initialCode = StringBuilder()
        initialCode.append("import java.util.*;\n\n")
        initialCode.append("class ")
        initialCode.append(className)
        initialCode.append(" {\n\t")

        val compilationUnit = JavaParser.parse(initialJavaCode)
        val classEntity = compilationUnit.getClassByName(className).orElseThrow<IllegalArgumentException> { IllegalArgumentException() }
        val methods = classEntity.methods
        for (method in methods) {
            val signature = method.signature

            initialCode.append("def ")
            initialCode.append(signature.name)
            initialCode.append("(")

            val parameters = signature.parameterTypes
            var start = 'a'
            for ((index, type) in parameters.withIndex()) {
                initialCode.append(start++)
                initialCode.append(": ")
                initialCode.append(type.javaClass.getSimpleName())

                if (index < parameters.size - 1)
                    initialCode.append(", ")
            }

            initialCode.append("): ")
            initialCode.append("Unit = {\n\t\t")
            initialCode.append("return null;")
            initialCode.append("\n\t}\n")
        }

        initialCode.append("}")

        return initialCode.toString()
    }

    fun createInitialJavaCode(className: String, methodSignature: String): String {
        val initialCode = StringBuilder()
        initialCode.append("import java.util.*;\n\n")
        initialCode.append("public class ")
        initialCode.append(className)
        initialCode.append(" {\n\t")
        initialCode.append(methodSignature)
        initialCode.append(" {\n\t\t")
        initialCode.append("return null;")
        initialCode.append("\n\t}\n}")

        return initialCode.toString()
    }

    fun findPublicClassName(input: String): Optional<String> {
        var input = input
        input = CodeUtils.removeSpaces(input)
        input = CodeUtils.removeComments(input)

        val pattern = Pattern.compile(PUBLIC_CLASS_REGEX)
        val matcher = pattern.matcher(input)

        var className = StringUtils.EMPTY

        if (matcher.find())
            className = matcher.group(1)

        val validateResult = CodeUtils.isJavaClassName(className)

        return if (validateResult) Optional.of(className) else Optional.empty()
    }

    fun isJavaMethodSignature(methodSignature: String): Boolean {
        var methodSignature = methodSignature
        methodSignature = removeSpaces(methodSignature)
        return Pattern.compile(METHOD_SIGNATURE_REGEX).matcher(methodSignature).matches()
    }

    fun isJavaClassName(className: String): Boolean {
        return SourceVersion.isIdentifier(className) && !SourceVersion.isKeyword(className)
    }

    fun removeSpaces(input: String): String {
        return input.replace(SPACES_REGEX.toRegex(), StringUtils.SPACE).trim({ it <= ' ' })
    }

    fun removeComments(input: String): String {
        return input.replace(COMMENTS_REGEX.toRegex(), StringUtils.EMPTY)
    }
}
