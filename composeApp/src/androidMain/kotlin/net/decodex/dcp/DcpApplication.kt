package net.decodex.dcp

import android.app.Application
import io.ktor.client.engine.okhttp.OkHttp
import net.decodex.dcp.di.initKoin
import org.koin.android.ext.koin.androidContext

class DcpApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@DcpApplication)
            OkHttp.create()
        }
    }
}
