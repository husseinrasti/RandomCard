package dependencies.dependencies

import dependencies.Versions

object TestDependencies {

    val junitTestAndroidX = "androidx.test.ext:junit:${Versions.junitTestAndroidX}"
    val espressoTest = "androidx.test.espresso:espresso-core:${Versions.espressoTest}"
    val jupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junitJupiterVersion}"
    val jupiterParams = "org.junit.jupiter:junit-jupiter-params:${Versions.junitJupiterVersion}"
    val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junitJupiterVersion}"
    val mockk = "io.mockk:mockk:${Versions.mockkVersion}"
    val junit4 = "junit:junit:${Versions.junit4Version}"

    val mockito =  "org.mockito:mockito-core:${Versions.mockitoCoreVersion}"
    val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInlineVersion}"
    val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"
}