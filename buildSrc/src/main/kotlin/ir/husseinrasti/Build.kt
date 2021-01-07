package dependencies

object Build {
    val buildTools = "com.android.tools.build:gradle:${Versions.gradle}"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val googleServices = "com.google.gms:google-services:${Versions.playServices}"
    val junit5 = "de.mannodermaus.gradle.plugins:android-junit5:${Versions.junit5Version}"
    val crashlyticsGradle = "com.google.firebase:firebase-crashlytics-gradle:${Versions.crashlyticsGradle}"
    val fabricIo = "io.fabric.tools:gradle:${Versions.fabricIo}"
    val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHilt}"
}