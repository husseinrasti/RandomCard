package dependencies.dependencies

import dependencies.Versions

object AndroidTestDependencies{

    val kotlinTest = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoCore}"
    val idlingResource = "androidx.test.espresso:espresso-idling-resource:${Versions.espressoIdlingResource}"
    val testRunner = "androidx.test:runner:${Versions.testRunner}"
    val testRules = "androidx.test:rules:${Versions.testRunner}"
    val textCoreKtx = "androidx.test:core-ktx:${Versions.testCore}"
    val mockkAndroid = "io.mockk:mockk-android:${Versions.mockkVersion}"
    val fragmentTesting = "androidx.fragment:fragment-testing:${Versions.fragmentVersion}"
    val androidxTestExt = "androidx.test.ext:junit-ktx:${Versions.androidxTestExt}"
    val navigationTesting = "androidx.navigation:navigation-testing:${Versions.navComponents}"

    val testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
}