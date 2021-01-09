package dependencies.dependencies

import dependencies.Versions

object ThirdParty {

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    val butterKnife = "com.jakewharton:butterknife:${Versions.butterKnife}"
    val butterknifeCompiler = "com.jakewharton:butterknife-compiler:${Versions.butterKnife}"

    val exoplayerCore = "com.google.android.exoplayer:exoplayer-core:${Versions.exoplayer}"
    val exoplayerDash = "com.google.android.exoplayer:exoplayer-dash:${Versions.exoplayer}"
    val exoplayerUI = "com.google.android.exoplayer:exoplayer-ui:${Versions.exoplayer}"

}