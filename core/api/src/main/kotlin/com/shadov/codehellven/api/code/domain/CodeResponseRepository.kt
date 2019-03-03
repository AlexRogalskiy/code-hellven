package com.shadov.codehellven.api.code.domain


import com.shadov.codehellven.api.code.model.CodeResponseEntity
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

internal interface CodeResponseRepository : MongoRepository<CodeResponseEntity, String> {
    fun findByCallbackId(callbackId: ObjectId): Optional<CodeResponseEntity>
}
