//[composeApp](../../../index.md)/[net.decodex.dcp.core.utils](../index.md)/[InstantSerializer](index.md)

# InstantSerializer

[common]\
object [InstantSerializer](index.md) : KSerializer&lt;Instant&gt;

## Properties

| Name | Summary |
|---|---|
| [descriptor](descriptor.md) | [common]<br>open override val [descriptor](descriptor.md): SerialDescriptor |

## Functions

| Name | Summary |
|---|---|
| [deserialize](deserialize.md) | [common]<br>open override fun [deserialize](deserialize.md)(decoder: Decoder): Instant |
| [serialize](serialize.md) | [common]<br>open override fun [serialize](serialize.md)(encoder: Encoder, value: Instant) |
