package dependencies.dependencies

import dependencies.Versions

object Dependencies {
    val guava = "com.google.guava:guava:${Versions.guava}"

    val multidex = "androidx.multidex:multidex:${Versions.multidex}"

    val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    val kotlinCoroutinesPlayServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutinesPlayServices}"

    val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    val daggerHiltExt = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.daggerHiltExt}"
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val javaX = "javax.inject:javax.inject:${Versions.javaX}"

    val rxKotlin = "io.reactivex.rxjava3:rxkotlin:${Versions.rxJava}"
    val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxJava}"
    val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxJava}"

    val rxBinding = "com.jakewharton.rxbinding4:rxbinding:${Versions.rxBinding}"
    val rxBindingRecyclerView = "com.jakewharton.rxbinding2:rxbinding-recyclerview-v7:${Versions.rxBinding}"
    val rxBindingSupportV4 = "com.jakewharton.rxbinding2:rxbinding-support-v4:${Versions.rxBinding}"
    val rxBindingAppcompatV7 = "com.jakewharton.rxbinding2:rxbinding-appcompat-v7:${Versions.rxBinding}"
    val rxBindingDesign = "com.jakewharton.rxbinding2:rxbinding-design:${Versions.rxBinding}"
    val rxBindingLeanBack = "com.jakewharton.rxbinding2:rxbinding-leanback-v17:${Versions.rxBinding}"

    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navComponents}"
    val navigationRuntime = "androidx.navigation:navigation-runtime:${Versions.navComponents}"
    val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navComponents}"
    val navigationDynamic = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navComponents}"

    val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    val roomRxJava = "androidx.room:room-rxjava3:${Versions.room}"
    val paging = "android.arch.paging:runtime:${Versions.paging}"

    val playCore = "com.google.android.play:core:${Versions.playCore}"
    val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"
    val googleMaps = "com.google.android.gms:play-services-maps:${Versions.googleMaps}"
    val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx:${Versions.firebaseFirestore}"
    val firebaseAuth = "com.google.firebase:firebase-auth:${Versions.firebaseAuth}"
    val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx:${Versions.firebaseAnalytics}"
    val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics:${Versions.firebaseCrashlytics}"
    val googlePlayAuth = "com.google.android.gms:play-services-auth:${Versions.playAuth}"
    val firebaseCore = "com.google.firebase:firebase-core:${Versions.firebaseVersion}"
    val playTagManager = "com.google.android.gms:play-services-tagmanager:${Versions.firebaseCrashlytics}"
    val firebaseCM = "com.google.firebase:firebase-messaging:${Versions.fcm}"
    val firebaseIAM = "com.google.firebase:firebase-inappmessaging-display:${Versions.firebaseInAppMessage}"

    val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    val lifecycleCoroutines = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    val lifecycleViewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2Version}"
    val retrofitRxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofit2RxJava}"
    val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2Version}"
    val googleGson = "com.google.code.gson:gson:${Versions.gson}"
    val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    // Coroutins
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"
    val retrofitCoroutines = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutinesRetrofit}"
}