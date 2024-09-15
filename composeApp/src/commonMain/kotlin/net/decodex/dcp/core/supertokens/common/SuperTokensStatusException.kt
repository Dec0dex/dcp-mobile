package net.decodex.dcp.core.supertokens.common

import net.decodex.dcp.core.utils.Error

open class SuperTokensStatusException(
    val status: SuperTokensStatus,
    message: String? = null,
) : RuntimeException(message ?: status.value), Error
