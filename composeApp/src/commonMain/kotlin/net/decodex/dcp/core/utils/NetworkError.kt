package net.decodex.dcp.core.utils

enum class NetworkError : Error {
    REQUEST_TIMEOUT,
    UNAUTHORIZED,
    CONFLICT,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    PAYLOAD_TOO_LARGE,
    SERVER_ERROR,
    SERIALIZATION,
    BAD_REQUEST,
    NOT_FOUND,
    NOT_ACCEPTABLE,
    METHOD_NOT_ALLOWED,
    UNKNOWN,
}
