import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
    alias(libs.plugins.detekt)
    alias(libs.plugins.kover)
    alias(libs.plugins.spotless)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.dokka)
}

kotlin {
    sourceSets.commonMain {
        kotlin.srcDir("build/generated/ksp/metadata")
    }

    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)

            implementation(libs.ktor.client.okhttp)
        }
        nativeMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.kotlinx.datetime)

            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.navigation.compose)

            implementation(libs.bundles.ktor)

            implementation(libs.room.runtime)
            implementation(libs.sqlite.bundled)

            api(libs.datastore)
            api(libs.datastore.preferences)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(kotlin("test-annotations-common"))
            implementation(libs.assertk)

            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.uiTest)
        }
    }
}

android {
    namespace = "net.decodex.dcp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "net.decodex.dcp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}

room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {
    // Room
    add("kspCommonMainMetadata", libs.room.compiler)
}

kover {
    reports {
        filters {
            excludes {
                classes =
                    listOf(
                        "dagger.hilt.internal.aggregatedroot.codegen.*",
                        "dcp_mobile.composeapp.generated.*",
                        "net.decodex.dcp.di.*",
                        "net.decodex.dcp.core.constants.*",
                        "net.decodex.dcp.ui.theme.*",
                        "net.decodex.dcp.core.presentation.AppThemeKt",
                        "net.decodex.dcp.*.di.*",
                        "net.decodex.dcp.*.*_InstantiateImplKt",
                        "net.decodex.dcp.core.data.AppDatabase",
                        "net.decodex.dcp.core.data.DB",
                        "net.decodex.dcp.core.data.DataStoreKt",
                        "net.decodex.dcp.core.data.DataStore_*",
                        "net.decodex.dcp.core.data.Database_*",
                        "net.decodex.dcp.core.data.dao",
                        "net.decodex.dcp.core.networking.CreateHttpClientKt",
                        "net.decodex.dcp.core.networking.CreateHttpClientKt*",
                        "net.decodex.dcp.*.Hilt_*",
                        "net.decodex.dcp.*DefaultImpls*",
                        "net.decodex.dcp.*.*_Factory*",
                        "net.decodex.dcp.core.*.*dao*.*",
                        "net.decodex.dcp.AppKt",
                        "net.decodex.dcp.DcpApplication",
                        "net.decodex.dcp.MainActivity",
                        "net.decodex.dcp.MainActivityKt",
                        "net.decodex.dcp.*.*_HiltModules*",
                        "net.decodex.dcp.*.*Module_*",
                        "net.decodex.dcp.*.*MembersInjector*",
                        "net.decodex.dcp.*.*_Impl*",
                        "net.decodex.dcp.ComposableSingletons*",
                        "net.decodex.dcp.BuildConfig*",
                        "net.decodex.dcp.*.Fake*",
                        "net.decodex.dcp.*.entities*",
                        "net.decodex.dcp.app.ComposableSingletons*",
                    )
            }
        }
    }
}

ktlint {
    debug.set(true)
    enableExperimentalRules.set(true)
    additionalEditorconfig.set(
        mapOf(
            "max_line_length" to "off",
            "ktlint_function_naming_ignore_when_annotated_with" to "Composable",
        ),
    )
    filter {
        exclude { entry ->
            entry.file.toString().contains("generated") ||
            entry.file.name.contains("MainViewController") ||
            entry.file.extension.contains("kts")
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.dsl.KotlinCompile<*>>().configureEach {
    if (name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}

tasks.dokkaHtml {
    outputDirectory.set(layout.projectDirectory.dir("../docs/html"))
}

tasks.dokkaGfm {
    outputDirectory.set(layout.projectDirectory.dir("../docs/markdown"))
}
