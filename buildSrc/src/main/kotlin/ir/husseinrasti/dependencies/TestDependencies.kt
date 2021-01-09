package dependencies.dependencies

import dependencies.Versions

object TestDependencies {

    val jupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junitJupiterVersion}"
    val jupiterParams = "org.junit.jupiter:junit-jupiter-params:${Versions.junitJupiterVersion}"
    val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junitJupiterVersion}"
    val junit4 = "junit:junit:${Versions.junit4Version}"

    val mockk = "io.mockk:mockk:${Versions.mockkVersion}"

    val mockito = "org.mockito:mockito-core:${Versions.mockitoCoreVersion}"
    val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInlineVersion}"
    val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"
    val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"

    val room = "androidx.room:room-testing:${Versions.room}"

    val junitTestAndroidX = "androidx.test.ext:junit:${Versions.junitTestAndroidX}"
    val testRunner = "androidx.test:runner:${Versions.supportTest}"
    val testRules = "androidx.test:runner:${Versions.supportTest}"

    val espressoTest = "androidx.test.espresso:espresso-core:${Versions.espressoTest}"
    val espressoContrib = ("androidx.test.espresso:espresso-contrib:${Versions.espressoTest}")
    val espressoIdlingResource = "androidx.test.espresso:espresso-idling-resource:${Versions.espressoTest}"

    val powermockModuleJunit4 = "org.powermock:powermock-module-junit4:${Versions.powermockVersion}"
    val powermockApiMockito = "org.powermock:powermock-api-mockito2:${Versions.powermockVersion}"

    val kotlinTest = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"
    val textCoreKtx = "androidx.test:core-ktx:${Versions.testCore}"
    val mockkAndroid = "io.mockk:mockk-android:${Versions.mockkVersion}"
    val androidxTestExt = "androidx.test.ext:junit-ktx:${Versions.androidxTestExt}"

    val robolectric = "org.robolectric:robolectric:${Versions.robolectricVersion}"
}