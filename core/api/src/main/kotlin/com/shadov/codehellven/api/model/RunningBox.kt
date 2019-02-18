package com.shadov.codehellven.api.model

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("running-box")
internal class RunningBox {
    lateinit var mainPath: String

    lateinit var scriptsPath: String

    lateinit var userOutputPath: String

    lateinit var mainScript: String

    lateinit var virtualDockerPath: String

    lateinit var dockerImageName: String

    lateinit var defaultTimeout: String

    lateinit var outputLogsFile: String

    lateinit var outputErrorsFile: String

    lateinit var userSystemInFile: String

    lateinit var userArgumentsFile: String

    lateinit var dockerFlags: String

    lateinit var compileScript: String

    lateinit var threadPoolSize: String
}
