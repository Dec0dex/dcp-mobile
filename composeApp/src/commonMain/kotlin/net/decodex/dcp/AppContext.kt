@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package net.decodex.dcp

internal expect object AppContext {
    fun get(): Any?
}
