package com.shadov.codehellven.api.model

import com.google.common.collect.Lists
import org.apache.commons.lang3.StringUtils
import java.util.*
import java.util.stream.Collectors

internal data class DockerCommand(
        val mainScript: String,
        val timeout: String,
        val flags: String,
        val userContentOutput: String,
        val virtualDockerPath: String,
        val dockerImageName: String,
        val compileScript: String,
        val sourceFile: String,
        val language: String,
        val testFile: String,
        val extra: String
) {
    override fun toString(): String {
        return Arrays.stream(this.toStringArray()).collect(Collectors.joining(StringUtils.SPACE))
    }

    fun toStringArray(): Array<String> {
        val list = Lists.newArrayList<String>()

        list.add(this.mainScript)
        list.add(this.timeout)
        list.addAll(Arrays.asList(*this.flags.split("\\s+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()))
        list.add(this.userContentOutput + ":" + this.virtualDockerPath)
        list.add(this.dockerImageName)
        list.add(this.virtualDockerPath + "/" + this.compileScript)
        list.add("--language=" + this.language)
        list.add("--source=" + this.sourceFile)

        if (StringUtils.isNotBlank(this.testFile))
            list.add("--test=" + this.testFile)

        if (StringUtils.isNotBlank(this.extra))
            list.add("--extra=" + this.extra)

        return list.toTypedArray()
    }
}
