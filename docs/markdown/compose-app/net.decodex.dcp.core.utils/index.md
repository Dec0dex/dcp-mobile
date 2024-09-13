//[composeApp](../../index.md)/[net.decodex.dcp.core.utils](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [EmptyResult](-empty-result/index.md) | [common]<br>typealias [EmptyResult](-empty-result/index.md)&lt;[E](-empty-result/index.md)&gt; = [Result](-result/index.md)&lt;[Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), [E](-empty-result/index.md)&gt; |
| [Error](-error/index.md) | [common]<br>interface [Error](-error/index.md) |
| [InstantSerializer](-instant-serializer/index.md) | [common]<br>object [InstantSerializer](-instant-serializer/index.md) : KSerializer&lt;Instant&gt; |
| [NetworkError](-network-error/index.md) | [common]<br>enum [NetworkError](-network-error/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[NetworkError](-network-error/index.md)&gt; , [Error](-error/index.md) |
| [Result](-result/index.md) | [common]<br>sealed interface [Result](-result/index.md)&lt;out [D](-result/index.md), out [E](-result/index.md) : [Error](-error/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [asEmptyDataResult](as-empty-data-result.md) | [common]<br>fun &lt;[T](as-empty-data-result.md), [E](as-empty-data-result.md) : [Error](-error/index.md)&gt; [Result](-result/index.md)&lt;[T](as-empty-data-result.md), [E](as-empty-data-result.md)&gt;.[asEmptyDataResult](as-empty-data-result.md)(): [EmptyResult](-empty-result/index.md)&lt;[E](as-empty-data-result.md)&gt; |
| [map](map.md) | [common]<br>inline fun &lt;[T](map.md), [E](map.md) : [Error](-error/index.md), [R](map.md)&gt; [Result](-result/index.md)&lt;[T](map.md), [E](map.md)&gt;.[map](map.md)(map: ([T](map.md)) -&gt; [R](map.md)): [Result](-result/index.md)&lt;[R](map.md), [E](map.md)&gt; |
| [mapClientError](map-client-error.md) | [common]<br>fun [mapClientError](map-client-error.md)(statusCode: HttpStatusCode): [NetworkError](-network-error/index.md) |
| [onError](on-error.md) | [common]<br>inline fun &lt;[T](on-error.md), [E](on-error.md) : [Error](-error/index.md)&gt; [Result](-result/index.md)&lt;[T](on-error.md), [E](on-error.md)&gt;.[onError](on-error.md)(action: ([E](on-error.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Result](-result/index.md)&lt;[T](on-error.md), [E](on-error.md)&gt; |
| [onSuccess](on-success.md) | [common]<br>inline fun &lt;[T](on-success.md), [E](on-success.md) : [Error](-error/index.md)&gt; [Result](-result/index.md)&lt;[T](on-success.md), [E](on-success.md)&gt;.[onSuccess](on-success.md)(action: ([T](on-success.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Result](-result/index.md)&lt;[T](on-success.md), [E](on-success.md)&gt; |
| [safeApiCall](safe-api-call.md) | [common]<br>inline suspend fun &lt;[T](safe-api-call.md)&gt; [safeApiCall](safe-api-call.md)(call: () -&gt; HttpResponse): [Result](-result/index.md)&lt;[T](safe-api-call.md), [NetworkError](-network-error/index.md)&gt; |
