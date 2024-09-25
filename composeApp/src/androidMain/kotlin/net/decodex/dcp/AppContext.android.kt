@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package net.decodex.dcp

import android.app.Application
import android.content.Context

internal actual object AppContext {
    private lateinit var application: Application

    fun setUp(context: Context) {
        application = context as Application
    }

    actual fun get(): Any? {
        if (::application.isInitialized.not()) throw Exception("Application context isn't initialized")
        return application.applicationContext
    }

    fun getContext(): Context {
        return application.applicationContext
    }
}
