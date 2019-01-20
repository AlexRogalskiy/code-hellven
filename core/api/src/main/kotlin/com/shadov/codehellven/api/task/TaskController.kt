package com.shadov.codehellven.api.task

import com.shadov.codehellven.api.code.domain.TaskApi
import com.shadov.codehellven.api.infrastructure.conversion.EntityConverter
import com.shadov.codehellven.api.task.entity.Task
import org.springframework.hateoas.Resources
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import io.vavr.collection.List as VavrList

@RestController
@CrossOrigin
@RequestMapping("/tasks")
internal class TaskController(private val taskApi: TaskApi, private val entityConverter: EntityConverter) {

    @PatchMapping("/failedAttempt")
    fun execute(@RequestBody taskLink: Resources<Task>): ResponseEntity<List<Task>> {
        return ResponseEntity
                .accepted()
                .body(
                        VavrList.ofAll(taskLink.links)
                                .map { link -> entityConverter.convert(link, Task::class.java) }
                                .map(taskApi::failedAttempt)
                                .map { it.getOrElseThrow { ex -> ex } }
                                .toJavaList()
                )
    }
}