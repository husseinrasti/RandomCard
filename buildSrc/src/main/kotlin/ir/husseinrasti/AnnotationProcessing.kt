package dependencies

object AnnotationProcessing {
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycleVersion}"
    val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
    val daggerHiltCompilerExt = "androidx.hilt:hilt-compiler:${Versions.daggerHiltExt}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val daggerCompilerAndroid = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
}