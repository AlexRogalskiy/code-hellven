package com.shadov.codehellven.api.task.model

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Predicate
import io.vavr.collection.List as VavrList
import org.springframework.data.domain.Sort

internal fun TaskEntity.asGraphQL(): TaskQL {
    return TaskQL(this)
}

private fun TaskSort.asOrder(): Sort.Order {
    return Sort.Order(direction.asDirection(), field.fieldName)
}

internal fun VavrList<TaskSort>.asSort(): Sort {
    return Sort(this.map { it.asOrder() }.toJavaList())
}

internal fun TaskFilter.toPredicate(): Predicate {
    val taskEntity = QTaskEntity.taskEntity
    val where = BooleanBuilder()

    if (this.active != null)
        where.and(taskEntity.active.eq(this.active))

    if (this.difficulty != null)
        where.and(taskEntity.difficulty.eq(this.difficulty))

    if (this.anyTag.nonEmpty())
        where.and(taskEntity.tags.any().`in`(this.anyTag.toJavaList()))

    return where
}
