package net.decodex.dcp.core.utils

import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException

sealed interface Result<out D, out E : Error> {
    data class Success<out D>(val data: D) : Result<D, Nothing>

    data class Error<out E : net.decodex.dcp.core.utils.Error>(
        val error: E,
        val message: String? = null,
        val data: Any? = null,
    ) : Result<Nothing, E>
}

inline fun <T, E : Error, R> Result<T, E>.map(map: (T) -> R): Result<R, E> {
    return when (this) {
        is Result.Error -> Result.Error(error)
        is Result.Success -> Result.Success(map(data))
    }
}

fun <T, E : Error> Result<T, E>.asEmptyDataResult(): EmptyResult<E> {
    return map {}
}

inline fun <T, E : Error> Result<T, E>.onSuccess(action: (T) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Error -> this
        is Result.Success -> {
            action(data)
            this
        }
    }
}

inline fun <T, E : Error> Result<T, E>.onError(action: (E) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Error -> {
            action(error)
            this
        }

        is Result.Success -> this
    }
}

suspend inline fun <reified T> safeApiCall(call: () -> HttpResponse): Result<T, NetworkError> {
    return try {
        val response = call()

        return when (response.status.value) {
            in 200..299 -> Result.Success(response.body<T>())
            in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
            else -> Result.Error(mapClientError(response.status), data = response.bodyAsText())
        }
    } catch (e: UnresolvedAddressException) {
        Result.Error(NetworkError.NO_INTERNET, e.message)
    } catch (e: ClientRequestException) {
        Result.Error(mapClientError(e.response.status), e.message)
    } catch (e: ServerResponseException) {
        Result.Error(NetworkError.SERVER_ERROR, e.message, e.response.bodyAsText())
    } catch (e: HttpRequestTimeoutException) {
        Result.Error(NetworkError.REQUEST_TIMEOUT, e.message)
    } catch (e: SerializationException) {
        Result.Error(NetworkError.SERIALIZATION, e.message)
    } catch (e: ResponseException) {
        Result.Error(mapClientError(e.response.status), e.message, e.response.bodyAsText())
    } catch (e: Exception) {
        Result.Error(NetworkError.UNKNOWN, e.message)
    }
}

fun mapClientError(statusCode: HttpStatusCode): NetworkError {
    return when (statusCode) {
        HttpStatusCode.Unauthorized -> NetworkError.UNAUTHORIZED
        HttpStatusCode.BadRequest -> NetworkError.BAD_REQUEST
        HttpStatusCode.Conflict -> NetworkError.CONFLICT
        HttpStatusCode.TooManyRequests -> NetworkError.TOO_MANY_REQUESTS
        HttpStatusCode.PayloadTooLarge -> NetworkError.PAYLOAD_TOO_LARGE
        HttpStatusCode.RequestTimeout -> NetworkError.REQUEST_TIMEOUT
        HttpStatusCode.NotFound -> NetworkError.NOT_FOUND
        HttpStatusCode.Gone -> NetworkError.NOT_FOUND
        HttpStatusCode.NotAcceptable -> NetworkError.NOT_ACCEPTABLE
        HttpStatusCode.MethodNotAllowed -> NetworkError.METHOD_NOT_ALLOWED
        else -> NetworkError.UNKNOWN
    }
}

typealias EmptyResult<E> = Result<Unit, E>
