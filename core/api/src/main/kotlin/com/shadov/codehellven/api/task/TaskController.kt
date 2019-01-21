package com.shadov.codehellven.api.task

import com.shadov.codehellven.api.code.domain.TaskApi
import com.shadov.codehellven.api.task.domain.TaskResourceAssembler
import com.shadov.codehellven.api.task.entity.Task
import org.springframework.hateoas.Resource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.vavr.collection.List as VavrList

@RestController
@CrossOrigin
@RequestMapping("/tasks")
internal class TaskController(private val taskApi: TaskApi, private val taskResourceAssembler: TaskResourceAssembler) {

    @PatchMapping("/{taskId}/failure")
    fun failure(@PathVariable taskId: String): ResponseEntity<Resource<Task>> {
        return ResponseEntity
                .accepted()
                .body(taskResourceAssembler.toResource(taskApi.failure(taskId).getOrElseThrow { ex -> ex }))
    }
}