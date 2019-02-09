package com.shadov.codehellven.api.task

import com.shadov.codehellven.api.task.domain.TaskApi
import com.shadov.codehellven.api.task.entity.TaskEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.vavr.collection.List as VavrList

@RestController
@CrossOrigin
@RequestMapping("/tasks")
internal class TaskController(private val taskApi: TaskApi) {

    @PatchMapping("/{taskId}/failure")
    fun failure(@PathVariable taskId: String): ResponseEntity<TaskEntity> {
        return ResponseEntity
                .accepted()
                .body(taskApi.failure(taskId).getOrElseThrow { ex -> ex })
    }
}