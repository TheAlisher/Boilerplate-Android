package com.alish.boilerplate.data.core.utils

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.text.DateFormat
import java.util.Date

object DateSerializer : KSerializer<Date> {
    override val descriptor get() = PrimitiveSerialDescriptor("Date", PrimitiveKind.STRING)
    override fun serialize(encoder: Encoder, value: Date) = encoder.encodeString(value.toString())
    override fun deserialize(decoder: Decoder) = DateFormat.getDateTimeInstance().parse(decoder.decodeString())
}