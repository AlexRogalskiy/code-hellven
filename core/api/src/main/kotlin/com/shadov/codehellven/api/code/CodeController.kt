package com.shadov.codehellven.api.code

import com.shadov.codehellven.api.code.domain.CodeApi
import com.shadov.codehellven.api.code.entity.CodeRequestEntity
import com.shadov.codehellven.common.lazyLogger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/api/code")
internal class CodeController(private val codeApi: CodeApi) {
    private val log by lazyLogger()

    @PostMapping("/execute")
    fun execute(@RequestBody request: CodeRequestEntity): ResponseEntity<String> {
        return ResponseEntity.accepted().body(codeApi.execute(request).getOrElseThrow { ex -> ex })
    }

    @GetMapping("/get")
    fun get(): ResponseEntity<String> {
        return ResponseEntity.accepted().body("whatever")
    }
}
