plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}