package ir.husseinrasti.randomcard

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ir.husseinrasti.randomcard.di.component.DaggerAppComponent

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().application(this).build()

}