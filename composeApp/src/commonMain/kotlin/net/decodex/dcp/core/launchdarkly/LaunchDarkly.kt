package net.decodex.dcp.core.launchdarkly

import com.myunidays.launchdarkly.AutoEnvAttributes
import com.myunidays.launchdarkly.LDClient
import com.myunidays.launchdarkly.LDConfig
import com.myunidays.launchdarkly.LDContext
import net.decodex.dcp.AppContext
import net.decodex.dcp.BuildKonfig

fun createLDClient(): LDClient {
    val config = LDConfig(BuildKonfig.LD_KEY, AutoEnvAttributes.Enabled)
    val context = LDContext("anonymous")
    return LDClient(AppContext.get(), config, context, onReady = {})
}
