package net.decodex.dcp

import android.app.Application
import net.decodex.dcp.di.initKoin
import org.koin.android.ext.koin.androidContext
import timber.log.Timber

class DcpApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppContext.setUp(this)
        if (BuildKonfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        initKoin {
            androidContext(this@DcpApplication)
        }
    }
}
