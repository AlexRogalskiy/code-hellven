package com.shadov.codehellven.api.user.domain

import com.mongodb.client.result.UpdateResult
import com.shadov.codehellven.api.solution.entity.SolutionEntity
import com.shadov.codehellven.api.user.entity.UserEntity
import io.vavr.control.Try
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.mongodb.core.updateFirst

internal class UserRepositoryImpl(
        private val mongoOperations: MongoOperations
) : UserRepositoryCustom {
    override fun completeTask(solution: SolutionEntity): Try<UpdateResult> {
        return Try.of {
            mongoOperations.updateFirst(
                    Query(Criteria.where("userId").`is`(solution.finisher.userId)),
                    Update().addToSet("completedTasks", solution.task),
                    UserEntity::class
            )
        }
    }
}