[![codecov](https://codecov.io/gh/Dec0dex/dcp-mobile/graph/badge.svg?token=ONFZSM7OOQ)](https://codecov.io/gh/Dec0dex/dcp-mobile)
[![CI](https://github.com/Dec0dex/dcp-mobile/actions/workflows/ci.yml/badge.svg)](https://github.com/Dec0dex/dcp-mobile/actions/workflows/ci.yml)
[![Latest Release](https://img.shields.io/github/release/Dec0dex/dcp-mobile.svg)](https://github.com/Dec0dex/dcp-mobile/releases)

This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
