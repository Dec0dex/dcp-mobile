package net.decodex.dcp.core.supertokens.models

data class TotpDevice(
    val name: String,
    val period: Long,
    val skew: Long,
    val verified: Boolean,
)
