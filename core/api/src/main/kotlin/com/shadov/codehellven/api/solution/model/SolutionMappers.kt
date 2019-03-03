package com.shadov.codehellven.api.solution.model

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Predicate
import com.shadov.codehellven.api.task.model.TaskEntity
import com.shadov.codehellven.api.user.model.UserEntity
import org.springframework.data.domain.Sort
import io.vavr.collection.List as VavrList

internal fun SolutionEntity.asGraphQL(): SolutionQL {
    return SolutionQL(this)
}

private fun SolutionSort.asOrder(): Sort.Order {
    return Sort.Order(direction.asDirection(), field.fieldName)
}

internal fun VavrList<SolutionSort>.asSort(): Sort {
    return Sort(this.map { it.asOrder() }.toJavaList())
}

internal fun SolutionFilter.toPredicate(user: UserEntity?, task: TaskEntity?): Predicate {
    val solutionEntity = QSolutionEntity.solutionEntity
    val where = BooleanBuilder()

    if (user != null)
        where.and(solutionEntity.finisher.userId.eq(user.userId))

    if (task != null)
        where.and(solutionEntity.task.taskId.eq(task.taskId))

    if (this.language != null)
        where.and(solutionEntity.codeSnippet.language.eq(this.language))

    if (this.runningLongerThan != null || this.runningShorterThan != null)
        where.and(solutionEntity.runningTime.between(runningLongerThan, runningShorterThan))

    if (this.submittedAfter != null || this.submittedBefore != null)
        where.and(solutionEntity.submitDate.between(this.submittedAfter, this.submittedBefore))

    return where
}