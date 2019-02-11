package com.shadov.codehellven.api.infrastructure

import com.shadov.codehellven.api.solution.domain.SolutionRepository
import com.shadov.codehellven.api.solution.entity.SolutionEntity
import com.shadov.codehellven.api.task.domain.TaskRepository
import com.shadov.codehellven.api.task.entity.TaskEntity
import com.shadov.codehellven.api.user.domain.UserRepository
import com.shadov.codehellven.api.user.entity.UserEntity
import com.shadov.codehellven.common.model.Difficulty
import com.shadov.codehellven.common.model.Languages
import org.springframework.boot.autoconfigure.AutoConfigureAfter
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime
import kotlin.random.Random


@Configuration
@AutoConfigureAfter(value = [MongoAutoConfiguration::class, MongoDataAutoConfiguration::class])
internal open class MongoPrefillConfig {

    private fun <T> List<T>.random(): T {
        return this[Random.nextInt(0, this.size)]
    }

/*    @Bean
    open fun preFill(userRepository: UserRepository, taskRepository: TaskRepository, solutionRepository: SolutionRepository): Boolean {
        val users = mutableListOf<UserEntity>()
        val tasks = mutableListOf<TaskEntity>()
        val solutions = mutableListOf<SolutionEntity>()

        users.add(userRepository.insert(
                UserEntity(
                        name = "John",
                        lastLoginDate = LocalDateTime.now(),
                        likedTasks = setOf(),
                        givenUpTasks = setOf(),
                        completedTasks = setOf()
                )
        ))

        tasks.add(taskRepository.insert(
                TaskEntity(
                        name = "fun task",
                        solutions = setOf(),
                        tags = setOf("easy", "simple"),
                        likeCount = 1,
                        failedAttempts = 1,
                        active = false,
                        creator = users[0],
                        description = "desc of fun task",
                        difficulty = Difficulty.EASY,
                        className = "FunTask",
                        methodSignature = "public void funTask"
                )
        ))

        solutions.add(solutionRepository.insert(
                SolutionEntity(
                        user = users[0],
                        task = tasks[0],
                        language = Languages.JAVA,
                        runningTime = 15,
                        code = "return 42;"
                )
        ))

        val task = taskRepository.findByNameIgnoreCase("fun task").get()
        task.solutions = setOf(solutions[0])
        taskRepository.save(task)


        val user = userRepository.findByName("John").get()
        user.completedTasks = setOf(tasks[0])
        userRepository.save(user)

        return true
    }*/

}