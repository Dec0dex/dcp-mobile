package net.decodex.dcp.core.constants

import io.ktor.client.plugins.logging.LogLevel

object AppConfig {
    const val API_ENDPOINT = "https://google.com"
    const val API_TIMEOUT: Long = 60_000
    val logLevel: LogLevel = LogLevel.ALL
}
