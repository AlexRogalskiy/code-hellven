package com.shadov.codehellven.api.task.domain

import com.mongodb.client.result.UpdateResult
import com.shadov.codehellven.api.solution.model.SolutionEntity
import com.shadov.codehellven.api.task.model.TaskEntity
import io.vavr.control.Try
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.core.updateFirst

internal class TaskRepositoryImpl(
        private val mongoOperations: MongoOperations
) : TaskRepositoryCustom {

    override fun failedAttempt(task: TaskEntity): Try<UpdateResult> {
        return Try.of {
            mongoOperations.updateFirst(
                    Query(Criteria.where("taskId").`is`(task.taskId)),
                    Update().inc("failedAttempts", 1),
                    TaskEntity::class
            )
        }
    }

    override fun acceptSolution(solution: SolutionEntity): Try<UpdateResult> {
        return Try.of {
            mongoOperations.updateFirst(
                    Query(Criteria.where("taskId").`is`(solution.task.taskId)),
                    Update().addToSet("solutions", solution).inc("completedCount", 1),
                    TaskEntity::class
            )
        }
    }
}

