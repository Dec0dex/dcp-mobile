package net.decodex.dcp.core.utils

import kotlinx.datetime.Instant
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object InstantSerializer : KSerializer<Instant> {
    override val descriptor = PrimitiveSerialDescriptor("Instant", PrimitiveKind.STRING)

    override fun serialize(
        encoder: Encoder,
        value: Instant,
    ) {
        // Format Instant to ISO 8601 string with milliseconds and 'Z' suffix
        val isoString = value.toString()
        encoder.encodeString(isoString)
    }

    override fun deserialize(decoder: Decoder): Instant {
        val isoString = decoder.decodeString()
        return Instant.parse(isoString)
    }
}
