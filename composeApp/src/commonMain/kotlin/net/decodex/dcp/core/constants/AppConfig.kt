package net.decodex.dcp.core.constants

import io.ktor.client.plugins.logging.LogLevel

object AppConfig {
    const val API_ENDPOINT = "http://localhost:4200"
    const val API_TIMEOUT: Long = 60_000
    val logLevel: LogLevel = LogLevel.ALL
}
