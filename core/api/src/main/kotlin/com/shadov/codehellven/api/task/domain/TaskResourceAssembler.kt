package com.shadov.codehellven.api.task.domain

import com.shadov.codehellven.api.task.entity.Task
import org.springframework.hateoas.EntityLinks
import org.springframework.hateoas.Resource
import org.springframework.hateoas.ResourceAssembler

internal class TaskResourceAssembler(private val entityLinks: EntityLinks) : ResourceAssembler<Task, Resource<Task>> {
    override fun toResource(task: Task): Resource<Task> {
        val self = entityLinks.linkFor(Task::class.java).slash(task.taskId).withSelfRel()
        val rel = entityLinks.linkFor(Task::class.java).slash(task.taskId).withRel("task")
        val creator = entityLinks.linkFor(Task::class.java).slash(task.taskId).slash("creator").withRel("creator")
        val solutions = entityLinks.linkFor(Task::class.java).slash(task.taskId).slash("solutions").withRel("solutions")
        return Resource(task, self, rel, creator, solutions)
    }

}