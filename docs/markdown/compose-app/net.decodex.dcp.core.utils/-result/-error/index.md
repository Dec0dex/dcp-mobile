//[composeApp](../../../../index.md)/[net.decodex.dcp.core.utils](../../index.md)/[Result](../index.md)/[Error](index.md)

# Error

[common]\
data class [Error](index.md)&lt;out [E](index.md) : [Error](../../-error/index.md)&gt;(val error: [E](index.md), val message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val data: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null) : [Result](../index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html), [E](index.md)&gt;

## Constructors

| | |
|---|---|
| [Error](-error.md) | [common]<br>constructor(error: [E](index.md), message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, data: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [data](data.md) | [common]<br>val [data](data.md): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? = null |
| [error](error.md) | [common]<br>val [error](error.md): [E](index.md) |
| [message](message.md) | [common]<br>val [message](message.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |

## Functions

| Name | Summary |
|---|---|
| [asEmptyDataResult](../../as-empty-data-result.md) | [common]<br>fun &lt;[T](../../as-empty-data-result.md), [E](../../as-empty-data-result.md) : [Error](../../-error/index.md)&gt; [Result](../index.md)&lt;[T](../../as-empty-data-result.md), [E](../../as-empty-data-result.md)&gt;.[asEmptyDataResult](../../as-empty-data-result.md)(): [EmptyResult](../../-empty-result/index.md)&lt;[E](../../as-empty-data-result.md)&gt; |
| [map](../../map.md) | [common]<br>inline fun &lt;[T](../../map.md), [E](../../map.md) : [Error](../../-error/index.md), [R](../../map.md)&gt; [Result](../index.md)&lt;[T](../../map.md), [E](../../map.md)&gt;.[map](../../map.md)(map: ([T](../../map.md)) -&gt; [R](../../map.md)): [Result](../index.md)&lt;[R](../../map.md), [E](../../map.md)&gt; |
| [onError](../../on-error.md) | [common]<br>inline fun &lt;[T](../../on-error.md), [E](../../on-error.md) : [Error](../../-error/index.md)&gt; [Result](../index.md)&lt;[T](../../on-error.md), [E](../../on-error.md)&gt;.[onError](../../on-error.md)(action: ([E](../../on-error.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Result](../index.md)&lt;[T](../../on-error.md), [E](../../on-error.md)&gt; |
| [onSuccess](../../on-success.md) | [common]<br>inline fun &lt;[T](../../on-success.md), [E](../../on-success.md) : [Error](../../-error/index.md)&gt; [Result](../index.md)&lt;[T](../../on-success.md), [E](../../on-success.md)&gt;.[onSuccess](../../on-success.md)(action: ([T](../../on-success.md)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)): [Result](../index.md)&lt;[T](../../on-success.md), [E](../../on-success.md)&gt; |
