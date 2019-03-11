package com.shadov.codehellven.api.code.domain


import com.shadov.codehellven.api.code.model.CodeResponseEntity
import io.vavr.control.Option
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

internal interface CodeResponseRepository : MongoRepository<CodeResponseEntity, String> {
    fun findByCallbackId(callbackId: ObjectId): Option<CodeResponseEntity>
}
